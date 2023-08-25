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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/Sign-in")
public class Controller_Session extends HttpServlet {
    User_Dao userDao;

    public Controller_Session() throws ClassNotFoundException {
        DatabaseConnectionManager connectionManager = new DatabaseConnectionManager();
        userDao = new User_Dao(connectionManager);
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }

    public void doPost(HttpServletRequest request,HttpServletResponse response){
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        try {
           Users users = userDao.selectUserByEmail(email);
            if (users != null) {
                if (BCrypt.checkpw(password, users.getPassword())) {
                    HttpSession session = request.getSession();
                    session.setAttribute("id", users.getId());
                    String redirectURL = request.getContextPath() + "/produit";
                    response.sendRedirect(redirectURL);
                } else {
                    String errorMessage = "Incorrect password.";
                    request.setAttribute("error", errorMessage);
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                }
            } else {
                String errorMessage = "User with provided email not found.";
                request.setAttribute("error", errorMessage);
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            }
        } catch (SQLException | IOException | ServletException e) {
            throw new RuntimeException(e);
        }

    }
}
