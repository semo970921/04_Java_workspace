package generics;

public class GenericsRun {
    public static void main(String[] args) {

        Box<String> box1 = new Box<String>();
        box1.setValue("String만 전달 가능");
        System.out.println(box1.getValue()); // String만 전달 가능

        Box<Integer> box2 = new Box<Integer>();
        box2.setValue(12345); // int -> Integer (AutoBoxing)
        System.out.println(box2.getValue()); // 12345

    }
}
