package hello.core.order.old;

import hello.core.discount.old.FixDiscountPolicy;
import hello.core.member.old.Grade;
import hello.core.member.old.Member;
import hello.core.member.old.MemoryMemberRepository;
import hello.core.order.old.Order;
import hello.core.order.old.OrderServiceImpl;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OrderServiceImplTest {

    @Test
    void createOrder() {
        MemoryMemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L, "name", Grade.VIP));

        OrderServiceImpl orderService = new OrderServiceImpl(new MemoryMemberRepository(),new FixDiscountPolicy());
        Order order = orderService.createOrder(1L, "itemA", 10000);

        assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}