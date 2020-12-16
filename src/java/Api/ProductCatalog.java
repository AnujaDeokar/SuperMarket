
package Api;

import java.util.ArrayList;
import java.util.Vector;
import java.sql.*;

public class ProductCatalog {

    protected Products[] items1;
    ArrayList<Products> items = new ArrayList<Products>();

    public ProductCatalog() {

        try {
            Connection conn;
            Statement stm;
            ResultSet rst;

            Class.forName(Api.DBClass.driver_url);
            conn = DriverManager.getConnection(Api.DBClass.db_url, Api.DBClass.db_user, Api.DBClass.db_pass);

            stm = conn.createStatement();
            rst = stm.executeQuery("SELECT * FROM product");
                while (rst.next()) //next read the current record and move to next,if end of record found it return false
                {
                    String product_id = rst.getString("product_id");
                    String product_name = rst.getString("product_name");
                    String product_category = rst.getString("product_category");
                    double cutted_price = rst.getDouble("cutted_price");
                    double show_price = rst.getDouble("show_price");
                    int stock = rst.getInt("stock");
                    int re_order_value = rst.getInt("re_order_value");
                    String image = rst.getString("image");
                    String description = rst.getString("description");
                    int star_value = rst.getInt("star_value");
                    int offer = rst.getInt("offer");
                    Products p= new Products();
                    p.setProduct_id(product_id);
                    p.setProduct_name(product_name);
                    p.setProduct_category(product_category);
                    p.setCutted_price(cutted_price);
                    p.setShow_price(show_price);
                    p.setStock(stock);
                    p.setRe_order_value(re_order_value);
                    p.setImage(image);
                    p.setDescription(description);
                    p.setStar_value(star_value);
                    p.setOffer(offer);
                    items.add(p);
                }
                System.out.println("Database Products:"+items);
        }
        catch(Exception ex){}
                
    }
    public Products[] getItems() {
        return getItems(0, items.size());
    }

    public Products[] getItems(int startingLocation, int numItems) {

        if (numItems > items.size()) {
            numItems = items.size();
        }


        if (startingLocation + numItems >= items.size()) {
            startingLocation = items.size() - numItems;
        }

// Create an array for the returned items.
        Products[] returnItems = new Products[numItems];

// Copy the items from the catalog into the return array.
        //System.arraycopy(items, startingLocation,returnItems, 0, numItems);
        
        items.toArray(returnItems);

        return returnItems;
    }

    
    public boolean itemsAvailable(int startingLocation) {
        if (startingLocation >= items.size()) {
            return false;
        }
        return true;
    }

    
    public Products findItemByProductCode(String productCode) {

        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getProduct_id().equals(productCode)) {
                return items.get(i);
            }
        }

        return null;
    }
}
