package com.changwook.boardservice.post.dao;

import com.changwook.boardservice.member.entity.Member;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MemberDaoMapImpl implements MemberDao{
    private static Map<Long, Member> store = new ConcurrentHashMap<>();
    private static Long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);

        return member;
    }

    @Override
    public Member findById(Long id) {
        return store.get(id);
    }

    @Override
    public Member findByEmail(String email) {
        List<Member> members = findByAll();
        for (Member member : members) {
            if(member.getEmail().equals(email))
                return member;
        }
        return null;
    }

    @Override
    public List<Member> findByAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public void delete(Long id) {
        store.remove(id);
    }

    @Override
    public Member update(Long id, Member newMember) {
        newMember.setId(id);
        store.put(newMember.getId(), newMember);
        return findById(newMember.getId());
    }
}
