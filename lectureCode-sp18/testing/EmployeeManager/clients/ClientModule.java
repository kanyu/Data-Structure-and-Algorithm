package EmployeeManager.clients;

import EmployeeManager.domain.Employee;
import EmployeeManager.domain.dao.EmployeeDAO;

public class ClientModule {
  public static void main(String[] args){
    Employee emp = new Employee(1, "Kan", "Janitor", true);
    ClientModule.hireNewEmployee(emp);
  }
  public static void hireNewEmployee(Employee emp) {
    EmployeeDAO empDAO = new EmployeeDAO();
    empDAO.saveEmployee(emp);
  }

  public static void terminateEmployee(Employee emp) {
    EmployeeDAO empDAO = new EmployeeDAO();
    empDAO.deleteEmployee(emp);
  }

  public static void printEmployeeReport(Employee emp) {

  }
}
