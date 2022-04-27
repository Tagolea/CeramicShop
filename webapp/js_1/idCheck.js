/**
 * https://cobook.tistory.com/8
 */
 
 //버튼을 누를때마다 유효성검사 실행
 $('#input_uuid').focusout(function(){
		
		let userId = $('#input_uuid').val(); // input_id에 입력되는 값
		
		console.log(userId);
		
		//ajax를 통해 서블릿으로 값 전송!
		$.ajax({
			url : "idCheck.do", //보낼 주소
			type : "post", //포스트 방식으로
			data : {userId: userId}, //userId라는 이름에 사용자의 입력값을 담음
			dataType : 'json',
			//보내는데에 성공하면, 서블릿에서 result를 받아옴
			success : function(result){ 
				if(result == 1){ //1이면 사용 불가
					$("#checkID").html('중복된 ID');
					$("#checkID").attr('color','red');
				} else{ //0이면 사용 가능
					$("#checkID").html('사용가능');
					$("#checkID").attr('color','green');
				} 
			},
			error : function(){
				alert("서버요청실패 : 관리자에게 문의");
			}
		})
		 
	})
