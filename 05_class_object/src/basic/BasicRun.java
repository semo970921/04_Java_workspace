package basic;

public class BasicRun {
    public static void main(String[] args){

        Car myCar = new Car();

        myCar.start();
        myCar.stop();

        myCar.brand = "현대";
        myCar.model = "소나타";
        myCar.year = 2025;
        System.out.println("myCar brand : " + myCar.brand);
        System.out.println("myCar model : " + myCar.model);
        System.out.println("myCar year : " + myCar.year);

        System.out.println("-------------------------------------------------");

        // Car 클래스 재사용
        Car myCar2 = new Car();

        myCar2.brand = "테슬라";
        myCar2.model = "Model Y";
        myCar2.year = 2024;
        System.out.printf("저의 자동차는 %s %s 이고, %d년식 입니다\n"
                , myCar2.brand, myCar2.model, myCar2.year);

        myCar2.start();

        System.out.println("안녕히 계세요 여러분~~~~~~~~~~~~~~~~~~~~");

    }
}
