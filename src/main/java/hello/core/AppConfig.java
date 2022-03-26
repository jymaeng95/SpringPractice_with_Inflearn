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

public class AppConfig {
    // 클라이언트 코드는 추상화만 의존하고 구현체에 대한 결정은 모두 Config에서 해준다.

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
//        return new MemberServiceImpl(memberRepository());
    }

    public OrderService orderService() {
         return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
//        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
