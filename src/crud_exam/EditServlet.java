package crud_exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h2>Update Employee Information</h2>");
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		
		Employee em =  EmployeeDAO.getInfoById(id);
	
		
		out.println("<form action='UpdateServlet' method='POST'>");
		out.println("<table>");
		out.println("<tr><td></td><td><input type='hidden' name='id' value='"+em.getId()+"' /></td></tr>");
		out.println("<tr><td>Name : </td><td><input type='text' name='name' value='"+em.getName()+"' /></td></tr>");
		out.println("<tr><td>Grade : </td><td><input type='text' name='grade' value='"+	em.getGrade()+"' /></td></tr>");
		out.println("<tr><td>Address : </td><td><input type='text' name='address' value='"+	em.getAddress()+"' /></td></tr>");
		out.println("<tr><td>Mobile Number: </td><td><input type='text' name='mobile' value='"+	em.getMobile()+"' /></td></tr>");
		out.println("<tr><td>Bank Account : </td><td><input type='text' name='bank' value='"+	em.getBank()+"' /></td></tr>");
		
	
		
		out.println("<tr><td colspan='2'><input type='submit'  value='Update'/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td></tr>");
		out.println("</table>");
		out.println("</form>");
		
		
		
		out.close();
		
		
		
		
		
		
		
		
	}

	
}
