package com.example.demo.employ;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Employ {

    @Id
    @SequenceGenerator(
            name = "employ_sequence",
            sequenceName = "employ_sequence",
            allocationSize = 1

    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "employ_sequence"
    )
    private Long id;
    private String name;
    private LocalDate dayOfBirth;
    private String email;
    private Integer salary;

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Transient
    private Integer age;

    public Employ() {
    }

    public Employ(Long id, String name, LocalDate dayOfBirth, String email,Integer salary) {
        this.id = id;
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.email = email;
        this.salary =salary;
    }

    public Employ(String name, LocalDate dayOfBirth, String email, Integer salary) {
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.email = email;
        this.salary=salary;
    }

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

    public Integer getAge() {
        return Period.between(this.dayOfBirth,LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(LocalDate dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Employ{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dayOfBirth=" + dayOfBirth +
                ", email='" + email + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }
}
