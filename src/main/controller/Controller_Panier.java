package main.controller;

import main.dao.DatabaseConnectionManager;
import main.dao.Product_Dao;
import main.entity.Panier;
import main.entity.Produit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/cart")
public class Controller_Panier extends HttpServlet {
    Product_Dao productDao;
    public Controller_Panier() throws ClassNotFoundException {
        DatabaseConnectionManager connectionManager = new DatabaseConnectionManager(); // Initialize the connection manager
        productDao = new Product_Dao(connectionManager);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Panier> cartItems = getCartItemsFromCookies(request);
        List<Produit> produits = new ArrayList<>(); // Create a list to hold produits

        for (Panier cartItem : cartItems) {
            Produit panier = productDao.getProduitById(cartItem.getId_Produit());
            produits.add(panier);
        }

        request.setAttribute("produits", produits); // Set the produits attribute
        request.getRequestDispatcher("user/cart.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int newItemProductId = Integer.parseInt(request.getParameter("id_produit"));
        int newItemQuantity = Integer.parseInt(request.getParameter("qte"));

        Panier newItem = new Panier(newItemProductId, newItemQuantity);
        addCartItemToCookies(newItem, response);

        response.sendRedirect(request.getContextPath() + "/cart");
    }

    private List<Panier> getCartItemsFromCookies(HttpServletRequest request) throws UnsupportedEncodingException {
        List<Panier> cartItems = new ArrayList<>();
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("cart_item")) {
                    String cookieValue = URLDecoder.decode(cookie.getValue(), StandardCharsets.UTF_8.toString());
                    String[] values = cookieValue.split(",");
                    if (values.length == 2) {
                        int idProduit = Integer.parseInt(values[0]);
                        int qte = Integer.parseInt(values[1]);
                        Panier item = new Panier(idProduit, qte);
                        cartItems.add(item);
                    }
                }
            }
        }
        return cartItems;
    }

    private void addCartItemToCookies(Panier item, HttpServletResponse response) {
        String cookieValue = item.getId_Produit() + "," + item.getQte();
        try {
            cookieValue = URLEncoder.encode(cookieValue, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace(); // Handle encoding exception
            return;
        }

        Cookie cookie = new Cookie("cart_item", cookieValue);
        cookie.setMaxAge(24 * 60 * 60); // Cookie expiration time in seconds (1 day)
        cookie.setPath("/"); // Set the cookie path to the root of the domain
        response.addCookie(cookie);
    }
}
