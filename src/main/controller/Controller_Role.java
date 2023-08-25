package main.controller;

import main.dao.Admin_Dao;
import main.dao.DatabaseConnectionManager;
import main.entity.Role;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/role")
public class Controller_Role extends HttpServlet {
    Admin_Dao adminDao;

    public Controller_Role() throws ClassNotFoundException {
        DatabaseConnectionManager connectionManager = new DatabaseConnectionManager();
        adminDao = new Admin_Dao(connectionManager);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("roles.jsp").forward(request,response);
    }

    public void doPost(HttpServletRequest request,HttpServletResponse response){
        String action = request.getParameter("action");
        switch (action){
            case "add":
                String nomRoles = request.getParameter("nomRoles");
                Role role = new Role(0,nomRoles);
                adminDao.AddRoles(role);
                break;
            case "update":
                int id = Integer.parseInt(request.getParameter("id"));
                String roles = request.getParameter("nomRoles");
                Role role1 = new Role(id,roles);
                try {
                    adminDao.updateRoles(role1);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
        }
    }
}
