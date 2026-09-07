<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.harini.harinimart.model.CartItem" %>
<!DOCTYPE html>
<html>
<head>
    <title>HariniMart - Shopping Cart</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; background-color: #f9f9f9; }
        .container { max-width: 800px; margin: auto; background: white; padding: 20px; border-radius: 8px; box-shadow: 0 2px 4px rgba(0,0,0,0.1); }
        table { width: 100%; border-collapse: collapse; margin-top: 20px; }
        th, td { padding: 12px; text-align: left; border-bottom: 1px solid #ddd; }
        th { background-color: #f2f2f2; }
        .total-section { font-size: 18px; font-weight: bold; text-align: right; margin-top: 20px; }
        .btn { padding: 8px 12px; background-color: #007bff; color: white; border: none; border-radius: 4px; cursor: pointer; text-decoration: none; }
        .btn:hover { background-color: #0056b3; }
    </style>
</head>
<body>

<div class="container">
    <h2>Your Shopping Cart</h2>
    
    <table>
        <thead>
            <tr>
                <th>Product</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Subtotal</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<CartItem> cartList = (List<CartItem>) session.getAttribute("cartList");
                double grandTotal = 0;
                
                if (cartList != null && !cartList.isEmpty()) {
                    for (CartItem item : cartList) {
                        double subtotal = item.getPrice() * item.getQuantity();
                        grandTotal += subtotal;
            %>
            <tr>
                <td><%= item.getProductName() %></td>
                <td>$<%= item.getPrice() %></td>
                <td><%= item.getQuantity() %></td>
                <td>$<%= subtotal %></td>
            </tr>
            <%
                    }
                } else {
            %>
            <tr>
                <td colspan="4" style="text-align: center;">Your cart is empty!</td>
            </tr>
            <% } %>
        </tbody>
    </table>

    <div class="total-section">
        Grand Total: $<%= grandTotal %>
    </div>

    <br>
    <a href="product.jsp" class="btn">Continue Shopping</a>
</div>

</body>
</html>