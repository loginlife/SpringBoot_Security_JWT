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
<h2>用户列表</h2>


<p>
	<div>
		Token（<a href="javascript:void(0)" id="deleteToken">删除</a>）:
	</div>
	<div id="token"></div>
</p>
<p id="message"></p>

<p>
	<table border="1" cellpadding="5">
		<thead>
			<tr>
				<th>ID</th>
				<th>USERNAME</th>
				<th>PASSWORD</th>
				<th>RULE</th>
			</tr>
		</thead>
		<tbody id="tbody"></tbody>
	</table>
</p>

<script type="text/javascript">
	$(function(){
		var token = $.cookie('authorization');
		$("#token").text(token);

		// 移除Token
		$("#deleteToken").click(function(){
			$.cookie('authorization', "");
			$("#token").text($.cookie('authorization'));
			alert("成功从Cookie移除Token")
		});

		// 加载用户列表
		$.ajax({
			// 传递Token到服务端
			headers: {
				authorization : token
			},
			type: "POST",
			url: "${basePath}/secure/user/list",
			contentType : "application/json",
			dataType : "json",
			success: function(result){
				console.debug(result);
				if ( result.status == "0" ) {
					var htmlCode = [], datas = result.data;
					for (var i = 0, len = datas.length; i < len; i++ ) {
						var t = datas[i];
						htmlCode.push('<tr>');
						htmlCode.push('<td>' + t.id + '</td>');
						htmlCode.push('<td>' + t.username + '</td>');
						htmlCode.push('<td>' + t.password + '</td>');
						htmlCode.push('<td>' + (t.roles||[]).join(",") + '</td>');
						htmlCode.push('</tr>');
					}
					$("#tbody").html(htmlCode.join(""))
				} else {
					$("#message").text(result.errorMsg).addClass("error");
				}
			}
		});
	});
</script>
</body>
</html>