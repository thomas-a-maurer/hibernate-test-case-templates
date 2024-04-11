package org.hibernate.bugs.entity;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "EMPLOYEE", schema = "DIRECTORY")
public class Employee {

    @Id
    @SequenceGenerator(name = "DIRECTORY.seqEmployee", schema = "DIRECTORY", sequenceName = "SEQ_EMPLOYEE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DIRECTORY.seqEmployee")
    @Column(name = "ID")
    private Long id;

    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "COMPANY_ID")
    private Long companyId;

    @ElementCollection
    @CollectionTable(schema = "DIRECTORY", name = "PHONE", joinColumns = @JoinColumn(name = "EMPLOYEE_ID"))
    @Column(name = "PHONE_NUMBER")
    private List<String> phoneNumbers;

    public Long getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
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
        if (!(object instanceof Employee)) {
            return false;
        }
        return Objects.equals(id, ((Employee) object).getId());
    }

    @Override
    public String toString() {
        return "Employee {" +
                "id=" + id + ", " +
                "userId='" + userId + "', " +
                "firstName='" + firstName + "', " +
                "lastName='" + lastName + "', " +
                "companyId=" + companyId + ", " +
                "phoneNumbers=" + phoneNumbers + '}';
    }
}
