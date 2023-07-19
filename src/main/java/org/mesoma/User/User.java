package org.mesoma.User;
//POJO for the user class to create users who want to use rental service

import java.util.Objects;
import java.util.UUID;

public class User {

    private UUID userId;
    private String firstName;

    //User provides first name, and we assign them a random userId
    public User(String firstName) {
        this.userId = UUID.randomUUID();
        this.firstName = firstName;
    }

    public User(UUID userId, String firstName) {
        this.userId = userId;
        this.firstName = firstName;
    }

    public UUID getUserId() {
        return userId;
    }


    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId) && Objects.equals(firstName, user.firstName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, firstName);
    }
}
