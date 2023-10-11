<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Registration Form</title>

</head>
<body>

   <div>
		<form action="regform" method="post">

			<fieldset align="center" style="margin-top: 200px; margin-left: 200px; margin-right: 200px;">
				<legend align="center" style="color:mediumslateblue; font-weight: bolder; font-size: xx-large;">Registration Form</legend>
				<br><br>
				<label>User Name</label>
				<input type="text" name="name1" id="usr" autofocus maxlength="15" size="20" required><br><br>
				<label>PassWord</label>
				<input type="password" name="pass" id="pwd" minlength="8" required maxlength="15" size="20" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" required><br><br>
				<label>Email</label>
				<input type="email" name="email" pattern=".+@gmail\.com" size="20" required ><br><br>
				<label>Mobile No </label>
				<input type="tel" name="mobile" maxlength="10"  pattern="[6789][0-9]{9}" 
       title="Phone number with 7-9 and remaing 9 digit with 0-9" required/><br><br>
				<label>Gender</label>
				<input type="radio" name="gender1"/>Male <input type="radio" name="gender2" required/>Female
				<br><br>
				<input type="submit" name="lgn" value="Register" onclick="fetchData()">
				<input type="reset" name="CANCEL" value="CANCEL">
				<br><br>
			</fieldset>
		</form>
		
	</div>
	<div>
		<a align="center" href="login.jsp">Login Form</a>
		</div>
</body>
</html>