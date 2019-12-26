<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>

<section class="content">
	<div class="row">
		<div class="col-sm-12">
			<div class="box box-primary">
				<div class="box-header">
					<h3 class="box-title">READ BOARD</h3>
				</div>
			
				<div class="box-body">
					<div class="form-group">
						<label>Title</label>
						<input type="text" name="title" class="form-control" 
						placeholder="Enter Title" value="${boardVO.title }" readonly="readonly">
					</div>
					<div class="form-group">
						<label>Content</label>
						<textarea rows="5" cols="50" class="form-control" name="content" 
						 placeholder="Enter Content" readonly="readonly" >${boardVO.content }</textarea>
					</div>
					<div class="form-group">
						<label>Writer</label>
						<input type="text" name="writer" class="form-control" 
						placeholder="Enter Title" value="${boardVO.writer }" readonly="readonly">
					</div>
				</div><!-- box-body -->
				<div class="box-footer">
					<div class="btn btn-warning" id="btnModify">Modify</div>
					<div class="btn btn-danger" id="btnRemove">Remove</div>
					<div class="btn btn-primary" id="btnList">Go List</div>
				</div>					
			</div>
		</div>
	</div>
</section>

<script>
	$("#btnModify").click(function(){
		location.href = "modifyPageSS?bno=${boardVO.bno}&page=${cri.page}&searchType=${cri.searchType}&keyword=${cri.keyword}" ;
	})
	
	$("#btnRemove").click(function(){
		var res = confirm("정말 삭제하시겠습니까?");
		if(res == true){
			location.href = "removePageS?bno=${boardVO.bno}&page=${cri.page}&searchType=${cri.searchType}&keyword=${cri.keyword}";
		}		
	})
	
	$("#btnList").click(function(){
		location.href = "listPageS?page=${cri.page}&searchType=${cri.searchType}&keyword=${cri.keyword}";
	})
</script>

<%@ include file="../include/footer.jsp"%>