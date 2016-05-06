<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Into the wild - LOD application</title>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/landing-page.css" rel="stylesheet">
    <link href="css/scrolling-nav.css" rel="stylesheet">

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

<!-- The #page-top ID is part of the scrolling feature - the lod-spy and lod-target are part of the built-in Bootstrap scrollspy function -->
<body id="page-top" data-spy="scroll" data-target=".navbar-fixed-top">


<!-- Navigation -->
<c:import url="navbar.jsp"></c:import>

<!-- Header -->
<section id="intro" class="intro-section">

    <div class="intro-header">
        <div class="container">

            <div class="row">
                <div class="col-lg-12">
                    <div class="intro-message">
                        <%--<h1>${ title }</h1>--%>
                        <h1>Into the wild</h1>
                        <h3>A Linked Open Data application</h3>
                        <%--<br/>created by ${ param.name }--%>
                        <hr class="intro-divider">
                        <ul class="list-inline intro-social-buttons">
                            <li>
                                <a href="#" class="btn btn-default btn-lg"><i
                                        class="fa fa-paw fa-fw"></i> <span class="network-name">Species</span></a>
                            </li>
                            <li>
                                <a href="#"
                                   class="btn btn-default btn-lg"><i class="fa fa-leaf fa-fw"></i> <span
                                        class="network-name">Wildlife</span></a>
                            </li>
                            <li>
                                <a href="#" class="btn btn-default btn-lg"><i class="fa fa-globe fa-fw"></i> <span
                                        class="network-name">Conservation</span></a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>

        </div>
        <!-- /.container -->

    </div>
    <!-- /.intro-header -->
</section>
<!-- /.intro-section -->

<!-- Page Content -->

<section id="about" class="about-section">
    <div class="content-section-a">

        <div class="container">
            <div class="row">
                <div class="col-lg-5 col-sm-6">
                    <hr class="section-heading-spacer">
                    <div class="clearfix"></div>
                    <h2 class="section-heading">About</h2>
                    <p class="lead">Lorem ipsum dolor sit amet</p>

                    <p><c:out value="Text displayed with JSTL"/></p>

                    <c:set var="message" value="This is a message from  a variable" scope="request"/>
                    <p><c:out value="${ requestScope.message }"/></p>

                    <p>
                        <a href="<c:url value="/home">
                        <c:param name="name" value="Benjamin"></c:param>
                    </c:url>">Change your name</a>
                    </p>

                </div>
                <div class="col-lg-5 col-lg-offset-2 col-sm-6">
                    <img class="img-responsive" src="img/ipad.png" alt="">
                </div>
            </div>

        </div>
        <!-- /.container -->

    </div>
    <!-- /.content-section-a -->
</section>
<!-- /.about-section -->


<section id="services" class="services-section">
    <div class="content-section-b">

        <div class="container">

            <div class="row">
                <div class="col-lg-5 col-lg-offset-1 col-sm-push-6  col-sm-6">
                    <hr class="section-heading-spacer">
                    <div class="clearfix"></div>
                    <h2 class="section-heading">Felidae</h2>
                    <p class="lead"><a href="/felidae">List of felidae</a></p>
                </div>
                <div class="col-lg-5 col-sm-pull-6  col-sm-6">
                    <img class="img-responsive" src="img/artic-wolf.jpg" alt="">
                </div>
            </div>

        </div>
        <!-- /.container -->

    </div>
    <!-- /.content-section-b -->
</section>
<!-- /.services-section -->


<section id="contact" class="contact-section">

    <div class="content-section-a">

        <div class="container">

            <div class="row">
                <div class="col-lg-5 col-sm-6">
                    <hr class="section-heading-spacer">
                    <div class="clearfix"></div>
                    <h2 class="section-heading">Contact</h2>
                    <p class="lead">This template features the 'Lato' font, part of the <a target="_blank"
                                                                                           href="http://www.google.com/fonts">Google
                        Web Font library</a>, as well as <a target="_blank" href="http://fontawesome.io">icons from Font
                        Awesome</a>.</p>
                </div>
                <div class="col-lg-5 col-lg-offset-2 col-sm-6">
                    <img class="img-responsive" src="img/panda.jpg" alt="">
                </div>
            </div>

        </div>
        <!-- /.container -->

    </div>
    <!-- /.content-section-a -->
</section>
<!-- /.contact-section -->


<div class="banner">

    <div class="container">

        <div class="row">
            <div class="col-lg-6">
                <h2>Sources</h2>
            </div>
            <div class="col-lg-6">
                <ul class="list-inline banner-social-buttons">
                    <li>
                        <a href="#" class="btn btn-default btn-lg"><span class="network-name">DBpedia</span></a>
                    </li>
                    <li>
                        <a href="#" class="btn btn-default btn-lg"><span class="network-name">BBC Wildfinder</span></a>
                    </li>
                    <li>
                        <a href="#" class="btn btn-default btn-lg"><span
                                class="network-name">IUCN Red List</span></a>
                    </li>
                </ul>
            </div>
        </div>

    </div>
    <!-- /.container -->

</div>
<!-- /.banner -->

<!-- Footer -->
<footer>
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <ul class="list-inline">
                    <li>
                        <a href="#">Home</a>
                    </li>
                    <li class="footer-menu-divider">&sdot;</li>
                    <li>
                        <a href="#about">About</a>
                    </li>
                    <li class="footer-menu-divider">&sdot;</li>
                    <li>
                        <a href="#services">Services</a>
                    </li>
                    <li class="footer-menu-divider">&sdot;</li>
                    <li>
                        <a href="#contact">Contact</a>
                    </li>
                </ul>
                <p class="copyright text-muted small">Copyright &copy; Your Company 2014. All Rights Reserved</p>
            </div>
        </div>
    </div>
</footer>

<!-- jQuery -->
<script src="js/jquery.js"></script>
<script src="js/jquery.easing.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="js/bootstrap.min.js"></script>

<script src="js/scrolling-nav.js"></script>

</body>

</html>

