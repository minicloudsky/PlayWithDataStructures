public class Main {
    public static void testArrayStack(int opCount) {
        double startTime = System.nanoTime();
        ArrayStack<Integer> stack = new ArrayStack<>();
        for (int i = 0; i < opCount; i++) {
            stack.push(i);
        }
        for (int i = 0; i < opCount; i++) {
            stack.pop();
        }
        double endTime = System.nanoTime();
        System.out.println("Array Stack Cost time : " + (endTime - startTime) / 1000000000);
    }

    public static void testLinkedListStack(int opCount) {
        double startTime = System.nanoTime();
        LinkedListStack<Integer> stack = new LinkedListStack<>();
        for (int i = 0; i < opCount; i++) {
            stack.push(i);
        }
        for (int i = 0; i < opCount; i++) {
            stack.pop();
        }
        double endTime = System.nanoTime();
        System.out.println("LinkedListStack Cost time : " + (endTime - startTime) / 1000000000);
    }

    public static void main(String[] args) {
        int opCount = 10000000;
        // LinkedListStack中需要很多 new 操作
        testArrayStack(opCount);
        testLinkedListStack(opCount);
    }
}
