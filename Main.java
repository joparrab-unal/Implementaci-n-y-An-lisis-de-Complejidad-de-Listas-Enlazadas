public class Main {

    public static long exec(int size, String method, Operation operation) {
        long start = System.nanoTime();
        
        for (int i = 0; i < size; i++) {
            operation.apply(i);
        }

        long finish = System.nanoTime();
        long timeElapsedMicros = (finish - start) / 1000;
        
        System.out.printf("Se ejecutó %s de %d elementos en: %d microsegundosss\n", method, size, timeElapsedMicros);
        return timeElapsedMicros;
    }

    public static void main(String[] args) {
        final int start = 100;
        final int endLento = 10000;
        final int endRapido = 1000000;
        
        StringBuilder resumen = new StringBuilder();
        resumen.append("\n--- Resumen de Promedios (microsegundos) ---\n");

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

        System.out.println(resumen.toString());
        System.out.printf("Fin de las pruebas\n");
    }
}
