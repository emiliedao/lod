<%--
  Created by IntelliJ IDEA.
  User: emiliedao
  Date: 5/19/16
  Time: 5:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>About</title>

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
            <h1 class="page-header">About
                <%--<small>This application</small>--%>
            </h1>
            <ol class="breadcrumb">
                <li><a href="/home">Home</a></li>
                <li class="active">About</li>
            </ol>
        </div>
    </div>
    <!-- /.row -->

    <!-- Intro Content -->
    <div class="row">
        <div class="col-lg-12">
            <div class="col-lg-6">
                <img class="img-responsive img-thumbnail img-hover" src="img/leopard.jpg" alt=""
                     style="margin-right: 17px; margin-bottom: 10px; ">
            </div>

            <h2>About this application</h2>

            <p>This application was created in the context of a ten-week internship in Computer Science. For this internship, I travelled all the way from Bordeaux to Japan, in the University of Tsukuba, and was welcomed by the Kitagawa Data Engineering laboratory.</p>

            <p>The aim of the internship was to create an application using Linked Open Data. In computing, Linked Data refers to a method of publishing information so that it can be interconnected. Rather than providing text content only readable by humans, Linked Data allows us to share information also readable by computers, enabling data from different sources to be connected and queried. The Open term simply means that the data is open content.</p>

            <p>To build this application, I used three main sources of data, as mentioned in the home page: DBpedia, BBC Wildlife Finder and the IUCN Red List. DBpedia provided the list of species for every family, as well as the basic information about each species, including the description, the picture, and the conservation status. The data was retrieved through DBpedia's SPARQL endpoint. BBC Wildlife finder provided the classification of species, including mammals, orders, and families, under the form of RDF files. Last but not least, the IUCN Red List provided the remaining information about each species, that is to say their location in the world, their type of habitats, the threats concerning them and the measures taken. It also provided the data used to build the statistics.</p>

            <p>I chose to work on the topic of endangered species because it is a very important topical issue, as humans are constantly destroying the world that surrounds us. I find essential to stay aware of the situation we are putting the Earth through, as well as all the species that we are disturbing, and too often leading to their extinction for our own interests. Due to the number of species, I chose to restrain the application to the mammals, at least for the basic presentation of each species.</p>
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

<script src="js/search.js"></script>


</body>