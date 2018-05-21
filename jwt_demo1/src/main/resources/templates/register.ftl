<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Spring Boot Security JWT</title>
	<link type="text/css" rel="stylesheet" href="${basePath}/css/public.css">
	<script type="text/javascript" src="${basePath}/jquery2.1.1/jquery-2.1.1.js"></script>
</head>
<body>

<h1>
	<a href="${basePath}">Spring Boot Security JWT</a>
</h1>
<hr>
<h2>注册</h2>


<p>
	帐号：<input type="text" id="username" value="Helen"/>
</p>
<p>
	密码：<input type="password" id="password" value="aaaaaa"/>
</p>
<p>
	<button type="submit" id="submit">注册</button>
</p>
<p id="message"></p>


<script type="text/javascript">
	$(function(){
		$("#submit").click(function () {
			$.ajax({
				type: "POST",
				url: "${basePath}/register",
				data: JSON.stringify({
					username : $("#username").val(),
					password : $("#password").val()
				}),
				contentType : "application/json",
				dataType : "json",
				success: function(result){
					console.debug(result);
					if (result.status == "0") {
						$("#message").text("注册用户成功！")
								.removeClass("error").addClass("success");
					} else {
						$("#message").text(result.errorMsg)
								.removeClass("success").addClass("error");
					}
				}
			});
		});
	});
</script>
</body>
</html>

