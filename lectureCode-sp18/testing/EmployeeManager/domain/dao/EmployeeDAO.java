package EmployeeManager.domain.dao;

import EmployeeManager.domain.Employee;

public class EmployeeDAO {

  public void saveEmployee(Employee emp) {
//    DatabaseConnectionManager connectionManager = DatabaseConnectionManager.getManagerInstance();
//    connectionManager.connect();
//    connectionManager.getConnectionObject().prepareStatement("INSERT INTO Employee_tbl");
//    connectionManager.disconnect();
    System.out.println("saved " + emp + " to database");
  }

  public void deleteEmployee(Employee emp) {
    System.out.println("deleted " + emp + " from database");
  }
}
