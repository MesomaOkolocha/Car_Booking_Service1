package org.mesoma.User;
//
//import org.junit.jupiter.api.Test;
//import java.util.UUID;
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//public class UserTest {
//
//    @Test
//    public void testConstructor() {
//        String firstName = "John";
//        User user = new User(firstName);
//
//        assertThat(user.getUserId()).isNotNull();
//    }
//
//    @Test
//    public void testConstructorWithUserId() {
//        UUID userId = UUID.randomUUID();
//        String firstName = "Jane";
//        User user = new User(userId, firstName);
//
//        assertThat(user.getUserId()).isEqualTo(userId);
//    }
//
//    @Test
//    public void testSetUserId() {
//        User user = new User("Alice");
//        UUID newUserId = UUID.randomUUID();
//
//        user.setUserId(newUserId);
//
//        assertThat(user.getUserId()).isEqualTo(newUserId);
//    }
//
//    @Test
//    public void testEqualsAndHashCode() {
//        UUID userId = UUID.randomUUID();
//        String firstName = "Bob";
//        User user1 = new User(userId, firstName);
//        User user2 = new User(userId, firstName);
//
//
//        assertThat(user1).isEqualTo(user2);
//        assertThat(user1.hashCode()).isEqualTo(user2.hashCode());
//    }
//
//    @Test
//    public void testToString() {
//        UUID userId = UUID.fromString("123e4567-e89b-12d3-a456-426655440000");
//        String firstName = "Alice";
//        User user = new User(userId, firstName);
//
//        String expectedToString = "User{userId=123e4567-e89b-12d3-a456-426655440000, firstName='Alice'}";
//        String actualToString = user.toString();
//
//        assertThat(actualToString).isEqualTo(expectedToString);
//    }
//}
