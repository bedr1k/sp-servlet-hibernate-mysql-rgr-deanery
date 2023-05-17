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
        	<a href="discipline?action=new">Добавить дисциплину</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="discipline?action=list">Список дисциплин</a>
			<br>
        	<a href="home">Главная страница</a>
        </h2>
	</center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Дисциплины ГТУГ</h2></caption>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Avg Grade</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="discipline" items="${listDisciplines}">
                <tr>
				    <td><c:out value="${discipline.id}" /></td>
                    <td><c:out value="${discipline.name}" /></td>
                    <td><c:out value="${mapGrades[discipline]}" /></td>
                    <td>
                    	<a href="discipline?action=edit&id=<c:out value='${discipline.id}' />">Редактировать</a>
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	<a href="discipline?action=delete&id=<c:out value='${discipline.id}' />">Вычеркнуть</a>                    	
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>	
</body>
</html>
