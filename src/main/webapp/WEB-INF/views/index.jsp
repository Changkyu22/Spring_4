<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
<c:import url="./layout/bootStrap.jsp" />
<c:import url="./layout/summerNote.jsp" />
</head>
<body>
<c:import url="./layout/nav.jsp" />
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<button id="btn">Get Json</button>
<button id="btn2">Click</button>
<button id="btn3">Click Movies</button>
<script type="text/javascript">
	$("#btn3").click(function() {
		$.ajax({
			type:"GET",
			url:"https://yts.lt/api/v2/list_movies.json",
			data:{
				limit:2,
			},
			success:function(data){
				console.log(data.movies[0].medium_cover_image);
			},
			error:function(){
				console.log("error");
			}
		});
	});
	
	$("#btn2").click(function() {
		$.ajax({
			type:"GET",
			url:"https://api.manana.kr/exchange/price.json",
			data:{
				base:"USD",
				price:1,
				code:"KRW"
			},
			success:function(data){
				console.log(data.KRW);
			}
		}); 
			
	});

	$("#btn").click(function() {
		$.get("./getJson3", function(data) {
			$.each(data, function(i, d) {
				console.log(i);
				console.log(d.num);
			});
			
// 			for(var i=0;i<data.length;i++){
// 				console.log(data[i].num);
// 			}
// 			data = data.trim();
// 			alert(typeof data);
// 			data = JSON.parse(data); 

// 			alert(data.title);
// 			alert(data.writer);
		});
	});
</script>
</body>
</html>
