package crud_exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		String name= request.getParameter("name");
		String grade= request.getParameter("grade");
		String address= request.getParameter("address");
		String mobile = request.getParameter("mobile");
		String bank= request.getParameter("bank");
		
		
		Employee employee = new Employee();
		
		employee.setName(name);
		employee.setGrade(grade);
		employee.setMobile(mobile);
		employee.setAddress(address);
		employee.setBank(bank);
		
		
		int status = EmployeeDAO.save(employee,1);
		
		if(status>0) {
			out.print("<p> Record Saved Successfully</p>");
			request.getRequestDispatcher("index.html").include(request, response);
		}else {
			out.print("Sorry ! Unable to save record");
		}
		out.close();
	}
	
}
