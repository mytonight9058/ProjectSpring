<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../include/header.jsp" %>


<h1>Register</h1>

<section class = "content">
	<div class = "row">
		<div class = "col-sm-12">
			<div class = "box box-primary">
				<div class = "box-header">
					<h3 class = "box-title">REISTER BOARD</h3>
				</div>
				<form action = "register" method ="post">
					<div class = "box-body">
						<div class = "form-group">
							<label>Title</label>
							<input type = "text" name= "title" class = "form-control" placeholder = "Enter Title">
						</div>
						
												<div class = "form-group">
							<label>Content</label>
						
							<textarea rows="5" cols="50" class = "form-control" name = "content" placeholder="Enter Content"> </textarea>
						</div>
						
						
						<div class = "form-group">
							<label>Writer</label>
							<input type = "text" name= "writer" class = "form-control" placeholder = "Enter Title">
						</div>
		
					</div>
				<div class = "box-footer">
					<button type = "submit" class  ="btn btn-primary">Submit</button>

				</div>
				
				</form>
				
			</div>
			
		</div>
		
	</div>


</section>


<%@ include file = "../include/footer.jsp" %>