package crud_exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

	// Database connection
	public static Connection getConnection() {
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/crud";
		String user = "root";
		String password = "1234";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			System.out.println("Database connected...");
		} catch (Exception e) {
			System.out.println(e);
		}

		return con;
	}
	
	public static void salary(Employee e, int grade) {
		String sql;
		try {
			Connection connection = EmployeeDAO.getConnection();
			
				sql = "SELECT salary FROM basic_salary where id= 1 ";
	
				PreparedStatement p = connection.prepareStatement(sql);
				ResultSet rs = p.executeQuery();
				
				while (rs.next()) {
 			
					int a = rs.getInt(1);
					
					
			          double basic =(double) (a + 5000 * (6 - grade));
					  double salaryPerPerson = (basic + basic * .35);
					  
					  e.setSalary(salaryPerPerson);
					
				}
				//System.out.println(e.getSalary());

			connection.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	

	// Data Insert into user table
	public static int save(Employee e, int a) {
		
		int status = 0;
		String sql;
		PreparedStatement p;
		int i = e.getId();

		try {
			Connection connection = EmployeeDAO.getConnection();
			if (a == 1) {
				sql = "INSERT INTO employee (name,grade, address, mobile_num, bank_acc) VALUES (?,?,?,?,?)";
				

			} else {

				sql = "update employee set name=?,grade=?, address=?, mobile_num=?, bank_acc=? where id=" + i;

			}
			
			

			p = connection.prepareStatement(sql);
			p.setString(1, e.getName());
			p.setString(2, e.getGrade());
			p.setString(3, e.getAddress());
			p.setString(4, e.getMobile());
			p.setString(5, e.getBank());

			status = p.executeUpdate();

			connection.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return status;

	}

	
	public static List<Employee> getAll() {

		List<Employee> list = new ArrayList<Employee>();
		try {
			Connection conection = EmployeeDAO.getConnection();

			String sql = "SELECT * FROM employee";
			PreparedStatement p = conection.prepareStatement(sql);
			ResultSet rs = p.executeQuery();

			while (rs.next()) {
				Employee em = new Employee();
				em.setId(rs.getInt(1));
				em.setName(rs.getString(2));
				em.setGrade(rs.getString(3));
				em.setAddress(rs.getString(4));
				em.setMobile(rs.getString(5));
				em.setBank(rs.getString(6));

				list.add(em);

			}
			conection.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}
	  
  
	public static int delet(Employee e) {
		int status = 0;
		try {
			Connection connection = EmployeeDAO.getConnection();
			String sql = "DELETE FROM employee WHERE id=?";
			;
			PreparedStatement p = connection.prepareStatement(sql);

			p.setInt(1, e.getId());

			status = p.executeUpdate();
			connection.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return status;

	}

	public static Employee getInfoById(int id) {
		Employee em = new Employee();

		try {
			Connection connection = EmployeeDAO.getConnection();
			String sql = "SELECT * FROM employee WHERE id=?";
			PreparedStatement p = connection.prepareStatement(sql);
			p.setInt(1, id);
			ResultSet rs = p.executeQuery();
			if (rs.next()) {
				em.setId(rs.getInt(1));
				em.setName(rs.getString(2));
				em.setGrade(rs.getString(3));
				em.setAddress(rs.getString(4));
				em.setMobile(rs.getString(5));
				em.setBank(rs.getString(6));

			}
			p.executeUpdate();
			connection.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return em;

	}
	 

}
