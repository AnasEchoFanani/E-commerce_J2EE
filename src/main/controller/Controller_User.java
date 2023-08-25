package main.controller;

import main.dao.DatabaseConnectionManager;
import main.dao.User_Dao;
import main.entity.Users;
import org.mindrot.jbcrypt.BCrypt;

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

    public Controller_User() throws ClassNotFoundException {
        DatabaseConnectionManager connectionManager = new DatabaseConnectionManager();
        userDao = new User_Dao(connectionManager);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action){
            case "register":
                request.getRequestDispatcher("index.jsp").forward(request,response);
                break;
            case "change":
                Users user = userDao.getUserById(Integer.parseInt(request.getParameter("id")));
                request.setAttribute("user",user);
                request.getRequestDispatcher("sign.jsp").forward(request,response);
                break;
        }
    }

    public void doPost(HttpServletRequest request,HttpServletResponse response) {
        String action = request.getParameter("action");
        switch (action){
            case "register":
                String regNom = request.getParameter("nom");
                String regPrenom = request.getParameter("prenom");
                String regEmail = request.getParameter("email");
                int regAge = Integer.parseInt(request.getParameter("age"));
                String regPlainPassword = request.getParameter("password");
                String regHashedPassword = BCrypt.hashpw(regPlainPassword, BCrypt.gensalt());
                Users regUser = new Users(regNom,regPrenom,regEmail,regAge,regHashedPassword,2);
                userDao.ajouterUseres(regUser);

                break;

            case "update":
                int id_user = Integer.parseInt(request.getParameter("id"));
                String nom = request.getParameter("nom");
                String prenom = request.getParameter("prenom");
                String email = request.getParameter("email");
                int age = Integer.parseInt(request.getParameter("age"));
                String plainPassword = request.getParameter("password"); // Get the plain password

                // Hash the plain password using BCrypt
                String hashedPassword = BCrypt.hashpw(plainPassword, BCrypt.gensalt());

                Users users = new Users(id_user, nom, prenom, email, age, hashedPassword, 2);

                try {
                    userDao.updateUser(users); // Update user information including hashed password
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "delete" :
                int id_delete = Integer.parseInt(request.getParameter("id"));
                userDao.supprimerUsers(id_delete);
                break;
        }
    }
}
