<%--
  Created by IntelliJ IDEA.
  User: emiliedao
  Date: 5/25/16
  Time: 10:47 AM
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

    <title>Statistics</title>

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
            <h1 class="page-header">Endangered wildlife
                <small>Statistics</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="/home">Home</a></li>
                <li class="active">Endangered wildlife</li>
            </ol>
        </div>
    </div>
    <!-- /.row -->

    <div class="row">
        <p>An endangered species is a species which has been categorized by the International Union for Conservation of Nature (IUCN) Red List as likely to become extinct. "Endangered" is the second most severe conservation status for wild populations in the IUCN's schema after "Critically Endangered".</p>

        <p>In 2012, the IUCN Red List featured 3079 animal and 2655 plant species as endangered worldwide. The figures for 1998 were, respectively, 1102 and 1197. Many nations have laws that protect conservation-reliant species: for example, forbidding hunting, restricting land development or creating preserves. Population numbers, trends and species' conservation status can be found in the lists of organisms by population.</p>
    </div>

    <h2>Species by conservation status</h2>
    <hr>

    <script type="text/javascript">
        var speciesByStatus = ${ speciesByStatus };
    </script>

    <div class="row">
        <div id="speciesByStatus" style="min-width: 310px; height: 400px; max-width: 600px; margin: 0 auto"></div>
    </div>
    <!-- /.row -->

    <h2>Critically endangered species by country</h2>
    <hr>
    <div class="row">
        <div id="criticallyEndangeredSpeciesByCountry" style="min-width: 500px; height: 400px; max-width: 800px; margin: 0 auto"></div>
    </div>
    <!-- /.row -->

    <h2>Endangered species by country</h2>
    <hr>
    <div class="row">
        <div id="endangeredSpeciesByCountry" style="min-width: 600px; height: 400px; max-width: 800px; margin: 0 auto"></div>
    </div>
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

<!-- Highcharts -->
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="js/speciesByStatus.js"></script>
<script src="js/criticallyEndangeredSpeciesByCountry.js"></script>
<script src="js/endangeredSpeciesByCountry.js"></script>

</body>