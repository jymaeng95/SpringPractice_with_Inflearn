package hello.core.scan;

import hello.core.AutoAppConfig;
import hello.core.discount.DiscountPolicy;
import hello.core.member.MemberService;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class AutoAppConfigTest {
    @Test
    void basicScan() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        MemberService memberService = applicationContext.getBean(MemberService.class);
        OrderService orderService = applicationContext.getBean(OrderService.class);


        assertThat(orderService).isInstanceOf(OrderService.class);
        assertThat(memberService).isInstanceOf(MemberService.class);

    }

    @Test
    void DiscountPolicyTest() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AutoAppConfig.class);
//        DiscountPolicy discountPolicy = applicationContext.getBean(DiscountPolicy.class);

        // DiscountPolicy가 두개가 Component로 등록된 경우는 NoUniqueBeanDefinitionException
        org.junit.jupiter.api.Assertions.assertThrows(NoUniqueBeanDefinitionException.class, () -> applicationContext.getBean(DiscountPolicy.class));
    }
}
