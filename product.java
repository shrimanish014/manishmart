package backend.model;

public class Product {
    private int id;
    private String name;
    private double price;
    private String category;
    private int stock;
    private String description;

    // Default constructor
    public Product() {}

    // Constructor without ID (useful when adding a new product, ID is auto-generated)
    public Product(String name, double price, String category, int stock, String description) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.stock = stock;
        this.description = description;
    }

    // Full constructor (with ID, useful when reading from DB)
    public Product(int id, String name, double price, String category, int stock, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.stock = stock;
        this.description = description;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Useful check: is product in stock?
    public boolean isInStock() {
        return stock > 0;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", stock=" + stock +
                ", description='" + description + '\'' +
                '}';
    }
}