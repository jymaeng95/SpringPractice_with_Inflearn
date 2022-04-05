package hello.core.discount.old;

import hello.core.member.old.Grade;
import hello.core.member.old.Member;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Component
//@Primary
//Main DB/ Sub DB
public class RateDiscountPolicy implements DiscountPolicy{
    private int discountPercent = 10;
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP)
            return price * discountPercent / 100;
        return 0;
    }
}
