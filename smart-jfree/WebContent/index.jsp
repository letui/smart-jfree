<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="jquery-1.4.4.min.js"></script>
<script type="text/javascript" >
var reverse=false;
function update(bol){
	var _url="TestAction";
	if(bol){
		reverse=bol;
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
function updateItem(){
	var _url="TestAction";
	if(reverse){
		_url=_url+"?reverse=true&"+$("#configForm").serialize();
	}else{
		_url=_url+"?"+$("#configForm").serialize();
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
<form action="" id="configForm">
<% Map<String,String> itemMap=(Map<String,String>)request.getAttribute("itemMap");
 for(String key:itemMap.keySet()){%>
<input type="checkbox" name="index" value="<%=key %>" onclick="updateItem()"/><%=itemMap.get(key)%>
<%} %>
</form>

<input type="button" value="not reverse" onclick="update(false)">
<input type="button" value="reverse" onclick="update(true)">

${z}
</body>
</html>