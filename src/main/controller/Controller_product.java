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
import javax.servlet.http.Part;
import java.io.*;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10,      // 10MB
        maxRequestSize = 1024 * 1024 * 50    // 50MB
)
public class  Controller_product extends HttpServlet {
    Product_Dao productDao;

    public Controller_product() throws ClassNotFoundException {
        DatabaseConnectionManager connectionManager = new DatabaseConnectionManager(); // Initialize the connection manager
        productDao = new Product_Dao(connectionManager);
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        try {
            List<Produit> produits = productDao.selectToutProduit();
            request.setAttribute("produits",produits);
            request.getRequestDispatcher("user/index.jsp").forward(request,response);
        } catch (SQLException | ServletException | IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action){
            case "add":
                String nomProduit = request.getParameter("nomProduit");
                Double prix = Double.valueOf(request.getParameter("prix"));
                int qnt = Integer.parseInt(request.getParameter("qnt"));
                int idCategor = Integer.parseInt(request.getParameter("idCategor"));
                String imageFolder = getServletContext().getRealPath("/images"); // Folder to store uploaded images
                String imageName = request.getPart("imageFile").getSubmittedFileName();
                String imagePath = imageFolder + File.separator + imageName;

                // Save the image to the image folder
                try (InputStream fileContent = request.getPart("imageFile").getInputStream();
                     OutputStream os = new FileOutputStream(imagePath)) {
                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    while ((bytesRead = fileContent.read(buffer)) != -1) {
                        os.write(buffer, 0, bytesRead);
                    }
                }
                Produit produit = new Produit(nomProduit,qnt,prix,imageName,idCategor);
                productDao.ajouterProduit(produit);
                response.sendRedirect("/karma/admin");
                break;
            case "update":
                String nomProduit2 = request.getParameter("nomProduit");
                Double prix2 = Double.valueOf(request.getParameter("prix"));
                int qnt2 = Integer.parseInt(request.getParameter("qnt"));
                int idCategor2 = Integer.parseInt(request.getParameter("idCategor"));
                String imageFolder2 = getServletContext().getRealPath("/images"); // Folder to store uploaded images
                String imageName2 = request.getPart("imageFile").getSubmittedFileName();
                String imagePath2 = imageFolder2 + File.separator + imageName2;

                // Save the image to the image folder
                try (InputStream fileContent = request.getPart("imageFile").getInputStream();
                     OutputStream os = new FileOutputStream(imagePath2)) {
                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    while ((bytesRead = fileContent.read(buffer)) != -1) {
                        os.write(buffer, 0, bytesRead);
                    }
                }
                Produit produit2 = new Produit(nomProduit2,qnt2,prix2,imageName2,idCategor2);
                productDao.modifierProduit(produit2);
                break;
            case "delete":
                int id_delete = Integer.parseInt(request.getParameter("id"));
                try {
                    productDao.supprimerProduit(id_delete);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                response.sendRedirect("/karma/admin");
                break;
        }
    }
}
