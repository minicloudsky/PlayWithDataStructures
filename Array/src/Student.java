public class Student {
    private String name;
    private int score;

    public Student(String studentName, int studentScore) {
        name = studentName;
        score = studentScore;
    }

    @Override
    public String toString() {
        return String.format("Student (name: %s,score: %d)", name, score);
    }

    public static void main(String[] args) {
        Array<Student> arr = new Array<>();
        arr.addLast(new Student("Alice", 12));
        arr.addLast(new Student("Bob", 55));
        arr.addLast(new Student("Charlie", 88));
        arr.remove(0);
        arr.addFirst(new Student("zhangsan", 34));
        System.out.println(arr);
    }
}
