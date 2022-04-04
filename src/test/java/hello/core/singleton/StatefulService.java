package hello.core.singleton;

public class StatefulService {
    private int price;      // 상태를 유지하는 필드 (공유하는 필드)

    public void order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);

        // 문제의 부분
        // StatefulService가 빈으로 관리 (싱글톤)으로 관리되기 때문에 값이 변함
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
