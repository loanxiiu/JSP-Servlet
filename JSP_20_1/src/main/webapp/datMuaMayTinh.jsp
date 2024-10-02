<%--
  Created by IntelliJ IDEA.
  User: ploan
  Date: 9/8/2024
  Time: 9:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    double tongTien=0;
//    Radio button -> name
    String processor = request.getParameter("processor");
    double processorPrice =0;
    if(processor!=null){
        if(processor.equals("core i9")){
            processorPrice+=5000000;
        }
        else if(processor.equals("core i7")){
            processorPrice+=4000000;
        }
        else if(processor.equals("core i5")){
            processorPrice+=3000000;
        }
        else {
            processorPrice+=0;
        }
    }

    String ram = request.getParameter("ram");
    double ramPrice =0;
    if(ram!=null){
        if(ram.equals("16 GB")){
            ramPrice+=1600000;
        }
        else if(ram.equals("8 MB")){
            ramPrice+=800000;
        }
        else {
            ramPrice+=0;
        }
    }


//    Checkbox -> name
    String monitor = request.getParameter("monitor");
    double monitorPrice =0;
    if(monitor!=null){
        monitorPrice+=2000000;
    }
    else {
        monitorPrice+=0;
    }


//    Select -> array
    String[] accessories = request.getParameterValues("accessori");
    double cameraPrice =0;
    double printerPrice =0;
    double scannerPrice =0;
    for(String accessorie:accessories){
        if(accessorie.equals("Camera")){
            cameraPrice+=800000;
        }
        if(accessorie.equals("Printer")){
            printerPrice+=1500000;
        }
        if(accessorie.equals("Scanner")){
            scannerPrice+=1500000;
        }
    }
    tongTien = monitorPrice+cameraPrice+printerPrice+scannerPrice+ramPrice+processorPrice;
%>
<h1>HÓA ĐƠN</h1>
<table class="table">
    <thead>
    <tr>
        <th scope="col">Tên sản phẩm</th>
        <th scope="col">Giá tiền</th>
    </tr>
    </thead>
    <tbody>
    <%
        if(processor!=null){
    %>
    <tr>
        <td> <%=processor%> </td>
        <td><%=processorPrice%></td>
    </tr>
    <%
        }
        if(ram!=null){
    %>
    <tr>
        <td> <%=ram%> </td>
        <td><%=ramPrice%></td>
    </tr>
    <%
        }
        if(monitor!=null){
    %>
    <tr>
        <td> <%=monitor%> </td>
        <td><%=monitorPrice%></td>
    </tr>
    <%
        }
    %>

    <%
        if(accessories!=null)
        for(String accessorie:accessories){
            double price=0;
            if(accessorie.equals("Camera")){
                price+=800000;
            }
            if(accessorie.equals("Printer")){
                price+=1500000;
            }
            if(accessorie.equals("Scanner")){
                price+=1500000;
            }
            %>
    <tr>
        <td> <%=accessorie%> </td>
        <td><%=price%></td>
    </tr>
<%
        }
    %>
    <tr>
        <td>Tổng tiền</td>
        <td><%=tongTien%></td>
    </tr>
    </tbody>
</table>
</body>
</html>
