<%--
  Created by IntelliJ IDEA.
  User: emiliedao
  Date: 5/19/16
  Time: 5:27 PM
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

    <title>Classification</title>

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
            <h1 class="page-header">Classification
                <small>Taxonomic rank</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="/home">Home</a></li>
                <li class="active">Classification</li>
            </ol>
        </div>
    </div>
    <!-- /.row -->

    <div class="row">
        <p align="center">
            <img class="img-responsive img-thumbnail img-hover" src="https://upload.wikimedia.org/wikipedia/commons/thumb/7/71/Taxonomic_Rank_Graph.svg/300px-Taxonomic_Rank_Graph.svg.png" alt="">
        </p>
    </div>

    <div class="row">
        <p>In biological classification, rank is the relative level of a group of organisms (a taxon) in a taxonomic hierarchy. Examples of taxonomic ranks are species, genus, family, class, kingdom, etc.</p>

        <p>A given rank subsumes under it less general categories, that is, more specific descriptions of life forms. Above it, each rank is classified within more general categories of organisms and groups of organisms related to each other through inheritance of traits or features from common ancestors. The rank of any species and the description of its genus is basic; which means that to identify a particular organism, it is usually not necessary to specify ranks other than these first two.</p>

        <p>Consider a particular species, the red fox Vulpes vulpes: its next rank, the genus Vulpes, comprises all the 'true foxes'. Their closest relatives are in the immediately higher rank, the family Canidae, which includes dogs, wolves, jackals, all foxes, and other caniforms; the next higher rank, the order Carnivora, includes feliforms and caniforms (lions, tigers, bears, hyenas, wolverines, and all those mentioned above), plus other carnivorous mammals. As one group of the class Mammalia, all of the above are classified among those with backbones in the Chordata phylum rank, and with them among all the animals in the Animalia kingdom rank. Finally, all of the above will find their earliest relatives somewhere in their domain rank Eukarya.</p>

        <p>The International Code of Zoological Nomenclature defines rank as:</p>

        <div class="well">
            The level, for nomenclatural purposes, of a taxon in a taxonomic hierarchy (e.g. all families are for
            nomenclatural purposes at the same rank, which lies between superfamily and subfamily)
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