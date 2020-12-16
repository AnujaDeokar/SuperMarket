<%@ page language="java" import="Api.*" %>
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
				<li class="active">Checkout</li>
			</ol>
		</div>
	</div>
<!-- //breadcrumbs -->
<div class="brands">
		<div class="container">
<p>
<jsp:include page="DisplayShoppingCartWOHF.jsp" flush="true"/>
<p>
<h1>Please enter your shipping information</h1>
<p>
<form action="CheckoutServlet" method="post">

<table>
<tr><td>Name:</td><td><input type="text" name="name"></td></tr>
<tr><td>Address:</td><td><input type="text" name="address1"></td>
</tr>
<tr><td></td><td><input type="text" name="address2"></td></tr>
<tr><td>City:</td><td><input type="text" name="city"></td></tr>
    <td>State:</td>
    <td><input type="text" name="state" size=2 maxlength=2></td></tr>
<tr><td>Postal Code (Zip in U.S.):</td>
    <td><input type="text" name="postalCode"></td></tr>
<tr><td>Country:</td><td><input type="text" name="country"></td></tr>
<tr></tr>
<tr><td>Email Address:</td><td><input type="text" name="email">
</td></tr>
</table>
<p>
<h1>Please enter your billing information</h1>
<table>
<tr><td>Name (as it appears on credit card):</td>
    <td><input type="text" name="nameOnCard"></td></tr>
<tr><td>Credit Card:</td>
<td><select name="creditCardType">
    <option value="amex">American Express</option>
    <option value="visa">Visa</option>
    <option value="mc">Mastercard</option>
    <option value="discover">Discover</option>
    <option value="bbbt">Billy Bob's Bank &amp; Trust</option>
    </select></td></tr>
<tr><td>Credit Card Number:</td>
    <td><input type="text" name="creditCardNumber"></td></tr>
<tr><td>Expiration Date:</td>
    <td><input type="text" name="creditCardExpiration"></td></tr>
</table>
<p>
<input type="submit" value="Complete Order">
</form>
 </div>
</div>
<%@include file="footer.jsp" %>