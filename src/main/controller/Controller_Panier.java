package main.controller;

import main.entity.Panier;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/cart")
public class Controller_Panier extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Panier> cartItems = getCartItemsFromCookies(request);

        request.setAttribute("cartItems", cartItems);
        request.getRequestDispatcher("/cart.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int newItemId = Integer.parseInt(request.getParameter("id"));
        int newItemProductId = Integer.parseInt(request.getParameter("id_produit"));
        int newItemQuantity = Integer.parseInt(request.getParameter("qte"));

        Panier newItem = new Panier(newItemId, newItemProductId, newItemQuantity);
        addCartItemToCookies(newItem, response);

        response.sendRedirect(request.getContextPath() + "/cart");
    }

    private List<Panier> getCartItemsFromCookies(HttpServletRequest request) {
        List<Panier> cartItems = new ArrayList<>();
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("cart_item")) {
                    String[] values = cookie.getValue().split(",");
                    if (values.length == 3) {
                        int id = Integer.parseInt(values[0]);
                        int idProduit = Integer.parseInt(values[1]);
                        int qte = Integer.parseInt(values[2]);
                        Panier item = new Panier(id, idProduit, qte);
                        cartItems.add(item);
                    }
                }
            }
        }
        return cartItems;
    }

    private void addCartItemToCookies(Panier item, HttpServletResponse response) {
        String cookieValue = item.getId() + "," + item.getId_Produit() + "," + item.getQte();
        Cookie cookie = new Cookie("cart_item", cookieValue);
        cookie.setMaxAge(24 * 60 * 60); // Cookie expiration time in seconds (1 day)
        response.addCookie(cookie);
    }
}
