package generics;

public class TestBox<T extends Parent> {

    private T obj;

    public T getObj(){
        return obj;
    }

    public void setObj(T obj){
        this.obj = obj;
    }
}
