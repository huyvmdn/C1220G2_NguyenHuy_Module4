<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 27/04/2021
  Time: 2:02 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1> chuyển đổi từ USD sang VNĐ với một tỉ giá cho trước</h1>
  <form action="/conversion" method="post">
   Nhập USD cần đổi" <input type="text" name="tien">
    <input type="submit" value="Đổi">
  </form>
 <p >${ketqua}</p>
  </body>
</html>
