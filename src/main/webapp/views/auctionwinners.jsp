<%@ page import="java.util.List" %>
<%@ page import="com.business.model.AuctionWinner" %><%--
  Created by IntelliJ IDEA.
  User: zakaria
  Date: 30/08/2016
  Time: 12:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Auction Winners !!</title>
    <script type="text/javascript">

        var winnersList = new Array();
        <c:forEach items="${winners}" var="auctwinner">
        var winner = new Object();
        winner.firstname = '${auctwinner.user.userFirstName}';
        winner.lastname = '${auctwinner.user.userLastName}';
        winner.prodname = '${auctwinner.prod.productName}';
        winner.bid = '${auctwinner.bid()}';
        winnersList.push(winner);
        </c:forEach>
    </script>
</head>
<body>
    <p> L'enchère dont l'id est ${auct} est terminée. </p><br>
    <p> Les gagnants par produits sont :</p>
        //afficher winnersList dans un tab

</body>
</html>
