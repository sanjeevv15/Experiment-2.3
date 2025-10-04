import java.util.*;
import java.util.stream.*;
import java.util.Comparator;

class Product {
    String name;
    double price;
    String category;

    Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }
}

public class ProductStreamOperations {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Laptop", 80000, "Electronics"),
            new Product("Phone", 50000, "Electronics"),
            new Product("TV", 60000, "Electronics"),
            new Product("Shirt", 2000, "Clothing"),
            new Product("Jeans", 3000, "Clothing"),
            new Product("Refrigerator", 45000, "Appliances"),
            new Product("Washing Machine", 35000, "Appliances")
        );

        Map<String, List<Product>> groupedByCategory =
                products.stream().collect(Collectors.groupingBy(p -> p.category));
        System.out.println("Products Grouped by Category:");
        groupedByCategory.forEach((category, prodList) -> {
            System.out.println(category + ": " + 
                prodList.stream().map(p -> p.name).collect(Collectors.joining(", ")));
        });

        Map<String, Optional<Product>> maxPriceByCategory =
                products.stream().collect(Collectors.groupingBy(
                        p -> p.category,
                        Collectors.maxBy(Comparator.comparingDouble(p -> p.price))
                ));
        System.out.println("\nMost Expensive Product in Each Category:");
        maxPriceByCategory.forEach((category, product) -> 
            System.out.println(category + " -> " + 
                product.map(p -> p.name + " (" + p.price + ")").orElse("None"))
        );

        double avgPrice = products.stream()
                .collect(Collectors.averagingDouble(p -> p.price));
        System.out.println("\nAverage Price of All Products: " + avgPrice);
    }
}


