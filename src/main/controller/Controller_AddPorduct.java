package main.controller;

import main.dao.Admin_Dao;
import main.dao.DatabaseConnectionManager;
import main.dao.Product_Dao;
import main.entity.Category;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/AddProduct")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10,      // 10MB
        maxRequestSize = 1024 * 1024 * 50    // 50MB
)
public class Controller_AddPorduct extends HttpServlet {
    Product_Dao productDao;
    Admin_Dao adminDao;

    public Controller_AddPorduct() throws ClassNotFoundException {
        DatabaseConnectionManager connectionManager = new DatabaseConnectionManager(); // Initialize the connection manager
        productDao = new Product_Dao(connectionManager);
        adminDao = new Admin_Dao(connectionManager);
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Category> categories = adminDao.selectToutCategorie();
            request.setAttribute("categories", categories);
            for (Category category : categories){
                System.out.println(category.getNomCategori()+" "+category.getId());
            }
            request.getRequestDispatcher("dashboard/examples/addProduct.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //
    }
}
