package com.harini.harinimart.controller;

import com.harini.harinimart.dao.ProductDao;
import com.harini.harinimart.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {

    private ProductDao productDao = new ProductDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Fetch products from database
        List<Product> products = productDao.getAllProducts();

        // Pass the list to your JSP page
        request.setAttribute("productList", products);

        // Forward to product.jsp
        request.getRequestDispatcher("product.jsp").forward(request, response);
    }
}