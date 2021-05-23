//package hello.core.beanfind;
//
//import hello.core.AppConfig;
//import hello.core.member.MemberService;
//import hello.core.member.MemberServiceImpl;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.NoSuchBeanDefinitionException;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class ApplicationContextBasicFindTest {
//    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
//
//    @Test
//    @DisplayName("빈 이름으로 조회")
//    void findBeanByName() {
//        MemberService memberService = ac.getBean("memberService", MemberService.class);
////        System.out.println("memberService = " + memberService);
////        System.out.println("memberService.getClass() = " + memberService.getClass());
//        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
//    }
//    @Test
//    @DisplayName("이름 없이 타입으로만 조회")
//    void findBeanByType() {
//        MemberService memberService = ac.getBean(MemberService.class);
////        System.out.println("memberService = " + memberService);
////        System.out.println("memberService.getClass() = " + memberService.getClass());
//        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
//    }
//
//    //구현에 의존한 코드, 구체 클래스를 접근하기 보단 추상화한 인터페이스를 접근하자!
//    @Test
//    @DisplayName("구체 타입으로만 조회")
//    void findBeanByName2() {
//        MemberService memberService = ac.getBean("memberService", MemberServiceImpl.class);
////        System.out.println("memberService = " + memberService);
////        System.out.println("memberService.getClass() = " + memberService.getClass());
//        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
//    }
//
//    @Test
//    @DisplayName("빈 이름으로 조회 x")
//    void findBeanByNameX() {
//        //ac.getbean("xxxx",MemerService.class):
//        MemberService xxxx = ac.getBean("xxxx", MemberService.class);
//        assertThrows(NoSuchBeanDefinitionException.class,
//                () -> ac.getBean("xxxx",MemberService.class));
//    }
//
//}
