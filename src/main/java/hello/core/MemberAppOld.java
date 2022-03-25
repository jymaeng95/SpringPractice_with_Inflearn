package hello.core;

import hello.core.member.old.Grade;
import hello.core.member.old.Member;
import hello.core.member.old.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberAppOld {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();


//        MemberService memberService = new MemberServiceImpl();
//        MemberService memberService = appConfig.memberService();
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfigOld.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member : "+member.getName());
        System.out.println("find member : "+findMember.getName());

    }
}