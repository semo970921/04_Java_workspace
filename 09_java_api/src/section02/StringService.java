package section02;

public class StringService {

    /**
     * String의 불변성 확인
     */
    public void test1(){
        String s1 = "hello";
        System.out.println("s1 : " + s1); // hello
        System.out.println(System.identityHashCode(s1)); // 495053715
        System.out.println("--------------------------------------");

        s1 += "world";
        System.out.println("s1 : " + s1); // helloworld
        System.out.println(System.identityHashCode(s1)); // 883049899
    }

    /**
     * String의 객체 생성 방법
     */
    public void test2(){
        String s1 = "hello"; // 664740647
        System.out.println("s1 : " + System.identityHashCode(s1));

        String s2 = "hello"; // 664740647
        System.out.println("s2 : " + System.identityHashCode(s2)); // s1과 s2는 원래 독립된 객체
        // -> s1과 s2의 주소 값이 같음!!

        // ====================================================

        String s3 = new String("hello"); // 321001045
        System.out.println("s3 : " + System.identityHashCode(s3));


        System.out.println("---------------------------------------");

        // Constant Pool 때문에 리터럴은 비교연산자로 비교 가능
        System.out.println("[참조 주소 비교]s1 == s2 : " + (s1 == s2)); // true
        System.out.println("[참조 주소 비교]s1 == s3 : " + (s1 == s3)); // false

        System.out.println("[필드 값 비교] s1.equals(s2) : " + s1.equals(s2)); // true
        System.out.println("[필드 값 비교] s1.equals(s3) : " + s1.equals(s3)); // true
    }

    /**
     * StringBuilder / StringBuffer
     */
    public void test3(){

        StringBuilder sb = new StringBuilder();

        System.out.println("sb 크기 : " + sb.capacity());
        System.out.println("sb 주소 : " + System.identityHashCode(sb));

        sb.append("abcde");
        sb.append("fghij");
        sb.append("klmno");
        sb.append("/");

        System.out.println("------------------------------------");
        System.out.println("sb.toString() : " + sb.toString());
        System.out.println("sb 크기 : " + sb.capacity());
        System.out.println("sb 주소 : " + System.identityHashCode(sb));


        sb.insert(0, "가나다라");
        System.out.println("------------------------------------");
        System.out.println("sb.toString() : " + sb.toString());
        System.out.println("sb 크기 : " + sb.capacity());
        System.out.println("sb 주소 : " + System.identityHashCode(sb));


        sb.delete(4, 9);
        System.out.println("------------------------------------");
        System.out.println("sb.toString() : " + sb);
        System.out.println("sb 크기 : " + sb.capacity());
        System.out.println("sb 주소 : " + System.identityHashCode(sb));


        sb.trimToSize();
        System.out.println("------------------------------------");
        System.out.println("sb 크기 : " + sb.capacity());
    }
}
