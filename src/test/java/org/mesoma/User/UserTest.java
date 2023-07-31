package org.mesoma.User;

import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class UserTest {

    @Test
    void getUserIdTest() {
        //given
        User testUserWithoutIdProvided = new User("James");
        //when
        UUID userId = testUserWithoutIdProvided.getUserId();
        //then
        //Since we generate a random UUID, we can test the version and variant
        assertThat(userId.version()).isEqualTo(4);
        assertThat(userId.variant()).isEqualTo(2);

        //given
        User testUserWithIdProvided = new User(UUID.fromString
                ("1fda7774-b948-42fa-ad35-7eb1a7248e35"),"James");
        //when
        UUID userId2 = testUserWithIdProvided.getUserId();
        UUID dummy = UUID.fromString("1fda7774-b948-42fa-ad35-7eb1a7248e36");
        //then
        assertThat(userId2).isEqualTo(UUID.fromString
                ("1fda7774-b948-42fa-ad35-7eb1a7248e35"));
        assertThat(userId2).isNotEqualTo(dummy);

    }

    @Test
    void setUserIdTest() {
        //given
        User testUserWithIdProvided = new User(UUID.fromString
                ("1fda7774-b948-42fa-ad35-7eb1a7248e35"),"James");

        //when
        UUID dummy = UUID.fromString("2fda7774-c948-52fa-bd35-8eb1a7248e35");
        testUserWithIdProvided.setUserId(dummy);
        //then
        UUID userId = testUserWithIdProvided.getUserId();
        assertThat(userId).isEqualTo(dummy);
    }

    @Test
    void testToString() {
        //given
        User testUserWithIdProvided = new User(UUID.fromString
                ("1fda7774-b948-42fa-ad35-7eb1a7248e35"),"James");
        String userString = testUserWithIdProvided.toString();
        //when
        String expectedString = "User{" +
                "userId=" + "1fda7774-b948-42fa-ad35-7eb1a7248e35" +
                ", firstName='" + "James" + '\'' +
                '}';
        //then
        assertThat(userString).isEqualTo(expectedString);
    }

    @Test
    void testEquals() {
        //given
        User testUserWithIdProvided = new User(UUID.fromString
                ("1fda7774-b948-42fa-ad35-7eb1a7248e35"),"James");
        //when
        User testUserWithIdProvided2 = new User(UUID.fromString
                ("1fda7774-b948-42fa-ad35-7eb1a7248e35"),"James");
        User testUserWithIdProvided3 = new User(UUID.fromString
                ("1fda7774-b948-42fa-ad35-7eb1a7248e35"),"Jamie");
        User testUserWithIdProvided4 = new User(UUID.fromString
                ("1fda7774-b948-42fa-ad35-7eb1a7248e36"),"James");
        //then
        assertThat(testUserWithIdProvided).isEqualTo(testUserWithIdProvided2);
        assertThat(testUserWithIdProvided).isNotEqualTo(testUserWithIdProvided3);
        assertThat(testUserWithIdProvided).isNotEqualTo(testUserWithIdProvided4);
    }

    @Test
    void testHashCode(){
        //given
        User testUserWithIdProvided = new User(UUID.fromString
                ("1fda7774-b948-42fa-ad35-7eb1a7248e35"),"James");
        //when
        int expected = Objects.hash(testUserWithIdProvided.getUserId(), "James");
        //then
        assertThat(testUserWithIdProvided.hashCode()).isEqualTo(expected);


    }

}