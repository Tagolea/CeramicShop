function showLocation(event) {
	  //Current weather data API 사용

      //위도 경도 받기
	  var latitude = event.coords.latitude 
	  var longitude = event.coords.longitude

	  //API키 URL연결	  
	  let apiKey = ""
	  let weatherUrl = "https://api.openweathermap.org/data/2.5/weather?lat=" + latitude 
	                + "&lon=" + longitude 
	                + "&appid=" + apiKey; 
	  
	  //함수시작
	  let options = { method: 'GET' }
	  $.ajax(weatherUrl, options).then((response) => {
	      //console.log(response)
	    
	      //아이콘 
	      let icon = response.weather[0].icon
	      let iconUrl = "http://openweathermap.org/img/wn/" + icon + ".png"
	      let img = document.querySelector("#wicon")
	      img.src = iconUrl
	      
	      //날씨정보 출력
	      document.querySelector("#tempr").textContent = (Math.round(response.main.temp - 273)) + "°C" // 현재 온도
	      document.querySelector("#city").textContent = "("+response.name+")"; //도시 이름
	    
	    }).catch((error) => {
	      console.log(error)
	    })
	}

	function showError(event) {
	  alert("위치 정보를 얻을 수 없습니다.");
	}

	window.addEventListener('load', () => { 
	  if(window.navigator.geolocation) {
	     window.navigator.geolocation.getCurrentPosition(showLocation,showError)
	  }

	})
