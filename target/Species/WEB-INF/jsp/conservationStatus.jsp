<%--
  Created by IntelliJ IDEA.
  User: emiliedao
  Date: 5/16/16
  Time: 5:28 PM
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

    <title>Conservation Status</title>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/custom.css" rel="stylesheet">
    <link href="css/timeline.css" rel="stylesheet">
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
            <h1 class="page-header">Conservation status
                <small>IUCN</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="/home">Home</a></li>
                <li class="active">Conservation status</li>
            </ol>
        </div>
    </div>
    <!-- /.row -->


    <div>
        <ul class="timeline">
            <c:forEach items="${ conservationStatus }" var="status" varStatus="it">
                <li class="${ it.index % 2 eq 0 ? 'timeline' : 'timeline-inverted' }"
                    id="${ status.id }">
                    <div class="timeline-badge
                            <c:choose>
                                <c:when test="${ status.id == 'EX' || status.id == 'EW'}">primary</c:when>
                                <c:when test="${  status.id == 'CR' || status.id == 'EN' || status.id == 'VU'  }">danger</c:when>
                                <c:when test="${  status.id == 'NT' }">warning</c:when>
                                <c:when test="${  status.id == 'LC' }">success</c:when>
                            </c:choose>
                        ">${ status.id }</div>

                    <div class="timeline-panel">

                        <div class="timeline-heading">
                            <h4 class="timeline-title">${ status.label }</h4>
                        </div>
                        <div class="timeline-body">
                            <p>${ status.description }</p>
                        </div>
                    </div>
                </li>
            </c:forEach>

        </ul>
    </div>

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