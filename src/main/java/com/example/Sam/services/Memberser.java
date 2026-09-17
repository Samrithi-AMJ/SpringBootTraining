package com.example.Sam.services;

import org.springframework.stereotype.Service;
import com.example.Sam.model.Member;
import com.example.Sam.repository.Memberrepo;

import java.util.List;


@Service 
public class Memberser {
    private final Memberrepo memberrepo;
    public Memberser(Memberrepo memberrepo) {
        this.memberrepo = memberrepo;
    }
    public Member addMember(Member member) {
        return memberrepo.save(member);
    }
    public List<Member> getAllMembers() {
        return memberrepo.findAll();
    }
    public Member getMemberById(Long id) {
        return memberrepo.findById(id).orElseThrow(() -> new RuntimeException("Member not found "));
    }
   public Member updateMember(Long id, Member updatedMember) {

    Member existingMember = memberrepo.findById(id)
            .orElseThrow(() -> new RuntimeException("Member not found"));

    existingMember.setName(updatedMember.getName());
    existingMember.setEmail(updatedMember.getEmail());
    existingMember.setPhoneNumber(updatedMember.getPhoneNumber());

    return memberrepo.save(existingMember);
}
    public void deleteMember(Long id) {
        memberrepo.deleteById(id);
    }
    
}
