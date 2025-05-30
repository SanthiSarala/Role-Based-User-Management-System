package com.vcubeController;

import java.io.IOException;
import com.vcube.dao.StudentDAO;
import com.vcube.model.RegisterModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	System.out.println("Hello Register Controller!!!!!!!!!!!");
    	int id=Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        String role = request.getParameter("role");

        if (!password.equals(confirmPassword)) {
            response.sendRedirect("register.jsp?error=Passwords do not match");
            return;
        }

        RegisterModel student = new RegisterModel();
        student.setId(id);
        student.setUsername(username);
        student.setFirstname(firstname);
        student.setLastname(lastname);
        student.setEmail(email);
        student.setPassword(password);
        student.setRole(role);
        System.out.println(student);

        StudentDAO studentDAO = new StudentDAO();
        String result = studentDAO.insertStudent(student);

        if ("SUCCESS".equals(result)) {
        	System.out.println("Redirecting to login page");
            response.sendRedirect("login.jsp");
        } else {
        	System.out.println("redirecting to register page");
            response.sendRedirect("register.jsp");
        }
    }
}
