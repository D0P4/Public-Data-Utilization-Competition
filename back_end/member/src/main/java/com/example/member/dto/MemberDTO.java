package com.example.member.dto;

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
}
