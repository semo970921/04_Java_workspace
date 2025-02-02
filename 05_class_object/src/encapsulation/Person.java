package encapsulation;

public class Person {

    // private String name; // 이름
    private String personName; // 이름(필드명 변경)
    private double height; // 키

    public void setName(String name){
        personName = name;
    }

    public void setHeight(double height){
        if(height >= 0) {
            this.height = height;
        } else{
            this.height = height*-1;
        }
    }

    public String getInfo(){
        return "이름: " + personName + " / 키: " + height;
    }
}
