<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.harini.harinimart.dao.ProductDao" %>
<%@ page import="com.harini.harinimart.model.Product" %>
<%@ page import="java.util.List" %>

<%
    // Fetch products dynamically using your DAO
    ProductDao productDao = new ProductDao();
    List<Product> productList = productDao.getAllProducts();
%>

<!DOCTYPE html>
<html>
<head>
    <title>HariniMart - Electronics</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; background-color: #f9f9f9; }
        .container { max-width: 1200px; margin: auto; }
        .header { display: flex; justify-content: space-between; align-items: center; margin-bottom: 20px; }
        .product-grid { display: grid; grid-template-columns: repeat(auto-fit, minmax(220px, 1fr)); gap: 20px; }
        .product-card { background: white; padding: 15px; border-radius: 8px; box-shadow: 0 2px 4px rgba(0,0,0,0.1); text-align: center; }
        .product-card img { max-width: 100%; height: 130px; object-fit: contain; border-radius: 4px; margin-bottom: 10px; }
        .rating { color: #ff9900; font-weight: bold; margin-bottom: 5px; }
        .price { color: #28a745; font-weight: bold; font-size: 18px; margin: 10px 0; }
        .btn { padding: 10px 15px; background-color: #007bff; color: white; border: none; border-radius: 4px; cursor: pointer; width: 100%; }
        .btn:hover { background-color: #0056b3; }
        .view-cart { text-decoration: none; background-color: #ffc107; color: #000; padding: 8px 15px; border-radius: 4px; font-weight: bold; }
    </style>
</head>
<body>

<div class="container">
    <div class="header">
        <h2>HariniMart - Electronics</h2>
        <a href="cart.jsp" class="view-cart">🛒 View Cart</a>
    </div>

    <div class="product-grid">
        <% 
            if (productList != null && !productList.isEmpty()) {
                for (Product product : productList) {
        %>
            <div class="product-card">
                <img src="<%= product.getImageUrl() %>" alt="<%= product.getName() %>">
                <h3><%= product.getName() %></h3>
                <div class="rating">★ <%= product.getRating() %></div>
                <p class="price">$<%= product.getPrice() %></p>
                
                <form action="AddToCartServlet" method="post">
                    <input type="hidden" name="productId" value="<%= product.getId() %>">
                    <input type="hidden" name="productName" value="<%= product.getName() %>">
                    <input type="hidden" name="price" value="<%= product.getPrice() %>">
                    <input type="hidden" name="imageUrl" value="<%= product.getImageUrl() %>">
                    <button type="submit" class="btn">Add to Cart</button>
                </form>
            </div>
        <% 
                }
            } else {
        %>
            <p>No electronic items found.</p>
        <% 
            }
        %>
    </div>
</div>

</body>
</html>