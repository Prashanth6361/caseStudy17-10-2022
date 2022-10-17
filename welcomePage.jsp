<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<form action="performRecharge" method="post">
<h2 style="color:blue">
<label>Enter Mobile Number:</label>
<input type="text" name="mobileNumber"/>
<br/>
<h3 style="color:blue">
<i>Select Plan from below</i>
</h3>
<table border="2" bgcolor="yellow">
<tr bgcolor="orange">
<th>PLAN ID</th>
<th>DAYS</th>
<th>TALKTIME</th>
<th>DATA</th>
<th>PRICE</th>
<th>SELECT</th>
</tr>
<c:forEach  items="${offerList}" var="offer">
<tr>
<td>${offer.id}</td>
<td>${offer.days}</td>
<td>${offer.talkTime}</td>
<td>${offer.data}GB</td>
<td>${offer.price}</td>
<td><input type="radio" name="offerId" value="${offer.id}"></td>
</tr>
</c:forEach>
</table>
</h2>
<br/>
<input type="submit" value="Submit"/>
</form>
</div>
</body>
</html>