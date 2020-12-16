<%@page import="java.sql.*" %>
<%@include file="header.jsp" %>
<!-- breadcrumbs -->
	<div class="breadcrumbs">
		<div class="container">
			<ol class="breadcrumb breadcrumb1 animated wow slideInLeft" data-wow-delay=".5s">
				<li><a href="index.html"><span class="glyphicon glyphicon-home" aria-hidden="true"></span>Home</a></li>
				<li class="active">Register Page</li>
			</ol>
		</div>
	</div>
<!-- //breadcrumbs -->
<!-- register -->
	<div class="register">
		<div class="container">
			<h2>Register Here</h2>
			<div class="login-form-grids">
				<h5>profile information</h5>
				<form action="DoRegister.jsp" method="post">
					<input name="fname" id="fname" type="text" placeholder="First Name..." required=" " >
					<input name="lname" id="lname" type="text" placeholder="Last Name..." required=" " >
				
				<div class="register-check-box">
					<div class="check">
						<label class="checkbox"><input type="checkbox" name="checkbox"><i> </i>Subscribe to Newsletter</label>
					</div>
				</div>
				<h6>Login information</h6>
					
					<input name="email" id="email" type="email" placeholder="Email Address" required=" " >
					<input name="upass" id="upass" type="password" placeholder="Password" required=" " >
					<input name="ucpass" id="ucpass" type="password" placeholder="Password Confirmation" required=" " >
					<div class="register-check-box">
						<div class="check">
							<label class="checkbox"><input type="checkbox" name="checkbox"><i> </i>I accept the terms and conditions</label>
						</div>
					</div>
					<input type="submit" value="Register">
				</form>
			</div>
			<div class="register-home">
				<a href="index.html">Home</a>
			</div>
		</div>
	</div>
<!-- //register -->
<%@include file="footer.jsp" %>