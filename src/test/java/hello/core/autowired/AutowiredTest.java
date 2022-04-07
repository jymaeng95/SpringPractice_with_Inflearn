package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {
    @Test
    void autowiredOption() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean {
        // 1. Member는 Bean이 아님, 주입 메소드 자체가 호출이 안됨
        @Autowired(required = false)
        void setNoBean1(Member member) {
            System.out.println("noBean1 = " + member);
        }

        // 2. 주입 메소드가 호출은 되지만 null 값 주입
        @Autowired
        void setNoBean2(@Nullable Member member) {
            System.out.println("noBean2 = " + member);
        }

        // 3. 주입 메소드가 호출은 되지만 Optional.empty 값 주입
        @Autowired
        void setNoBean3(Optional<Member> member) {
            System.out.println("noBean3 = " + member);
        }
    }
}
