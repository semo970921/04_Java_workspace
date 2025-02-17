package section04.exception;

/**
 * 결과가 음수인 경우 발생하는 예외
 */
public class NegativeQuantityException extends Exception{

    // 기본 생성자
    public NegativeQuantityException() {
        super("음수 결과 발생!");
    }

    // 매개 변수가 있는 생성자
    public NegativeQuantityException(String message) {
        super(message);
    }

}
