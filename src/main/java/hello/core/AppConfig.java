package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration      //@Configuration 설정정보
public class AppConfig {

    //생성자 주
    @Bean           //@Bean 스프링 컨테이너에 등록
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    //구현체 결정 다른 구현체 결정시 해당 부분만 코드 변경
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    //구현체 결정 (Fix -> Rate) 교체하면 모든 사용부분에서 교체가된다.
    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
