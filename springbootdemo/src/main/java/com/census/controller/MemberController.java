package com.census.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.census.exceptions.MemberNotFoundException;
import com.census.model.Member;
import com.census.service.MemberService;



@RestController
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	
	@GetMapping("/members")
	public List<Member> getAllMembers(){
		return memberService.findAllMembers();
	}
	
	@PostMapping("/members")
	public Member addMember(@Valid @RequestBody Member member) {
		return memberService.addMember(member);
	}
	
	@GetMapping("/greet")
	public String getGreetings() {
		return "Hello welocme to spring boot demo";
	}
	
	@GetMapping("/member/{name}")
	public Member getMember(@PathVariable("name") String memberName) {
		return memberService.getMember(memberName);
	}
	
	@GetMapping("/memberbyid/{id}")
	public Optional<Member> getMemberById(@PathVariable("id") Integer id) throws MemberNotFoundException {
		System.out.println(id);
		Optional<Member> member=memberService.getMemberById(id);
		if(!member.isEmpty()) {
			return member;
		}
		else
			throw new MemberNotFoundException(id);
			
	}

}
