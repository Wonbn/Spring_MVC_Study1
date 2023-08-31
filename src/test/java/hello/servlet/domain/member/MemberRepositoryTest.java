package hello.servlet.domain.member;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void save() {
        //given (member 생성)
        Member member = new Member("hello", 20);

        //when (member 저장)
        Member saveMember = memberRepository.save(member);
        assertEquals(saveMember, member);

        //then (member 조회 By id)
        Member findMember = memberRepository.findById(saveMember.getId());
        assertEquals(findMember, saveMember);
    }

    @Test
    void findById() {
        //given
        Member member1 = new Member("hello1", 23);
        Member member2 = new Member("hello2", 25);
        memberRepository.save(member1);
        memberRepository.save(member2);

        //when
        Member findMember1 = memberRepository.findById(1L);
        Member findMember2 = memberRepository.findById(2L);

        //then
        assertEquals(findMember1, member1);
        assertEquals(findMember2, member2);
    }

    @Test
    void findAll() {
        //given
        Member member1 = new Member("hello1", 23);
        Member member2 = new Member("hello2", 25);
        Member member3 = new Member("hello3", 27);
        memberRepository.save(member1);
        memberRepository.save(member2);
        memberRepository.save(member3);

        //when
        List<Member> findMembers = memberRepository.findAll();

        //then
        assertEquals(3, findMembers.size());
        assertThat(findMembers).contains(member1, member2, member3);
    }
}