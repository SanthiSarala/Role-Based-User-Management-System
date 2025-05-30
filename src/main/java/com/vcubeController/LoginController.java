package com.vcubeController;

import java.io.IOException;

import com.vcube.dao.StudentDAO;
import com.vcube.model.RegisterModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
         System.out.println("🚀 Welcome to Login Controller!");

        // Retrieve form parameters
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
       

        // Debugging: Check if parameters are received correctly
        System.out.println("🔍 Received - Username: " + username +", password:"+password+ ", Role: " + role);

        // Validate if parameters are null or empty
        if (username == null || username.trim().isEmpty() || 
            password == null || password.trim().isEmpty() || 
            role == null || role.trim().isEmpty()) {
            
            System.out.println("❌ Missing credentials. Redirecting to login.jsp...");
            response.sendRedirect("login.jsp?error=Missing credentials");
            return;
        }
        if (password.length() < 6) {
            response.sendRedirect("login.jsp?error=Password must be at least 6 characters");
            return;
        }


        // Instantiate DAO and validate user
        StudentDAO userDAO = new StudentDAO();
        RegisterModel student = userDAO.validateUser(username, password, role);

        // Debugging: Check if user object is retrieved
        if (student != null) {
            System.out.println("✅ User found: " + student.getUsername() + " (Role: " + student.getRole() + ")");

            // Start session and set attributes
            HttpSession session = request.getSession();
            session.setAttribute("user", student);
            session.setAttribute("role", role);

            // Redirect to role-specific dashboard
            switch (role.toLowerCase()) {
                case "admin":
                    
                    response.sendRedirect("Admin.jsp");
                    System.out.println("🔄 Redirecting to Admin dashboard...");
                    break;
                case "teacher":
                    response.sendRedirect("Teacher.jsp");
                    System.out.println("🔄 Redirecting to Teacher dashboard...");
                    break;
                case "student":
                    response.sendRedirect("Student.jsp");
                    System.out.println("🔄 Redirecting to Student dashboard...");
                    break;
                default:
                    System.out.println("❌ Unknown role. Redirecting to login.jsp...");
                    response.sendRedirect("login.jsp?error=Invalid role");
            }
        } else {
            System.out.println("❌ Invalid credentials. Redirecting to login.jsp...");
            response.sendRedirect("login.jsp?error=Invalid credentials");
        }
    }
}
