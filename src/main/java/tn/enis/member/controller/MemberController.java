package tn.enis.member.controller;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tn.enis.member.entities.Member;
import tn.enis.member.services.MemberService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/members")
@CrossOrigin("*")
@AllArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping
    public ResponseEntity<List<Member>> getAllMembers () {
        List<Member> members = memberService.findAll();
        return new ResponseEntity<>(members, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Member>> getMemberById (@PathVariable Long id) {
        Optional<Member> member = memberService.findMember(id);
        return new ResponseEntity<>(member, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Member> addMember (@Validated @RequestBody Member member) {
        Member newClient = memberService.addMember(member);
        return new ResponseEntity<>(newClient, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMember (@PathVariable("id") Long id) {
        memberService.deleteMember(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Member> updateClient (@RequestBody Member member) {
        Member updatedMember = memberService.updateMember(member);
        return new ResponseEntity<>(updatedMember, HttpStatus.OK);
    }


    @GetMapping("/fullmember/{id}")
    public Member findAFullMember(@PathVariable(name="id") Long id)
    {

        Optional<Member> mbr=memberService.findMember(id);
        if(mbr.isPresent()){
            mbr.get().setPubs(memberService.findPublicationParAuteur(id));
            return mbr.get();
        }
        return null;
    }
}