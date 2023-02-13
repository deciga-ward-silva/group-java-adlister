<nav class="navbar navbar-dark bg-dark fixed-top">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" href="/ads">Ads-List</a>
        </div>
<%--        <ul class="nav navbar-nav navbar-right">--%>
<%--            <li><a href="/login">Login</a></li>--%>
<%--            <li><a href="/logout">Logout</a></li>--%>
<%--        </ul>--%>
        <form class="d-flex" role="search">
            <a href="/login"class="btn btn-primary"  type="submit">Login</a>
            <a href="/logout" class="btn btn-danger"  type="submit">Logout</a>
            <input class="form-control me-2" type="search" name="searchTerm" placeholder="Search" aria-label="Search">
            <button class="btn btn-info" type="submit">Search</button>
        </form>
        <div class="dropdown">
            <a class="btn btn-secondary dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                Dropdown link
            </a>

            <ul class="dropdown-menu">
                <li><a class="dropdown-item" href="#">Action</a></li>
                <li><a class="dropdown-item" href="#">Another action</a></li>
                <li><a class="dropdown-item" href="#">Something else here</a></li>
            </ul>
        </div>
    </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>


