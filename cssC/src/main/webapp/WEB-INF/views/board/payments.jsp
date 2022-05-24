<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>2022. 4. 29.오후 5:43:41</title>
<jsp:include page="../common/head.jsp"/>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<!-- 아래 제이쿼리는 1.0이상이면 원하는 버전을 사용하셔도 무방합니다. -->
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
</head>
<body>
<div id="wrapper">
   	<jsp:include page="../common/nav.jsp"/>
	<div class="container-fluid" >
	    <div class="row justify-content-center">
	        <div class="col-12 col-lg-11" id="payments-box">
	            <div class="card card0 rounded-0">
	                <div class="row">
	                    <div class="col-md-5 d-md-block d-none p-0 box">
	                        <div class="card rounded-0 border-0 card1" id="bill">
	                            <h3 id="heading1">Payment Summary</h3>
	                            <div class="row">
	                                <div class="col-lg-7 col-8 mt-4 line pl-4">
	                                    <h2 class="bill-head">Electronics</h2> <small class="bill-date">2017 Feb 10 at 10:30 PM</small>
	                                </div>
	                                <div class="col-lg-5 col-4 mt-4">
	                                    <h2 class="bill-head px-xl-5 px-lg-4">CAF</h2>
	                                </div>
	                            </div>
	                            <div class="row">
	                                <div class="col-lg-7 col-8 mt-4 line pl-4">
	                                    <h2 class="bill-head">Food</h2> <small class="bill-date">2017 Feb 25 at 11:30 PM</small>
	                                </div>
	                                <div class="col-lg-5 col-4 mt-4">
	                                    <h2 class="bill-head px-xl-5 px-lg-4">JFK</h2>
	                                </div>
	                            </div>
	                            <div class="row">
	                                <div class="col-lg-7 col-8 mt-4 line pl-4">
	                                    <h2 class="bill-head">Grocery</h2> <small class="bill-date">2017 Mar 17 at 10:45 PM</small><br> <small class="bill-date">2017 Mar 18 at 11:45 PM</small>
	                                </div>
	                                <div class="col-lg-5 col-4 mt-4">
	                                    <h2 class="bill-head px-xl-5 px-lg-4">LHR</h2>
	                                </div>
	                            </div>
	                            <div class="row">
	                                <div class="col-lg-7 col-8 mt-4 line pl-4">
	                                    <h2 class="bill-head">Accessories</h2> <small class="bill-date">2017 Apr 13 at 05:30 PM</small>
	                                </div>
	                                <div class="col-lg-5 col-4 mt-4">
	                                    <h2 class="bill-head px-xl-5 px-lg-4">JFK</h2>
	                                </div>
	                            </div>
	                            <div class="row">
	                                <div class="col-md-12 red-bg">
	                                    <p class="bill-date" id="total-label">Total Price</p>
	                                    <h2 class="bill-head" id="total">$ 523.65</h2> <small class="bill-date" id="total-label">Price includes all taxes</small>
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	                    <div class="col-md-7 col-sm-12 p-0 box">
	                        <div class="card rounded-0 border-0 card2" id="paypage">
	                            <div class="form-card">
	                                <h2 id="heading2" class="text-danger">Payment Method</h2>
	                                <div class="radio-group">
	                                    <div class='radio' data-value="credit"><img src="https://i.imgur.com/28akQFX.jpg" width="200px" height="60px"></div>
	                                    <div class='radio' data-value="paypal"><img src="https://i.imgur.com/5QFsx7K.jpg" width="200px" height="60px"></div> <br>
	                                </div> <label class="pay">Name on Card</label> <input type="text" name="holdername" placeholder="John Smith">
	                                <div class="row">
	                                    <div class="col-8 col-md-6"> <label class="pay">Card Number</label> <input type="text" name="cardno" id="cr_no" placeholder="0000-0000-0000-0000" minlength="19" maxlength="19"> </div>
	                                    <div class="col-4 col-md-6"> <label class="pay">CVV</label> <input type="password" name="cvcpwd" placeholder="&#9679;&#9679;&#9679;" minlength="3" maxlength="3"> </div>
	                                </div>
	                                <div class="row">
	                                    <div class="col-md-12"> <label class="pay">Expiration Date</label> </div>
	                                    <div class="col-md-12"> <input type="text" name="exp" id="exp" placeholder="MM/YY" minlength="5" maxlength="5"> </div>
	                                </div>
	                                <div class="row">
	                                    <div class="col-md-6"> <button class="btn placeicon" onclick="iamport()">결제하기</button> </div>
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	                </div>
	            </div>
	        </div>
	    </div>
	</div>
</div>
<jsp:include page="../common/footer.jsp"></jsp:include>
<script>
	var IMP = window.IMP; // 생략 가능
	//IMP.init("{imp23763120}"); // 예: imp00000000
	
	function iamport(){
		//가맹점 식별코드
		IMP.init('imp23763120');
		IMP.request_pay({
	        pg: "kakaopay",
	        pay_method: "card",
	        merchant_uid: "ORD20180131-0000011",
	        name: "노르웨이 회전 의자",
	        amount: 64900,
	        buyer_email: "gildong@gmail.com",
	        buyer_name: "홍길동",
	        buyer_tel: "010-4242-4242",
	        buyer_addr: "서울특별시 강남구 신사동",
	        buyer_postcode: "01181"
		}, function(rsp) {
			console.log(rsp);
			if ( rsp.success ) {
				var msg = '결제가 완료되었습니다.';
				msg += '고유ID : ' + rsp.imp_uid;
				msg += '상점 거래ID : ' + rsp.merchant_uid;
				msg += '결제 금액 : ' + rsp.paid_amount;
				msg += '카드 승인번호 : ' + rsp.apply_num;
			} else {
				var msg = '결제에 실패하였습니다.';
				msg += '에러내용 : ' + rsp.error_msg;
			}
		    alert(msg);
		});
	}
</script>
</body>
</html>