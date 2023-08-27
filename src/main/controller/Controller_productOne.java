package main.controller;

import main.dao.DatabaseConnectionManager;
import main.dao.Product_Dao;
import main.entity.Produit;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/produitOne")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10,      // 10MB
        maxRequestSize = 1024 * 1024 * 50    // 50MB
)
public class Controller_productOne extends HttpServlet {
    Product_Dao productDao;

    public Controller_productOne() throws ClassNotFoundException {
        DatabaseConnectionManager connectionManager = new DatabaseConnectionManager(); // Initialize the connection manager
        productDao = new Product_Dao(connectionManager);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        Produit produits = productDao.getProduitById(Integer.parseInt(id));
        request.setAttribute("produits", produits);
        request.getRequestDispatcher("user/single-product.html").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //
    }
}
