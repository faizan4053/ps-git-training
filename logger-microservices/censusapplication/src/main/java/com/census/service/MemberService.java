package com.census.service;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.census.exceptions.MemberNotFoundException;
import com.census.model.Member;
import com.census.repository.MemberRepository;

@Service
public class MemberService {
	
	static Logger log=Logger.getLogger(MemberService.class.getName());
	
	@Autowired
	private MemberRepository memberRepository;

	public List<Member> findAllMembers() {
		List<Member> result=memberRepository.findAll();
		if(result!=null) {
			log.info("retreiving members successfully");
		}
		else {
			log.info("not able to retrieve members");
		}
		return result;
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
