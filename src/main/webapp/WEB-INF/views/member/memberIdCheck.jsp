<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../layout/bootStrap.jsp"></c:import>
</head>
<body>
	<div class="container">
	<h1>${param.id}(은)는${result}</h1>
		<form class="form-inline" action="./memberIdCheck">
		    <label for="id" class="mb-2 mr-sm-2">ID:</label>
		    <input type="text" class="form-control mb-2 mr-sm-2" id="id" placeholder="Enter id" name="id" value="${param.id}">
		    
		    <button type="submit" class="btn btn-default">Submit</button>
		    <c:if test="${empty dto}">
		    	<input type="button" id="useId" value="사용하기">
		    </c:if>
		</form>
	</div>
</body>
<script type="text/javascript">
	$("#useId").click(function() {
		var id=$('#id').val();
		// javascript에서 보내는법
		// opener.document.getElementById("id").value=id;
		// jquery에서 보내는법
		$('#id',opener.document).val(id);
		window.self.close();
	})
</script>
</html>