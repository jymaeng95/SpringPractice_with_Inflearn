package hello.core.singleton.old;

public class SingletonService {
    //자기자신 static으로 하나 가짐 / 클래스 레벨에 올라가므로 한개만 존재  -> 자바 기본 static 공부
    //1. 자바 로딩시 하나만 올라감 / static 영역에 객체 1개 생성
    private static final SingletonService instance = new SingletonService();

    //2, public을 이용해 객체 인스턴스 필요 시  static 메소드를 통해서 조회
    public static SingletonService getInstance() {
        return instance;
    }

    //private 생성자이므로 getinstnace() 메소드를 통해서만 참조 가능
    // 외부에서 new 키워드로 객체 인스턴스 생성 못함
    private SingletonService() {}

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
