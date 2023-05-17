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
        	<a href="student?action=new">Добавить студента</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="student?action=list">Список студентов</a>
			<br>
        	<a href="home">Главная страница</a>
        </h2>
	</center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Студенты ГТУГ</h2></caption>
            <tr>
                <th>ID</th>
                <th>First Name</th>
                <th>Second Name</th>
                <th>Patronymic</th>
                <th>Group Name</th>
                <th>Avg Grade</th>
				<th>Group ID</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="student" items="${listStudents}">
                <tr>
				    <td><c:out value="${student.id}" /></td>
                    <td><c:out value="${student.firstName}" /></td>
                    <td><c:out value="${student.secondName}" /></td>
                    <td><c:out value="${student.patronymic}" /></td>
                    <td><c:out value="${student.group.name}" /></td>
                    <td><c:out value="${mapGrades[student]}" /></td>
					<td><c:out value="${student.group.id}" /></td>
                    <td>
                    	<a href="student?action=edit&id=<c:out value='${student.id}' />">Редактировать</a>
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	<a href="student?action=delete&id=<c:out value='${student.id}' />">Вычеркнуть</a>                    	
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>	
</body>
</html>
