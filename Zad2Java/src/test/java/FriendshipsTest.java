import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class FriendshipsTest {
    private static Friendships sut;

    @BeforeEach
    void setUp() {
        sut = new Friendships();
        sut.makeFriends("Adam", "Magda");
    }

    @AfterEach
    void tearDown() {
        sut = null;
    }

    @Test
    @DisplayName("List contains Key")
    public void testListHasKey() {
        assertThat(sut.friendships, hasKey("Adam"));
    }

    @Test
    @DisplayName("List contains Key")
    public void testListHasKey2() {
        assertThat(sut.friendships, hasKey("Magda"));
    }

    @Test
    @DisplayName("Key 1 has item")
    public void testKeyHasItem() {
        assertThat(sut.friendships, hasEntry(is("Adam"), hasItem("Magda")));
    }

    @Test
    @DisplayName("Key 2 has item")
    public void testKeyHasItem2() {
        assertThat(sut.friendships, hasEntry(is("Magda"), hasItem("Adam")));
    }

    @Test
    @DisplayName("Test method 'areFriends' = true")
    public void testAreFriendsFrue() {
        assertThat(sut.areFriends("Adam", "Magda"), is(true));
    }

    @Test
    @DisplayName("Test method 'areFriends' = false")
    public void testAreFriendsFalse() {
        assertThat(sut.areFriends("Adam", "Ola"), not(true));
    }

    @Test
    @DisplayName("Test method 'getFriendsList'")
    public void testGetFriendsListTrue() {
        assertThat(sut.getFriendsList("Adam"), notNullValue());
    }

    @Test
    @DisplayName("Test method 'getFriendsList'")
    public void testGetFriendsListTrue2() {
        assertThat(sut.getFriendsList("Magda"), notNullValue());
    }
}
