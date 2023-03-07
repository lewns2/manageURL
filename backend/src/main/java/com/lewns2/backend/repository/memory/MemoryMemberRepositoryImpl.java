//package com.lewns2.backend.repository.memory;
//
//import com.lewns2.backend.model.Member;
//import com.lewns2.backend.repository.MemberRepository;
//
//import java.util.Map;
//import java.util.Optional;
//import java.util.concurrent.ConcurrentHashMap;
//
//public class MemoryMemberRepositoryImpl implements MemberRepository {
//
//    // 임시 저장소
//    private static Map<Long, Member> store = new ConcurrentHashMap<>();
//
//    @Override
//    public void save(Member member) {
//        store.put(member.getId(), member);
//    }
//
//    @Override
//    public Member findMemberById(Long memberId) {
//        return store.get(memberId);
//    }
//
//    @Override
//    public Member findMemberByNickName(String nickName) {
//        return null;
//    }
//
//    @Override
//    public Optional<Member> findMemberByEmail(String email) {
//        return null;
//    }
//
//
//}
