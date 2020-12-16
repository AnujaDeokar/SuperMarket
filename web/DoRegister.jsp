<%@page import="java.sql.*" %>
<%@include file="header.jsp" %>
<!-- breadcrumbs -->
	<div class="breadcrumbs">
		<div class="container">
			<ol class="breadcrumb breadcrumb1 animated wow slideInLeft" data-wow-delay=".5s">
				<li><a href="index.html"><span class="glyphicon glyphicon-home" aria-hidden="true"></span>Home</a></li>
				<li class="active">Registration Complete</li>
			</ol>
		</div>
	</div>
<!-- //breadcrumbs -->
<!-- register -->

<%
                    String email = request.getParameter("email");
                    String pass = request.getParameter("upass");
                    String fname = request.getParameter("fname");
                    String lname = request.getParameter("lname");
                   
                    String reg_date = new java.util.Date().toString();
                    String active = "1";

                    try {
                        Connection conn;
                        Statement stm;
                        ResultSet rst;

                       Class.forName(Api.DBClass.driver_url);
                       conn = DriverManager.getConnection(Api.DBClass.db_url, Api.DBClass.db_user, Api.DBClass.db_pass);

                        stm = conn.createStatement();
                        rst = stm.executeQuery("select * from users where email='" + email + "'");
                        rst.next();
                        if (rst.getRow() != 0) {
                %>

                <div class="alert alert-danger" role="alert">
                    <button type="button" class="close" data-dismiss="alert">
                        <span aria-hidden="true">×</span>
                        <span class="sr-only">Close</span>
                    </button>
                    <strong>Oh snap!</strong> This Email Address Already Registered Please Choose Different Email Address.
                </div>
                <%
                } else {
                    String q = "Insert into users values('" + email + "',\'" + pass + "\',\'" + fname + "\',\'" + lname + "\',\'" + reg_date + "\',1)";

                    System.out.println(q);
                    int i = stm.executeUpdate(q);

                    

                %>

               <div class="register">
		<div class="container">
			<h2>Your Registration is Completed!!</h2>
			<div class="login-form-grids">
				<h5 align="center">Click Login Button Given Below </h5>
                                
				
			</div>
			<div class="register-home">
				<a href="Login.jsp">Login Here</a>
			</div>
		</div>
	</div>
                <%                }
                        conn.close();

                    } catch (Exception ex) {
                        out.println("Error:" + ex.getMessage());
                    }
                %>
	
<!-- //register -->
<%@include file="footer.jsp" %>