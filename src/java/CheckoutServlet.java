

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Api.*;
import java.net.URLEncoder;
import javax.servlet.http.HttpSession;

public class CheckoutServlet extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
            Shipping shipping = new Shipping();

            shipping.setName(request.getParameter("name"));
            shipping.setAddress1(request.getParameter("address1"));
            shipping.setAddress2(request.getParameter("address2"));
            shipping.setCity(request.getParameter("city"));
            shipping.setState(request.getParameter("state"));
            shipping.setPostalCode(request.getParameter("postalCode"));
            shipping.setCountry(request.getParameter("country"));
            shipping.setEmail(request.getParameter("email"));

//  get the billing values.

            Billing billing = new Billing();

            billing.setNameOnCard(request.getParameter("nameOnCard"));
            billing.setCreditCardType(request.getParameter("creditCardType"));
            billing.setCreditCardNumber(request.getParameter(
                    "creditCardNumber"));
            billing.setCreditCardExpiration(request.getParameter(
                    "creditCardExpiration"));

            HttpSession session = request.getSession();

// Get the cart.

            ShoppingCart cart
                    = (ShoppingCart) session.getAttribute("ShoppingCart");

// If there is no shopping cart, create one (this should really be an error).
            if (cart == null) {
                cart = new ShoppingCart();

                session.setAttribute("ShoppingCart", cart);
            }

            try {
                String confirmation = cart.completeOrder(shipping, billing);

// Now display the cart and allow the user to check out or order more items.

                response.sendRedirect(response.encodeRedirectURL(
                        "ShowConfirmation.jsp"
                        + "?confirmationNumber=" + URLEncoder.encode(confirmation)));
            } catch (ShoppingCartException exc) {
                //PrintWriter out = response.getWriter();

                out.println("<html><body><h1>Error</h1>");
                out.println("The following error occurred while "
                        + "processing your order:");
                out.println("<pre>");
                out.println(exc.getMessage());
                out.println("</pre>");
                out.println("</body></html>");
                return;
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
