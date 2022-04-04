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

@Configuration
public class AppConfig {
    // 클라이언트 코드는 추상화만 의존하고 구현체에 대한 결정은 모두 Config에서 해준다.

    //@Bean memberService -> new MemoryMemberRepository()
    //@Bean orderService -> new MemoryMemberRepository()  :  두번 호출하는데 싱글톤 깨지지 않나?!

    // -----------예상 호출-------------
    //call AppConfig.memberService
    //call AppConfig.memberRepository
    //call AppConfig.memberRepository
    //call AppConfig.orderService
    //call AppConfig.memberRepository

    // -----------실제 호출-------------
    //call AppConfig.memberRepository
    //call AppConfig.memberService
    //call AppConfig.orderService

    @Bean
    public MemberService memberService() {
        // 이전에는 레포지토리 코드를 역할을 구분안해서 서비스별로 코드를 변경해주어야했다.
//        return new MemberServiceImpl(new MemoryMemberRepository());
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
//         return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

    @Bean
    // 추후에 DB 레포지토리로 바뀌는 경우에 해당 코드만 변경해주면된다.
    public MemberRepository memberRepository() {

        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }
}
