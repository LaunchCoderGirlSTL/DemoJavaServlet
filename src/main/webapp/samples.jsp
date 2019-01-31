<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@ page import="java.lang.*;"%>

<html>
<head>
<style>

body {
 background-image: url("images/grand_prismatic.jpeg");
 background-color: #cccccc;
 font-family: fantasy;
}

table {margin: auto;}
img { height: 250px;
      padding: 20px;
      }
tr {
     text-align: center}

.rotate90 {
    width: 250px;
    height: auto;

    -webkit-transform: rotate(90deg);
    -moz-transform: rotate(90deg);
    -o-transform: rotate(90deg);
    -ms-transform: rotate(90deg);
    transform: rotate(90deg);
}


</style>
</head>
<body>

<br/>
<br/>
<p class="intro">
   <h2>Here are a selection of photos from the database<h2>
</p>
<br/>
<br/>

<table cellpadding="0" cellspacing="0" border="0" bgcolor="lightgrey">
<tr>
<c:forEach var="image" items="${results}">

    <td> <img src="${image.getUrl()}"  </td>

</c:forEach>
    <td></td>
</tr>

<tr>
<c:forEach var="image" items="${results}">

    <td>  ${image.getCaption()} </td>

</c:forEach>
</tr>

</table>

</body>
</html>
