<%@ page language="java" import="Api.*,java.net.*,java.text.*" %>
<%@include file="header.jsp" %>
<%!
// Declare a constant for the number of items to show on a page.
    public static final int ITEMS_PER_PAGE = 5;
%>


<!-- breadcrumbs -->
	<div class="breadcrumbs">
		<div class="container">
			<ol class="breadcrumb breadcrumb1 animated wow slideInLeft" data-wow-delay=".5s">
				<li><a href="index.jsp"><span class="glyphicon glyphicon-home" aria-hidden="true"></span>Home</a></li>
				<li class="active">Confirmation</li>
			</ol>
		</div>
	</div>
<!-- //breadcrumbs -->
<div class="brands">
		<div class="container">
<h1>Order Submitted Successfully!</h1>
<p>
Thank you for your order. Your order confirmation number is:
<br>
<pre>
<%=request.getParameter("confirmationNumber")%>
</pre>
<p>
    Please use this number when calling to check on your order.<br/>
    <a href="ShowProductCatalog.jsp">Go To Home - All Products</a>
    <%
        session.setAttribute("ShoppingCart", null);
        session.invalidate();
    %>
 </div>
</div>
<%@include file="footer.jsp" %>