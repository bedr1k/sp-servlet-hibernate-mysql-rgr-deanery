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
		<c:if test="${discipline != null}">
			<form action="discipline?action=update" method="post">
        </c:if>
        <c:if test="${discipline == null}">
			<form action="discipline?action=insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
            	<h2>
            		<c:if test="${discipline != null}">
            			Редактирование дисциплины
            		</c:if>
            		<c:if test="${discipline == null}">
            			Добавление дисциплины
            		</c:if>
            	</h2>
            </caption>
        		<c:if test="${discipline != null}">
        			<input type="hidden" name="id" value="<c:out value='${discipline.id}' />" />
        		</c:if>            
            <tr>
                <th>Name: </th>
                <td>
                	<input type="text" name="name" size="45"
                			value="<c:out value='${discipline.name}' />"
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
