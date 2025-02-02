package com.devsenior.camorour;

public class Main {
    public static void main(String[] args) {
        var inventory = new Inventory();
        inventory.addProduct(new Product("Laptop", 10, 3000d));
        inventory.addProduct(new Product("Phone", 0, 600.0));
        inventory.addProduct(new Product("Laptop", 5, 1500d));

        inventory.sellProduct("laptop", 5);
        inventory.sellProduct("phone", 1);
        inventory.sellProduct("tablet", 2);
        inventory.sellProduct("LAPTOP", 6);

        var total = inventory.calculateTotalInventory();
        System.out.printf("Valor total del inventario: $ %.2f%n", total);
    }
}