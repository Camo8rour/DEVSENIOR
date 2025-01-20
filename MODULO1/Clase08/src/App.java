import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        var request = new Scanner(System.in);

        showMenu(request);

        request.close();
    }

    private static void showMenu(Scanner request) {
        List<String> products = new ArrayList<>();
        byte menu;

        do {
            System.out.printf("%n----------------------%n");
            System.out.println("\t MENÚ");
            System.out.println("----------------------");
            System.out.println("1. Ingresar producto.");
            System.out.println("2. Mostrar productos.");
            System.out.println("3. Buscar producto.");
            System.out.println("4. Actualizar producto.");
            System.out.println("5. Calcular valor total del inventario.");
            System.out.println("6. Mostrar producto más caro y más barato.");
            System.out.println("0. Salir");
            System.out.print("--> ");
            menu = request.nextByte();

            switch (menu) {
                case 1:
                    enterProduct(request, products);
                    pressEnter(request);
                    break;
                case 2:
                    showProducts(products);

                    request.nextLine();
                    pressEnter(request);
                    break;
                case 3:
                    searchProduct(request, products);
                    pressEnter(request);
                    break;
                case 4:
                    updateProduct(request, products);
                    
                    request.nextLine();
                    pressEnter(request);
                    break;
                case 5:
                    calculateTotalValue(products);
                    
                    request.nextLine();
                    pressEnter(request);
                    break;
                case 6:
                    showMostExpensiveAndCheapestProduct(products);
                    
                    request.nextLine();
                    pressEnter(request);
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.err.println("El valor ingresado es invalido.");

                    request.nextLine();
                    pressEnter(request);
                    break;
            }

        } while (menu != 0);

    }

    private static void enterProduct(Scanner request, List<String> products) {
        System.out.printf("%nIngrese el número de productos que desea ingresar: ");
        int numberProducts = request.nextInt();

        request.nextLine();

        for (int i = 0; i < numberProducts; i++) {
            System.out.printf("%nIngrese el nombre del producto %d: ", i + 1);
            String name = request.nextLine();

            int quantity;
            do {
                System.out.printf("Ingrese la cantidad del producto %d: ", i + 1);
                quantity = request.nextInt();
                if (quantity > 100) {
                    System.err
                            .printf("%nLa cantidad maxima de productos es de 100 productos.%n\tVuelva a intentarlo.%n");
                }
            } while (quantity > 100);

            System.out.printf("Ingrese el precio del producto %d: ", i + 1);
            double price = request.nextDouble();

            request.nextLine();

            products.add(name + " | " + quantity + " | " + price);
        }

    }

    private static void showProducts(List<String> products) {
        System.out.println("""

                -------------------------------
                |Lista de Productos ingresados|
                -------------------------------""");
        System.out.println("Nombre | Cantidad | Precio");
        for (String product : products) {
            System.out.println(product);
        }
    }

    private static void searchProduct(Scanner request, List<String> products) {
        request.nextLine();

        System.out.print("Ingrese el nombre del producto a buscar: ");
        String productName = request.nextLine().toLowerCase();

        products.stream()
                .filter(product -> product.toLowerCase().contains(productName))
                .forEach(product -> System.out
                        .printf("%n   Producto encontrado.%nNombre | Cantidad | Precio%n" + product));

        if (products.stream().noneMatch(product -> product.toLowerCase().contains(productName))) {
            System.out.println("No se encontró el producto con el nombre: " + productName);
        }
    }

    private static void updateProduct(Scanner request, List<String> products) {
        request.nextLine();

        System.out.print("Ingrese el nombre del producto a actualizar: ");
        String productName = request.nextLine().toLowerCase();

        boolean found = false;
        for (int i = 0; i < products.size(); i++) {
            String product = products.get(i);

            if (product.toLowerCase().contains(productName)) {
                found = true;

                System.out.println("Producto encontrado: " + product);

                int newQuantity;
                do {
                    System.out.print("Ingrese la nueva cantidad para el producto: ");
                    newQuantity = request.nextInt();
                    if (newQuantity > 100) {
                        System.err.println("La cantidad máxima de productos es 100. Vuelva a intentarlo.");
                    }
                } while (newQuantity > 100);

                System.out.print("Ingrese el nuevo precio para el producto: ");
                double newPrice = request.nextDouble();

                String updatedProduct = product.split(" \\| ")[0] + " | " + newQuantity + " | " + newPrice;
                products.set(i, updatedProduct);

                System.out.println("Producto actualizado correctamente.");
                break;
            }
        }

        if (!found) {
            System.out.println("No se encontró ningún producto con el nombre: " + productName);
        }
    }

    private static void calculateTotalValue(List<String> products) {
        double totalValue = 0;

        for (String product : products) {
            String[] division = product.split("\\|");
            int quantity = Integer.parseInt(division[1].trim());
            double price = Double.parseDouble(division[2].trim());

            totalValue += quantity * price;  
        }

        System.out.printf("%n%nValor total del inventario: %.2f.", totalValue);
    }

    private static void showMostExpensiveAndCheapestProduct(List<String> products) {
        if (products.isEmpty()) {
            System.out.println("No hay productos en la lista.");
            return;
        }
    
        String mostExpensiveProduct = "";
        String cheapestProduct = "";
        double highestPrice = Double.MIN_VALUE;
        double lowestPrice = Double.MAX_VALUE;
    
        for (String product : products) {
            String[] productDetails = product.split(" \\| ");
            double price = Double.parseDouble(productDetails[2]);
    
            if (price > highestPrice) {
                highestPrice = price;
                mostExpensiveProduct = product;
            }
    
            if (price < lowestPrice) {
                lowestPrice = price;
                cheapestProduct = product;
            }
        }
    
        System.out.println("\nProducto más caro: ");
        System.out.println(mostExpensiveProduct);
        System.out.println("\nProducto más barato: ");
        System.out.println(cheapestProduct);
    }

    private static void pressEnter(Scanner pressRequest) {
        System.out.printf("%nOprima ENTER para continuar.%n");
        pressRequest.nextLine();
    }
    
}
