package section2.dto;

public abstract class Animal {
    private String type; // 종

    public Animal(){
        super();
    }
    public Animal(String type){
        super();
        this.type = type;
    }
    public String getType(){
        return type;
    }
    public void setType(String type){
        this.type = type;
    }

    @Override
    public String toString(){
        return "type : " + type;
    }

    /**
     *(동물은 움직이고, 먹고, 자는데 다 다름)
     * 추상 메서드
     */
    public abstract void move();
    public abstract void eat();
    public abstract void sleep();
}
