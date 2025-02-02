package staticmember;

public class StaticmemberRun {
    public static void main(String[] args) {

        // 확인
        System.out.println("Korean.nationalCode : " + Korean.nationalCode );

        Korean k1 = new Korean("김철수", "051212-3456789");
        Korean k2 = new Korean("이미영", "050304-4567891");

        System.out.println(k1.toString());
        System.out.println(k2.toString());

        Korean.nationalCode = 1000;

        System.out.println("-------------------------");
        System.out.println("Korean.nationalCode : " + Korean.nationalCode);
        System.out.println(k1.toString());
        System.out.println(k2.toString());

        System.out.println("-------------------------");
        System.out.println("[초기화 블럭 확인]");

        Korean k3 = new Korean();
        Korean k4 = new Korean();
        System.out.println(k3.toString());
        System.out.println(k4.toString());

    }

}
