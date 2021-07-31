package employeepayrolljdbc;


import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;


public class EmployeePayRollDBService
{
	public static void main(String[] args)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		} 
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		ListDrivers();
		try
		{
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll_service?useSSL=false"
				, "root", "Peddamavaya_1952@");
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		System.out.println("Connection Done..!!!");
	}

	private static void ListDrivers()
	{
		Enumeration<Driver> driverList=DriverManager.getDrivers();
		while(driverList.hasMoreElements())
		{
			Driver driverClass=(Driver)driverList.nextElement();
			System.out.println("  "+driverClass.getClass().getName());
		}
	}
}