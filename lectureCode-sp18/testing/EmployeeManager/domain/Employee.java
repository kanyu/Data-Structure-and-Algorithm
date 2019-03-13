package EmployeeManager.domain;

public class Employee {
  private int id;
  private String name;
  private String department;
  private Boolean working;

  public Employee(int id, String name, String department, Boolean working) {
    this.id = id;
    this.name = name;
    this.department = department;
    this.working = working;
  }

  public int getId() {
    return id;
  }

  @Override
  public String toString() {
    return "Employee{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", department='" + department + '\'' +
        ", working=" + working +
        '}';
  }

  public String getName() {
    return name;
  }

  public String getDepartment() {
    return department;
  }

  public Boolean getWorking() {
    return working;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public void setWorking(Boolean working) {
    this.working = working;
  }
}
