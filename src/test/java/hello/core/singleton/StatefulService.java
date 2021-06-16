package hello.core.singleton;

public class StatefulService {
    private int price; //상태를 유지하는 필드 10000 -> 20000

    public void order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        this.price = price; // 문제 발생 위치
    }

    // 해결 방법 (지역변수 사용)
    public int order2(String name,int price) {
        System.out.println("name = " + name);
        System.out.println("price = " + price);

        return price;
    }
    public int getPrice() {
        return price;
    }
}
