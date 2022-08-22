package com.changwook.boardservice.post.dao;

import com.changwook.boardservice.member.entity.Member;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public interface MemberDao {
    Member save(Member member);
    Member findById(Long id);
    Member findByEmail(String email);
    List<Member> findByAll();
    void delete(Long id);
    Member update(Long id, Member newMember);


}
