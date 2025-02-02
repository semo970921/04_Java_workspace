package staticmember;

public class Korean {

    public static int nationalCode = 82;

    private String name;
    private String id; // 주민등록번호

    {
        System.out.println("객체 생성 시 마다 수행");
        name = "홍길동";
        id = "900101-1234567";
    }

    static{
        System.out.println("프로그램 실행 시 수행");
        nationalCode = 999;
        // name = "김길동"
    }

    public Korean(){}

    public Korean(String name, String id){
        this.name = name;
        this.id = id;
    }

    public String getName(){
        return name;
    }
    public void SetName(String name){
        this.name = name;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public int getNationalCode() {
        return nationalCode;
    }
    public void setNationalCode(int nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String toString() {
        return
                String.format(
                        "이름 : %s / 주민 등록 번호 : %s / 국가코드 : %d"
                        , name, id, nationalCode);
    }
}
