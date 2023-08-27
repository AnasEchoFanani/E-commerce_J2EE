package main.controller;

import main.dao.Admin_Dao;
import main.dao.DatabaseConnectionManager;
import main.dao.Product_Dao;
import main.entity.Category;
import main.entity.Produit;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/admin")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10,      // 10MB
        maxRequestSize = 1024 * 1024 * 50    // 50MB
)
public class Controller_TableProduct extends HttpServlet {
    Product_Dao productDao;
    Admin_Dao adminDao;
    public Controller_TableProduct() throws ClassNotFoundException {
        DatabaseConnectionManager connectionManager = new DatabaseConnectionManager(); // Initialize the connection manager
        productDao = new Product_Dao(connectionManager);
        adminDao = new Admin_Dao(connectionManager);
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Produit> produitList = new ArrayList<>(); // Initialize the list

        try {
            List<Produit> produits = productDao.selectToutProduit();
            List<Category> categories = adminDao.selectToutCategorie();

            for (Produit produit : produits) {
                Category category = null; // Initialize category to null

                // Find the corresponding category for the current produit
                for (Category cat : categories) {
                    if (produit.getidCategor() == cat.getId()) {
                        category = cat;
                        break;
                    }
                }

                if (category != null) {
                    Produit produit1 = new Produit(
                            produit.getId(),
                            produit.getNomProduit(),
                            produit.getQnt(),
                            produit.getPrix(),
                            produit.getImage(),
                            produit.getidCategor(),
                            category.getNomCategori()
                    );
                    produitList.add(produit1);
                }
            }

            request.setAttribute("produitList", produitList);
            request.getRequestDispatcher("dashboard/examples/dashboard.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //
    }
}
