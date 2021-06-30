package com.census.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.census.model.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer>{
	
	@Query("select u from Member u where u.memberName = ?1")
	 public Member findByMemberName(String memberName);

}
