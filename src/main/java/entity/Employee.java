package entity;

import java.sql.Date;
import java.util.Objects;

public class Employee {

    private long id;
    private String firstNme;
    private String lastName;
    private Date birthday;
    private long addressId;

    public Employee() {
    }

    public Employee(long id, String firstNme, String lastName, Date birthday, long addressId) {
        this.id = id;
        this.firstNme = firstNme;
        this.lastName = lastName;
        this.birthday = birthday;
        this.addressId = addressId;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstNme() {
        return firstNme;
    }

    public void setFirstNme(String firstNme) {
        this.firstNme = firstNme;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id &&
                addressId == employee.addressId &&
                Objects.equals(firstNme, employee.firstNme) &&
                Objects.equals(lastName, employee.lastName) &&
                Objects.equals(birthday.toString(), employee.birthday.toString());
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, firstNme, lastName, birthday, addressId);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstNme='" + firstNme + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday=" + birthday +
                ", addressId=" + addressId +
                '}';
    }
}
