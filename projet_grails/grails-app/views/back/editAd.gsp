

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main" />
    <title></title>
</head>
<body>
<g:if test="${message != ''}">
    <div class="alert alert-primary" role="alert">
        ${message}
    </div>
</g:if>

<div class="container">
    <div class="row">
        <g:uploadForm name="myUpload" class="col mt-3"  method="post">
            <div class="form-group">
                <label for="title" >Titre :</label>
                <input type="text" class="form-control" id="title" name="title" placeholder="Enter title" value="${saleAd.title}">
            </div>

            <div class="form-group">
                <label for="descShort"> Description :</label>
                <input type="text" class="form-control" id="descShort" name="descShort" placeholder="Enter a short description" value="${saleAd.descShort}">
            </div>



            <div class="form-group">
                <label for="price">Price :</label>
                <input type="number" class="form-control" id="price" name="price" placeholder="Enter price" value="${saleAd.price}">
            </div>



            <button type="submit" class="btn btn-primary" formaction="/back/editAdMethod/${saleAd.id}">Submit</button>
        </g:uploadForm>
    </div>
</div>
</body>
</html>