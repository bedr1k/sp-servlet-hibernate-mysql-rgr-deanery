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
        	<a href="exam?action=new">Добавить результат</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="exam?action=list">Список результатов</a>
			<br>
        	<a href="home">Главная страница</a>
        </h2>
	</center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Результаты экзаменов</h2></caption>
            <tr>
                <th>ID</th>
                <th>Grade</th>
                <th>Exam Day</th>
                <th>Student Second Name</th>
                <th>Discipline Name</th>
                <th>Discipline ID</th>
				<th>Student ID</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="exam" items="${listExams}">
                <tr>
				    <td><c:out value="${exam.id}" /></td>
                    <td><c:out value="${exam.grade}" /></td>
                    <td><c:out value="${exam.examDay}" /></td>
                    <td><c:out value="${exam.student.secondName}" /></td>
                    <td><c:out value="${exam.discipline.name}" /></td>
                    <td><c:out value="${exam.discipline.id}" /></td>
					<td><c:out value="${exam.student.id}" /></td>
                    <td>
                    	<a href="exam?action=edit&id=<c:out value='${exam.id}' />">Редактировать</a>
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	<a href="exam?action=delete&id=<c:out value='${exam.id}' />">Вычеркнуть</a>                    	
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>	
</body>
</html>
