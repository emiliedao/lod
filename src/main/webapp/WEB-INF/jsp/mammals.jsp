<%--
  Created by IntelliJ IDEA.
  User: emiliedao
  Date: 5/11/16
  Time: 1:53 PM
  To change this template use File | Settings | File Templates.
--%>
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

    <title>Mammals</title>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/modern-business.css" rel="stylesheet">
    <link href="css/custom.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet"
          type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

<!-- Navigation -->
<c:import url="navbar.jsp"></c:import>


<!-- Page Content -->
<div class="container">

    <!-- Page Heading/Breadcrumbs -->
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Mammals
                <small>Class</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="/home">Home</a>
                </li>
                <c:set var="nbOrders" value="${ fn:length(orders) }"/>
                <li class="active">Mammals
                    (${ nbOrders } ${ (nbOrders == 0 || nbOrders == 1) ? 'order' : 'orders'})</li>
            </ol>
        </div>
    </div>
    <!-- /.row -->

    <!-- Intro Content -->
    <div class="row">
        <div class="col-lg-12">
            <div class="col-lg-6">
                <img class="img-responsive img-thumbnail" src="${ mammal.image }" alt=""
                     style="margin-right: 17px; margin-bottom: 10px; ">
            </div>
            <h2>About mammals</h2>
            <p>${ mammal.description }</p>
        </div>
    </div>
    <!-- /.row -->

    <!-- Orders -->
    <div class="row">
        <div class="col-lg-12">
            <h2 class="page-header">Orders</h2>
        </div>

        <c:forEach items="${ orders }" var="order">
        <c:set var="orderName" value="${fn:replace(order.name, '_', ' ')}" />
        <div class="col-md-4 text-center">
            <div class="thumbnail">
                <a href="<c:url value="/order"><c:param name="name" value="${ order.name }"/></c:url>">
                    <img class="img-responsive img-hover" src="${ order.image }" alt="">
                    <div class="caption">
                        <h3>${ orderName }</a></h3>
                        <p>${ order.description }</p>
                    </div>
            </div>
        </div>
        </c:forEach>

    </div>
    <!-- /.row -->

    <hr>

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

</body>

</html>

