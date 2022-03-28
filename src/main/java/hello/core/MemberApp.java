package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// 순수한 자바로 서비스 개발 완료 (테스트)
public class MemberApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

//        MemberService memberService = new MemberServiceImpl();

        // Spring Container
        // AppConfig의 환경 정보를 가지고 스프링 컨테이너에 넣어서 관리
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        // getBean 의 name은 메소드 이름으로 등록
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new Member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
