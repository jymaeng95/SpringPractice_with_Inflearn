package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
// 다른 클래스들에 Configuration 애놑테이션에도 Component가 붙어있기 때문에 해당 정보들을 제외
@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class))
public class AutoAppConfig {
    // AppConfig와 달리 설정정보 코드가 없다.
    // 의존관계 주입을 Autowired를 통해 주입한다.
}
