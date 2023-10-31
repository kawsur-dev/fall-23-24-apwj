<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Person List</title>
</head>
<body>

<input type="button" value="Add Person"
				   onclick="window.location.href='person-create.jsp'; return false;"
			/>

<table>

    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Action</th>
    </tr>

    <c:forEach var="person" items="${persons}">
        <c:url var="update" value="first">
            <c:param name="COMMAND" value="UPDATE_PAGE" />
            <c:param name="id" value="${person.id}" />
            <c:param name="name" value="${person.name}" />
        </c:url>
        <c:url var="delete" value="first">
            <c:param name="COMMAND" value="DELETE" />
            <c:param name="id" value="${person.id}" />
        </c:url>

        <tr>
            <td> ${person.id} </td>
            <td> ${person.name} </td>
            <td>
                <a href="${update}">Update</a>
                 |
                <a href="${delete}"
                onclick="if (!(confirm('Are you sure you want to delete this student?'))) return false">
                Delete</a>
            </td>
        </tr>

    </c:forEach>

</table>

</body>
</html>