<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Olsker Cupcakes</title>
    <link rel="stylesheet" href="styles/style.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <header>
        <img src="pictures/cupcakeBanner.png" alt="banner">
    </header>

</head>
<body>



<!--<img src="../gifs/cupcake.gif" alt="gifman"-->
<!--style="width:50%;height:50%;">-->


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

    <div class="jumbotron">
        <h1 class="display-4"><b>Velkommen ombord </b></h1>
        <h4> Øens bedste cupcakes. Vælg og bestil her:</h4>

        <form action="receipt.html" method="post">
            <div class="form-inline justify-content-center align-items-center" style="padding: 2%;">
                <div class="form-group mx-sm-4 mb-4">
                    <label for="Vælg Bund"></label>
                    <select class="form-control" id="Vælg Bund" name="Vælg Topping">
                        <option value="" disabled selected hidden>Vælg Bund</option>
                        <option>Chocolate</option>
                        <option>Vanilla</option>
                        <option>Nutmeg</option>
                        <option>Pistacio</option>
                        <option>Almond</option>
                    </select>
                </div>
                <div class="form-group mx-sm-4 mb-4">
                    <label for="Vælg Topping"></label>
                    <select class="form-control" id="Vælg Topping" name="Vælg Topping">
                        <option value="" disabled selected hidden>Vælg Topping</option>
                        <option>Chocolate</option>
                        <option>Blueberry</option>
                        <option>Raspberry</option>
                        <option>Crispy</option>
                        <option>Strawberry</option>
                        <option>Rum/Raisin</option>
                        <option>Orange</option>
                        <option>Lemon</option>
                        <option>Blue Cheese</option>
                    </select>
                </div>
                <div class="form-group mx-sm-4 mb-4">
                    <label for="Antal"></label>
                    <select class="form-control" id="Antal" name="Antal">
                        <option value="" disabled selected hidden>Antal</option>
                        <option>1</option>
                        <option>2</option>
                        <option>3</option>
                        <option>4</option>
                        <option>5</option>
                        <option>6</option>
                        <option>7</option>
                        <option>8</option>
                        <option>9</option>
                        <option>10</option>
                    </select>
                </div>
            </div>
            <div class="justify-content-center align-items-center">
                <button class="btn btn-primary mb-1" type="submit">Læg i kurv</button>
            </div>
        </form>
    </div>

    <div class="container-fluid">
        <h3>The Bottoms</h3>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Bund</th>
                <th></th>
                <th></th>
                <th>Pris</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>Chocolate</td>
                <td></td>
                <td></td>
                <td>5.00</td>
            </tr>
            <tr>
                <td>Vanilla</td>
                <td></td>
                <td></td>
                <td>5.00</td>
            </tr>
            <tr>
                <td>Nutmeg</td>
                <td></td>
                <td></td>
                <td>5.00</td>
            </tr>
            <tr>
                <td>Pistacio</td>
                <td></td>
                <td></td>
                <td>6.00</td>
            </tr>
            <tr>
                <td>Almon</td>
                <td></td>
                <td></td>
                <td>7.00</td>
            </tr>
            </tbody>
        </table>
        <br>
        <h3>The Toppings</h3>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Topping</th>
                <th></th>
                <th></th>
                <th>Pris</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>Chocolate</td>
                <td></td>
                <td></td>
                <td>5.00</td>
            </tr>
            <tr>
                <td>Blueberry</td>
                <td></td>
                <td></td>
                <td>5.00</td>
            </tr>
            <tr>
                <td>Raspberry</td>
                <td></td>
                <td></td>
                <td>5.00</td>
            </tr>
            <tr>
                <td>Crispy</td>
                <td></td>
                <td></td>
                <td>6.00</td>
            </tr>
            <tr>
                <td>Strawberry</td>
                <td></td>
                <td></td>
                <td>6.00</td>
            </tr>
            <tr>
                <td>Rum/Raisin</td>
                <td></td>
                <td></td>
                <td>8.00</td>
            </tr>
            <tr>
                <td>Orange</td>
                <td></td>
                <td></td>
                <td>8.00</td>
            </tr>
            <tr>
                <td>Lemon</td>
                <td></td>
                <td></td>
                <td>8.00</td>
            </tr>
            <tr>
                <td>Blue Cheese</td>
                <td></td>
                <td></td>
                <td>9.00</td>
            </tr>
            </tbody>
        </table>

    </div>


</div>


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