package product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class inventory {
    private List<shop> products;

    public inventory() {
        this.products = new ArrayList<>();
    }
    public Connection getDBConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cafe","din","");
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return con;
    }

    public void addProduct(shop product) {
        Statement stmt;
        ResultSet rs;
        dbutil db = new dbutil();
        try {
            Connection con =getDBConnection();
            stmt = con.createStatement();
            int count = stmt.executeUpdate("INSERT INTO coffee(id, brand, coffee_name, price, reviews) VALUES('"
                    + product.getId() + "','" + product.getBrand() + "','" + product.getCoffeeName() + "',"
                    + product.getPrice() + ",'" + product.getReviews() + "')");
            System.out.println("INSERTED SUCCESSFULLY");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void updateProduct(shop cs) {
        Statement stmt;
        dbutil db = new dbutil();
        try {
            Connection con =getDBConnection();
            stmt = con.createStatement();
            int count = stmt.executeUpdate("UPDATE coffee SET coffee_name='" + cs.getCoffeeName()
                    + "', price=" + cs.getPrice() + " WHERE id=" + cs.getId());
            System.out.println("UPDATED SUCCESSFULLY");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void removeProduct(int shopId) {
        Statement stmt;
        dbutil db = new dbutil();
        try {
            Connection con =getDBConnection();
            stmt = con.createStatement();
            int count = stmt.executeUpdate("DELETE FROM coffee WHERE id=" + shopId);
            System.out.println("DELETED SUCCESSFULLY");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public shop findBrand(String brand) {
        for (shop product : products) {
            if (product.getBrand().equals(brand)) {
                return product;
            }
        }
        return null;
    }

    public void showAllProducts() {
        Statement stmt;
        ResultSet rs;
        dbutil db = new dbutil();
        try {
            Connection con = getDBConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM coffee");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "    " + rs.getString(2) + "    " + rs.getString(3) + "    " + rs.getInt(4) + "    " + rs.getString(5));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<shop> getProducts() {
        return products;
    }
}
