

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Api.*;
import javax.servlet.http.HttpSession;

public class RemoveItemServlet extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
           // Get the index of the item to remove.

        int itemIndex = Integer.parseInt(request.getParameter("item"));

        HttpSession session = request.getSession();

// Get the cart.

        ShoppingCart cart =
            (ShoppingCart) session.getAttribute("ShoppingCart");

// If there is no shopping cart, create one.

        if (cart == null)
        {
            cart = new ShoppingCart();

            session.setAttribute("ShoppingCart", cart);
        }

        cart.removeItem(itemIndex);

//  display the cart and allow the user to check out or order more items.

        response.sendRedirect(response.encodeRedirectURL(
            "DisplayShoppingCart.jsp"));
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
