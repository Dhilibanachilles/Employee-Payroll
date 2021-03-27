import java.util.List;
import org.junit.Assert;
import org.junit.Test;


public class EmployeePayroll_Test {

	EmployeePayroll_DB employeePayrollService = new EmployeePayroll_DB();
	
	
	@Test
	public void givenEmployeePayrollInDB_WhenRetrieved_ShouldMatchEmployeeCount()
	{
		List<EmployeeData> employeePayrollData = employeePayrollService.readData();
		Assert.assertEquals(3, employeePayrollData.size());
	}
	
	
	@Test
	public void givenNewSalaryToEmployee_WhenUpdated_ShouldSyncWithDatabase()
	{
		List<EmployeeData> employeePayrollData = employeePayrollService.readData();
		employeePayrollService.updateEmployeeSalary("Terrisa",3000000.0);
		boolean result = employeePayrollService.checkEmployeePayrollSyncWithDB("Terrisa");
		Assert.assertTrue(result);
	}
	
	
		@Test
		public void givenNewSalaryToEmployee_WhenUpdated_ShouldSyncWithDatabaseUsingPreparedStatement()
		{
			List<EmployeeData> employeePayrollData = employeePayrollService.readData();
			employeePayrollService.updateEmployeeSalary("Terrisa",3000000.0);
			boolean result = employeePayrollService.checkEmployeePayrollSyncWithDB("Terrisa");
			Assert.assertTrue(result);
		}
}