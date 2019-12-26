<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../include/header.jsp" %>


<section class = "content">
	<div class = "row">
		<div class = "col-sm-12">
			<div class = "box box-primary">
				<div class = "box-header">
					<h3 class = "box-title">LIST ALL</h3>
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
								<td><a href = "read?bno=${board.bno }">${board.title }</a></td>
								<td>${board.writer }</td>
								<td>
								<fmt:formatDate value="${board.regdate }" pattern="yyyy-MM-dd HH:mm" />
						
								
								</td>
								<td><span class = "badge bg-red">${board.viewcnt }</span></td>
							</tr>
						
						</c:forEach>
						
						
					</table>
				
				</div>
			
				
			</div>
			
		</div>
		
	</div>
</section>





<%@ include file = "../include/footer.jsp" %>