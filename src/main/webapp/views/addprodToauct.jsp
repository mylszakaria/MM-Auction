<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zakaria
  Date: 30/08/2016
  Time: 21:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        var products = new Array();
        <c:forEach items="${auctProducts}" var="prod">
        var product = new Object();
        product.name = '${prod.productName}';
        product.img = '${prod.productImg}';
        products.push(product);
        </c:forEach>
    </script>
</head>
<body>

</body>
</html>
