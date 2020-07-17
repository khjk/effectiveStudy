import java.util.EnumSet;
/*
* 생성자 대신 static 팩토리 메소드를 고려해 볼 것.
* */
public class item1 {
    String name;
    String address;

    private  static final item1 CREATED_INSTANCE = new item1();

    public item1() { //기본 생성자
    }

    public item1(String name) { //생성자
        this.name = name;
    }
    /*public item1(String address) { //ERROR!!!
        this.address = address;
    }*/
    public static  item1 withName(String name) { //static 메소드
        return new item1(name); //장점4. 입력 매개변수에 따라 매번 다른 클래스의 객체를 반환할 수 있다.
    }

    public static item1 withAddress(String address) { //ERROR  해결!!!
        //name과 같은 매개변수 형(string)으로도 객체반환이 가능(생성자 역할)
        item1 item = new item1();
        item.address= address;
        return item;
    }

    private static item1 getitem1() {
        return CREATED_INSTANCE;
    }

    public static void main(String[] args) {
        item1 item  = new item1("hyojung"); //생성자 방식
        item1 item2 = item1.withName("hyojung"); //static 생성 방식 (장점1. 이름을 가질 수 있다.)
        item1 itme3 = item1.getitem1(); //매번 동일한 객체 (장점2. 반드시 새로운 객체를 만들필요가 없다.)

        EnumSet<Color> colors = EnumSet.allOf(Color.class); //EnumSet에 넣어주기
        EnumSet.of(BLUE, WHITE);
    }
    enum Color {
        RED, BLUE, WHITE
    }
}
