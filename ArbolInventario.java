/**
 * Clase ArbolInventario (La Lógica)
 * Contiene los algoritmos recursivos para la manipulación y administración
 * de la estructura dinámica del Árbol Binario de Búsqueda (ABB).
 */
public class ArbolInventario {
    // Puntero principal que apunta a la raíz del árbol (Primer nodo)
    private Producto raiz;

    /**
     * Constructor de la clase. Inicializa el árbol vacío.
     */
    public ArbolInventario() {
        this.raiz = null; // El árbol comienza sin ningún nodo
    }

    // =========================================================================
    // MÉTODO 1: INSERCIÓN RECURSIVA
    // =========================================================================

    /**
     * Método público para solicitar la inserción de un nuevo producto.
     */
    public void insertar(int id, String nombre) {
        // Asigna el resultado del método recursivo a la raíz del árbol
        raiz = insertarRecursivo(raiz, id, nombre);
    }

    /**
     * Método privado recursivo para ubicar el nuevo nodo según las reglas del ABB.
     * @param actual Nodo en el que se encuentra la navegación en la llamada actual
     * @param id ID del nuevo producto
     * @param nombre Nombre del nuevo producto
     * @return El nodo actualizado
     */
    private Producto insertarRecursivo(Producto actual, int id, String nombre) {
        // CASO BASE: Si se llega a una posición nula (vacía), se crea el nuevo nodo
        if (actual == null) {
            return new Producto(id, nombre);
        }

        // LÓGICA DE NAVEGACIÓN Y RECURSIVIDAD:
        // Si el ID a insertar es menor al ID del nodo actual, navega hacia la izquierda
        if (id < actual.id) {
            actual.izquierdo = insertarRecursivo(actual.izquierdo, id, nombre);
        } 
        // Si el ID a insertar es mayor al ID del nodo actual, navega hacia la derecha
        else if (id > actual.id) {
            actual.derecho = insertarRecursivo(actual.derecho, id, nombre);
        } 
        // CASO DE DUPLICADO: No permite insertar productos con el mismo ID
        else {
            System.out.println("-> Error: Ya existe un producto registrado con el ID " + id);
        }

        // Retorna el nodo actual con sus punteros actualizados
        return actual;
    }

    // =========================================================================
    // MÉTODO 2: RECORRIDO INORDEN (LISTAR INVENTARIO)
    // =========================================================================

    /**
     * Método público para imprimir el inventario completo.
     */
    public void mostrarInorden() {
        if (raiz == null) {
            System.out.println("-> El inventario está vacío.");
        } else {
            System.out.println("\n--- INVENTARIO DE PRODUCTOS (ORDENADO ASCENDENTE POR ID) ---");
            inordenRecursivo(raiz);
            System.out.println("----------------------------------------------------------");
        }
    }

    /**
     * Recorrido Inorden: Subárbol Izquierdo -> Nodo Raíz -> Subárbol Derecho.
     * Gracias a la propiedad del ABB, este recorrido imprime los elementos en orden ascendente.
     */
    private void inordenRecursivo(Producto actual) {
        if (actual != null) {
            // 1. Recorrer de forma recursiva todo el subárbol izquierdo
            inordenRecursivo(actual.izquierdo);
            
            // 2. Procesar/Imprimir los datos del nodo actual
            System.out.println("ID: " + actual.id + " | Nombre: " + actual.nombre);
            
            // 3. Recorrer de forma recursiva todo el subárbol derecho
            inordenRecursivo(actual.derecho);
        }
    }

    // =========================================================================
    // MÉTODO 3: BÚSQUEDA RECURSIVA POR ID
    // =========================================================================

    /**
     * Método público para buscar un producto por su clave ID.
     */
    public void buscar(int id) {
        Producto resultado = buscarRecursivo(raiz, id);
        if (resultado != null) {
            System.out.println("-> Producto ENCONTRADO: ID " + resultado.id + " - Nombre: " + resultado.nombre);
        } else {
            System.out.println("-> El producto con ID " + id + " NO existe en el inventario.");
        }
    }

    /**
     * Búsqueda recursiva aprovechando la propiedad de orden del ABB.
     */
    private Producto buscarRecursivo(Producto actual, int id) {
        // CASOS BASE: 
        // 1. Si actual es null, se recorrió la rama y no se encontró el elemento.
        // 2. Si actual.id == id, se encontró el elemento buscado.
        if (actual == null || actual.id == id) {
            return actual;
        }

        // Si el ID buscado es menor al del nodo actual, buscar únicamente en la izquierda
        if (id < actual.id) {
            return buscarRecursivo(actual.izquierdo, id);
        }

        // Si el ID buscado es mayor, buscar únicamente en la derecha
        return buscarRecursivo(actual.derecho, id);
    }
}
