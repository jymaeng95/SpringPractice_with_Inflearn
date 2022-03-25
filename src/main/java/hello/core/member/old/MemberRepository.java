package hello.core.member.old;

public interface MemberRepository {
    void save(Member member);

    Member findById(Long memberId);
}
