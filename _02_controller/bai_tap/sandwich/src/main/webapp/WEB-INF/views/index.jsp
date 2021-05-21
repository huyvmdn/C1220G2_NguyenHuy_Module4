<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>The World Clock</title>
  <style type="text/css">

  </style>
</head>
<body>

<form id="locale" action="/giaVi" method="get">
  <input type="checkbox" name="giaVi" value="Lettuce">Lettuce
  <input type="checkbox" name="giaVi" value="Tomato">Tomato
  <input type="checkbox" name="giaVi" value="Mustard">Mustard
  <input type="checkbox" name="giaVi" value="Sprouts">Sprouts
  <input type="submit" value="save">
</form>

<p>Các loại gia vị đã chọn :</p>

 <c:forEach var="string" items="${mangGiaVi}">
      <p>${string}</p>
 </c:forEach>

</body>
</html>