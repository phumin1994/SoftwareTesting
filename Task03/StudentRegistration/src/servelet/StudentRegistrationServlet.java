package servelet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.StudentRegistration;
import bl.ProcessStudentRegistration;

public class StudentRegistrationServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProcessStudentRegistration processStudentRegistration = new ProcessStudentRegistration();
		StudentRegistration studentRegistrationReq = mapRequest(req);
		String processStudentRegistrationResponse = null;
		processStudentRegistrationResponse = processStudentRegistration.processStudentRegistration(studentRegistrationReq);
			resp.getWriter().println("<html>");
			resp.getWriter().println("<head>");
			resp.getWriter().println("<title>Response</title>");
			resp.getWriter().println("</head>");
			resp.getWriter().println("<body>");
			resp.getWriter().println("<h3 id='response'>"+processStudentRegistrationResponse+"</h3>");
			resp.getWriter().println("</body>");
			resp.getWriter().println("</html>");
	}
	
	private StudentRegistration mapRequest(HttpServletRequest req) {
		StudentRegistration request = new StudentRegistration();
		request.setFirstName(req.getParameter("firstname"));
		request.setLastName(req.getParameter("lastname"));
		request.setPersonalIdentificationCode(req.getParameter("personalcode"));
		request.setGender(req.getParameter("gender"));
		request.setAddress(req.getParameter("address"));
		request.setPhonenumber(req.getParameter("phonenumber"));
		request.setStudyprogram(req.getParameter("studyprogram"));
		request.setFormofstudy(req.getParameter("formofstudy"));
		return request;
	}
}
