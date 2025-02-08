package section3.dto;

public interface Calculator {

    public static final int MAX_NUM = 1_000_000_000; // 10억
    int MIN_NUM = -1_000_000_000; // 10억
    double PI = 3.141592; // 원주율

    /**
     * 두 수의 합을 반환
     * 단, 결과는 최대, 최소 값을 넘을 수 없음
     * @param a
     * @param b
     * @return 결과
     */
    public abstract int plus(int a, int b);


    // public abstract 생략 가능
    /**
     * 두 수의 차를 반환
     * 단, 결과는 최대, 최소 값을 넘을 수 없음
     * @param a
     * @param b
     * @return 결과
     */
    int minus(int a, int b);

    /**
     * 두 수의 곱을 반환
     * 단, 결과는 최대, 최소 값을 넘을 수 없음
     * @param a
     * @param b
     * @return 결과
     */
    int multi(int a, int b);

    /**
     * 두 수를 나눈 몫을 반환
     * 단, 결과는 최대, 최소 값을 넘을 수 없음
     * @param a
     * @param b
     * @return 결과
     */
    double div(int a, int b);


    /**
     * 두 수를 나눈 나머지를 반환
     * 단, 결과는 최대, 최소 값을 넘을 수 없음
     * @param a
     * @param b
     * @return 결과
     */
    int mod(int a, int b);


    /**
     * a를 x만큼 거듭 제곱한 결과를 반환
     * 단, 결과는 최대/최소 값을 넘을 수 없음
     * @param a
     * @param x
     * @return 결과
     */
    int pow(int a, int x);

    /**
     * 원의 넓이를 반환
     * 단, 결과는 최대/최소 값을 넘을 수 없음
     * @param r
     * @return 결과
     */
    double areaOfCircle(double r);


    /* default 메서드 */

    /**
     * 전달 받은 num이 최대/최소를 초과하는지 확인
     * - 최대값 초과 시 MAX_NUM 반환
     * - 최소값 미만 시 MIN_NUM 반환
     * - 범위 내 숫자는 그냥 반환
     * @param num
     * @return 결과
     */
    default int checkNum(int num) {
        if(num > MAX_NUM) return MAX_NUM;
        if(num < MIN_NUM) return MIN_NUM;
        return num;
    }
}
