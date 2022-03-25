package hello.core;

import hello.core.discount.old.DiscountPolicy;
import hello.core.discount.old.RateDiscountPolicy;
import hello.core.member.old.MemberRepository;
import hello.core.member.old.MemberService;
import hello.core.member.old.MemberServiceImpl;
import hello.core.member.old.MemoryMemberRepository;
import hello.core.order.old.OrderService;
import hello.core.order.old.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration      //@Configuration 설정정보
public class AppConfigOld {

    //@Bean memberService -> new MemoryMemberRepository()
    //@Bean orderService -> new MemoryMemberRepository()

    //생성자 주 
    @Bean           //@Bean 스프링 컨테이너에 등록
    public MemberService memberService() {
        System.out.println("AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {

        System.out.println("AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
//        return null;
    }


    //구현체 결정 다른 구현체 결정시 해당 부분만 코드 변경
    @Bean
    public MemberRepository memberRepository() {

        System.out.println("AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    //구현체 결정 (Fix -> Rate) 교체하면 모든 사용부분에서 교체가된다.
    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
