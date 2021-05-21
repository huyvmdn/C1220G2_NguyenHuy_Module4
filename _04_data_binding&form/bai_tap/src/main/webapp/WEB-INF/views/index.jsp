<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>Máy tính</title>
  <style type="text/css">

  </style>
</head>
<body>
<h2>Setting</h2>

<form:form method="post" action="/email" modelAttribute="email">
  Languages
  <form:select path="languages" items="${listLanguages}"/> <br><br>
  Page Sizes
  <form:select path="pageSize" items="${listSizePage}"/> <br><br>
Spams Filter:
<form:checkbox path="spamsFilter"/> <br><br>
Signature
<form:textarea path="signature"/> <br><br>
<form:button>Update</form:button>
 <button><a href="/email">Cancle</a></button>
</form:form>
<script src="jquery\jquery-3.6.0.min.js"></script>
<script src="datatables/js/jquery.dataTables.min.js"></script>
<script src="datatables/js/dataTables.bootstrap4.min.js"></script>
<script src="bootstrap413\js\bootstrap.min.js"></script>
<script>
  $(document).ready(function () {
    $('#Table').dataTable({
      "dom": 'lrtip',
      "lengthChange": false,
      "pageLength": 5
    });
  });

</script>
</body>
</html>