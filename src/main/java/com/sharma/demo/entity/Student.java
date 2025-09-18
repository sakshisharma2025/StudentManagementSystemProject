package com.sharma.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Only letters A-Z / a-z, at least one letter
    @Column(name = "first_name", nullable = false)
    @NotBlank(message = "First name is required")
    @Pattern(regexp = "^[A-Za-z]+$", message = "Name is not acceptable — only letters allowed")
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @NotBlank(message = "Last name is required")
    @Pattern(regexp = "^[A-Za-z]+$", message = "Name is not acceptable — only letters allowed")
    private String lastName;

    // Email must start with an alphanumeric char and end with @gmail.com
    // ^[A-Za-z0-9]  => first char mandatory alphanumeric
    // [A-Za-z0-9._%+-]* => optional subsequent allowed chars before domain
    // @gmail\.com$ => must end with @gmail.com
    @Column(nullable = false, unique = true)
    @NotBlank(message = "Email is required")
    @Pattern(regexp = "^[A-Za-z0-9][A-Za-z0-9._%+-]*@gmail\\.com$", message = "Email must be a valid Gmail address (example@gmail.com)")
    private String email;

    public Student() {}

    public Student(int id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    // getters / setters
    public int getId() { 
        return id;
    }
    public void setId(int id) {
        this.id = id;
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

    public String getEmail() {
        return email; 
    }
    public void setEmail(String email) { 
        this.email = email; 
    }
}
