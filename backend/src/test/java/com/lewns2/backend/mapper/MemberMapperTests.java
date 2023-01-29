package com.lewns2.backend.mapper;


import com.lewns2.backend.model.Member;
import com.lewns2.backend.model.Role;
import com.lewns2.backend.rest.dto.MemberDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

public class MemberMapperTests {

    @Test
    public void toMemberDto_테스트() {
        // given
        Member memberA = new Member();
        memberA.setEmail("test@naver.com");

        // when
        MemberDto memberDto = MemberMapper.INSTANCE.toMemberDto(memberA);

        // then
        assertThat(memberDto).isNotNull();
        assertThat(memberDto.getEmail()).isEqualTo("test@naver.com");
    }

    @Test
    public void toMember_테스트() {
        // given
        Member memberA = new Member();
        memberA.setEmail("test2@naver.com");

        // when
        MemberDto memberDto = MemberMapper.INSTANCE.toMemberDto(memberA);

        Member newMember = MemberMapper.INSTANCE.toMember(memberDto);

        // then
        assertThat(newMember).isNotNull();
        assertThat(newMember.getEmail()).isEqualTo("test2@naver.com");

    }
}
