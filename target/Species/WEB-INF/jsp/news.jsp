<%--
  Created by IntelliJ IDEA.
  User: emiliedao
  Date: 5/19/16
  Time: 11:11 AM
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

    <title>News</title>

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
            <h1 class="page-header">News</h1>
            <ol class="breadcrumb">
                <li><a href="/home">Home</a></li>
                <li class="active">News</li>
            </ol>
        </div>
    </div>
    <!-- /.row -->

    <!-- Service Tabs -->
    <div class="row">

        <div class="col-md-8">

            <ul class="nav nav-tabs nav-justified">
                <li ${ (source.equals("guardian")) ? 'class="active"' : '' }>
                    <a href="/news?source=guardian"><i class="fa fa-newspaper-o"></i> The Guardian</a>
                </li>
                <li ${ (source.equals("ny")) ? 'class="active"' : '' }>
                    <a href="/news?source=ny"><i class="fa fa-building"></i> The New York Times</a>
                </li>
                <li ${ (source.equals("alchemy")) ? 'class="active"' : '' }>
                    <a href="/news?source=alchemy"><i class="fa fa-flask"></i> AlchemyData</a>
                </li>
            </ul>

            <c:forEach items="${ listNews }" var="news">
                <!-- First Blog Post -->
                <h3>${ news.title }</h3>

                <p><i class="fa fa-clock-o"></i> Posted on ${ news.publicationDate }</p>
                <hr>

                <p>${ news.summary }</p>
                <a class="btn btn-primary"
                   target="_blank"
                   href="<c:url value="${ news.webUrl }"/>">Read More <i class="fa fa-angle-right"></i></a>

                <hr>
            </c:forEach>

        </div>

        <!-- Blog Sidebar Widgets Column -->
        <div class="col-md-4">

            <!-- Blog Search Well -->
            <div class="well">
                <h4>Search news</h4>
                <form method="post" action="/news">
                    <div class="input-group">
                            <input type="text" class="form-control" name="search"
                                   placeholder="${ search }">
                                <span class="input-group-btn">
                                    <button class="btn btn-default" type="submit"><i class="fa fa-search"></i></button>
                                </span>
                    </div>

                    <div class="radio">
                        <label>
                            <input type="radio" name="source" value="guardian"
                            ${ (source.equals("guardian")) ? 'checked' : '' }>The Guardian
                        </label>
                    </div>
                    <div class="radio">
                        <label>
                            <input type="radio" name="source" value="ny"
                            ${ (source.equals("ny")) ? 'checked' : '' }>The New York Times
                        </label>
                    </div>
                    <div class="radio">
                        <label>
                            <input type="radio" name="source" value="alchemy"
                            ${ (source.equals("alchemy")) ? 'checked' : '' }>AlchemyData
                        </label>
                    </div>

                    <!-- /.input-group -->
                </form>
            </div>

            <!-- Blog Categories Well -->
            <div class="well">
                <h4>News categories</h4>
                <div class="row">
                    <div class="col-lg-6">
                        <ul class="list-unstyled">
                            <li><a href="<c:url value="/news">
                                    <c:param name="category" value="endangered_species"/>
                                </c:url>">Endangered species</a>
                            </li>
                            <li><a href="<c:url value="/news">
                                    <c:param name="category" value="wildlife"/>
                                </c:url>">Wildlife</a>
                            </li>
                            <li><a href="<c:url value="/news">
                                    <c:param name="category" value="animals"/>
                                </c:url>">Animals</a>
                            </li>
                            <li><a href="<c:url value="/news">
                                    <c:param name="category" value="mammals"/>
                                </c:url>">Mammals</a>
                            </li>
                        </ul>
                    </div>
                    <!-- /.col-lg-6 -->
                    <div class="col-lg-6">
                        <ul class="list-unstyled">
                            <li>
                                <a href="<c:url value="/news">
                                    <c:param name="category" value="environment"/>
                                </c:url>">Environment</a>
                            </li>
                            <li><a href="<c:url value="/news">
                                    <c:param name="category" value="global_warming"/>
                                </c:url>">Global warming</a>
                            </li>
                            <li>
                                <a href="<c:url value="/news">
                                <c:param name="category" value="planet"/>
                            </c:url>">Planet</a>
                            </li>
                            <li>
                                <a href="<c:url value="/news">
                                <c:param name="category" value="climate_change"/>
                            </c:url>">Climate change</a>
                            </li>
                        </ul>

                    </div>
                    <!-- /.col-lg-6 -->
                </div>
                <!-- /.row -->
            </div>

            <!-- Side Widget Well -->
            <div class="well">
                <h4>Side Widget Well</h4>
                <p>You can choose the source and find some news published in this month corresponding to your own keywords, or search other news from all sources using the predefine categories.</p>
            </div>

        </div>

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

</body>

</html>

