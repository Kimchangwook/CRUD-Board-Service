package com.changwook.boardservice.member.dao;

import com.changwook.boardservice.member.entity.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemberDaoMapImplTest {

    private MemberDao memberDaoMap;

    @BeforeEach
    void init(){
        memberDaoMap = new MemberDaoMapImpl();
    }

    @Test
    void save() {
        Member member = new Member("example@example.com", "zxc123", "User", "Nick");

        memberDaoMap.save(member);

        Member findMember = memberDaoMap.findById(member.getId());
        assertThat(findMember.getId()).isEqualTo(member.getId());
        assertThat(findMember.getEmail()).isEqualTo(member.getEmail());
        assertThat(findMember.getPassword()).isEqualTo(member.getPassword());
        assertThat(findMember.getName()).isEqualTo(member.getName());
        assertThat(findMember.getNickName()).isEqualTo(member.getNickName());
    }

    @Test
    void findByEmail() {

        Member member = new Member("example@example.com", "zxc123", "User", "Nick");

        memberDaoMap.save(member);

        Member findMember = memberDaoMap.findByEmail(member.getEmail());
        assertThat(findMember.getId()).isEqualTo(member.getId());
        assertThat(findMember.getEmail()).isEqualTo(member.getEmail());
        assertThat(findMember.getPassword()).isEqualTo(member.getPassword());
        assertThat(findMember.getName()).isEqualTo(member.getName());
        assertThat(findMember.getNickName()).isEqualTo(member.getNickName());
    }

    @Test
    void findAll() {
        Member member1 = new Member("1@email.com", "123", "User1", "Nick1");
        Member member2 = new Member("2@email.com", "123", "User2", "Nick2");
        Member member3 = new Member("3@email.com", "123", "User3", "Nick3");

        memberDaoMap.save(member1);
        memberDaoMap.save(member2);
        memberDaoMap.save(member3);

        List<Member> members = memberDaoMap.findAll();

        assertThat(members).contains(member1, member2, member3);
    }

    @Test
    void delete() {
        Member member = new Member("email@email.com", "password", "Name", "Nick");

        memberDaoMap.save(member);
        memberDaoMap.delete(member.getId());
        Member findMember = memberDaoMap.findById(member.getId());

        assertThat(findMember).isNull();


    }

    @Test
    void update() {
        Member member = new Member("email@email.com", "password", "Name", "Nick");
        Member newMember = new Member("email@email.com", "newPassword", "newName", "newNick");

        memberDaoMap.save(member);
        Member updatedMember = memberDaoMap.update(member.getId(), newMember);

        assertThat(updatedMember.getId()).isEqualTo(newMember.getId());
        assertThat(updatedMember.getEmail()).isEqualTo(newMember.getEmail());
        assertThat(updatedMember.getPassword()).isEqualTo(newMember.getPassword());
        assertThat(updatedMember.getName()).isEqualTo(newMember.getName());
        assertThat(updatedMember.getNickName()).isEqualTo(newMember.getNickName());    }
}