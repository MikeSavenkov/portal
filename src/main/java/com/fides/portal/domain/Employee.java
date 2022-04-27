package com.fides.portal.domain;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String subdivision;
    private String position;

    public Employee() {

    }

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setSubdivision(String subdivision) {
        this.subdivision = subdivision;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getSubdivision() {
        return subdivision;
    }
    public String getPosition() {
        return position;
    }

}
