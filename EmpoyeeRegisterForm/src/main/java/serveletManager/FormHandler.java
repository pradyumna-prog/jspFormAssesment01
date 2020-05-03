package serveletManager;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import serveletManager.model.EmployeeModel;

@WebServlet("/addEmployee")
public class FormHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(EmployeeModel.class);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(reg);
		Session session = sf.openSession();
		session.beginTransaction();
		
		{
			EmployeeModel obj = new EmployeeModel();
			obj.setFirstName(request.getParameter("firstName"));
			obj.setLastName(request.getParameter("lastName"));
			obj.setUserName(request.getParameter("userName"));
			obj.setPassword(request.getParameter("password"));
			obj.setAddress(request.getParameter("address"));
			obj.setContact(request.getParameter("contact"));
			session.save(obj);
		}

		session.getTransaction().commit();
		
		String str = "<h2>Successfully Saved Data</h2>";
		request.setAttribute("result", str);
		
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
