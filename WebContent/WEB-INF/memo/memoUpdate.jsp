<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style type="text/css">
	body{
		font-size:12px;
	
	}
</style>
</head>
<body>
<fildset style="width:450px">
	<legend>번호:${vo.mnum}</legend>
	<form action="mUpdate.mo" method="post">
	<input type="hidden" name="mnum" value="${vo.mnum}"/>
<table border="0"width="350px">
	
    <tr>
		<td>이름</td>
		<td>${vo.mname}</td>
	</tr>
	<tr>
		<td>한줄메모</td>
		<td><input type="text" name="mcontent" value="${vo.mcontent}" size="60"}/></td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="수정"/>
			<input type="button" value="목록" onClick="location.href='mList.mo'"/>
		</td>
	</tr>


</table>
</form>
</fildset>
</body>
</html>