package crud_exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//response.setContentType("text/html);
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		
		Employee e = new Employee();
		e.setId(id);
		
		int status = EmployeeDAO.delet(e);
		
		PrintWriter out = response.getWriter();
		
		if(status>0) {
			out.print("<p> Delet Successfully</p>");
			
			request.getRequestDispatcher("ViewServlet").include(request, response);
		}else {
			out.print("Sorry ! Unable to delet");
		}
		out.close();
		
	}
}
