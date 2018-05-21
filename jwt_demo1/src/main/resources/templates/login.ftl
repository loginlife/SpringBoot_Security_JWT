<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Spring Boot Security JWT</title>
	<link type="text/css" rel="stylesheet" href="${basePath}/css/public.css">
	<script type="text/javascript" src="${basePath}/jquery2.1.1/jquery-2.1.1.js"></script>
	<script type="text/javascript" src="${basePath}/jquery-cookie/jquery.cookie.js"></script>
</head>
<body>

<h1>
	<a href="${basePath}">Spring Boot Security JWT</a>
</h1>
<hr>
<h2>登录</h2>


<p>
	帐号：<input type="text" id="username" value="Helen"/>
</p>
<p>
	密码：<input type="password" id="password" value="aaaaaa"/>
</p>
<p>
	<button type="submit" id="submit">登录</button>
</p>
<p id="message"></p>


<script type="text/javascript">
	$(function(){
		$("#submit").click(function () {
			$.ajax({
				type: "POST",
				url: "${basePath}/login",
				data: JSON.stringify({
					username : $("#username").val(),
					password : $("#password").val()
				}),
				contentType : "application/json",
				dataType : "json",
				success: function(result){
					console.debug(result);
					if (result.status == "0") {
						// 创建Cookie
						$.cookie('authorization', 'Bearer ' + result.data);
						$("#message").text(result.data).css({color:"green"});
					} else {
						$("#message").text(result.errorMsg).css({color:"red"});
					}
				}
			});
		});
	});
</script>
</body>
</html>