<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<c:import url="../layout/nav.jsp"></c:import>
	<div class="container">
		<h2>Member Join Form</h2>
		<form action="./memberJoin" id="frm" method="post">
			<div class="form-group">
				<label for="id" class="form-group">ID:</label>
				<input type="text" class="form-inline" id="id" placeholder="Enter ID" required="required" name="id">
		    	<input type="button" class="btn btn-default" value="중복확인" id="checkId">
			</div>	
		    <div class="form-group">
				<label for="pw">PW:</label>
				<input type="password" class="form-control" id="pw" placeholder="Enter PW" required="required" name="pw">
		    </div>
		    <div class="form-group">
				<label for="name">NAME:</label>
				<input type="text" class="form-control" id="name" placeholder="Enter NAME" required="required" name="name">
		    </div>
		    <div class="form-group">
				<label for="email">email:</label>
				<input type="email" class="form-control" id="email" placeholder="Enter E-MAIL" required="required" name="email">
		    </div>
		    <div class="form-group">
				<label for="birth">BIRTH:</label>
				<input type="date" class="form-control" id="birth" placeholder="Enter BIRTH DAY" required="required" name="birth">
		    </div>
		    <div class="form-group">
				<label for="gender">GENDER:</label>
				<div class="checkbox">
					<label><input type="checkbox" name="gender" value="M">Male</label>
					<label><input type="checkbox" name="gender" value="F">Female</label>
				</div>
		    </div>
			<button type="submit" class="btn btn-default">Submit</button>
		</form>
	</div>
	
	<script type="text/javascript">
		//$("선택자").action();
		$("#checkId").click(function() { // callback 함수
			var id = $("#id").val();
			window.open("./memberIdCheck?id="+id,"","width=1000,height=400,left=400,top=200");
		});
	</script>
</body>
</html>