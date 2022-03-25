package hello.core.member.old;

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);
}
