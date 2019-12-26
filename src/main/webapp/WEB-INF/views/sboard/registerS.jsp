<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../include/header.jsp" %>

<script type="text/javascript" src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<h1>Register</h1>

<section class = "content">
	<div class = "row">
		<div class = "col-sm-12">
			<div class = "box box-primary">
				<div class = "box-header">
					<h3 class = "box-title">REISTER BOARD</h3>
				</div>
				<form action = "registerS" method ="post" enctype="multipart/form-data">
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
		
						<div class = "form-group">
							<label>Image Files</label>
							<input type = "file" name= "imageFiles" id = "imageUp" multiple="multiple" class = "form-control" placeholder = "Enter File">
							
							
							<div id = "imagebox">    </div>
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


imagebox

<script>

$(function(){

	$("#imageUp").change(function(){
		var file = $(this)[0].files[0];

		var reader = new FileReader();
		reader.readAsDataURL(file); 
		reader.onload = function(e){ 
			var $img= $("<img>").attr("src",e.target.result); // target.result   https://www.phpschool.com/gnuboard4/bbs/board.php?bo_table=qna_html&wr_id=274940
			$("#imagebox").append($img);
		}
	
	})
	$("#imagebox").empty();
})


</script>






<%@ include file = "../include/footer.jsp" %>