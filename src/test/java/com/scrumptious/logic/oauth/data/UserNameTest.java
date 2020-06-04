package com.scrumptious.logic.oauth.data;

import static org.junit.Assert.*;

import org.junit.Test;

public class UserNameTest {

	@Test
	public void testFirstName() {
		User u = new User("John", null, null, null);
		User v = new User(null, null, null, null);
		User w = new User("Billy", "Bob", "abc.bob@me.me", null);
		
		assertEquals("John", u.getFirstName());
		assertNull(v.getFirstName());
		assertEquals("Billy", w.getFirstName());
	}
	
	@Test
	public void testLastName() {
		User u = new User(null, "Smith", null, null);
		User v = new User(null, null, null, null);
		User w = new User("Billy", "Bob", "def.bob@me.me", null);
		
		assertEquals("Smith", u.getLastName());
		assertNull(v.getLastName());
		assertEquals("Bob", w.getLastName());
	}
}
