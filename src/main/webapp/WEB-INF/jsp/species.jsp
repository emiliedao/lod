<%--
  Created by IntelliJ IDEA.
  User: emiliedao
  Date: 5/13/16
  Time: 3:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<c:set var="familyName" value="${fn:replace(species.family.name, '_', ' ')}"/>
<c:set var="orderName" value="${fn:replace(species.family.order.name, '_', ' ')}"/>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>${ familyName }</title>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/custom.css" rel="stylesheet">
    <link href="css/modern-business.css" rel="stylesheet">

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
            <h1 class="page-header">${ species.name }
                <small>Species</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="/home">Home</a></li>
                <li><a href="/mammals">Mammals</a></li>
                <li>
                    <a href="<c:url value="/order"><c:param name="name" value="${ species.family.order.name }"/></c:url>">${ orderName }</a>
                </li>
                <li>
                    <a href="<c:url value="/family"><c:param name="name" value="${ species.family.order.name }"/></c:url>">${ familyName }</a></li>
                <li class="active">${ species.name } </li>
            </ol>
        </div>
    </div>
    <!-- /.row -->

    <!-- Intro Content -->
    <div class="row">
        <div class="col-lg-12">
            <div class="col-md-8">
                <p>${ species.description }</p>

                <c:set var="status" value="${ species.conservationStatus.id }" />
                <p align="center"><button type="button" class="btn btn-circle btn-xxl
                    <c:choose>
                        <c:when test="${ status == 'EX' || status == 'EW'}">btn-primary</c:when>
                        <c:when test="${  status == 'CR' || status == 'EN' || status == 'VU'  }">btn-danger</c:when>
                        <c:when test="${  status == 'NT' }">btn-warning</c:when>
                        <c:when test="${  status == 'LC' }">btn-success</c:when>
                        <c:otherwise>btn-default</c:otherwise>
                    </c:choose>
                ">
                    ${ species.conservationStatus.label }
                </button></p>
            </div>

            <div class="col-md-4">
                <img align=right class="img-responsive img-thumbnail" src="${ species.image }" alt="">
            </div>

        </div>
    </div>
    <!-- /.row -->

    <hr>

    <div class="row">
        <div class="col-lg-6">
            <h3>Threats</h3>
        </div>

        <div class="col-lg-6">
            <h3>Measures</h3>
        </div>
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

