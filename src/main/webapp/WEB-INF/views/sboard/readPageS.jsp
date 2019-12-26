<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../include/header.jsp" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.5.3/handlebars.min.js"></script>


<script>


$(function(){
	$("#modi").click(function(){
		
//		location.href = "${pageContext.request.contextPath}/read2.jsp";

		location.href = "modifyPageSS?bno=${boardVO.bno}&page=${cri.page}&searchType=${cri.searchType}&keyword=${cri.keyword}";
	})
	$("#remove1").click(function(){
		
		location.href = "removePageS?bno=${boardVo.bno}&page=${cri.page}";
		

	})
		$("#go").click(function(){
		
		location.href = "listPageS?page=${cri.page}";
		
	})
})




</script>

<!-- 댓글 -->



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
							<input type="hidden" id="bno" value="${boardVo.bno }">
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
					
					<div class = "form-group">
					<label>Image Files</label>
					
					<div>
						<c:forEach var = "file" items= "${boardVo.files }">
							<img src = "${pageContext.request.contextPath }/upload/displayFile?filename=${file }">
						</c:forEach>					
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

<div id = "modifyModal" class = "modal modal-primary fade" role = "dialog">

	<div class = "modal-dialog">
		<div class = "modal-content">
			<div class = "modal-header">
				<button type = "button" class = "close" data-dismiss = "modal">&times;</button>
				<h4 class = "modal-title">rno 번호</h4>			
			</div>
			<div class = "modal-body">			
				<p>
					<input type = "text" id = "replytext" class = "form-control">				
				</p>		
			</div>		
			<div class = "modal-footer">
				<button type = "button" class = "btn btn-info" id = "btnModSave">Modify</button>
				<button type = "button" class = "btn default" data-dismiss = "modal">Modify</button>			
			</div>
		
		</div>
	
	</div>

</div>


<div class = "row">
	<div class = "col-xs-12">
		<div class = "box-header">
			<h3 class = "box-title">Add New Reply</h3>
		</div>
		
		<div class = "box-body">
			<label>Writer</label>
			<input type = "text" class = "form-control" id = "newReplyer">
			<label>Reply Text</label>
			<input type = "text" class = "form-control" id = "newReplyerText">
		</div>
		
		<div class = "box-footer">
			<button class = "btn btn-primary" id = "btnAddReply">Add Reply</button>
		</div>
		
	</div>
</div>

<ul class = "timeline"> 
	<li class= "time-label" id = "repliesDiv"><span class = "bg-green">Replies List <span id = "reply">[${board.replycnt }]</span></span></li>
</ul>

</section>

<script id = "template" type = "text/x-handlebars-template">

{{#list}}

<li class = "replyLi" data-rno = "{{rno}}">
<i class = "fa fa-comments bg-blue"></i>
<div class = "timeline-item">
	<span class = "time">
		<i class = "fa fa-clock-o"></i>{{prettifyData regdate}}
	</span>
	
	<h3 class = "timeline-header"><strong>{{rno}}</strong> - {{replyer}}</h3>
	<div class = "timeline-body">{{replytext}}</div>
	<div class = "timeline-footer">
		<a class = "btn btn-primary btn-xs updatebtn" data-toggle="modal" data-target="#modifyModal">modify</a>

		<a class = "btn btn-danger btn-xs" id = "delete">delete</a>
	</div>
	
</div>
</li>

{{/list}}

</script>

<div class = "text-center">
	<ul id = "pagination" class = "pagination pagination-sm no-margin"></ul>

</div>


<script>

var nPage = 1;

Handlebars.registerHelper("prettifyData",function(value){
	var date= new Date(value);
	var year = date.getFullYear();
	var month = date.getMonth();
	var d = date.getDate();
	
	return year+ "/" + month+ "/"+d;
	
	
})



$("#repliesDiv").click(function(){
	getPageList(nPage);	
	
})
function getPageList(page){
	$.ajax({
		url: "${pageContext.request.contextPath}/replies/${boardVo.bno}/"+page,
		type:"get",
		dataType:"json",
		success:function(res){
			console.log(res);
			
			$(".replyLi").remove();
			
			var source = $("#template").html();
			var func = Handlebars.compile(source);
			var str = func(res);
			$(".timeline").append(str);
			
			$("ul.pagination").empty();
			
			for(var i = res.pageMaker.startPage; i <= res.pageMaker.endPage; i++){					
				var $li= $("<li>");
				if( i == page){
					$li.addClass("active");
				}
			
				$("#reply").text(res.pageMaker.totalCount);  // 댓글 삭제하면 카운트 변화  
				
				var $a = $("<a>").attr("data-page",i).attr("href","#").text(i);
				$li.append($a);
				
				$("ul.pagination").append($li);
			}
			
			if(res.pageMaker.next == true){
				var $li= $("<li>");
				var $a = $("<a>").attr("data-page",res.pageMaker.endPage).attr("href","#").text(">>");
				$li.append($a);
				
				$("ul.pagination").append($li);
			}
	
		},			
		error:function(e){
			console.log(e);
		}		
	})				
		}
		$("#repliesDiv").click(function(){
					
			getPageList(nPage);		
			
		})

		$(document).on("click", ".updatebtn", function() {
			var rno = $(this).parents(".timeline-item").find(".timeline-header strong").text();
			var replytext = $(this).parents(".timeline-item").find(".timeline-body").text();
			
			$(".modal-title").text(rno);
			$("#replytext").val(replytext);
			
		})
		

		$(document).on("click","ul.pagination a", function(){
			var page = $(this).attr("data-page");
			
			getPageList(page);
		})
		
		
		$(document).on("click","#delete", function(){
			var rno = $(this).parents(".timeline-item").find(".timeline-header strong").text();
			
			
			$.ajax({
				url: "${pageContext.request.contextPath}/replies/"+ rno,
				type: "delete",
				dataType: "text",
				success:function(res){
					getPageList(nPage);
					
					
					
					
				}

			})
			
		})
		
		$(document).on("click","#btnModSave", function(){
			var rno= $(this).parents(".modal-content").find(".modal-title").text();
			var replytext = $("#replytext").val();
			
			var data = JSON.stringify({
				replytext:replytext
			});
			
			$.ajax({
				url: "${pageContext.request.contextPath}/replies/" + rno,
				type: "put",
				data: data,
				headers:{"Content-Type":"application/json"},
				dataType: "text",
				success:function(res){
					console.log(res);
					
					if(res == "success") {
						alert("수정하였습니다.");
						getPageList(nPage);
					}
				},
				error:function(e){
				
				}
			})
			
		})
		
	
		$("#btnAddReply").click(function(){
			var bno = $("#bno").val();
			var newReplyer = $("#newReplyer").val();
			var newReplyerText = $("#newReplyerText").val();			

			var data = JSON.stringify({
				bno:bno,
				replyer:newReplyer,
				replytext:newReplyerText
				});
			
			$.ajax({			
				url: "${pageContext.request.contextPath}/replies/",
				type: "post",
				data: data,
				headers:{"Content-Type":"application/json"},
				dataType: "text",
				success:function(res){		
					console.log(res);
					getPageList(nPage);
				},
				error:function(e){
					console.log(e);
				}
				
			})
			
			
		})
		

		
		

</script>




<%@ include file = "../include/footer.jsp" %>