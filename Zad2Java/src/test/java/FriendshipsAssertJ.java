import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FriendshipsAssertJ {

    private static Friendships sut;

    @BeforeEach
    void setUp(){
        sut = new Friendships();
        sut.makeFriends("Adam", "Magda");
    }

    @AfterEach
    void tearDown(){
        sut = null;
    }

    @Test
    @DisplayName("List contains Key")
    public void testListHasKey() {
        assertThat(sut.friendships).containsKey("Adam");
    }

    @Test
    @DisplayName("List contains Key")
    public void testListHasKey2() {
        assertThat(sut.friendships).containsKey("Magda");
    }

    @Test
    @DisplayName("Key 1 has item")
    public void testKeyHasItem1(){
        assertThat(sut.getFriendsList("Adam")).contains("Magda");
    }

    @Test
    @DisplayName("Key 2 has item")
    public void testKeyHasItem2(){
        assertThat(sut.getFriendsList("Magda")).contains("Adam");
    }

    @Test
    @DisplayName("Test method 'areFriends' = true")
    public void testAreFriendsTrue(){
        assertThat(sut.areFriends("Adam", "Magda")).isTrue();
    }

    @Test
    @DisplayName("Test method 'areFriends' = false")
    public void testAreFriendsFalse(){
        assertThat(sut.areFriends("Adam", "Ola")).isFalse();
    }

    @Test
    @DisplayName("Test method 'getFriendsList'")
    public void testGetFriendsListTrue(){
        assertThat(sut.getFriendsList("Adam")).isNotNull();
    }

    @Test
    @DisplayName("Test method 'getFriendsList'")
    public void testGetFriendsListTrue2(){
        assertThat(sut.getFriendsList("Magda")).isNotNull();
    }
}
