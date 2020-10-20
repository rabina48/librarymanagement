package com.shiraz.librarymanagement.controllers;

import com.shiraz.librarymanagement.domain.Member;
import com.shiraz.librarymanagement.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("{id}")
    public Member getMemberById(@PathVariable("id") Long id){
        return memberService.getMemberById(id);
    }

    @GetMapping("")
    public List<Member> getAllMembers(){
        return memberService.getAllMembers();
    }

    @PostMapping("")
    public Member addMember(@RequestBody Member member){
        return memberService.addMember(member);
    }

    @DeleteMapping("{id}")
    public Member deleteMemberById(@PathVariable("id") Long id) throws Exception{
        return memberService.deleteMember(id);
    }

    @PatchMapping("{id}")
    public Member updateMember(@PathVariable("id") Long id, @RequestBody Member member) throws Exception{
        return memberService.updateMember(id, member);
    }

}
