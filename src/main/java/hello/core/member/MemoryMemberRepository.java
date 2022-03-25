package hello.core.member;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/** 메모리에 멤버 저장 리포지토리 생성
 *  순수 자바로 구현 중
 *
 */
public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    // 실무에서는 동시성 이슈로 인해 Concurrent Hash map 사용 동시에 접근하는 경우가 있기 때문
    // private static Map<Long,Member> store = new ConcurrentHashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
