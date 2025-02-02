package abstraction;

public class AbstractionRun {
    public static void main(String[] args) {

        Student std = new Student();
        std.setName("신짱구");
        std.setStudentNumber("202521235");
        std.setHtml(100);
        std.setCss(75);
        std.setJs(80);
        std.setJava(70);

        // 합계 출력하기
        System.out.println(std.getName() + "의 점수 합계: " + std.getSum());

        String result = std.toString();
        System.out.println(result);

        System.out.println("----------------------");

        Student std2 = new Student();
        std2.setName("유리");
        std2.setStudentNumber("202521098");
        std2.setHtml(90);
        std2.setCss(80);
        std2.setJs(70);
        std2.setJava(75);

        String result2 = std2.toString();
        System.out.println(result2);

        System.out.println("----------------------");

        // 일일이 다 하니 불편하네??
        // >>>>>생성자<<<<!!

        Student std3 = new Student(
                "202521456", "철수",
                95, 70, 80, 85
        );
        String result3 = std3.toString();
        System.out.println(result3);
    }
}
