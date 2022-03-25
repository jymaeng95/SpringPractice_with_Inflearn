package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000;   // 1000원 고정 금액 할인

    // 요구사항의 모든 VIP는 1000원을 고정으로 할인해준다.
    @Override
    public int discount(Member member, int price) {
        // 등급이 VIP인 경우 (enum 은 == 비교)
        if(member.getGrade() == Grade.VIP) return discountFixAmount;
        return 0;
    }
}
