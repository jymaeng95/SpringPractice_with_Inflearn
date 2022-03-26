package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {
//    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    // 클라이언트 코드의 변경 (구현체도 의존하는 경우이므로 DIP 위배)
    // private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    // 현재 클라이언트 코드는 추상화(인터페이스)에만 의존 중 -> DIP 해결
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    // 어떤 구현체가 주입될 지 클라이언트는 모름
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    // 1. 주문 생성 (memberId, itemName, itemPrice)
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        // 2. 회원 조회
        Member member = memberRepository.findById(memberId);

        // 3. 할인 적용
        int discountPrice = discountPolicy.discount(member, itemPrice);     // Discount 에게 역할 위임

        // 4. 주문 결과 반환
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
