<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<%@include file="header.jsp" %>
<!-- breadcrumbs -->
	<div class="breadcrumbs">
		<div class="container">
			<ol class="breadcrumb breadcrumb1 animated wow slideInLeft" data-wow-delay=".5s">
				<li><a href="index.jsp"><span class="glyphicon glyphicon-home" aria-hidden="true"></span>Home</a></li>
				<li class="active">Login Page</li>
			</ol>
		</div>
	</div>
<!-- //breadcrumbs -->


<%
    
    String email=request.getParameter("email");
    String pass=request.getParameter("upass");
    
    
    try
    {
         Connection conn;
         Statement stm;
         ResultSet rst;
       
         Class.forName(Api.DBClass.driver_url);
         conn = DriverManager.getConnection(Api.DBClass.db_url, Api.DBClass.db_user, Api.DBClass.db_pass);
         
        stm=conn.createStatement();
        rst=stm.executeQuery("select * from users where email='"+email+"' and password=\'"+pass+"\'");
        rst.next();
        
        if(rst.getRow()!=0)
        {
            String name=rst.getString("first_name");
            int active =rst.getInt("active");
            
             if (active == 0) {
                %>

                <div class="alert alert-danger" role="alert">
                    <button type="button" class="close" data-dismiss="alert">
                        <span aria-hidden="true">×</span>
                        <span class="sr-only">Close</span>
                    </button>
                    <strong>Oh snap!</strong> Your Account is Not Activated.Please contact Web Admin @ 9999999999
                </div>
                <%
                } else {
                    
                        session.setAttribute("username", name);
                        session.setAttribute("email", email);
                        response.sendRedirect("index.jsp");
                    }
                    

               }
               else
                {
            %>
            
           <div class="alert alert-danger" role="alert">
								<button type="button" class="close" data-dismiss="alert">
									<span aria-hidden="true">×</span>
									<span class="sr-only">Close</span>
								</button>
								<strong>Oh snap!</strong> Wrong Email Address Or Password.
							</div>
        <%
            }
         conn.close();
        
    }catch(Exception ex){
        out.println("Error:"+ex.getMessage());
    }
    %>


  <%@include file="footer.jsp" %>