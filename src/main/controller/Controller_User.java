package main.controller;

import main.dao.User_Dao;
import main.entity.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/user")
public class Controller_User extends HttpServlet{
    User_Dao userDao;

    public Controller_User(){
        userDao = new User_Dao();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Users user = userDao.getUserById(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("user",user);
        request.getRequestDispatcher("userDashboard.jsp").forward(request,response);
    }

    public void doPost(HttpServletResponse response,HttpServletRequest request) throws SQLException {
        String action = request.getParameter("action");
        switch (action){
            case "update":
                int id_user = Integer.parseInt(request.getParameter("id"));
                String nom = request.getParameter("nom");
                String prenom = request.getParameter("prenom");
                String email = request.getParameter("email");
                int age = Integer.parseInt(request.getParameter("age"));
                Users users = new Users(id_user,nom,prenom,email,age,2);

                userDao.updateUser(users);
            case "delete" :
                int id_delete = Integer.parseInt(request.getParameter("id"));
                userDao.supprimerUsers(id_delete);
        }
    }
}
