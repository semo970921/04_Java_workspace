package section3.dto;

/* 인터페이스 다중 상속 확인*/
public interface Machine {

    public abstract void powerOn();
    public abstract void powerOff();

    int plus(int a, int b);
}
