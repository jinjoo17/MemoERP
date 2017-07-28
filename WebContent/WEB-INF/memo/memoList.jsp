<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<fieldset style="width:400px">
	<label>MEMO LIST</label>
    <table border="0"width="350">
       <tr align="center">
       	<td width="100px">이름</td>
        <td>내용</td>
       </tr>
       <c:forEach var="vo" items="${list}">
       <tr>
       <td width="70px">${vo.mname}</td>
       <td><a href='mContent.mo?mnum=${vo.mnum}'>${vo.mcontent}</a></td>
           
       </tr>
       </c:forEach>
       <tr>
       	<td colspan="2" align="right">
       		<input type="button" value="글쓰기" onClick="location.href='mInsertForm.mo'"/>
       	
       	</td>
       </tr>
    </table>

</fieldset>

</body>
</html>