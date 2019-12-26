<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../include/header.jsp" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>

$(function(){
	$("#modi").click(function(){
		
//		location.href = "${pageContext.request.contextPath}/read2.jsp";

		location.href = "modifyPage?bno=${boardVo.bno}";
	})
	$("#remove1").click(function(){
		
		location.href = "removePage?bno=${boardVo.bno}&page=${cri.page}";
		

	})
		$("#go").click(function(){
		
		location.href = "listPage?page=${cri.page}";
		
	})
})


</script>


<section class = "content">
	<div class = "row">
		<div class = "col-sm-12">
			<div class = "box box-primary">
				<div class = "box-header">
					<h3 class = "box-title">READ BOARD</h3>
				</div>
				
					<div class = "box-body">
						<div class = "form-group">
							<label>Title</label>
							<input type = "text" name= "title" class = "form-control" placeholder = "Enter Title" value = "${boardVo.title }" readonly="readonly">
						</div>
						
												<div class = "form-group">
							<label>Content</label>
						
							<textarea rows="5" cols="50" class = "form-control" name = "content" placeholder="Enter Content"readonly="readonly">${boardVo.content } </textarea>
						</div>
						
						
						<div class = "form-group">
							<label>Writer</label>
							<input type = "text" name= "writer" class = "form-control" placeholder = "Enter Title" value = " ${boardVo.title }"readonly="readonly">
						</div>
		
					</div>
				<div class = "box-footer">
				
					<div class = "btn btn-warning" id = "modi">	Modify</div>
					<div class = "btn btn-danger" id = "remove1">Remove</div>
					<div class = "btn btn-primary" id = "go">Go List</div>
				</div>
				
				
			</div>
			
		</div>
		
	</div>


</section>





<%@ include file = "../include/footer.jsp" %>