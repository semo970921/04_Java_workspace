package generics;

public class Child extends Parent{

    private int number;

    public Child(){}

    public Child(int number) {
        this.number = number;
    }

    @Override
    public String toString(){
        return super.toString() + " / number : " + number;
    }
}
