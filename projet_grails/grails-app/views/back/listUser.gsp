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

                    <th scope="col">utilisateur</th>
                    <th scope="col">son role</th>
                    <th scope="col">Action</th>
                </tr>
                </thead>
                <tbody>
                <g:each in="${listUser}">
                    <tr style="color: #1b1e21; background-color: navajowhite">

                        <td>${it.username}</td>
                        <td><g:each in="${it.getAuthorities()}">${it.authority}</g:each></td>
                        <td>

                            <g:link controller="back" action="deleteUser" class="btn btn-danger my-2 my-lg-0" onclick="return confirm('voulez-vous supprimez cet utilisateur?!')" id="${it.id}">Delete user</g:link>
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