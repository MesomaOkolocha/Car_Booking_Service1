package org.mesoma.User;
import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;

public class UserFakerDataAccessService implements UserDaoInterface{
    final List<User> users = new ArrayList<>();
    @Override
    public List<User> getUsers() {
        if (users.isEmpty()){
            createUsers();
        }
        return users;
    }

    public List<User> createUsers() {
        Faker faker = new Faker();
        //List<User> users = new ArrayList<>();
        for (int i = 0; i <= 20 ; i++) {
            User user = new User(faker.name().firstName());
            users.add(user);
        }
        return users;
    }

}
