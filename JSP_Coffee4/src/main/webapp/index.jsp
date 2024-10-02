<%@ page import="model.Customer" %>
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
<%--header--%>
<%@include file="header.jsp"%>
<%--<jsp:include page="header.jsp"></jsp:include>--%>

<%--Page Content--%>
<div class="container">
    <div class="row">
<%--menu let--%>
        <%@include file="left.jsp"%>
<%--<jsp:include page="left.jsp"></jsp:include>--%>
<%--    end menu left--%>

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
                        <img src="img/slider/1.png" class="d-block w-100" alt="...">
                    </div>
                    <div class="carousel-item">
                        <img src="img/slider/2.png" class="d-block w-100" alt="...">
                    </div>
                    <div class="carousel-item">
                        <img src="img/slider/3.png" class="d-block w-100" alt="...">
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
                        <img src="img/product/2.png" class="card-img-top" alt="...">
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
                        <img src="img/product/3.png" class="card-img-top" alt="...">
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
                        <img src="img/product/4.png" class="card-img-top" alt="...">
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
                        <img src="img/product/5.png" class="card-img-top" alt="...">
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
                        <img src="img/product/1.png" class="card-img-top" alt="...">
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
                        <img src="img/product/6.png" class="card-img-top" alt="...">
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

<%--    footer--%>
    <%@include file="footer.jsp"%>
</div>
</body>
</html>