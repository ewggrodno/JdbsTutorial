package service;

import bl.Util;
import entity.Address;
import entity.EmplProj;
import entity.Employee;
import entity.Project;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class EmplProjServiseTest {

    private AddressService addressService = new AddressService();
    private EmployeeService employeeService = new EmployeeService();
    private ProjectService projectService = new ProjectService();
    private EmplProjServise emplProjServise = new EmplProjServise();

    private Address address1 = null;
    private Address address2 = null;
    private Address address3 = null;

    private Employee employee1 = null;
    private Employee employee2 = null;
    private Employee employee3 = null;

    private Project project1 = null;
    private Project project2 = null;
    private Project project3 = null;

    private EmplProj emplProj1 = null;
    private EmplProj emplProj2 = null;
    private EmplProj emplProj3 = null;

    @Before
    public void setUp() throws Exception {
        Util.clearAllTables();

        address1 = new Address(1, "Country 1", "City 1", "Street 1", "000001");
        address2 = new Address(2, "Country 2", "City 2", "Street 2", "000002");
        address3 = new Address(3, "Country 3", "City 3", "Street 3", "000003");

        employee1 = new Employee(1, "firstName 1", "lastName 1", new Date(5000), 3);
        employee2 = new Employee(2, "firstName 2", "lastName 3", new Date(10000), 2);
        employee3 = new Employee(3, "firstName 3", "lastName 3", new Date(20000), 1);

        project1 = new Project(1, "Title 1");
        project2 = new Project(2, "Title 2");
        project3 = new Project(3, "Title 3");

        emplProj1 = new EmplProj(1, 1);
        emplProj2 = new EmplProj(2, 2);
        emplProj3 = new EmplProj(3, 3);

        addressService.add(address1);
        addressService.add(address2);
        addressService.add(address3);

        employeeService.add(employee1);
        employeeService.add(employee2);
        employeeService.add(employee3);

        projectService.add(project1);
        projectService.add(project2);
        projectService.add(project3);

        emplProjServise.add(emplProj1);
        emplProjServise.add(emplProj2);
        emplProjServise.add(emplProj3);
    }

    @After
    public void tearDown() throws Exception {
        Util.clearAllTables();
    }

    @Test
    public void add_EMPL_PROJ() {
        Util.clearAllTables();

        addressService.add(address1);
        addressService.add(address2);
        addressService.add(address3);

        employeeService.add(employee1);
        employeeService.add(employee2);
        employeeService.add(employee3);

        projectService.add(project1);
        projectService.add(project2);
        projectService.add(project3);

        emplProjServise.add(emplProj1);
        emplProjServise.add(emplProj2);
        emplProjServise.add(emplProj3);
    }

    @Test
    public void getAll_EMPL_PROJ() {
        List<EmplProj> expected = new ArrayList<>();
        expected.add(emplProj1);
        expected.add(emplProj2);
        expected.add(emplProj3);

        List<EmplProj> actual = emplProjServise.getAll();

        assertEquals(expected, actual);
    }

    @Test
    public void getByEmployeeIdAndProjectId_EMPL_PROJ() {
        EmplProj actual1 = emplProjServise.getByEmployeeIdAndProjectId(1, 1);
        EmplProj actual2 = emplProjServise.getByEmployeeIdAndProjectId(2, 2);
        EmplProj actual3 = emplProjServise.getByEmployeeIdAndProjectId(3, 3);

        assertEquals(emplProj1, actual1);
        assertEquals(emplProj2, actual2);
        assertEquals(emplProj3, actual3);
    }

    @Test
    public void update_EMPL_PROJ_ChangeEmployee() {
        EmplProj newEmplProj1 = new EmplProj(2, 1);
        emplProjServise.update(emplProj1, newEmplProj1);
        EmplProj actual1 = emplProjServise.getByEmployeeIdAndProjectId(2, 1);
        System.out.println(emplProj1 == actual1);

        assertEquals(newEmplProj1, actual1);
    }

    @Test
    public void update_EMPL_PROJ_ChangeProject() {
        EmplProj newEmplProj1 = new EmplProj(1, 2);
        emplProjServise.update(emplProj1, newEmplProj1);
        EmplProj actual1 = emplProjServise.getByEmployeeIdAndProjectId(1, 2);
        System.out.println(emplProj1 == actual1);

        assertEquals(newEmplProj1, actual1);
    }

    @Test
    public void update_EMPL_PROJ_ChangeEmployeeAndProject() {
        EmplProj newEmplProj1 = new EmplProj(2, 2);
        emplProjServise.update(emplProj1, newEmplProj1);
        EmplProj actual1 = emplProjServise.getByEmployeeIdAndProjectId(2, 2);
        System.out.println(emplProj1 == actual1);

        assertEquals(newEmplProj1, actual1);
    }

    @Test
    public void remove_EMPL_PROJ() {
        emplProjServise.remove(emplProj1);

        List<EmplProj> expected = new ArrayList<>();
        expected.add(emplProj2);
        expected.add(emplProj3);

        List<EmplProj> actual = emplProjServise.getAll();

        assertEquals(expected, actual);
    }
}