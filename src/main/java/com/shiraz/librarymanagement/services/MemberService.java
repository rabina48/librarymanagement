package com.shiraz.librarymanagement.services;

import com.shiraz.librarymanagement.domain.Member;
import com.shiraz.librarymanagement.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    //add Member
    public Member addMember(Member member) {
        return memberRepository.save(member);
    }

    //get Member By Id
    public Member getMemberById(Long id) {
        return memberRepository.findById(id).get();
    }

    //get All members
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    //delete a member
    public Member deleteMember(Long id) throws Exception {
        Member member = getMemberById(id);
        if (member == null) {
            throw new Exception("Member does not exist");
        }
        memberRepository.deleteById(id);
        return member;
    }

    //update a member
    public Member updateMember(Long id, Member member) throws Exception {
        Member newMember = getMemberById(id);

        if (newMember == null) {
            throw new Exception("Member does not exist");
        }

        if (newMember.getName() != null) {
            newMember.setName(member.getName());
        }

        if (newMember.getEmail() != null) {
            newMember.setEmail(member.getEmail());
        }

        if (newMember.getPassword() != null) {
            newMember.setPassword(member.getPassword());
        }

        if (newMember.getTotalBooksBorrowed() >= 0) {
            member.setTotalBooksBorrowed(member.getTotalBooksBorrowed());
        }

        if (newMember.getRegisteredDate() != null){
            newMember.setRegisteredDate(member.getRegisteredDate());
        }

        return memberRepository.save(newMember);
    }

}
