<%--
  Created by IntelliJ IDEA.
  User: lucafornelli
  Date: 2019-06-13
  Time: 21:32
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>List Products</title>
</head>

<body>
<table border="1">
    <thead>
    <th>Name</th>
    <th>SKU</th>
    <th>Price</th>
    </thead>
    <g:each in="${allProducts}" var="thisProduct">
        <tr>
            <td>${thisProduct.name}</td>
            <td>${thisProduct.sku}</td>
            <td>${thisProduct.price}</td>
        </tr>
    </g:each>
</table>
</body>
</html>