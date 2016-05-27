
<nav class="navbar navbar-default navbar-fixed-top topnav" role="navigation">
    <div class="container topnav">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header page-scroll">
            <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand topnav" href="/home">Home</a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

            <ul class="nav navbar-nav navbar-right pull-right">

                <!-- Hidden li included to remove active class from about link when scrolled up past about section -->
                <li class="hidden">
                    <a class="page-scroll" href="#page-top"></a>
                </li>
                <li>
                    <a class="page-scroll" href="/about">About</a>
                </li>

                <li>
                    <a class="page-scroll" href="/contact">Contact</a>
                </li>

                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><span class="glyphicon glyphicon-align-justify"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="/mammals">Species</a></li>
                        <li><a href="/endangeredWildlife">Endangered wildlife</a></li>
                        <li><a href="/news">News</a></li>
                        <li role="separator" class="divider"></li>
                        <li class="dropdown-header">Learn more about</li>
                        <li><a href="/classification">Classification</a></li>
                        <li><a href="/conservationStatus">Conservation status</a></li>
                    </ul>
                </li>
            </ul>

            <div class="col-sm-3 col-md-3 pull-right">
                <form class="navbar-form search-form" role="search" method="get">
                    <div class="input-group">
                        <input type="text" class="form-control dropdown-toggle" data-toggle="dropdown"  aria-haspopup="true" aria-expanded="false" placeholder="Search" name="q" id="search-value">

                        <ul class="dropdown-menu" id="search-results">
                            <li><a href="#">Result #1</a></li>
                            <li><a href="#">Result #2</a></li>
                            <li><a href="#">Result #3</a></li>
                        </ul>

                        <div class="input-group-btn">
                            <button class="btn btn-default" type="submit" id="search-button"><i class="glyphicon glyphicon-search"></i></button>
                        </div>
                    </div>

                </form>

            </div>

        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>

<%--<script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>--%>
<%--<script src="js/search.js"></script>--%>