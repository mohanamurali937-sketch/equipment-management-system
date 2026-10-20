package model;

import jakarta.persistence.*;

@Entity
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type;
    private String status = "AVAILABLE";

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    // Constructors, Getters, and Setters
    public Equipment() {}

    public Equipment(String name, String type) {
        this.name = name;
        this.type = type;
        this.status = "AVAILABLE";
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public Employee getEmployee() { return employee; }
    public void setEmployee(Employee employee) { this.employee = employee; }
}