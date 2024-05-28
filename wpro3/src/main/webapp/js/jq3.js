$(document).ready(function(){
	$('#id_err').hide();
	$('#age_err1').hide();
	$('#age_err2').hide();
	$('#pwd_err1').hide();
	$('#pwd_err2').hide();
	
	$('#btnsend').click(function(){
		//입력자료 오류 검사 후 server로 전송
		//id 검사
		let id = $('#userId').val(); //document.querySelector('#userId').value
		if(id.length < 2){
			$('#id_err').show();
			return false;
		}else{
			$('#id_err').hide();
		}
		
		//age 검사
		let age = $('#age').val();
		if(age.length < 1 ){
			$('#age_err1').show();
			return false;
		}else{
			$('#age_err1').hide();
		}
		/* 아스키코드 사용
		//age 숫자만 허용
		for(let i=0; i<age.length; i++){
			let data = age.charAt(i).charCodeAt(0); ///1글자 추출후 Asicll코드 출력
			if(data < 48 || ata > 57){ //48=0 보다 작으면 숫자 아님
				$('#age_err2').show();
				return false;
			}else{
				$('#age_err2').hide();
			}
		}
		*/
		/* 사용자 정의 함수 작성 후 호출
		if(isPositiveInteger_myfunc(age) || age<15 || age >100){
			$('#age_err2').show();
			return false;
		}else{
				$('#age_err2').hide();
		};
		*/
		
		//사용자정의 함수 ; 정규표현식
		if(!isValidAge_myfunc(age)){
			$('#age_err2').show();
			return false;
		}else{
				$('#age_err2').hide();
		};
		
		//비빌번호 검사
		let pwd1 = $('#pwd1').val();
		if(pwd1.length < 1){
			$('#pwd1').next().show(); //next() : newxt siblicng을 의미한다.
			return false;
		}else{
			$('#pwd1').next().hide();//next() : prev();
		}
		
		let pwd2 = $('#pwd2').val();
		if(pwd1 !== pwd2){
			$('#pwd_err2').show();
			return false;
		}else{
			$('#pwd_err2').hide();
		}
		//frm 태그에서 입력한 자료를 서버 특정 파일로 전송
		$("#signfrm").attr('action','jp3.jsp').attr('method','post').submit();
	});
	
});

function isPositiveInteger_myfunc(para){
	let num = Number(para);
	return Number.isInteger(num) && num > 0;
}

function isValidAge_myfunc(para){ //정규표현식 사용함수
	let ageRegex = /^(1[5-9]|[2-9][0-9]|100)$/;
	return ageRegex.test(para); //age가 정규표현식과 일치하는지 테스트한 값 반환
}

$(function() {
	//요소 추가
	const newEl = document.createElement("div");
	document.body.appendChild(newEl);
	//속성 id 추가
	newEl.id = "newdiv";
	newEl.className = "HI"
	//글 넣기
	//$('#newdiv').append('글자추가');
	//$('글자추가').appendTo('#newdiv');
	document.querySeletor("#newdiv").innerText = '짱구';
	//
})
