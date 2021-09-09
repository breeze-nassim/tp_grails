<!doctype html>
<html>
<head>
    <meta name="layout" content="main" />
    <title>le coin coin</title>
</head>
<body>
    <div class="container">
        <g:each status="i" var="it" in="${ listSalesAd }">


                    <img src="http://localhost:8080/assets/salesAd/iniesta.jpg" >
                    <div class="card-body">
                        <h4 style="color: #005cbf" class="card-title">${ it.title } </h4>
                        <p style="color: #005cbf" class="card-text">Description : ${ it.descShort } </p>
                        <p style="color: #005cbf" class="card-text">prix : <b>${ it.price } €</b></p>
                    </div>



        </g:each>
    </div>
</body>
</html>
