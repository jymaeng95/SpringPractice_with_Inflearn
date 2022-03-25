package hello.core.discount.old;

import hello.core.member.old.Member;

public interface DiscountPolicy {
    /*
    * @return 할인 대상 금액
    */
    int discount(Member member, int price);
}
