package com.example.member.service;

import com.example.member.dto.MemberDTO;
import com.example.member.entity.MemberEntity;
import com.example.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private MemberRepository memberRepository;
    public void save(MemberDTO memberDTO) {
        //dto->entity 변환
        //repository의 save 호출
        MemberEntity memberEntity = MemberEntity.toMemberEntity(memberDTO);
        memberRepository.save(memberEntity);
    }

    public MemberDTO login(MemberDTO memberDTO) {
        /*
        1. 회원이 입력한 이메일로 db조회
        2. db조회결과 비밀번호와 사용자 입력이 일치하는 지 판단
         */
        Optional<MemberEntity> byMemberEmail = memberRepository.findByMemberEmail(memberDTO.getMemberEmail());
        if (byMemberEmail.isPresent()) {
            //조회결과 있음
            MemberEntity memberEntity = byMemberEmail.get();
            if (memberEntity.getMemberPassword().equals(memberDTO.getMemberPassword())) {
                //비밀번호 일치
                //entity ->dto 변환
                MemberDTO dto = MemberDTO.toMemberDTO(memberEntity);
                return dto;
            } else {
                return null;
            }
        } else {
            //조회결과 없음
            return null;
        }
    }

    public List<MemberDTO> findAll() {
        List<MemberEntity> memberEntityList = memberRepository.findAll();
        List<MemberDTO> memberDTOList = new ArrayList<>();
        for (MemberEntity memberEntity : memberEntityList) {
            memberDTOList.add(MemberDTO.toMemberDTO(memberEntity));
        }
        return memberDTOList;
    }

    public MemberDTO findById(Long id) {
        Optional<MemberEntity> optiionalMemberentity = memberRepository.findById(id);
        if (optiionalMemberentity.isPresent()) {
            return MemberDTO.toMemberDTO(optiionalMemberentity.get());
        } else {
            return null;
        }
    }

    public MemberDTO updateForm(String myEmail) {
        Optional<MemberEntity> optionalMemberEntity = memberRepository.findByMemberEmail(myEmail);
        if (optionalMemberEntity.isPresent()) {
            return MemberDTO.toMemberDTO((optionalMemberEntity.get()));
        }else {
            return null;
        }
    }

    public void update(MemberDTO memberDTO) {
        memberRepository.save(MemberEntity.toUpdateMemberEntity(memberDTO));

    }

    public void deleteById(Long id) {
        memberRepository.deleteById(id);
    }
}
