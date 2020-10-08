package crud_exam;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		out.println("<a href='index.html'>Add New Employee</a>");
		out.println("<h2> Employee List </h2>");
		
		List<Employee> list= EmployeeDAO.getAll();
			
		
		out.println("<table border='1'>");
		out.println("<tr> <th>Name</th><th>Grade</th> <th>Address</th> <th>Mobile Number</th><th>Bank Account</th><th>Salary</th> <th colspan='2'>Action</th></tr>");
		
		for(Employee e : list) {
			
			EmployeeDAO.salary(e, Integer.parseInt(e.getGrade()));
			
			out.println("<tr>  <td>"+e.getName()+"</td>  <td>"+e.getGrade()+"</td>  <td>"+e.getAddress()+"</td> <td>"+e.getMobile()+"</td>  <td>"+e.getBank()+"</td>  <td>"+e.getSalary()+"</td>  <td><a href='EditServlet?id="+e.getId()+"'>Edit</a></td><td><a href='DeleteServlet?id="+e.getId()+"'>Delete</a></td></tr>");
			
		//	System.out.println(e.getSalary());
		}
		
		out.println("</table>");
		out.close();
	}
}
