import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArbolInventario arbol = new ArbolInventario();

        int opcion;

        do {
            System.out.println("\n--- TREE-STOCK ---");
            System.out.println("1. Registrar Producto");
            System.out.println("2. Mostrar Inventario");
            System.out.println("3. Buscar Producto");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Ingrese nombre: ");
                    String nombre = sc.nextLine();

                    arbol.insertar(id, nombre);
                    System.out.println("Producto registrado correctamente.");
                    break;

                case 2:
                    System.out.println("\nInventario:");
                    arbol.mostrarInventario();
                    break;

                case 3:
                    System.out.print("Ingrese ID a buscar: ");
                    int idBuscar = sc.nextInt();

                    if (arbol.existe(idBuscar)) {
                        System.out.println("Producto encontrado.");
                    } else {
                        System.out.println("Producto NO existe.");
                    }
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 0);

        sc.close();
    }
}