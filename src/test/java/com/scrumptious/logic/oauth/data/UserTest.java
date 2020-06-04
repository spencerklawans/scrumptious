package com.scrumptious.logic.oauth.data;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

class UserTest {

	@Test
	void testFirstName() {
		User u = new User("John", null, null, null);
		User v = new User(null, null, null, null);
		User w = new User("Billy", "Bob", "bob.bob@me.me", null);
		
		assertEquals("John", u.getFirstName());
		assertNull(v.getFirstName());
		assertEquals("Billy", w.getFirstName());
	}
	
	@Test
	void testLastName() {
		User u = new User(null, "Smith", null, null);
		User v = new User(null, null, null, null);
		User w = new User("Billy", "Bob", "bob.bob@me.me", null);
		
		assertEquals("Smith", u.getLastName());
		assertNull(v.getLastName());
		assertEquals("Bob", w.getLastName());
	}
	
	
	@Test
	void testEmail() {
		User u = new User("Billy", "Bob", "bob.bob@me.me", null);
		
		assertEquals("bob.bob@me.me", u.getEmail());
	}

}
