<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
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
                    <h1 class="h3 text-gray-800 mb-4">글 작성</h1>

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary float-left">작성페이지</h6>
                            <a class="btn btn-primary btn-sm float-right" href="register${page.cri.params}">글작성</a>
                        </div>
                        <div class="card-body">
							<form method="post">
								<div class="form-group">
									<label for="title">title</label>
									<input type="text" class="form-control" placeholder="title" id="title" name="title">
								</div>
								<div class="form-group">
									<label for="content">content</label>
									<textarea class="form-control" placeholder="content" id="content" name="content"></textarea>
								</div>
								<div class="form-group">
									<label for="writer">writer</label>
									<input type="text" class="form-control" id="writer" name="writer" readonly value='<sec:authentication property="principal.username"/>'>
								</div>
								<sec:csrfInput/>
								<div class="form-group">
									<label for="attach" class="btn btn-success btn-sm">attach</label>
									<input type="file" class="form-control d-none" placeholder="attach" id="attach" name="attach" multiple>
									<div>
										
									</div>
								</div>

								<button type="submit" class="btn btn-primary ">Submit</button>
							</form>
                        </div>
                    </div>
                </div>
                <!-- /.container-fluid -->
            </div>
            <!-- End of Main Content -->
 			<jsp:include page="../common/footer.jsp"/>
			<script>
			$(function(){
				$("#attach").change(function(){
					var str = "";
					$(this.files).each(function(){
						str += "<p>" + this.name + "</p>";
					})
					$(this).next().html(str);
				});
			})
			</script> 
    	</div>
    	<!-- End of Content Wrapper -->
	</div>
	<!-- End of Page Wrapper -->

	
</body>

</html>