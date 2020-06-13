<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>User Management Application</title>
</head>
<body>

	<center>
		<h1>User Management</h1>
        <h2>
        	<a href="/admin/new">Add New User</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="/admin">List All Users</a>

        </h2>
	</center>
    <div align="center">
		<c:if test="${user != null}">
			<form action="/admin/update" method="post">
        </c:if>
        <c:if test="${user == null}">
			<form action="/admin/add" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
            	<h2>
            		<c:if test="${userForEdit != null}">
            			Edit User
            		</c:if>
            		<c:if test="${userForEdit == null}">
            			Add New User
            		</c:if>
            	</h2>
            </caption>
        		<c:if test="${userForEdit != null}">
        			<input type="hidden" name="id" value="<c:out value='${userForEdit.id}' />" />
        		</c:if>



            <tr>
                <th>User Name: </th>
                <td>
                	<input type="text" name="name" size="45"
                			value="<c:out value='${userForEdit.name}' />"
                		/>
                </td>
            </tr>
            <tr>
                <th>User Age: </th>
                <td>
                	<input type="text" name="age" size="45"
                			value="<c:out value='${userForEdit.age}' />"
                	/>
                </td>
            </tr>
            <tr>
                <th>Login: </th>
                <td>
                	<input type="text" name="login" size="15"
                			value="<c:out value='${userForEdit.login}' />"
                	/>
                </td>
            </tr>
			<tr>
				<th>Password: </th>
				<td>
					<input type="text" name="password" size="15"
						   value="<c:out value='${userForEdit.password}' />"
					/>
				</td>
			</tr>
			<tr>
				<th>Role: </th>
				<td>
					<input type="text" name="role" size="15"
						   value="<c:out value='${userForEdit.role}' />"
					/>
				</td>
			</tr>
            <tr>
            	<td colspan="2" align="center">
            		<input type="submit" value="Save" />
            	</td>
            </tr>
        </table>
        </form>
    </div>
</body>
</html>
