package section03;

public class WrapperService {	public void printValue(Object obj) {

    // Wrpper Class(Integer) 전달 받았지만
    // Object로 업캐스팅 상태
    // 따라서 제대로 사용 시 다운 캐스팅 필요
    Integer wrap = (Integer)obj; // 다운 캐스팅

    int num = wrap.intValue(); // Integer -> int로 Unboxing

    //System.out.println("값 출력 : " + obj); // 자동으로.toString() 호출함
    System.out.println("값 출력 : " + num);

}

    public void test1() {
        /*int -> Integer Boxing*/
        int num1 = 100;

        Integer wrap1 = new Integer(num1);
        // The constructor Integer(int) has been deprecated
        // deprecated : 사용되지 않음

        printValue(wrap1);

    }


    public void printValue2(Object obj) {
        int num = (int)obj;// Object -> Integer -> int

        System.out.println("Auto UnBoxing 후 값 출력 : " + num);

        Integer wrap = new Integer(300);
        int num2 = wrap;
    }

    public void test2() {
        int num = 200;
        printValue2(num);
    }



    public void test3() {

        System.out.println("int는 몇바이트? " + Integer.BYTES);
        System.out.println("int는 몇비트? " + Integer.SIZE);
        System.out.println("int 최대 값 : " + Integer.MAX_VALUE);
        System.out.println("int 최소 값 : " + Integer.MIN_VALUE);
        System.out.println("-------------------------------------");

        System.out.println("double는 몇바이트? " + Double.BYTES);
        System.out.println("double는 몇비트? " + Double.SIZE);
        System.out.println("double 최대 값 : " + Double.MAX_VALUE);
        System.out.println("double 최소 값 : " + Double.MIN_VALUE);
        System.out.println("-------------------------------------");


        System.out.println(Double.NaN);
        System.out.println(Double.POSITIVE_INFINITY);
        System.out.println(Double.NEGATIVE_INFINITY);
        System.out.println("-------------------------------------");

        System.out.println("[String -> 기본 자료형으로 변환]");

        byte b = Byte.parseByte("100");
        int i = Integer.parseInt("123456789");
        long l = Long.parseLong("123456789012345");
        double d = Double.parseDouble("3.1415926538");
        boolean bool = Boolean.parseBoolean("true");


        System.out.println(b);
        System.out.println(i);
        System.out.println(l);
        System.out.println(d);
        System.out.println(bool);
        System.out.println("-------------------------------------");


        System.out.println("[기본 자료형 -> String]");

        // 방법1)
        int num1 = 500;
        // String s1 = num1; // 오류(왜? 자료형 불일지)
        String s1 = num1 + "";


        // 방법2) Wrapper Class 의 valueOf() / toStirng()이용
        int num2 = 700;
        String s2 = Integer.valueOf(num2).toString();

        String s3 = Integer.toString(num2);
        System.out.println("s2 : " + s2);
        System.out.println(s2.getClass());
        System.out.println("s3 : " + s3);
        System.out.println(s2.getClass());


    }
}
