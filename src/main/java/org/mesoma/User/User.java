package org.mesoma.User;
//POJO for the user class to create users who want to use rental service

import java.util.Objects;
import java.util.UUID;

public class User {

    private UUID userId;
    private String name;

    //User provides first name, and we assign them a random userId
    public User(String name) {
        this.userId = UUID.randomUUID();
        this.name = name;
    }

    //This constructor is used when we are given users with userId and firstName provided
    public User(UUID userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public UUID getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", firstName='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId) && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, name);
    }
}
