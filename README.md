# Tree-Stock

# Sistema de Inventario "Tree-Stock" - Árbol Binario de Búsqueda (ABB)

## Información del Proyecto y Estudiante
- **Nombre del Estudiante:** Evelyn Gomez Ramirez
- **Programa Académico:** Ingeniería de Software
- **Asignatura:** Estructuras de Datos 
- **Institución:** IU Digital de Antioquia
- **Repositorio de GitHub:** https://github.com/evelyngomezr/Tree-Stock

---

## 1. Objetivo del Proyecto
El objetivo principal de esta actividad es comprender, diseñar e implementar manualmente la estructura de datos dinámica de un **Árbol Binario de Búsqueda (ABB)** en Java, sin utilizar librerías nativas de colecciones automáticas. La aplicación simula el sistema de inventario "Tree-Stock", donde los productos se organizan, buscan y listan dinámicamente utilizando punteros y métodos recursivos.

---

## 2. Marco Teórico y Sustentación Conceptual

### ¿Qué es un Árbol Binario de Búsqueda (ABB)?
Un Árbol Binario de Búsqueda es una estructura de datos no lineal jerárquica compuesta por **nodos**. Cada nodo almacena una clave (en este caso, el `id` del producto) y mantiene dos referencias o **punteros** hacia sus nodos hijos (`izquierdo` y `derecho`).

La característica fundamental del ABB es su **Propiedad de Ordenamiento**, la cual establece que para cualquier nodo $N$:
1. Todos los nodos ubicados en su **subárbol izquierdo** tienen un valor (ID) **estrictamente menor** que el valor de $N$.
2. Todos los nodos ubicados en su **subárbol derecho** tienen un valor (ID) **estrictamente mayor** que el valor de $N$.

### Aplicación de la Recursividad en el Sistema
La recursividad es un enfoque de programación donde un método se llama a sí mismo para resolver un subproblema de menor tamaño. En este proyecto se aplica en tres operaciones esenciales:

#### 1. Inserción Recursiva (`insertarRecursivo`)
Cuando se desea registrar un nuevo producto, el sistema compara recursivamente el nuevo `id` con el `id` del nodo actual:
- Si el nuevo `id` es menor, el método se invoca recursivamente enviando el hijo izquierdo (`actual.izquierdo`).
- Si es mayor, se invoca enviando el hijo derecho (`actual.derecho`).
- **Caso base:** Cuando el apuntador alcanzado es `null`, significa que se ha encontrado la posición correcta en el árbol; allí se instancia un nuevo objeto `Producto` y se conecta mediante punteros.

#### 2. Recorrido Inorden (`inordenRecursivo`)
El algoritmo de recorrido **Inorden** procesa la estructura siguiendo este patrón estricto:
$$\text{Subárbol Izquierdo} \longrightarrow \text{Nodo Raíz} \longrightarrow \text{Subárbol Derecho}$$

Debido a la propiedad de ordenamiento del ABB, este recorrido matemático garantiza que al procesar e imprimir cada nodo, los productos se muestren en pantalla **automáticamente ordenados de forma ascendente según su ID**, sin necesidad de aplicar métodos de ordenamiento secundarios.

#### 3. Búsqueda Recursiva (`buscarRecursivo`)
La búsqueda aprovecha la estructura de ramas del árbol. Al comparar el ID buscado con el nodo actual, el algoritmo decide descartar la mitad del árbol en cada iteración:
- Si el ID buscado es menor, ignora por completo el subárbol derecho y busca a la izquierda.
- Si es mayor, ignora el subárbol izquierdo y busca a la derecha.
- **Caso base:** Retorna el nodo si encuentra la coincidencia (`actual.id == id`) o retorna `null` si llega a una hoja sin hallarlo. Esto otorga una complejidad promedio de $O(\log n)$.

---

## 3. Estructura y Arquitectura del Código

El proyecto cumple estrictamente con el patrón de diseño modular compuesto por tres clases:

| Clase | Archivo | Responsabilidad / Descripción |
| :--- | :--- | :--- |
| **Nodo** | `Producto.java` | Modela la entidad del producto (`id`, `nombre`) y contiene las referencias de punteros manuales `izquierdo` y `derecho`. |
| **Lógica** | `ArbolInventario.java` | Administra la raíz del árbol y encapsula los métodos recursivos de inserción, recorrido inorden y búsqueda. |
| **Interfaz** | `Main.java` | Implementa el menú interactivo en consola mediante `switch-case` para interactuar con el usuario. |

---

## 4. Instrucciones de Ejecución

### Opción 1: Desde un IDE (VS Code, NetBeans, Eclipse, IntelliJ)
1. Abrir la carpeta del proyecto en el entorno de desarrollo.
2. Abrir el archivo `Main.java`.
3. Hacer clic en la opción de ejecución (**Run** / **Play**).

### Opción 2: Desde la Terminal o Consola de Comandos
1. Abrir la terminal en la carpeta donde se encuentra el proyecto.
2. Compilar todas las clases del programa:
   ```bash
   javac *.java

   Capturas de Pantalla de la Ejecución en Consola
<img width="1919" height="1008" alt="Captura de pantalla 2026-09-22 161526" src="https://github.com/user-attachments/assets/d1b6b30e-fe80-4156-94b6-ab3637819488" />

   <img width="1918" height="1007" alt="Captura de pantalla   j 2026-09-22 161526" src="https://github.com/user-attachments/assets/16a41f1a-faa8-4134-9889-a067dc07bc73" />

   <img width="1918" height="1013" alt="Captura de pantalla   j k 2026-09-22 161551" src="https://github.com/user-attachments/assets/ea484316-c53d-4589-85df-b01d8e8854d9" />



Video de Sustentación
https://youtu.be/q19m8mi2AIg

