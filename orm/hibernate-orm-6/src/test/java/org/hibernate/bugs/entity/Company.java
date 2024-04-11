package org.hibernate.bugs.entity;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Set;

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
import jakarta.persistence.Version;

@Entity
@Table(name = "COMPANY", schema = "DIRECTORY")
public class Company {

    @Id
    @SequenceGenerator(name = "DIRECTORY.seqCompany", schema = "DIRECTORY", sequenceName = "SEQ_COMPANY", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DIRECTORY.seqCompany")
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Version
    @Column(name = "VERSION")
    private Integer version;

    @ElementCollection
    @CollectionTable(schema = "DIRECTORY", name = "EMPLOYEE", joinColumns = @JoinColumn(name = "COMPANY_ID"))
    @Column(name = "USER_ID")
    private Set<String> employeeUserIds;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<String> getEmployeeUserIds() {
        return employeeUserIds;
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
        if (!(object instanceof Company)) {
            return false;
        }
        return Objects.equals(id, ((Company )object).getId());
    }

    @Override
    public String toString() {
        return "Company {" +
                "id=" + id + ", " +
                "name='" + name + "', " +
                "version=" + version + ", " +
                "employeeUserIds=" + employeeUserIds + '}';
    }
}
