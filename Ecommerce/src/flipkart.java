
import java.sql.*;

public class flipkart {
    public static void main(String[] args) {

        try {
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/ecommerce",
                "root",
                "1234"
            );

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(
                "SELECT * FROM products"
            );

            System.out.println("FLIPKART PRODUCTS");
            System.out.println("-----------------");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("product_id") + " | " +
                    rs.getString("product_name") + " | " +
                    rs.getString("category") + " | " +
                    rs.getDouble("price") + " | " +
                    rs.getInt("quantity")
                );
            }

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
