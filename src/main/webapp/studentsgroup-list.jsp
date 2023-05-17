<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>Деканат ГТУГ</title>
</head>
<body>
	<center>
		<h1>Деканат Государственного Технологического Университета Генсокё</h1>
        <h2>
        	<a href="group?action=new">Создать группу</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="group?action=list">Список групп</a>
			<br>
        	<a href="home">Главная страница</a>
        </h2>
	</center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Группы ГТУГ</h2></caption>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Course</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="group" items="${listGroups}">
                <tr>
				    <td><c:out value="${group.id}" /></td>
                    <td><c:out value="${group.name}" /></td>
                    <td><c:out value="${group.course}" /></td>
                    <td>
                    	<a href="group?action=edit&id=<c:out value='${group.id}' />">Редактировать</a>
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	<a href="group?action=delete&id=<c:out value='${group.id}' />">Вычеркнуть</a>                    	
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>	
</body>
</html>
