package com.example.Sam.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.PathVariable;
import com.example.Sam.model.Member;
import com.example.Sam.services.Memberser;
import java.util.List;


@RestController
@RequestMapping("/members")
public class Membercon {
    private final Memberser memberser;
    public Membercon(Memberser memberser) {
        this.memberser = memberser;
    }
    @GetMapping
    public List<Member> getAllMembers() {
        return memberser.getAllMembers();
    }
    @GetMapping("/{id}")
    public Member getMemberById(@PathVariable Long id) {
        return memberser.getMemberById(id);
    }
    @PostMapping
    public Member addMember(@RequestBody Member member) {
        return memberser.addMember(member);
    }
    @PutMapping 
    public Member updateMember(@RequestParam Long id, @RequestBody Member updatedMember) {
        return memberser.updateMember(id, updatedMember);
    }
    @DeleteMapping
    public String deleteMember(@RequestParam Long id) {
        memberser.deleteMember(id);
        return "Member with ID " + id + " has been deleted.";
    }
    

}
