<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="http://code.jquery.com/jquery-1.9.1.min.js"></script>

<style>
#modWrap{
	display: none;
}

</style>

</head>
<body>

<fieldset>

<form action = "insert" method = "post">

아이디 : <input type = "text" name = "id" id = "id"><br>
이름 : <input type = "text" name = "name" id = "name"><br>
비밀번호 : <input type = "text" name = "password" id = "password"><br>
이메일 : <input type = "text" name = "email" id = "email"><br>

<input type = "submit" value = "추가" id = "insert"> <button id = "list">리스트 가져오기</button>

</form>

<div id = "modWrap">

아이디 : <input type = "text" name = "id" id = "mid"><br>
이름 : <input type = "text" name = "name" id = "mname"><br>
비밀번호 : <input type = "text" name = "password" id= "mpassword"><br>
이메일 : <input type = "text" name = "email" id = "memail"><br>

	<button id = "btnModSave">수정</button>
	<button id = "btnModCancel">닫기</button>

</div>

</fieldset>

<script>

$(function(){

	$("#list").click(function(){		
		list();			
	})	


	$("#insert").click(function(){
		var id = $("#id").val();
		var name = $("#name").val();
		var password = $("#password").val();
		var email = $("#email").val();
		
		var data = JSON.stringify({
			userid : id,
			userpw : name,
			username : password,	
			email: email
		});
		
		console.log(data);
			
		$.ajax({
			
			url: "member/",
			type: "post",
			data: data,
			headers:{"Content-Type":"application/json"},
			dataType: "text",
			success:function(res){		
				console.log(res);
				
				$(".id").text(id);
				$(".name").text(name);
				$(".email").text(email);
				$(".password").text(password); 
				
				
				
				$("#list").click();
			},
			error:function(e){
				
				console.log(e);
			}
			
		})
		
	})	

	
function list(){
		
		$.ajax({
			
			url:"member/",
			type: "get",
			dataType: "json",
			success:function(res){
				console.log(res);
				alert("success");
				$("#list").empty();

				var source = $("#template").html();
				var func = Handlebars.compile(source);
				var str = func(res);
				$("#list").html(str);
			
	
			},			
			error:function(e){
				console.log(e)
			}
		})

	}

$(document).on("click",".btnMod",function(){
	
	$("#modWrap").css("display","block");
	
	
})


$(document).on("click",".btnDel",function(){
	
	
	$.ajax({
		url: "member/",
		type: "delete",
		dataType: "text",
		success:function(res){

			if(res == success){
				alert("삭제");
				$("#btnList").click();
				list();
				
			}
				
		}

	})
	
	
})


$("#btnModSave").click(function(){
			
	var id = $("#mid").text();
	var name = $("#mname").text();
	var email = $("#memail").text();
	var password = $("#mpassword").text();
	
	var data = JSON.stringify({
		userid : id,
		userpw : name,
		username : password,	
		email: email
	});
		$.ajax({
		
			url: "member/",
			type: "put",
			data: data,
			headers:{"Content-Type":"application/json"},
			dataType: "text",
			success:function(res){
				console.log(res);
				
				$(".id").text(id);
				$(".name").text(name);
				$(".email").text(email);
				$(".password").text(password); 
								
				if(res == "success"){
					$("#modWrap").css("display","none");
					list();
				}
			
			},
			error:function(e){
		
				console.log(e);
			}
		})
			
	})
})
</script>


<script id = "template" type = "text/x-handlebars-template"> 


{{#list}}

	<tr>
		<td class = "id">{{id}}</td>
		<td class = "name">{{name}}</td>
		<td class = "password">{{password}}</td>
		<td class = "email">{{email}}</td>
		<td>		
		<button class = "btnMod">수정</button>
		<button class = "btnDel">삭제</button>
		</td>
	</tr>


{{/list}}


</script>






</body>
</html>