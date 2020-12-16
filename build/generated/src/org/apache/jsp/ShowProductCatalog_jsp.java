package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Api.*;
import java.net.*;
import java.text.*;

public final class ShowProductCatalog_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


// Declare a constant for the number of items to show on a page.
    public static final int ITEMS_PER_PAGE = 5;

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\n');
      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<body bgcolor=\"#ffffff\">\n");
      out.write("\n");
      out.write("<a href=\"/shoppingcart/ViewShoppingCart.jsp\">View Shopping Cart</a>\n");
      out.write("<p>\n");
      out.write("<h1>Available Products</h1>\n");
      out.write("<table border=\"1\">\n");
      out.write("<tr><th>Description<th>Quantity<th>Price\n");


// Get the shared product catalog.
    ProductCatalog catalog = (ProductCatalog) application.getAttribute(
        "ProductCatalog");

// If the shared product catalog hasn't been created yet, create it.
    if (catalog == null)
    {

// Not that it matters because it would be okay for two threads to initialize
// the product catalog, but synchronize this anyway to make sure only one
// thread stores the catalog. Any other JSP or servlet that needs to store
// the product catalog in the application object must also synchronize
// on application.

        synchronized (application)
        {
            catalog = new ProductCatalog();
            application.setAttribute("ProductCatalog", catalog);
        }
    }

// Get the next starting position for displaying catalog items.
    String startingPositionStr = (String) request.
        getParameter("StartingPosition");

    int startingPosition = 0;

// If there is a starting position parameter, parse it as an integer.
    if (startingPositionStr != null)
    {
        try
        {
// If there's an error parsing the number, the starting position will
// just remain 0.
            startingPosition = Integer.parseInt(startingPositionStr);
        }
        catch (Exception ignore)
        {
        }
    }

// Get ITEMS_PER_PAGE items at a time.
    Products[] items = catalog.getItems(startingPosition, ITEMS_PER_PAGE);

// Get a currency formatter for showing the price.
    NumberFormat currency = NumberFormat.getCurrencyInstance();

    for (int i=0; i < items.length; i++)
    {
        Products item = items[i];

// Create the URL for adding the item to the shopping cart.
        String addItemURL =
            "/shoppingcart/AddToShoppingCartServlet?"+
            "productCode="+URLEncoder.encode(item.getProduct_id())+
            "&description="+URLEncoder.encode(item.getDescription())+
            "&quantity="+URLEncoder.encode(""+item.getStock())+
            "&price="+URLEncoder.encode(""+item.getShow_price());

      out.write("\n");
      out.write("<tr><td>");
      out.print(item.getDescription());
      out.write("</td><td>");
      out.print(item.getStock());
      out.write("\n");
      out.write("    </td><td>");
      out.print(item.getShow_price());
      out.write("</td>\n");
      out.write("<td><a href=\"");
      out.print(addItemURL);
      out.write("\">Add to Shopping Cart</a></td></tr>\n");

    }

      out.write("\n");
      out.write("</table>\n");
      out.write("<table border=\"0\">\n");
      out.write("<tr>\n");

    if (startingPosition > 0)
    {
        int prevPosition = startingPosition-ITEMS_PER_PAGE;

// Don't let the starting position go negative.
        if (prevPosition < 0) prevPosition = 0;

// Write out a link to display the previous catalog page.
        out.println("<td><a href=\"/shoppingcart/ShowProductCatalog2.jsp?StartingPosition="+prevPosition+"\">&lt;&lt;Prev</a></td>");
    }
// Compute the next starting position in the catalog.
    int nextPosition = startingPosition+ITEMS_PER_PAGE;

// Make sure that there are still items to display at that starting
// position (that is, make sure nextPosition isn't greater than the total
// catalog size).
    if (catalog.itemsAvailable(nextPosition))
    {
// Write out a link to display the next catalog page.
        out.println("<td><a href=\"/shoppingcart/ShowProductCatalog2.jsp?StartingPosition="+nextPosition+"\">Next&gt;&gt;</a></td>");
    }

      out.write("\n");
      out.write("</tr>\n");
      out.write("</table>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
