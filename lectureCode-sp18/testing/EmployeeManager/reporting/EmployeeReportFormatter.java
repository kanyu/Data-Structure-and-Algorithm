package EmployeeManager.reporting;

public class EmployeeReportFormatter extends ReportFormatter{
  public EmployeeReportFormatter(EmployeeManager.domain.Employee emp, FormatType format) {
    super(emp, format);
  }

  public String getFormattedEmployee(){
    return getFormattedValue();
  }
}
