<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>May Tinh</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <h1>Chọn cấu hình máy tính bạn cần mua</h1>
    <hr/>
    <form action="datMuaMayTinh.jsp">
        <h2>CPU</h2>
        <div class="form-check">
            <input class="form-check-input" type="radio" name="processor" id="core i9" value="core i9">
            <label class="form-check-label" for="core i9">
                Core i9
            </label>
        </div>
        <div class="form-check">
            <input class="form-check-input" type="radio" name="processor" id="core i7" value="core i7">
            <label class="form-check-label" for="core i7">
                Core i7
            </label>
        </div>
        <div class="form-check">
            <input class="form-check-input" type="radio" name="processor" id="core i5" value="core i5">
            <label class="form-check-label" for="core i5">
                Core i5
            </label>
        </div>

        <h2>RAM</h2>
        <div class="form-check">
            <input class="form-check-input" type="radio" name="ram" id="ram16gb" value="16 GB">
            <label class="form-check-label" for="ram16gb">
                16 GB
            </label>
        </div>
        <div class="form-check">
            <input class="form-check-input" type="radio" name="ram" id="ram8gb" value="8 GB">
            <label class="form-check-label" for="ram8gb">
                8 GB
            </label>
        </div>

        <h2>Monitor</h2>
        <div class="form-check">
            <input class="form-check-input" type="checkbox" name="monitor" id="monitor" value="Monitor">
            <label class="form-check-label" for="monitor">
                Monitor
            </label>
        </div>

        <h2>Accessori</h2>
        <select class="form-select" multiple aria-label="multiple select example" name="accessori">
            <option value="Camera">Camera</option>
            <option value="Printer">Printer</option>
            <option value="Scanner">Scanner</option>
        </select>
        <button class="btn btn-primary mt-2" type="submit">Buy</button>
    </form>
</div>
</body>
</html>
