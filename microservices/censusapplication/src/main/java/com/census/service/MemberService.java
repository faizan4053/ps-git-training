package com.census.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.census.exceptions.MemberNotFoundException;
import com.census.model.Member;
import com.census.repository.MemberRepository;

@Service
public class MemberService {
	
	@Autowired
	private MemberRepository memberRepository;

	public List<Member> findAllMembers() {
		return memberRepository.findAll();
	}

	public Member addMember(Member member) {
		return memberRepository.save(member);
	}

	
	public Member getMember(String memberName) {
		
		return memberRepository.findByMemberName(memberName);
	}

	
	public Optional<Member> getMemberById(Integer id) throws MemberNotFoundException {
		Optional<Member> member = memberRepository.findById(id);
		if(member!=null)
			return member;
		else 
			throw new MemberNotFoundException(id);
	}
	
	
	
}
