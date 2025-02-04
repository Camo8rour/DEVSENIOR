package com.devsenior.camorour;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.devsenior.camorour.exceptions.NotEnoughQuantityException;
import com.devsenior.camorour.exceptions.NotFoundException;

public class InventoryTest {

    private Inventory inventory;

    @BeforeEach
    void setup() {
        inventory = new Inventory();
    }
    
    @Test
    void testAddProductWhenListIsEmpty() {
        // GIVEN - WHEN - THEN
        // GIVEN
        var product = new Product("Laptop", 10, 200d);
        var totalExpected = 2_000d;

        // WHEN
        inventory.addProduct(product);

        // THEN
        var totalCalculated = inventory.calculateTotalInventory();

        assertEquals(totalExpected, totalCalculated);
    }

    @Test
    void testAddProductWhenProductExistWhitSamePrice() {
        // GIVEN
        var existingProduct = new Product("Laptop", 10, 200d);
        inventory.addProduct(existingProduct);
        var newProduct = new Product("Laptop", 3, 200d);
        var totalExpected = 2_600d;

        // WHEN
        inventory.addProduct(newProduct);

        // THEN
        var totalCalculated = inventory.calculateTotalInventory();

        assertEquals(totalExpected, totalCalculated);
    }

    @Test
    void testSellProduct() {
        // GIVEN
        var newProduct = new Product("Laptop", 3, 300d);
        var totalExpected = 300d;
        inventory.addProduct(newProduct);

        // WHEN
        try {
            inventory.sellProduct("laptop", 2);
        } catch (NotFoundException | NotEnoughQuantityException e) {
            System.err.println(e.getMessage());
        }

        // THEN
        var totalCalculated = inventory.calculateTotalInventory();

        assertEquals(totalExpected, totalCalculated);
    }

    @Test
    void testCalculateTotalInventory() {
        // GIVEN
        var newProduct = new Product("Laptop", 3, 300d);
        var newProduct2 = new Product("Phone", 6, 250d);
        var newProduct3 = new Product("Tablet", 2, 150d);
        var totalExpected = 2_200d;

        // WHEN
        inventory.addProduct(newProduct);
        inventory.addProduct(newProduct2);
        inventory.addProduct(newProduct3);
        try {
            inventory.sellProduct("phone", 2);
        } catch (NotFoundException | NotEnoughQuantityException e) {
            System.err.println(e.getMessage());
        }

        // THEN
        var totalCalculated = inventory.calculateTotalInventory();

        assertEquals(totalExpected, totalCalculated);
    }

}
