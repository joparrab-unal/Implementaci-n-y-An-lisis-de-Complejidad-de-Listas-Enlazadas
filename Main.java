public class Main {

    public interface Operation {
        void apply(int value);
    }

    public static long exec(int size, String method, Operation operation) {
        for (int i = 0; i < size; i++) {
            operation.apply(i);
        }

        long start = System.nanoTime();
        
        operation.apply(size);

        long finish = System.nanoTime();
        long timeElapsedNanos = finish - start;
        
        System.out.printf("Se ejecutó %s en estructura de %d elementos en: %d nanosegundos\n", method, size, timeElapsedNanos);
        return timeElapsedNanos;
    }

    public static long execLectura(int size, String method, Operation setupOperation, Operation targetOperation) {
        for (int i = 0; i < size; i++) {
            setupOperation.apply(i);
        }

        long start = System.nanoTime();
        
        targetOperation.apply(size);

        long finish = System.nanoTime();
        long timeElapsedNanos = finish - start;
        
        System.out.printf("Se ejecutó %s en estructura de %d elementos en: %d nanosegundos\n", method, size, timeElapsedNanos);
        return timeElapsedNanos;
    }

    public static void main(String[] args) {
        final int start = 100;
        final int endLento = 100000;
        final int endRapido = 1000000;
        
        StringBuilder resumen = new StringBuilder();
        resumen.append("\n---Resumen de Promedios (nanosegundos)--\n");

        for (int size = start; size <= endRapido; size *= 10) {
            long sum = 0;
            for (int j = 0; j < 6; j++) {
                ListaSimple<Integer> lista = new ListaSimple<>();
                long time = exec(size, "pushFront", lista::pushFront);
                if (j > 0) sum += time;
            }
            resumen.append(String.format("pushFront de %10d: %d\n", size, sum / 5));
        }

        for (int size = start; size <= endLento; size *= 10) {
            long sum = 0;
            for (int j = 0; j < 6; j++) {
                ListaSimple<Integer> lista = new ListaSimple<>();
                long time = exec(size, "pushBack", lista::pushBack);
                if (j > 0) sum += time;
            }
            resumen.append(String.format("pushBack de %10d: %d\n", size, sum / 5));
        }

        for (int size = start; size <= endRapido; size *= 10) {
            long sum = 0;
            for (int j = 0; j < 6; j++) {
                ListaSimpleConCola<Integer> lista = new ListaSimpleConCola<>();
                long time = exec(size, "pushBack_tail", lista::pushBack);
                if (j > 0) sum += time;
            }
            resumen.append(String.format("pushBack_tail de %10d: %d\n", size, sum / 5));
        }

        for (int size = start; size <= endRapido; size *= 10) {
            long sum = 0;
            for (int j = 0; j < 6; j++) {
                MyStack<Integer> stack = new MyStack<>();
                long time = exec(size, "stack_push", stack::push);
                if (j > 0) sum += time;
            }
            resumen.append(String.format("stack_push de %10d: %d\n", size, sum / 5));
        }

        for (int size = start; size <= endRapido; size *= 10) {
            long sum = 0;
            for (int j = 0; j < 6; j++) {
                MyQueue<Integer> queue = new MyQueue<>();
                long time = exec(size, "queue_enqueue", queue::enqueue);
                if (j > 0) sum += time;
            }
            resumen.append(String.format("queue_enqueue de %10d: %d\n", size, sum / 5));
        }

        for (int size = start; size <= endRapido; size *= 10) {
            long sum = 0;
            for (int j = 0; j < 6; j++) {
                ListaSimple<Integer> lista = new ListaSimple<>();
                long time = execLectura(size, "popFront", lista::pushFront, x -> lista.popFront());
                if (j > 0) sum += time;
            }
            resumen.append(String.format("popFront de %10d: %d\n", size, sum / 5));
        }

        for (int size = start; size <= endLento; size *= 10) {
            long sum = 0;
            for (int j = 0; j < 6; j++) {
                ListaSimple<Integer> lista = new ListaSimple<>();
                long time = execLectura(size, "popBack", lista::pushFront, x -> lista.popBack());
                if (j > 0) sum += time;
            }
            resumen.append(String.format("popBack de %10d: %d\n", size, sum / 5));
        }

        for (int size = start; size <= endLento; size *= 10) {
            long sum = 0;
            for (int j = 0; j < 6; j++) {
                ListaSimple<Integer> lista = new ListaSimple<>();
                long time = execLectura(size, "find", lista::pushFront, lista::find);
                if (j > 0) sum += time;
            }
            resumen.append(String.format("find de %10d: %d\n", size, sum / 5));
        }

        for (int size = start; size <= endLento; size *= 10) {
            long sum = 0;
            for (int j = 0; j < 6; j++) {
                ListaSimple<Integer> lista = new ListaSimple<>();
                long time = execLectura(size, "erase", lista::pushFront, lista::erase);
                if (j > 0) sum += time;
            }
            resumen.append(String.format("erase de %10d: %d\n", size, sum / 5));
        }

        /* Nos falta añadir los métodos de addBefore y addAfter, porfa cuando lo hagan descomenten esto:
        for (int size = start; size <= endLento; size *= 10) {
            long sum = 0;
            for (int j = 0; j < 6; j++) {
                ListaSimple<Integer> lista = new ListaSimple<>();
                long time = execLectura(size, "addBefore", lista::pushFront, lista::addBefore);
                if (j > 0) sum += time;
            }
            resumen.append(String.format("addBefore de %10d: %d\n", size, sum / 5));
        }

        for (int size = start; size <= endLento; size *= 10) {
            long sum = 0;
            for (int j = 0; j < 6; j++) {
                ListaSimple<Integer> lista = new ListaSimple<>();
                long time = execLectura(size, "addAfter", lista::pushFront, lista::addAfter);
                if (j > 0) sum += time;
            }
            resumen.append(String.format("addAfter de %10d: %d\n", size, sum / 5));
        }

        */
        for (int size = start; size <= endRapido; size *= 10) {
            long sum = 0;
            for (int j = 0; j < 6; j++) {
                ListaSimple<Integer> lista = new ListaSimple<>();
                long time = execLectura(size, "isEmpty", lista::pushFront, x -> lista.isEmpty());
                if (j > 0) sum += time;
            }
            resumen.append(String.format("isEmpty de %10d: %d\n", size, sum / 5));
        }

        for (int size = start; size <= endRapido; size *= 10) {
            long sum = 0;
            for (int j = 0; j < 6; j++) {
                ListaSimpleConCola<Integer> lista = new ListaSimpleConCola<>();
                long time = execLectura(size, "LSC_popFront", lista::pushBack, x -> lista.popFront());
                if (j > 0) sum += time;
            }
            resumen.append(String.format("LSC_popFront de %10d: %d\n", size, sum / 5));
        }

        for (int size = start; size <= endLento; size *= 10) {
            long sum = 0;
            for (int j = 0; j < 6; j++) {
                ListaSimpleConCola<Integer> lista = new ListaSimpleConCola<>();
                long time = execLectura(size, "LSC_popBack", lista::pushBack, x -> lista.popBack());
                if (j > 0) sum += time;
            }
            resumen.append(String.format("LSC_popBack de %10d: %d\n", size, sum / 5));
        }

        for (int size = start; size <= endRapido; size *= 10) {
            long sum = 0;
            for (int j = 0; j < 6; j++) {
                MyStack<Integer> stack = new MyStack<>();
                long time = execLectura(size, "stack_pop", stack::push, x -> stack.pop());
                if (j > 0) sum += time;
            }
            resumen.append(String.format("stack_pop de %10d: %d\n", size, sum / 5));
        }

        for (int size = start; size <= endRapido; size *= 10) {
            long sum = 0;
            for (int j = 0; j < 6; j++) {
                MyQueue<Integer> queue = new MyQueue<>();
                long time = execLectura(size, "queue_dequeue", queue::enqueue, x -> queue.dequeue());
                if (j > 0) sum += time;
            }
            resumen.append(String.format("queue_dequeue de %10d: %d\n", size, sum / 5));
        }

        System.out.println(resumen.toString());
        System.out.printf("Fin de las pruebas.\n");
    }
}
