<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../include/header.jsp" %>


<section class = "content">
	<div class = "row">
		<div class = "col-sm-12">
			<div class = "box box-primary">
				<div class = "box-header">
					<h3 class = "box-title">LIST SEARCH PAGE</h3>
				</div>
			
				<div class = "box-body">
					<select id = "searchType">
						<option>-------</option>
						<option ${cri.searchType=='t'?'selected':'' }value = "t">Title</option>
						<option ${cri.searchType=='c'?'selected':'' }value = "c">Content</option>
						<option ${cri.searchType=='w'?'selected':'' }value = "w">Writer</option>
						<option ${cri.searchType=='tc'?'selected':'' }value = "tc">Title or Content</option>
						<option ${cri.searchType=='cw'?'selected':'' }value = "cw">Content or Writer</option>
						<option ${cri.searchType=='tcw'?'selected':'' }value = "tcw">Title or Content or Writer</option>
					</select>

					<input type = "text" id = "keyword" value = "${cri.keyword }">
					<button id  ="btnSearch">search</button>
					<button id  ="btnRegister">New Board</button>
				</div>
			
			
			
				<div class = "box-body">
					<table class = "table table-boarderd">
						
						<tr>
							<th style = "width=10px;">BNO</th>
							<th>Title</th>
							<th>Writer</th>
							<th>RegDate</th>
							<th style = "width = 40px;">ViewCnt</th>
						</tr>
						
						<c:forEach var = "board" items="${list }">
							<tr>
								<td>${board.bno }</td>
								<td><a href = "readPageS?bno=${board.bno }&page=${pageMaker.cri.page}">${board.title }</a>[${board.replycnt }]</td>
								<td>${board.writer }</td>
								<td>
								<fmt:formatDate value="${board.regdate }" pattern="yyyy-MM-dd HH:mm" />
										
								</td>
								<td><span class = "badge bg-red">${board.viewcnt }</span></td>
							</tr>
						
						</c:forEach>
						
					</table>		
				
				</div>
				<div class = "box-footer">
					<div class = "text-center">
	
						<ul class = "pagination">
							<c:if test = "${pageMaker.prev == true }">
							<li><a href = "listPageS?page=${pageMaker.startPage-1 }">&laquo;</a></li>
							</c:if>
							<c:forEach begin= "${pageMaker.startPage }" end= "${pageMaker.endPage }" var = "idx">
							
								<li ${idx == pageMaker.cri.page ?'class=active':'' }><a href = "listPageS?page=${idx }">${idx }</a></li>
							
							</c:forEach>
							<c:if test = "${pageMaker.next == true }">
							<li><a href = "listPageS?page=${pageMaker.endPage+1 }">	&raquo;</a></li>
							</c:if>
					
						</ul>
						
					</div>
				</div>
				
			
				
			</div>
			
		</div>
		
	</div>


</section>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<script>

$(function(){

	$("#btnSearch").click(function(){
		var type = $("#searchType").val();
		var keyword = $("#keyword").val();
		location.href = "listPage?searchType="+type+"&keyword="+keyword;
	})

	$("#btnRegister").click(function(){

		location.href = "registerS";
	})

	
	
	btnRegister
	
})


</script>





<%@ include file = "../include/footer.jsp" %>