<%--
  Created by IntelliJ IDEA.
  User: emiliedao
  Date: 5/11/16
  Time: 3:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>${ order.name }</title>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/custom.css" rel="stylesheet">
    <link href="css/modern-business.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

<c:set var="orderName" value="${fn:replace(order.name, '_', ' ')}" />

<!-- Navigation -->
<c:import url="navbar.jsp"></c:import>

<!-- Page Content -->
<div class="container">

    <!-- Page Heading/Breadcrumbs -->
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">${ orderName }
                <small>Order</small></h1>
            <ol class="breadcrumb">
                <li><a href="/home">Home</a></li>
                <li><a href="/mammals">Mammals</a></li>
                <c:set var="nbFamilies" value="${ fn:length(families) }"/>
                <li class="active">${ orderName }
                    (${ nbFamilies } ${ (nbFamilies == 0 || nbFamilies == 1) ? 'family' : 'families'})</li>
            </ol>
        </div>
    </div>
    <!-- /.row -->

    <div class="row">
        <div class="col-lg-12">
            <p>${ order.description }</p>
        </div>
    </div>

    <h2>Families</h2>
    <hr>

    <!-- Families -->
    <c:forEach items="${ families }" var="family">
    <c:set var="familyName" value="${fn:replace(family.name, '_', ' ')}" />
        <div class="row">
        <div class="col-md-5">
            <a href="<c:url value="/family"><c:param name="name" value="${ family.name }"/></c:url>">
                <img class="img-responsive img-hover" src="${ family.image }" alt="">
            </a>
        </div>
        <div class="col-md-7">
            <h3>
                <a href="<c:url value="/family"><c:param name="name" value="${ family.name }"/></c:url>"> ${ familyName }</a></h3>
            <p>${ family.description }</p>
        </div>
    </div>
    <hr>
    </c:forEach>
    <!-- /.row -->

    <!-- Footer -->
    <footer>
        <div class="row">
            <div class="col-lg-12">
                <p>Copyright &copy; Into The Wild 2016</p>
            </div>
        </div>
    </footer>

</div>
<!-- /.container -->



<!-- jQuery -->
<script src="js/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="js/bootstrap.min.js"></script>
<script src="js/search.js"></script>

</body>

</html>

