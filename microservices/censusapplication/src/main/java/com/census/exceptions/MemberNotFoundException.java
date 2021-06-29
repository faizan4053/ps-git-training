/**
 * 
 */
package com.census.exceptions;

/**
 * @author admi
 *
 */
public class MemberNotFoundException extends RuntimeException {
	
	public MemberNotFoundException() {
		
	}

	public MemberNotFoundException(Integer id) {
		super("Could not find member " + id);
	}
}

