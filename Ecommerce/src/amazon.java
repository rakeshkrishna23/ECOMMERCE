
import java.sql.*;
import java.util.Scanner;

public class amazon {
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

            System.out.print("Enter category: ");
            String category = sc.nextLine();

            System.out.print("Enter price: ");
            double price = sc.nextDouble();

            System.out.print("Enter quantity: ");
            int quantity = sc.nextInt();

            String sql = "INSERT INTO products " +
                "(product_name, category, price, quantity) " +
                "VALUES (?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, category);
            ps.setDouble(3, price);
            ps.setInt(4, quantity);

            ps.executeUpdate();

            System.out.println("Product added successfully!");

            ps.close();
            con.close();
            sc.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

