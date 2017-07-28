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
<fildset style="width:380px">
	<legend>번호:${vo.mnum}</legend>
<table border="0"width="350px">
	
    <tr>
		<td>이름</td>
		<td>${vo.mname}</td>
	</tr>
	<tr>
		<td>한줄메모</td>
		<td>${vo.mcontent}</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<a href='mUpdateForm.mo?mnum=${vo.mnum}'>[수정]</a>
			<a href='mDelete.mo?mnum=${vo.mnum}'>[삭제]</a>
			<a href='mList.mo'>[목록]</a>
		</td>
	</tr>


</table>
</fildset>
</body>
</html>