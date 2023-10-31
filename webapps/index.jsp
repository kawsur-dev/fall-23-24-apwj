<%@ page import="java.util.Date" %>
<%@ page import="com.Utility" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>First App</title>
</head>
<body>

<c:set var="i" value="200" />
<c:set var="arr1" value="XYZ, YZA, ABC, XXY, YYX, UUI, IIO" />
<c:out value="${i}" />

<c:forEach items="${arr1}" var="x">
   <c:if test = "${x == 'XYZ' }">
       Just Print
   </c:if>

   <c:if test = "${! (x == 'XYZ') }">
        Exceptional Just Print
   </c:if>
</c:forEach>

</body>
</html>