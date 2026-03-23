import java.time.Instant;
import java.time.Duration;

public class Main {

    public static void exec(int size, String method, Operation operation) {
        Instant start = Instant.now();        
        
        for (int i =0; i<size; i++);
            operation.apply(i);

        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        System.out.printf("Se ejecutó %s de %d elementos en: %d milisegundos\n", method, size, timeElapsed);
    }

    public static void main(String[] args) {
        final int start = 100;
        final int endLento = 10000;
        final int endRapido = 1000000;
        
       for (int size = start; size <= endRapido; size *= 10) {
    for (int j = 0; j < 5; j++) {
        ListaSimple<Integer> lista = new ListaSimple<>();
        exec(size, "pushFront", lista::pushFront);
    }
}
        for (int size = start; size <= endRapido; size *= 10) {
    for (int j = 0; j < 5; j++) {
        ListaSimple<Integer> lista = new ListaSimple<>();
        exec(size, "pushBack", lista::pushBack);
    }
}
        for (int size = start; size <= endRapido; size *= 10) {
    for (int j = 0; j < 5; j++) {
        ListaSimpleConCola<Integer> lista = new ListaSimpleConCola<>();
        exec(size, "pushBack_tail", lista::pushBack);
    }
}
        for (int size = start; size <= endRapido; size *= 10) {
    for (int j = 0; j < 5; j++) {
        MyStack<Integer> stack = new MyStack<>();
        exec(size, "stack_push", stack::push);
    }
}
    for (int size = start; size <= endRapido; size *= 10) {
    for (int j = 0; j < 5; j++) {
        MyQueue<Integer> queue = new MyQueue<>();
        exec(size, "queue_enqueue", queue::enqueue);
    }
}
    }
}
