<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>Máy tính</title>
  <style type="text/css">

  </style>
</head>
<body>

<form id="locale" action="/phepTinh" method="get">
  <input type="number" name="so1" >
    <input type="number" name="so2">
    <select name="phepTinh" id="">
        <option value="+">Cộng</option>
        <option value="-"> Trừ </option>
        <option value="*"> Nhân</option>
        <option value="/"> Chia</option>
    </select>
    <input type="submit" value="tính">
</form>

<p>RESULT :</p>
<p>${ketQua}</p>



</body>
</html>