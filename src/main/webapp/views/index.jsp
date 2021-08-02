<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href=
"https://cdn.datatables.net/1.10.22/css/jquery.dataTables.min.css" />
<script type="text/javascript"
     src="https://code.jquery.com/jquery-3.5.1.js">
</script>
 <script type="text/javascript" src=
"https://cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js">
     </script>


<script>
    $(document).ready( function () {
        $('#mobilesTbl').DataTable();
    } );
</script>

</head>
<body>
    <form:form action="searchMobiles" method="POST" modelAttribute="formObject">
        <table>
            <tr>
                <td>Band</td>
                    <td><form:select path="brand">
                        <form:option value="">-Select-</form:option>
                        <form:options items="${brands}"/>
                    </form:select></td>
                <td>Ram</td>
                    <td><form:select path="ram">
                            <form:option value="">-Select-</form:option>
                            <form:options items="${ram}"/>
                    </form:select></td>
                <td>Rating</td>
                    <td><form:select path="rating">
                            <form:option value="">-Select-</form:option>
                            <form:options items="${rating}"/>
                    </form:select></td>
                <td>Price Range</td>
                     <td><form:select path="price">
                            <form:option value="">-Select-</form:option>
                            <form:option value="10000"><10000</form:option>
                            <form:option value="15000"><15000</form:option>
                            <form:option value="20000"><20000</form:option>
                            <form:option value="30000"><30000</form:option>
                            <form:option value="40000"><40000</form:option>
                            <form:option value="50000"><50000</form:option>
                     </form:select></td>
                <td><input type="SUBMIT" value="Search" /></td>
            </tr>
        </table>
    </form:form>
    <hr/>
    <div>
        <table border="1" id="mobilesTbl">
            <thead>
                    <tr>
                        <td>Mobile Name</td>
                        <td>Mobile Price</td>
                        <td>Mobile Rating</td>
                        <td>Mobile Ram</td>
                    </tr>
            </thead>
            <tbody>
                  <c:forEach items="${mobiles}" var="c" varStatus="count">
                               <tr>
                                	<td>${c.brand}</td>
                                	<td>${c.price}</td>
                                	<td>${c.ram}</td>
                                	<td>${c.rating}</td>
                               </tr>
                  </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>