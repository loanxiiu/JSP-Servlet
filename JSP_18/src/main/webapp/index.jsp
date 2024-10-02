<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
</head>
<body>
<form action="trangDatHang.jsp" method="Get">
    <div class="form-group row">
        <label for="hoVaTen" class="col-sm-2 col-form-label">Ho va ten</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="hoVaTen" name="hoVaTen">
        </div>
    </div>
    <div class="form-group row">
        <label for="email" class="col-sm-2 col-form-label">Email</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="email" name="email">
        </div>
    </div>
    <div class="form-group row">
        <label for="soLuong" class="col-sm-2 col-form-label">So luong</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="soLuong" name="soLuong">
        </div>
    </div>
    <div class="form-group row">
        <button type="submit" class="btn btn-primary">Dat hang</button>
    </div>

</form>
</body>
</html>