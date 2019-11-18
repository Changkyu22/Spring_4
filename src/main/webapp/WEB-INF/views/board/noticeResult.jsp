<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- <c:forEach items="list" var="vo"> --%>
<!-- 	<ul> -->
<%-- 		<li><a href="./notice/noticeSelect?num=${vo.num}">${vo.title}</a></li> --%>
<%-- 		<li>${vo.reg_date}</li> --%>
<!-- 	</ul> -->
<%-- </c:forEach> --%>



<c:forEach items="${list}" var="dto" varStatus="st">
	<tr>
	  <td>${dto.num}</td>
	  <td>
	  <c:catch>
	  	<c:forEach begin="1" end="5">└</c:forEach>
	  </c:catch>
	  <a href="./${board}Select?num=${dto.num}">${dto.title}</a></td>
	  <td>${dto.writer}</td>
	  <td>${dto.reg_date}</td>
	  <td>${dto.hit}</td>
	</tr>
</c:forEach>