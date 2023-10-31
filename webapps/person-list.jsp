<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Person List</title>
</head>
<body>

<c:forEach items="${persons}" var="person">
    ${person.id} - ${person.name}
    <hr>
</c:forEach>

</body>
</html>