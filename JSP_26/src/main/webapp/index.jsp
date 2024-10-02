<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSP - Hello World</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
</head>
<body>

<%--Navbar--%>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">
            <img src="img\coffee.png" alt="Logo" width="30" height="24" class="d-inline-block align-text-top">
            Coffee
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#">Trang chủ</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Giảm giá</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Thể loại
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="#">Losto</a></li>
                        <li><a class="dropdown-item" href="#">Capybara</a></li>
                        <li><a class="dropdown-item" href="#">Loopy</a></li>
                        <li><hr class="dropdown-divider"></li>
                        <li><a class="dropdown-item" href="#">Khác</a></li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled" aria-disabled="true">Hết hàng</a>
                </li>
            </ul>
            <form class="d-flex" role="search" style="width: 70%">
                <input class="form-control me-2" type="search" placeholder="Bạn muốn uống gì?" aria-label="Search">
                <button class="btn btn-outline-success" type="submit" style="width: 15%">Tìm kiếm</button>
            </form>
        </div>
    </div>
</nav>
<%--End Navbar--%>

<%--Page Content--%>
<div class="container">
    <div class="row">

        <%--        Menu Left--%>
        <div class="col-lg-3">
            <div class="list-group">
                <a href="#" class="list-group-item list-group-item-action">
                    The current link item
                </a>
                <a href="#" class="list-group-item list-group-item-action">A second link item</a>
                <a href="#" class="list-group-item list-group-item-action">A third link item</a>
                <a href="#" class="list-group-item list-group-item-action">A fourth link item</a>
                <a class="list-group-item list-group-item-action disabled" aria-disabled="true">A disabled link item</a>
            </div>
        </div>

        <%--    Slider and Products--%>
        <div class="col-lg-9">
            <div id="carouselExampleIndicators" class="carousel slide">
                <div class="carousel-indicators">
                    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
                    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
                    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
                </div>
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img src="img\slider\1.png" class="d-block w-100" alt="...">
                    </div>
                    <div class="carousel-item">
                        <img src="img\slider\2.png" class="d-block w-100" alt="...">
                    </div>
                    <div class="carousel-item">
                        <img src="img\slider\3.png" class="d-block w-100" alt="...">
                    </div>
                </div>
                <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Previous</span>
                </button>
                <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Next</span>
                </button>
            </div>
            <%--            End Slider--%>

            <%--            Products--%>
            <div class="row" style="margin-top: 3%">
                <div class="col-lg-4 col-md-6 mb-4">
                    <div class="card h-100">
                        <img src="img\product\2.png" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">Iced Cappucino</h5>
                            <p class="card-text">50.000đ</p>
                            <a href="#" class="btn btn-primary">Mua ngay</a>
                        </div>
                        <div>
                            <small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9733;</small>
                        </div>
                    </div>
                </div>


                <div class="col-lg-4 col-md-6 mb-4">
                    <div class="card h-100">
                        <img src="img\product\3.png" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">Salted Milk Foam Coffe</h5>
                            <p class="card-text">50.000đ</p>
                            <a href="#" class="btn btn-primary">Mua ngay</a>
                        </div>
                        <div>
                            <small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734;</small>
                        </div>
                    </div>
                </div>

                <div class="col-lg-4 col-md-6 mb-4">
                    <div class="card h-100">
                        <img src="img\product\4.png" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">Americano</h5>
                            <p class="card-text">50.000đ</p>
                            <a href="#" class="btn btn-primary">Mua ngay</a>
                        </div>
                        <div>
                            <small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9733;</small>
                        </div>
                    </div>
                </div>

                <div class="col-lg-4 col-md-6 mb-4">
                    <div class="card h-100">
                        <img src="img\product\5.png" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">Chocolate Latte</h5>
                            <p class="card-text">50.000đ</p>
                            <a href="#" class="btn btn-primary">Mua ngay</a>
                        </div>
                        <div>
                            <small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734;</small>
                        </div>
                    </div>
                </div>

                <div class="col-lg-4 col-md-6 mb-4">
                    <div class="card h-100">
                        <img src="img\product\1.png" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">Iced Americano</h5>
                            <p class="card-text">50.000đ</p>
                            <a href="#" class="btn btn-primary">Mua ngay</a>
                        </div>
                        <div>
                            <small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9733;</small>
                        </div>
                    </div>
                </div>

                <div class="col-lg-4 col-md-6 mb-4">
                    <div class="card h-100">
                        <img src="img\product\6.png" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">Iced Latte</h5>
                            <p class="card-text">50.000đ</p>
                            <a href="#" class="btn btn-primary">Mua ngay</a>
                        </div>
                        <div>
                            <small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734;</small>
                        </div>
                    </div>
                </div>


            </div>

        </div>
        <%--        End Slider Product--%>
    </div>
</div>
</body>
</html>