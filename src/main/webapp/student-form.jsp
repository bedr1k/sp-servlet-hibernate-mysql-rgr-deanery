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
		<c:if test="${student != null}">
			<form action="student?action=update" method="post">
        </c:if>
        <c:if test="${student == null}">
			<form action="student?action=insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
            	<h2>
            		<c:if test="${student != null}">
            			Редактирование студента
            		</c:if>
            		<c:if test="${student == null}">
            			Добавление студента
            		</c:if>
            	</h2>
            </caption>
        		<c:if test="${student != null}">
        			<input type="hidden" name="id" value="<c:out value='${student.id}' />" />
        		</c:if>            
            <tr>
                <th>First Name: </th>
                <td>
                	<input type="text" name="firstName" size="45"
                			value="<c:out value='${student.firstName}' />"
					/>
                </td>
            </tr>
            <tr>
                <th>Second Name: </th>
                <td>
                	<input type="text" name="secondName" size="45"
                			value="<c:out value='${student.secondName}' />"
                	/>
                </td>
            </tr>
            <tr>
                <th>Patronymic: </th>
                <td>
                	<input type="text" name="patronymic" size="15"
                			value="<c:out value='${student.patronymic}' />"
                	/>
                </td>
            </tr>
			<tr>
                <th>Group ID: </th>
                <td>
                	<input type="text" name="groupId" size="15"
                			value="<c:out value='${student.group.id}' />"
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
