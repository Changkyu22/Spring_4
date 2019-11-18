<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
<c:import url="./layout/bootStrap.jsp"></c:import>
</head>
<body>
<c:import url="./layout/nav.jsp"></c:import>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<div id="noticeResult">
	
</div>
	
<div>
	<select id="animal">
		<option value="d">Dog</option>
		<option value="c">Cat</option>
		<option value="b">Bird</option>
	</select>
	<div id="kind">
		<select>
			<option>치와와</option>
			<option>푸들</option>
			<option>불독</option>
			<option>시베리안</option>
		</select>
	</div>
</div>


<div>
	<input type="text" id="num">
	<button id="btn">Number</button>
</div>
<div id="result"></div>

<script type="text/javascript">
	var xmlhttp;

	if(window.XMLHttpRequest){
		xmlhttp=new XMLHttpRequest();
	}else{
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	
	xmlhttp.open("GET", "./notice/noticeResult");
	
	xmlhttp.send();
	
	xmlhttp.onreadystatechange=function(){
		if(this.readyState==4 && this.status == 200){
			$('#noticeResult').html(this.responseText);
		}
	}
	
	
		
		// 1. XMLHttpRequest 생성
		var xmlhttp;
		
		if(window.XMLHttpRequest){
			xmlhttp=new XMLHttpRequest();
		}else{
			xmlhttp = new XMLHttpRequest();
		}
		
		// 2. 요청정보 작성
		xmlhttp.open("GET", "./selectAnimal?kind="+$('#animal').val);
		
		// 3. 전송 GET
		xmlhttp.send();
		
		// 3-1. 전송 POST
		//xmlhttp.send("파라미터이름=파라미터값&파라미터이름2=파라미터값2");
		//xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		
		// 4. 결과처리
		xmlhttp.onreadystatechange=function(){
			if(this.readyState==4 && this.status == 200){
				$('#kind').html(this.responseText);
			}
		}


	$('#animal').change(function() {
		var xmlhttp;
		
		// 1. XMLHttpRequest 생성
		if(window.XMLHttpRequest){
			xmlhttp=new XMLHttpRequest();
		}else{
			xmlhttp = new XMLHttpRequest();
		}
		
		// 2. 요청정보 작성
		xmlhttp.open("GET", "./selectAnimal?kind="+$('#animal').val);
		
		// 3. 전송 GET
		xmlhttp.send();
		
		// 3-1. 전송 POST
		//xmlhttp.send("파라미터이름=파라미터값&파라미터이름2=파라미터값2");
		//xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		
		// 4. 결과처리
		xmlhttp.onreadystatechange=function(){
			if(this.readyState==4 && this.status == 200){
				$('#kind').html(this.responseText);
			}
		}
	})


	$('#btn').click(function() {
		
		var xmlhttp;
	
		if (window.XMLHttpRequest) {
		   // code for modern browsers
		   xmlhttp = new XMLHttpRequest();
		 } else {
		   // code for old IE browsers
		   xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		
		var num = $('#num').val();
		// request 정보
 		//xmlhttp.open("GET", "./testAjax?num"+num);
		xmlhttp.open("POST", "./testAjax");
		
		// GET method
		// xmlhttp.send();
		
		// POST method
		xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xmlhttp.send("num="+num);
		
		xmlhttp.onreadystatechange = function() {
			if(this.readyState == 4 && this.status == 200){
				// JavaScript
				// document.getElementById("result").innerHTML=this.responseText
				
				// Jquery
				$('#result').html(this.responseText);
			}
		}
	
	});
	
	
	
	
	
	
	
	
	
	
</script>
</body>
</html>
