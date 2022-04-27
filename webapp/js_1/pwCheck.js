var pwOrgin = document.getElementById('pw');
var pwCheck = document.getElementById('pwCheck');

pwCheck.onkeyup = function pwChecking() {
	console.log(this.value);
	
	//재확인 비밀번호와 처음 비밀번호의 입력이 같으면
	if (pwOrgin.value!=null && this.value == pwOrgin.value) {
		$("#checkPw").html('일치');
        $("#checkPw").attr('color','green');
		this.style.background = "palegreen";
	} else {
		
		$("#checkPw").html('비밀번호가 일치하지 않습니다.');
		$("#checkPw").attr('color','red');
		this.style.background = "lightsalmon";
	}
}
