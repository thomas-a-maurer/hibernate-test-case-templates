package org.hibernate.bugs.entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "PHONE", schema = "DIRECTORY")
public class Phone {

    @Id
    @SequenceGenerator(name = "DIRECTORY.seqPhone", schema = "DIRECTORY", sequenceName = "SEQ_PHONE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DIRECTORY.seqPhone")
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "EMPLOYEE_ID")
    private Long employeeId;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Phone)) {
            return false;
        }
        return Objects.equals(id, ((Phone) object).getId());
    }

    @Override
    public String toString() {
        return "Phone {" +
                "id=" + id + ", " +
                "name='" + name + "', " +
                "phoneNumber='" + phoneNumber + "', " +
                "employeeId=" + employeeId + '}'                ;
    }
}
