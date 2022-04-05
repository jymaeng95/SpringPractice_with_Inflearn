package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component // AppConfig 에서는 의존관계 주입코드를 작성했었음 -> AutoAppConfig 에는 의존관계 주입 코드 없기 때문에 자동 의존관계 주입 필요 = Autowired
public class MemberServiceImpl implements MemberService {

    // 인터페이스로 구현객체 참조 -> 런타임 시 다형성에 의해 구현객체의 메소드를 호출
    // OCP, DIP 위배 -> 추상화,구현 객체를 의존
//    private final MemberRepository memberRepository = new MemoryMemberRepository();

    private final MemberRepository memberRepository;

    // AppConfig 에서 Repository구현체를 파라미터로 주입해주기 때문에 클라이언트 코드에서 구현 객체를 의존하지 않음 -> DIP 해결
    // 기존 코드의 변경을 하지 않음 -> OCP 해결
    // 생성자를 통해 의존관계 주입 -> 생성자 주입
    @Autowired  // ac.getBean(MemberRepository.class)
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        // memberRepository 객체는 구현체를 참조하므로 다형성에 의해 MemmoryMemberRepsitory를 읽음
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // 테스트 용도 (싱글톤 보장 확인)
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
