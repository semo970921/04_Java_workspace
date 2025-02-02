package abstraction;

public class ConstructorRun {
    public static void main(String[] args) {

        // Student 기본 생성자를 이용해 객체 생성
        Student std1 = new Student();
        System.out.println(std1.toString());

        System.out.println("-------------------");


        // Student(String, String) 매개 변수가 있는 생성자 이용
        Student std2 = new Student("202127897",  "유리");
        System.out.println(std2.toString());

        // Student 객체 필드를 모두 초기화 하는 생성자 이용
        Student std3 = new Student("202121943", "짱구", 50 , 40, 30, 59);
        System.out.println(std3.toString());
    }
}











