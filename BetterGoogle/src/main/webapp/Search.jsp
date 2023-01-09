<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Better Google</title>
<style type="text/css">
.button{
	position:absolute;
	width:45px;
	height:25px;
	font-size:15px;
	left:50%;
	top:50%;
}
.border-style {
	border-radius:75px/90px;
}
#padding{
	padding: 0px 0px 0px 15px;
}
.note{
	position:absolute;
	width:50px;
	height:50px;
	animation-timing-function: ease-in-out;
	animation-direction: alternate;
	animation-name:note;
	animation-duration:5s;
	animation-iteration-count:infinite;
	
}
@keyframes note{
	0%{
		
		left:640px;		
		top:0px;
		
	}
	25%{
		left:700px;
		top:60px;
		
	}
	50%{
		left:760px;
		top:0px;
	}
	75%{
		left:700px;
		top:-60px;
	}
	100%{
		left:640px;
		top:0px;
	}
}
.note1{
	position:absolute;
	width:50px;
	height:50px;
	animation-direction: alternate;
	animation-timing-function: ease-in-out;
	animation-name:note1;
	animation-duration:5s;
	animation-iteration-count:infinite;
}
@keyframes note1{
	0%{
		left:760px;		
		top:0px;
		
	}
	25%{
		left:700px;
		top:-60px;
	}
	50%{
		left:640px;
		top:0px;
	}
	75%{
		left:700px;
		top:60px;
	}
	100%{
		left:760px;
		top:0px;
		
	}
}
.note2{
	position:absolute;
	width:50px;
	height:50px;
	animation-direction: alternate;
	animation-timing-function: ease-in-out;
	animation-name:note2;
	animation-duration:5s;
	animation-iteration-count:infinite;
}
@keyframes note2{
	0%{
		left:700px;		
		top:-60px;		
	}
	25%{
		left:640px;
		top:0px;
	}
	50%{
		left:700px;
		top:60px;
	}
	75%{
		left:760px;
		top:0px;
	}
	100%{
		left:700px;
		top:-60px;
		
	}
}
.note3{
	position:absolute;
	width:50px;
	height:50px;
	animation-direction: alternate;
	animation-timing-function: ease-in-out;
	animation-name:note3;
	animation-duration:5s;
	animation-iteration-count:infinite;
}
@keyframes note3{
	0%{
		left:700px;		
		top:60px;		
	}
	25%{
		left:760px;
		top:0px;
	}
	50%{
		left:700px;
		top:-60px;
	}
	75%{
		left:640px;
		top:0px;
	}
	100%{
		left:700px;
		top:60px;
		
	}
}
.box{
  position:relative;
}
.box:before{
  content:'';
  position:absolute;
  z-index:2;
  top:60px;
  left:50px;
  width:50px;
  height:50px;
  
  border-radius:2px;
  transform: rotate(45deg);
  -webkit-animation:box 1.25s infinite ; 
}
@-webkit-keyframes box{
  0%{
    top:50px;
  }
  20%{
    border-radius:2px;  
  }
  50%{
    top:80px; 
    border-bottom-right-radius:25px;
  }
  80%{
    border-radius:2px; 
  }
  100%{
    top:50px;
  }
}
.box:after{
  content:'';
  position:absolute;
  z-index:1;
  top:128px;
  left:52px;
  width:44px;
  height:3px;
  background:#eaeaea;
  border-radius:100%;
  -webkit-animation:shadow 1.25s infinite ; 
}
@-webkit-keyframes shadow{
  0%,100%{
    left:54px;
    width:40px;
    background:#eaeaea;
  }
  50%{
    top:126px;
    left:50px;   
    width:50px;
    height:7px;
    background:#eee;
  }
}
</style>
</head>
<img src="https://img.1ppt.com/uploads/allimg/1801/1_180119093001_1.JPG" style='position:fixed;width:1300px;left:0%;top:0%;margin-top:0px;margin-left:0px '>

<form action='${requestUri}' method='get'>
<div>
<input type='text' name='searchNum' value='10' style='color:#F1F2E4;border-style:none;background-color:#F1F2E4'>
</div>
<div>
<img src="https://cdn-icons-png.flaticon.com/512/2112/2112088.png" 
style='position:absolute;width:360px;height:162px;left:49.5%;top:59%;margin-top:-265px;margin-left:-175px '>
</a>
</div>
<h1 style="position:absolute;width:350px;height:150px;left:51%;top:86%;margin-top:-265px;margin-left:-175px;
font-size:300%;font-family:'Georgia';color:#2D2926;">Better Google</h1>
<div>
<input type='text' class="border-style" id="padding"  
style='font-size:120%;position:absolute;left:50%;top:62%;
margin-top:-47px;margin-left:-400px;width:800px;height:45px' name='keyword' placeholder='搜尋Better Google或輸入關鍵字'
 " onblur="placeholder='搜尋Better Google或輸入關鍵字'" />
</div>
<div>
<input type='image' src="images/loupe-2.png" 
style='position:absolute;width:27px;height:27px;left:50%;top:64%;margin-top:-47px;
margin-left:368px '/>
</div>
<img src="https://media.giphy.com/media/ZZIeHmjtrWRCyvqH3z/giphy.gif" 
style='position:absolute;width:130px;height:130px;left:12%;top:75%;margin-top:-47px;
margin-left:368px'/>
<h3 style="position:absolute;left:64%;top:130%;margin-top:-265px;margin-left:-175px;
font-size:100%;font-family:'Georgia';color:#2D2926;"></h3>
<%/**if(keyword!=""){
	<div>
	<h5 style='position:absolute;width:205px;height:135px;left:12%;top:75%;margin-top:-47px;margin-left:368px;
	color:#F1F2E4;background-color:#F1F2E4;'></h5></div>
	}else{
	<div style="display:none">
	<h5 style='position:absolute;width:205px;height:135px;left:12%;top:75%;margin-top:-47px;margin-left:368px;
	color:#F1F2E4;background-color:#F1F2E4;'> s</h5></div>**/%>
</form>
</body>
</html>