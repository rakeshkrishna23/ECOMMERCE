
import java.sql.*;
import java.util.Scanner;

public class mesho {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/ecommerce",
                "root",
                "1234"
            );

            System.out.print("Enter product ID: ");
            int id = sc.nextInt();

            System.out.print("Enter new price: ");
            double price = sc.nextDouble();

            String sql =
                "UPDATE products SET price = ? WHERE product_id = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, price);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Price updated successfully!");
            } else {
                System.out.println("Product ID not found!");
            }

            ps.close();
            con.close();
            sc.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

