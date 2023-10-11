<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
         <div>
		<form action="loginform" method="post">

			<fieldset align="center" style="margin-top: 200px; margin-left: 200px; margin-right: 200px;">
				<legend align="center" style="color:mediumslateblue; font-weight: bolder; font-size: xx-large;">Login Form</legend><br><br>
				<label>Email</label>
				<input type="text" name="email" id="usr"><br><br>
				<label>PAssWord</label>
				<input type="password" name="pass1" id="pwd" ><br><br>
				<input type="submit" name="lgn" value="LOGIN" >
				<input type="reset" name="CANCEL" value="CANCEL">
			</fieldset>
		</form>
		
		</div>
		<div>
		<a align="center" href="register.jsp">Registration Form</a>
		</div>

</body>
</html>