# Implementación y Análisis de Complejidad de Listas, Pilas y Colas en Java

Este proyecto mide y compara el rendimiento de diferentes implementaciones de listas, pilas y colas en Java. El objetivo es ver cómo afectan las decisiones de diseño (como usar un puntero `tail` o un arreglo circular) al tiempo de ejecución real frente a la complejidad teórica.

## Estructura del Proyecto

* **`ListaSimple.java`**: Lista enlazada estándar.
* **`ListaSimpleConCola.java`**: Lista con puntero al último nodo (`tail`) para optimizar el `pushBack`.
* **`MyStack.java` / `MyQueue.java`**: Implementaciones de Pila y Cola.
* **`Main.java`**: Motor de pruebas. Contiene la lógica para promediar tiempos y formatear el resumen de resultados.
* **`Operation.java`**: Interfaz funcional para pasar los métodos de las estructuras como parámetros a los métodos de medición.
* **`Nodo.java`**: Definición básica del nodo genérico.

## Metodología 

Para que los tiempos sean lo más precisos posible, el código en `Main.java` sigue estas reglas:

1.  **Aislamiento:** No se mide el tiempo de creación ni de llenado de la estrutura. Se llena la estructura con $n$ elementos, se inicia el cronómetro, se ejecuta **una sola operación** y se detiene el reloj.
2.  **Promedios:** Cada prueba se corre 6 veces. La primera ejecución se descarta (para evitar el ruido del encendido de la JVM/JIT) y se promedian las 5 restantes.
3.  **Unidad de tiempo:** Se utilizan nanosegundos (`System.nanoTime()`) para poder capturar la diferencia en operaciones $O(1)$ que en milisegundos marcaban 0.0.

## Ejecución y Resultados

El programa prueba tamaños de entrada desde 100 hasta 1,000,000 de elementos. Para los métodos más lentos (como el `pushBack` sin tail o `find`), el límite se reduce a 100,000 para evitar tiempos de espera excesivos.

Al finalizar, el programa imprime un resumen de promedios por consola que permite comparar directamente, por ejemplo, el `stack_push` contra el `pushFront` de la lista simple.
