import java.util.Scanner;

/**
 * Clase Main (La Interfaz)
 * Contiene el punto de entrada de la aplicación y la interfaz de menú interactivo en consola.
 */
public class Main {
    public static void main(String[] args) {
        // Instancia del árbol para gestionar el inventario
        ArbolInventario arbol = new ArbolInventario();
        Scanner sc = new Scanner(System.in);
        int opcion = -1;

        // Bucle del menú interactivo en consola
        do {
            System.out.println("\n==================================");
            System.out.println("   SISTEMA DE INVENTARIO TREE-STOCK");
            System.out.println("==================================");
            System.out.println("1. Registrar Producto");
            System.out.println("2. Mostrar Inventario");
            System.out.println("3. Buscar Producto");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            // Captura de datos con validación de entradas numéricas
            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("-> Error: Debe ingresar un número entero válido.");
                continue;
            }

            // Manejo de las opciones del menú mediante un bloque switch-case
            switch (opcion) {
                case 1: // Registrar Producto
                    System.out.print("Ingrese el ID del producto (número entero): ");
                    int id = Integer.parseInt(sc.nextLine());
                    System.out.print("Ingrese el nombre del producto: ");
                    String nombre = sc.nextLine();
                    
                    // Inserción en la estructura dinámica
                    arbol.insertar(id, nombre);
                    break;

                case 2: // Mostrar Inventario
                    // Ejecuta el recorrido inorden para mostrar los datos ordenados
                    arbol.mostrarInorden();
                    break;

                case 3: // Buscar Producto
                    System.out.print("Ingrese el ID a buscar: ");
                    int idBuscar = Integer.parseInt(sc.nextLine());
                    
                    // Ejecuta la búsqueda recursiva
                    arbol.buscar(idBuscar);
                    break;

                case 0: // Salir
                    System.out.println("Saliendo del sistema Tree-Stock...");
                    break;

                default:
                    System.out.println("-> Opción fuera de rango. Seleccione una opción válida.");
            }
        } while (opcion != 0);

        // Cierre de recursos de la consola
        sc.close();
    }
}
