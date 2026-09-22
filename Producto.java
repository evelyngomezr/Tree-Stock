/**
 * Clase Producto (El Nodo)
 * Representa la estructura de cada elemento dentro del Árbol Binario de Búsqueda.
 * Cada objeto almacena la información del producto y los punteros a sus nodos hijos.
 */
public class Producto {
    // Atributos de información que guarda el nodo
    int id;           // Clave numérica para organizar y buscar en el árbol
    String nombre;    // Nombre descriptivo del producto

    // Punteros a los nodos hijos (Referencias en memoria)
    Producto izquierdo; // Apunta al subárbol con productos de ID menor
    Producto derecho;   // Apunta al subárbol con productos de ID mayor

    /**
     * Constructor para inicializar un nuevo nodo.
     * @param id Clave única del producto
     * @param nombre Nombre del producto
     */
    public Producto(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        // Al instanciar un nuevo nodo, se inicializan sus punteros en null 
        // indicando que inicialmente es una hoja (sin hijos).
        this.izquierdo = null;
        this.derecho = null;
    }
}
