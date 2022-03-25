package hello.core.scan.old;

import hello.core.AutoAppConfigOld;
import hello.core.member.old.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoAppConfigTest {

    @Test
    void basicScan()  {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfigOld.class);
        MemberService memberService = ac.getBean(MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberService.class);
    }
}
