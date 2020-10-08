package crud_exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		
		
        Employee employee = new Employee();
		
        employee.setId(id);
		employee.setName(request.getParameter("name"));
		employee.setGrade(request.getParameter("grade"));
		employee.setAddress(request.getParameter("address"));
		employee.setMobile(request.getParameter("mobile"));
		employee.setBank(request.getParameter("bank"));
		 
		int status = EmployeeDAO.save(employee,2);
		
		if(status>0) {
			
			out.print("<p>Edit Successfully</p>");
			response.sendRedirect("ViewServlet");
			
			
		}
		else {
			out.println("Sorry! Unable to Edit");
		}
		
	}
	
}
