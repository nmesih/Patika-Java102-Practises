package PatikaStore;

import PatikaStore.model.Brand;
import PatikaStore.model.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PatikaStore {

    private List<Brand> brands;
    private List<Product> products;

    public PatikaStore() {
        brands = new ArrayList<>();
        brands.add(new Brand(1, "Samsung"));
        brands.add(new Brand(2, "Lenovo"));
        brands.add(new Brand(3, "Apple"));
        brands.add(new Brand(4, "Huawei"));
        brands.add(new Brand(5, "Casper"));
        brands.add(new Brand(6, "Asus"));
        brands.add(new Brand(7, "HP"));
        brands.add(new Brand(8, "Xiaomi"));
        brands.add(new Brand(9, "Monster"));

        products = new ArrayList<>();
    }

    public void listProductsByCategory(String category) {
        List<Product> filteredProducts = products.stream()
                .filter(p -> p.getName().equalsIgnoreCase(category))
                .collect(Collectors.toList());

        if (filteredProducts.isEmpty()) {
            System.out.println("No products found in the " + category + " category.");
            return;
        }

        System.out.println("Listing products in the " + category + " category:");
        System.out.println("ID\tProduct\t\tBrand\t\tPrice\t\tDiscounted Price\tStock");
        for (Product product : filteredProducts) {
            System.out.format("%d\t%s\t\t%s\t\t%.2f\t\t%.2f\t\t%d\n",
                    product.getId(), product.getName(), product.getBrand().getName(),
                    product.getPrice(), product.getDiscountedPrice(), product.getStock());
        }
    }

    public void addProduct(String category, double price, double discountRate, int stock, String name, int brandId) {
        Brand selectedBrand = brands.stream()
                .filter(b -> b.getId() == brandId)
                .findFirst()
                .orElse(null);

        if (selectedBrand == null) {
            System.out.println("Invalid brand ID. Product not added.");
            return;
        }

        int newId = products.isEmpty() ? 1 : products.get(products.size() - 1).getId() + 1;
        Product newProduct = new Product(newId, price, discountRate, stock, name, selectedBrand);
        products.add(newProduct);
        System.out.println("Product added successfully.");
    }

    public void deleteProduct(int productId) {
        Product productToRemove = products.stream()
                .filter(p -> p.getId() == productId)
                .findFirst()
                .orElse(null);

        if (productToRemove == null) {
            System.out.println("Product with ID " + productId + " not found. No product removed.");
            return;
        }

        products.remove(productToRemove);
        System.out.println("Product with ID " + productId + " has been removed.");
    }

    public void listProductsByBrand(int brandId) {
        List<Product> filteredProducts = products.stream()
                .filter(p -> p.getBrand().getId() == brandId)
                .sorted(Comparator.comparing(Product::getName))
                .collect(Collectors.toList());

        if (filteredProducts.isEmpty()) {
            System.out.println("No products found for the brand with ID " + brandId);
            return;
        }

        System.out.println("Listing products for the brand with ID " + brandId);
        System.out.println("ID\tProduct\t\tBrand\t\tPrice\t\tDiscounted Price\tStock");
        for (Product product : filteredProducts) {
            System.out.format("%d\t%s\t\t%s\t\t%.2f\t\t%.2f\t\t%d\n",
                    product.getId(), product.getName(), product.getBrand().getName(),
                    product.getPrice(), product.getDiscountedPrice(), product.getStock());
        }
    }
}


