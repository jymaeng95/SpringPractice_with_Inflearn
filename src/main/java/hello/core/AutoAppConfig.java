package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
// 다른 클래스들에 Configuration 애놑테이션에도 Component가 붙어있기 때문에 해당 정보들을 제외
@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class))
public class AutoAppConfig {
    // AppConfig와 달리 설정정보 코드가 없다.
    // 의존관계 주입을 Autowired를 통해 주입한다.
    // field injection 가급적 사용 X 사용하더라도 스프링 부트 단 테스트나 configuration에서 넣어주는건데 그마저도 좋지않음

   /* @Autowired
    MemberRepository memberRepository;
    @Autowired
    DiscountPolicy discountPolicy;

    @Bean
    OrderService orderService() {
        return new OrderServiceImpl(memberRepository, discountPolicy);
    }*/
}
