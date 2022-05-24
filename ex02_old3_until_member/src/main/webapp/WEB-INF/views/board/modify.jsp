<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<
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
                            <h6 class="m-0 font-weight-bold text-primary float-left">Modify</h6>
                        </div>
                        <div class="card-body">
							<form method="post">
								<div class="form-group">
									<label for="title">title</label>
									<input type="text" class="form-control" placeholder="title" id="title" name="title" value="${board.title}">
								</div>
								<div class="form-group">
									<label for="content">content</label>
									<textarea class="form-control" placeholder="content" id="content" name="content">${board.content }</textarea>
								</div>
								<div class="form-group">
									<label for="writer">writer</label>
									<input type="text" class="form-control" id="writer" name="writer" required value="${board.writer}" readonly>
								</div>
								<input type="hidden" name="bno" value="${board.bno}">
								<input type="hidden" name="pageNum" value="${cri.pageNum}">
								<input type="hidden" name="amount" value="${cri.amount}">
								<input type="hidden" name="type" value="${cri.type}">
								<input type="hidden" name="keyword" value="${cri.keyword}">
								<hr>
								<sec:authorize access="isAuthenticated() && principal.username == #board.writer">
								<button type="submit" class="btn btn-secondary btn-sm" formaction="modify">수정</button>
								<button type="submit" class="btn btn-danger btn-sm" formaction="remove">삭제</button>
								<sec:csrfInput/>
								</sec:authorize>
								<a class="btn btn-secondary btn-sm" href="list${cri.params}">취소</a>
							</form>
                        </div>
                    </div>
                </div>
                <!-- /.container-fluid -->
            </div>
            <!-- End of Main Content -->
 			<jsp:include page="../common/footer.jsp"/> 
    	</div>
    	<!-- End of Content Wrapper -->
	</div>
	<!-- End of Page Wrapper -->
	<script>

	</script>
	
</body>

</html>