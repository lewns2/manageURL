package com.lewns2.backend.mapper;

import com.lewns2.backend.model.Member;
import com.lewns2.backend.rest.dto.MemberDto;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-30T01:17:07+0900",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 11.0.13 (Azul Systems, Inc.)"
)
public class MemberMapperImpl implements MemberMapper {

    @Override
    public MemberDto toMemberDto(Member member) {
        if ( member == null ) {
            return null;
        }

        String email = null;

        email = member.getEmail();

        MemberDto memberDto = new MemberDto( email );

        return memberDto;
    }

    @Override
    public Member toMember(MemberDto memberDto) {
        if ( memberDto == null ) {
            return null;
        }

        Member member = new Member();

        member.setEmail( memberDto.getEmail() );

        return member;
    }
}
