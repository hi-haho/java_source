window.onload=()=>{
	
}

function zipCheck(){ //우편 번호 찾기 버튼
	let url = "zipcheck.jsp?check=y" //찾는 화(y) or 결과화면(n)
	window.open(url,"post","toolbar=no,width=550,height=300,top=300,left=300,status=yes,scrollbars=yes,menubar=no");
	
}

function idCheck(){ //id 중복하기 버튼
	if(regForm.id.value === ""){
		regForm.id.focus();
		alert('아이디를 입력하세요');
		return;
	}else{
		url = "idcheck.jsp?id="+regForm.id.value;
		window.open(url,"id","toolbar=no,width=300,height=150,top=300,left=100,status=yes,scrollbars=yes,menubar=no")
	}
}

function inputCheck(){ //회원가입 버튼
	if(regForm.zipcode.value === ""){
		regForm.zipcode.focus();
		alert('우편번호를 입력하세요');
		return;
	}
	if(regForm.name.value === ""){
		regForm.name.focus();
		alert('이름을 입력하세요');
		return;
	}
	if(regForm.email.value === ""){
		regForm.email.focus();
		alert('이메일을 입력하세요');
		return;
	}
	if(regForm.phone.value === ""){
		regForm.phone.focus();
		alert('전화번호를 입력하세요');
		return;
	}
	regForm.submit();
}

function funcLogin(){
	//alert('a');
	if(loginForm.id.value === ""){
		loginForm.id.focus();
		alert('아이디를 입력하세요');
		return;
	}else if(loginForm.passwd.value === ""){
		loginForm.passwd.focus();
		alert('비밀번호를 입력하세요');
		return;
	}else{
		loginForm.action="loginproc.jsp";
		loginForm.method="post";
		loginForm.submit();
	}
}


function funcNewMember(){
	//alert('b');
	location.href="register.jsp";
}


//----------------------------------

//쇼핑몰 로그인 후 자신의 정보 수정 시 사용
function memberUpdateOk(){ 
	//입력자료 오류검사 생략
	document.updateForm.submit();
}
function memberUpdateCancel(){
	location.href="../guest/guest_index.jsp";
}
function memberDelete(){
	alert("회원탈퇴는 곧 죽음!!!");
}

//관리자 관련 
function funcAdminLogin(){
	if(adminLoginform.adminid.value === ""){
		alert("id 를 입력하시오");
		adminLoginform.adminid.focus();
		return;
	}
	if(adminLoginform.adminpasswd.value === ""){
		alert("password를 입력하시오");
		adminLoginform.adminpasswd.focus();
		return;
	}
	adminLoginform.submit();
}
function funcAdminHome(){
	location.href = "../guest/guest_index.jsp";
}

//관리자 입장에서 각 회원 수정
function memUpdate(id) {
	//alert(id);
	document.updateFrm.id.value = id;
	document.updateFrm.submit();
}

function memberUpdateAdmin(){
	document.updateFormAdmin.submit();
}
function memberUpdateCancelAdmin(){
	location.href = "membermanager.jsp";
}

//관리자에서 상품처리
function productDetail(no){
	document.detailForm.no.value = no;
	document.detailForm.submit();
}
function productUpdate(no){
	if(confirm("정말 수정할까요?")){
		document.updateForm.no.value = no;
		document.updateForm.submit();
	}
}
function productDelete(no){
	if(confirm("정말 삭제할까요?")){
		document.delForm.no.value = no;
		document.delForm.submit();		
	}
}

//사용자에서 상품 처리
function productDetail_guest(no){ 
	document.detailFrm.no.value = no;
	document.detailFrm.submit();
}

//카트 처리용
function cartUpdate(form){
	form.flag.value = "update";
	form.submit();
}
function cartDelete(form){
	form.flag.value = "del";
	form.submit();
}

//관리자에서 주문 처리
function orderDetail(no){
	document.detailFrm.no.value = no;
	document.detailFrm.submit();
}

function orderUpdate(form){
	document.detailFrm.flag.value = "update";
	form.submit();
}

function orderDelete(form){
	document.detailFrm.flag.value = "delete";
	form.submit();
}






