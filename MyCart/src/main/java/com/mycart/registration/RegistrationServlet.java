//code by ab;;
//package com.mycart.registration;
//import java.io.IOException;
//
//import java.io.PrintWriter;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//@WebServlet("/register")  // Ensure this matches your form action
//public class RegistrationServlet extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//
//        String uname = request.getParameter("name");
//        String uemail = request.getParameter("email");
//        String upwd = request.getParameter("pass");
//        String umobile = request.getParameter("mobile");
//
//        try {
//            // Load MySQL JDBC Driver
//            Class.forName("com.mysql.cj.jdbc.Driver");
//
//            // Connect to Database
//           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mycart?useSSL=false&allowPublicKeyRetrieval=true","root","9022617321@Vinay");
//           
//
//
//            // Insert Query
//            String query = "INSERT INTO users(uname, uemail, upwd, umobile) VALUES (?, ?, ?, ?)";
//            PreparedStatement ps = con.prepareStatement(query);
//            ps.setString(1, uname);
//            ps.setString(2, uemail);
//            ps.setString(3, upwd);
//            ps.setString(4, umobile);
//            
//            int rowCount = pst.executeUpdate();
//      	  dispatcher= request.getRequestDispatcher(".jsp");
//      	  if(rowCount>0) {
//      		  request.setAttribute("status","success");
//      		  
//      	  }else {
//      		  request.setAttribute("status","Failed");     	  }
//
//            int i = ps.executeUpdate();
//
//            if (i > 0) {
//                // Redirect to index.jsp after successful registration
//                response.sendRedirect("index.jsp");
//            } else {
//                out.println("<h3>Registration failed, please try again.</h3>");
//            }
//
//            ps.close();
//            con.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//            out.println("<h3>Error: " + e.getMessage() + "</h3>");
//        }
//    }
//}

//old
//package com.mycart.registration;
//
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
//import jakarta.servlet.RequestDispatcher;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
///**
// * Servlet implementation class RegistrationServlet
// */
//@WebServlet("/register")
//public class RegistrationServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
// 
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
//			throws ServletException, IOException {
//      String uname = request.getParameter("name");
//      String uemail = request.getParameter("email");
//      String upwd = request.getParameter("pass");
//      String umobile = request.getParameter("mobile");
//      RequestDispatcher dispatcher = null;
//      Connection con = null;
//      try {
//    	  Class.forName("com.mysql.cj.jdbc.Driver");
//    	  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mycart","root","9022617321@Vinay");
//    	  PreparedStatement pst = con.prepareStatement("insert into users(uname,upwd,uemail,umobile)values(?,?,?,?)");
//    	  pst.setString(1, uname);
//    	  pst.setString(2, upwd);
//    	  pst.setString(3, uemail);
//    	  pst.setString(4, umobile);
//    	  

//      }catch(Exception e) {
//    	  e.printStackTrace();
//      }finally {
//    	  try {
//    		  con.close();
//    	  }catch (SQLException e) {
//    		  e.printStackTrace();
//    	  }
//    	  
//      }
//	}
//
//}







package com.mycart.registration;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")  
public class RegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        RequestDispatcher dispatcher = null;

        String uname = request.getParameter("name");
        String uemail = request.getParameter("email");
        String upwd = request.getParameter("pass");
        String umobile = request.getParameter("mobile");

        Connection con = null;
        PreparedStatement ps = null;

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to Database
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/mycart?useSSL=false&allowPublicKeyRetrieval=true",
                "root",
                "9022617321@Vinay"
            );

            // Insert Query
            String query = "INSERT INTO users(uname, uemail, upwd, umobile) VALUES (?, ?, ?, ?)";
            ps = con.prepareStatement(query);
            ps.setString(1, uname);
            ps.setString(2, uemail);
            ps.setString(3, upwd);
            ps.setString(4, umobile);
            
            int rowCount = ps.executeUpdate();
            
            if (rowCount > 0) {
                request.setAttribute("status", "success");
            } else {
                request.setAttribute("status", "failed");
            }

            // Forward request back to register.jsp with status message
            dispatcher = request.getRequestDispatcher("register.jsp");
            dispatcher.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            out.println("<h3>Error: " + e.getMessage() + "</h3>");
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}

