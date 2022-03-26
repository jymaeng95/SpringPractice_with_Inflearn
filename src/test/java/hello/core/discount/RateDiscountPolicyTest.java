package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RateDiscountPolicyTest {

    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 되어야 한다.")
    void VIP_O() {
        //given
        Member member = new Member(1L, "memberVIP", Grade.VIP);

        // when
        int discount = rateDiscountPolicy.discount(member, 10000);

        //then
        assertThat(discount).isEqualTo(1000);
    }

    // 실패 테스트도 만들어야함
    @Test
    @DisplayName("VIP가 아닌 경우 할인이 적용되면 안된다.")
    void VIP_X() {
        //given
        Member member = new Member(1L, "memberBASIC", Grade.Basic);

        // when
        int discount = rateDiscountPolicy.discount(member, 10000);

        //then
        assertThat(discount).isEqualTo(0);
    }
}
