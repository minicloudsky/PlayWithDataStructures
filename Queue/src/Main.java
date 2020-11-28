import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.Random;

public class Main {
    private static double testQueue(Queue<Integer> q, int opCount) {
        long statTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            q.enqueue(random.nextInt());
        }
        for (int i = 0; i < opCount; i++) {
            q.dequeue();
        }

        long endTime = System.nanoTime();
        return (endTime - statTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        int opCount = 1000000;
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double time1 = testQueue(arrayQueue, opCount);
        double time2 = testQueue(loopQueue, opCount);
        System.out.println("ArrayQueue time1: " + time1);
        System.out.println("LoopQueue time2: " + time2);

    }
}
