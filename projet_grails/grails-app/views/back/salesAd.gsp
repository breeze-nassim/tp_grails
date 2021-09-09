

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main" />
    <title></title>
</head>

<body>
<table>
    <div class="container">
        <div class="row justify-content-md-center" >
            <div class="col col-lg-2">
                <table style="margin-top: 30px; margin-left: 10%; width: 70%" class="table">
                    <thead>
                    <tr style="color: #9fcdff; background-color: firebrick">
                        <th scope="col">Titre</th>
                        <th scope="col">Description</th>
                        <th scope="col">Prix</th>
                        <th scope="col">Actions</th>
                    </tr>
                    </thead>
                    <tbody>
                    <g:each in="${listSalesAd}">
                        <tr style="color: #1b1e21; background-color: navajowhite">
                            <td>${it.title}</td>
                            <td>${it.descShort}</td>
                            <td>${it.price} €</td>
                            <td>
                                <g:link controller="back" class="btn btn-danger my-2 my-lg-0" action="editAd" id="${it.id}">modifier article</g:link>
                                <g:link controller="back" class="btn btn-danger my-2 my-lg-0" action="deleteAd" onclick="return confirm('voulez-vous supprimez cette annonce?!')" id="${it.id}">supprimer article</g:link>
                            </td>
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</body>
</html>