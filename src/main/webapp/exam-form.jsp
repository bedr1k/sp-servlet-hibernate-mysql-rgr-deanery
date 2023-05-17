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
		<c:if test="${exam != null}">
			<form action="exam?action=update" method="post">
        </c:if>
        <c:if test="${exam == null}">
			<form action="exam?action=insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
            	<h2>
            		<c:if test="${exam != null}">
            			Редактировать результат
            		</c:if>
            		<c:if test="${exam == null}">
            			Добавить результат
            		</c:if>
            	</h2>
            </caption>
        		<c:if test="${exam != null}">
        			<input type="hidden" name="id" value="<c:out value='${exam.id}' />" />
        		</c:if>            
            <tr>
                <th>Grade: </th>
                <td>
                	<input type="text" name="grade" size="45"
                			value="<c:out value='${exam.grade}' />"
					/>
                </td>
            </tr>
            <tr>
                <th>Exam Day: </th>
                <td>
                	<input type="text" name="examDay" size="45"
                			value="<c:out value='${exam.examDay}' />"
                	/>
                </td>
            </tr>
            <tr>
                <th>Discipline ID: </th>
                <td>
                	<input type="text" name="disciplineId" size="15"
                			value="<c:out value='${exam.discipline.id}' />"
                	/>
                </td>
            </tr>
			<tr>
                <th>Student ID: </th>
                <td>
                	<input type="text" name="studentId" size="15"
                			value="<c:out value='${exam.student.id}' />"
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
