
import java.sql.*;
import java.util.Scanner;

public class myntra {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/ecommerce",
                "root",
                "1234"
            );

            System.out.print("Enter product name: ");
            String name = sc.nextLine();

            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM products WHERE product_name = ?"
            );

            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("Product: " +
                    rs.getString("product_name"));
                System.out.println("Category: " +
                    rs.getString("category"));
                System.out.println("Price: " +
                    rs.getDouble("price"));
                System.out.println("Quantity: " +
                    rs.getInt("quantity"));
            } else {
                System.out.println("Product not found!");
            }

            con.close();
            sc.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

