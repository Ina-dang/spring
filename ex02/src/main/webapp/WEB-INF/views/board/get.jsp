<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<jsp:include page="../common/head.jsp"/>
</head>
<body id="page-top">
    <!-- Page Wrapper -->
    <div id="wrapper">
        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">
            <!-- Main Content -->
            <div id="content">
				<jsp:include page="../common/nav.jsp"/>
                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <h1 class="h3 text-gray-800 mb-4">Board Register Page</h1>

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary float-left">상세보기</h6>       
                        </div>
                        <div class="card-body">
							<form method="post">
								<div class="form-group">
									<label for="title">title</label>
									<input type="text" class="form-control" placeholder="title" id="title" name="title" value="${board.title}" readonly>
								</div>
								<div class="form-group">
									<label for="content">content</label>
									<textarea class="form-control" placeholder="content" id="content" name="content" readonly>${board.content}</textarea>
								</div>
								<div class="form-group">
									<label for="writer">writer</label>
									<input type="text" class="form-control" placeholder="writer" id="writer" name="writer" value="${board.writer}" readonly>
								</div>
								<input type="hidden" name="bno" value="${board.bno}">
								<input type="hidden" name="pageNum" value="${cri.pageNum}">
								<input type="hidden" name="amount" value="${cri.amount}">
								<input type="hidden" name="type" value="${cri.type}">
								<input type="hidden" name="keyword" value="${cri.keyword}">
								<a class="btn btn-warning btn-sm" href="modify${cri.params}&bno=${board.bno}">수정</a>
								<a class="btn btn-secondary btn-sm" href="list${cri.params}">목록</a>
							</form>
                        </div>
                    </div>
					<!-- 본문끝 -->
					<!-- 댓글 -->
					<div class="card shadow mb-4">
						<div class="card-header py-3">
							<h6 class="m-0 font-weight-bold text-primary float-left">댓글</h6>       
						</div>
						<!-- 댓글작성 -->						
						<div class="input-group p-3" >
							<textarea class="form-control" style='resize:none' placeholder="댓글을 입력해주세요"></textarea>
							<div class="input-group-append">
								<button type="button" class="btn btn-primary">작성</button>
							</div>
						</div>
						<div class="card-body list-group p-3 chat">
							<div class="list-group-item p-0 bg-secondary text-white p-3">
								<strong>작성자</strong>
								<small class="float-right">게시일</small>
							</div>
							<p class="p-3 list-group-item mb-0">글내용</p>
							<div class="list-group-item p-0 bg-secondary text-white p-3">
								<strong>작성자</strong>
								<small class="float-right">게시일</small>
							</div>
							<p class="p-3 list-group-item mb-0">글내용</p>
							<div class="list-group-item p-0 bg-secondary text-white p-3">
								<strong>작성자</strong>
								<small class="float-right">게시일</small>
							</div>
							<p class="p-3 list-group-item mb-0">글내용</p>
						</div>
					</div>
				</div>
            <!-- 댓글끝 -->
            </div>
            <!-- End of Main Content -->
 			<jsp:include page="../common/footer.jsp"/> 
 			<script src="/resources/js/reply.js"></script>
 			<script type="text/javascript">
 				var bno = '${board.bno}'
 				console.log(replyService);
 				
 				$(function(){
 					function showList(lastRno, amount){
						var param = {bno: bno, lastRno: lastRno, amount: amount}
 		 				replyService.getList(param, function(result){
	 					console.log(result);
						var str = '';
						 for(var i in result){
							str += '<div class="list-group-item p-0 bg-secondary text-white p-3" data-rno="' + result[i].rno + '">';
							str += '	<strong>' + result[i].replyer + '</strong>';
							str += '	<small class="float-right">' + replyService.displayTime(result[i].replyDate) + '</small>';
							str += '</div>';
							str += '<p class="p-3 list-group-item mb-0">' + result[i].reply + '</p>';
						}
						// console.log(str);
						$(".chat").html(str);
 		 				})
 					}
					showList();
 				});
 				
 				
 				//replyService.add();
 						//성공함수, 실패함수
 				//reply, callback, error
 				
 				// 글 등록
 				/* replyService.add({bno:bno, reply:"get.jsp 작성 테스트", replyer:"작성자"}, function(result){
 					alert("글 등록 성공");
 					console.log(result);
 				}); */	
 						
 				 // 글 삭제
/*   				 replyService.remove(8, function(result){
 					 alert("글 삭제 성공");
 					 console.log(result);
 				 })  */
 				 
 				 // 글 조회
/*   				 replyService.get(5, function(result){
 					 alert("조회");
					 console.log(result);
 				 })  */
 				 
 				 //글 수정
/*  				 replyService.update({rno:5, reply:"get.jsp 수정 테스트"}, function(result){
 					alert("글 수정 성공");
 					console.log(result);
 				}); */
 			</script>
    	</div>
    	<!-- End of Content Wrapper -->
	</div>
	<!-- End of Page Wrapper -->
	<script>

	</script>
	
</body>

</html>