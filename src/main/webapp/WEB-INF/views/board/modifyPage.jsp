<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../include/header.jsp" %>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>




</script>

<section class = "content">
	<div class = "row">
		<div class = "col-sm-12">
			<div class = "box box-primary">
				<div class = "box-header">
					<h3 class = "box-title">READ BOARD</h3>
				</div>

				<form action = "modifyPage" method ="post">
				
				<input type = "hidden"  name  = "bno"value = "${boardVo.bno}">
				
				
					<div class = "box-body">
						<div class = "form-group">
							<label>Title</label>
							<input type = "text" name= "title" class = "form-control" placeholder = "Enter Title" value = "${boardVo.title }">
						</div>
						
												<div class = "form-group">
							<label>Content</label>
						
							<textarea rows="5" cols="50" class = "form-control" name = "content" placeholder="Enter Content">${boardVo.content } </textarea>
						</div>
						
						
						<div class = "form-group">
							<label>Writer</label>
							<input type = "text" name= "writer" class = "form-control" placeholder = "Enter Title" value = " ${boardVo.title }" readonly="readonly">
						</div>
		
					</div>
				<div class = "box-footer">
					<input type = "submit" value = "modify">
					
				</div>
				</form>
				
			</div>
			
		</div>
		
	</div>


</section>





<%@ include file = "../include/footer.jsp" %>