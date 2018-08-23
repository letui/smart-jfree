<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="jquery-1.4.4.min.js"></script>
<script type="text/javascript" >
function update(flag){
	var _url="TestAction";
	if(flag){
		_url=_url+"?reverse=true";
	}
	$.ajax({
		type:"post",
		url:_url,
		data:{reqType:"ajax"},
		success:function(html){
			$("#imageChart").attr("src",html);
		}
	});
}
</script>
</head>
<body>
<img id="imageChart" src="${imageURL}"/>
<br/>

<input type="button" value="not reverse" onclick="update(false)">
<input type="button" value="reverse" onclick="update(true)">
</body>
</html>