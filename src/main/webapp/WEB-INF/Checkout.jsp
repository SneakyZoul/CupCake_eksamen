<%@ page import="business.entities.Cupcake" %>
<%@ page import="java.awt.*" %>
<%@ page import="com.example.cupcakedemoeksamen.CheckoutServlet" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="business.services.CupCakeUtil.Initializer" %>
<%@ page import="business.entities.Topping" %>
<%@ page import="business.entities.Bunde" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Olsker Cupcakes</title>
    <link rel="stylesheet" href="styles/Checkout.css">
    <link rel="stylesheet" href="styles/style.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <header>
        <img src="pictures/cupcakeBanner.png" alt="banner">
    </header>

</head>
<style>
    .button {
        width: 300px;

    }

    .form-check {
        margin-right: 3%;
    }

    .table-striped {
        background-color: #331151;
        color: #e9ecef
    }

    tr.table-striped {
        background-color: #3c1361
    }

    .ToIndex {
        margin-left: 50%;
    }

    .DinMail {
        width: 300px;
    }

    .Checker {
        margin-left: 20px;
    }
</style>
<body>

<div class="container-fluid">
    <div class="bannerSize">
        <a href="orders.html" class="bannerText" style="text-decoration: none;">Ordrer</a>
        &ensp;
        &emsp;
        <a href="customer.html" class="bannerText" style="text-decoration: none;"> Kunder </a>

        <span class="icon">
            <a href="basket.html" class="icon">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-bag"
                     viewBox="0 0 16 16">
                    <path d="M8 1a2.5 2.5 0 0 1 2.5 2.5V4h-5v-.5A2.5 2.5 0 0 1 8 1zm3.5 3v-.5a3.5 3.5 0 1 0-7 0V4H1v10a2 2 0 0 0 2 2h10a2 2 0 0 0 2-2V4h-3.5zM2 5h12v9a1 1 0 0 1-1 1H3a1 1 0 0 1-1-1V5z"/>
                </svg>
            </a>
        </span>
    </div>
</div>


<div class="container-fluid">
    <table class="table table-striped">
        <th> Bunde:</th>
        <th> Toppings:</th>
        <th> Antal:</th>
        <th> I Alt:</th>
        <c:forEach var="cupcakeItem" items="${sessionScope.cupcakeList}">
            <tr>
                <td>${cupcakeItem.bunde.navn}</td>
                <td>${cupcakeItem.topping.navn}</td>
                <td> 5 stk</td>
                <td> 120,- :</td>
            </tr>
        </c:forEach>
        <tr>
            <td>Ialt</td>
            <td></td>
            <td></td>
            <td> 120,- kr</td>

        </tr>
    </table>
</div>


<form action="TakForKøbServlet" method="post">

    <div class="container-fluid">
        <button class=" btn btn-primary button">Check out</button>
    </div>
</form>


<div class="form-check Checker">
    <input class="form-check-input " type="checkbox" name="info" value="1" id="flexCheckDefault1">
    <label class="form-check-label" for="flexCheckDefault1">
        Jeg vil gerne modtage min order på mail.
    </label>
</div>
<br/>

<div class="container-fluid ">
    <label for="OrderEmail" class="form-label">Email address</label>
    <input type="email" class="form-control DinMail" id="OrderEmail" placeholder="Din mail">
</div>


<form action="index.jsp">
    <div>
        <button class="btn-primary ToIndex" type="submit">Til forsiden</button>
    </div>
</form>


<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
</body>
</html>
