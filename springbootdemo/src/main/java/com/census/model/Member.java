package com.census.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
public class Member {
	
	@Id
	@Column(name="id")
	private Integer memberId;
	
	@NotBlank(message="name cannot be empty")
	@Size (min=3, message="Name should have atleast 2 characters")
	@Column(name="membername")
	private String memberName;
	
	
	public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
}
