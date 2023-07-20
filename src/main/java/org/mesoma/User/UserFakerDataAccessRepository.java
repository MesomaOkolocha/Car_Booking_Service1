package org.mesoma.User;
import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserFakerDataAccessRepository implements UserDaoInterface{
    static List<User> users = new ArrayList<>();

    static{
        Faker faker = new Faker();
        for (int i = 0; i <= 20 ; i++) {
            User user = new User(faker.name().firstName());
            users.add(user);
        }
    }
    @Override
    public List<User> getUsers() {
        return users;
    }

    protected void addNewUser(User user){
        //check if UUID is not taken
        for (User value : users) {
            if (user.getUserId().equals(value.getUserId())) {
                System.out.println("UserId taking\n" + "Reassigning userId...");
                user.setUserId(UUID.randomUUID());
            }
        }
        users.add(user);
    }

}
