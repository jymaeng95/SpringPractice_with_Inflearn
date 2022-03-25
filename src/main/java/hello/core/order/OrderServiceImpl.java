package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

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
