package com.example.member.dto;

import com.example.member.entity.MemberEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor //기본생성자 자동
@ToString
public class MemberDTO {//회원정보 필드
    private Long id;
    private String memberEmail;
    private String memberPassword;
    private String memberName;

    public static MemberDTO toMemberDTO(MemberEntity memberEntity) {
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setId(memberEntity.getId());
        memberDTO.setMemberEmail(memberEntity.getMemberEmail());
        memberDTO.setMemberPassword(memberEntity.getMemberPassword());
        memberDTO.setMemberName(memberEntity.getMemberName());
        return memberDTO;
    }
}
