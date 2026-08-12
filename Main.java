package backend;

import backend.model.User;
import backend.model.Product;
import backend.dao.UserDAO;
import backend.dao.ProductDAO;
import backend.util.DBConnection;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // 1. Test DB connection
        testDBConnection();

        Scanner sc = new Scanner(System.in);
        UserDAO userDAO = new UserDAO();
        ProductDAO productDAO = new ProductDAO();

        int choice;
        do {
            System.out.println("\n===== E-Commerce Backend Test Menu =====");
            System.out.println("1. Test Login");
            System.out.println("2. View All Products");
            System.out.println("3. Search Product by Category");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    testLogin(sc, userDAO);
                    break;
                case 2:
                    testViewProducts(productDAO);
                    break;
                case 3:
                    testSearchByCategory(sc, productDAO);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 4);

        sc.close();
    }

    // Check if DB connection works
    private static void testDBConnection() {
        try (Connection conn = DBConnection.getConnection()) {
            if (conn != null) {
                System.out.println("✅ Database connected successfully!");
            }
        } catch (Exception e) {
            System.out.println("❌ Database connection failed: " + e.getMessage());
        }
    }

    // Test login flow using UserDAO
    private static void testLogin(Scanner sc, UserDAO userDAO) {
        System.out.print("Enter email: ");
        String email = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();

        User user = userDAO.loginUser(email, password);

        if (user != null) {
            System.out.println("Login successful! Welcome, " + user.getName());
        } else {
            System.out.println("Invalid email or password.");
        }
    }

    // Test fetching all products using ProductDAO
    private static void testViewProducts(ProductDAO productDAO) {
        List<Product> products = productDAO.getAllProducts();

        if (products.isEmpty()) {
            System.out.println("No products found.");
        } else {
            System.out.println("\n--- All Products ---");
            for (Product p : products) {
                System.out.println(p.getId() + ". " + p.getName() +
                        " | Price: ₹" + p.getPrice() +
                        " | Category: " + p.getCategory());
            }
        }
    }

    // Test filtering products by category
    private static void testSearchByCategory(Scanner sc, ProductDAO productDAO) {
        System.out.print("Enter category name: ");
        String category = sc.nextLine();

        List<Product> products = productDAO.getProductsByCategory(category);

        if (products.isEmpty()) {
            System.out.println("No products found in this category.");
        } else {
            System.out.println("\n--- Products in " + category + " ---");
            for (Product p : products) {
                System.out.println(p.getId() + ". " + p.getName() + " | Price: ₹" + p.getPrice());
            }
        }
    }
}