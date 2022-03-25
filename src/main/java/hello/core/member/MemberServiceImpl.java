package hello.core.member;

public class MemberServiceImpl implements MemberService {

    // 인터페이스로 구현객체 참조 -> 런타임 시 다형성에 의해 구현객체의 메소드를 호출
    // OCP, DIP 위배 -> 추상화,구현 객체를 의존
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        // memberRepository 객체는 구현체를 참조하므로 다형성에 의해 MemmoryMemberRepsitory를 읽음
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
