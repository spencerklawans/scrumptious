package com.scrumptious.logic.oauth.data;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MoreUserTest {
    @Test
    public void testEmail() {
        User u = new User("Billy", "Bob", "abc.bob@me.me", null);

        assertEquals("abc.bob@me.me", u.getEmail());
    }

    @Test
    public void testPic() {
        User u = new User("Billy", "Bob", "bob.bob@me.me", "abc.com");

        assertEquals("abc.com", u.getPicture());
    }
}
