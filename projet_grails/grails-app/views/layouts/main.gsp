<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <asset:stylesheet src="bootstrap.css"/>

    <g:layoutHead/>
</head>
<body>

    <nav class="navbar navbar-light bg-light">
        <a  style="color: #1b1e21"><g:username /></a>
        <a  class="navbar-brand mb-0 h1" href="/" style="color: #1b1e21">consulter les articles</a>

        <ul class="navbar-nav  navbar-expand-sm">
            <li class="nav-item mr-3">
                <a style="color: #1b1e21" class="nav-link" href="/back/listUser">liste des utilisateurs</a>
            </li>

            <li class="nav-item mr-3">
                <a style="color: #721c24" class="nav-link" href="/back/salesAd">liste des articles</a>
            </li>

        </ul>
        <g:if test="${g.isLoggedIn() == 'true'}">
            <div class="my-2 my-sm-0">

                <a href="/logout" class="btn btn-danger" >se déconnecter</a>
            </div>
        </g:if>
        <g:else>
            <a href="/login" class="btn btn-outline-success my-2 my-sm-0" >se connecter</a>
        </g:else>

    </nav>

    <g:layoutBody/>
    <asset:javascript src="bootstrap.js"/>

</body>
</html>
