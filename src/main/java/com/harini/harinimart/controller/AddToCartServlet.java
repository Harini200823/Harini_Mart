package com.harini.harinimart.controller;

import com.harini.harinimart.model.CartItem;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AddToCartServlet")
public class AddToCartServlet extends HttpServlet {
    @SuppressWarnings("unchecked")
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        int productId = Integer.parseInt(request.getParameter("productId"));
        String productName = request.getParameter("productName");
        double price = Double.parseDouble(request.getParameter("price"));
        String imageUrl = request.getParameter("imageUrl");

        HttpSession session = request.getSession();
        List<CartItem> cartList = (List<CartItem>) session.getAttribute("cartList");

        if (cartList == null) {
            cartList = new ArrayList<>();
            cartList.add(new CartItem(productId, productName, price, 1, imageUrl));
        } else {
            boolean exist = false;
            for (CartItem item : cartList) {
                if (item.getProductId() == productId) {
                    item.setQuantity(item.getQuantity() + 1);
                    exist = true;
                    break;
                }
            }
            if (!exist) {
                cartList.add(new CartItem(productId, productName, price, 1, imageUrl));
            }
        }

        session.setAttribute("cartList", cartList);
        response.sendRedirect("cart.jsp");
    }
}
