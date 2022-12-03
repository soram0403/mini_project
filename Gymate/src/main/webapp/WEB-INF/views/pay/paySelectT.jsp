<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

<style>
body {
	background-color: #5f5f5f;
}

#payplan1, #payprice1, #update1 {
	display: none;
}

#imgg {
	opacity: 0.7;
	width: 100%;
	height: 400px;
	object-fit: cover;
	filter: brightness(20%);
}
</style>
</head>
<body>
	<div>
		<img id="imgg" alt="HTML" src="images/bg/bg-5.jpg">
	</div>
	<br>
	<br>
	<div align="center">
		<div class="card" style="width: 40rem;">
			<img src="..." class="card-img-top" alt="...">
			<div class="card-body">
				<h5 class="card-title">${vo1.productName }</h5>
			</div>
			<ul class="list-group list-group-flush">
				<li class="list-group-item" id="paynum">�ֹ���ȣ : ${vo.payNum }</li>
				<li class="list-group-item" id="payplan">������� : <c:if
						test="${vo.payPlan == 0}">���ݰ���</c:if> <c:if
						test="${vo.payPlan == 1}">ī�����</c:if></li>
				<li class="list-group-item" id="paycount"></li>
				<li class="list-group-item" id="payprice">�����ݾ� : ${vo.price }</li>
				<li class="list-group-item">���ų�¥ : ${vo.payDate }</li>
			</ul>
			<div class="card-body">
				<a href="#" onclick="location.href='paySelectListT.do'"
					class="card-link">���</a> <a href="#"
					onclick="deletePay('${vo.payNum}')" class="card-link">�Ǹ� ���</a>
			</div>
		</div>
	</div>
	<br>
	<br>


	<form id="frm1" action="payUpdate.do" method="POST">
		<input type="hidden" id="id1" name="id1"> <input type="hidden"
			id="pl1" name="pl1"> <input type="hidden" id="pr1" name="pr1">
	</form>

	<form id="frm" action="payDelete.do" method="POST">
		<input type="hidden" id="id" name="id">
	</form>

	<script type="text/javascript">
	let totalprice = parseInt(${vo.price });
	let price = parseInt(${vo1.price });
	let count = totalprice/price;
	document.getElementById("paycount").innerText = "���� : " + count;
	
		function deletePay(id) {
			document.getElementById("id").value = id;
			frm.submit();
		}
	</script>
</body>
</html>