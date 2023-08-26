package main.controller;

import main.dao.Admin_Dao;
import main.dao.DatabaseConnectionManager;
import main.entity.Category;
import main.entity.Role;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/category")
public class Controller_Category extends HttpServlet {
    Admin_Dao adminDao;

    public Controller_Category() throws ClassNotFoundException {
        DatabaseConnectionManager connectionManager = new DatabaseConnectionManager();
        adminDao = new Admin_Dao(connectionManager);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action){
            case "update":
                String id = request.getParameter("id");
                System.out.println(id);
                request.getRequestDispatcher("category-update.jsp").forward(request,response);
            case "afficher":
                try {
                    List<Category> categories = adminDao.selectToutCategorie();
                    request.setAttribute("categories",categories);
                    request.getRequestDispatcher("category.jsp").forward(request,response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
        }

    }

    public void doPost(HttpServletRequest request,HttpServletResponse response){
        String action = request.getParameter("action");
        switch (action){
            case "add":
                String nomCategori = request.getParameter("nomCategori");
                Category category = new Category(0,nomCategori);
                adminDao.AddCategorie(category);
                break;
            case "update":
                int id = Integer.parseInt(request.getParameter("id"));
                String nomCategori_update = request.getParameter("nomCategori");
                Category cat = new Category(id,nomCategori_update);
                try {
                    adminDao.updateCategory(cat);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "delete":
                int id_delete = Integer.parseInt(request.getParameter("id"));
                adminDao.supprimerCategorie(id_delete);
        }
    }
}
