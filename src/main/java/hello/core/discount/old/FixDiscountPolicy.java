package hello.core.discount.old;

import hello.core.member.old.Grade;
import hello.core.member.old.Member;
import org.springframework.stereotype.Component;

//@Component
public class FixDiscountPolicy implements DiscountPolicy {
    private int discountixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP ) {
            return discountixAmount;
        }
        return 0;
    }
}
