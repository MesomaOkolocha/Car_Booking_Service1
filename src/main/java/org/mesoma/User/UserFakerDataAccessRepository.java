package org.mesoma.User;
import com.github.javafaker.Faker;
import org.mesoma.utils.UserIdException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public class UserFakerDataAccessRepository implements UserDaoInterface{
    static List<User> users = new ArrayList<>();

    static{
        Faker faker = new Faker();
        for (int i = 0; i <= 20 ; i++) {
            User user = new User(faker.name().firstName());
            users.add(user);
        }
    }
    public List<User> getUsers() {
        return users;
    }

    public void addNewUser(User user){
        //check if UUID is not taken
        for (User value : users) {
            if (user.getUserId().equals(value.getUserId())) {
                throw new UserIdException("User Id taken, Use a different User Id");
            }
        }
        users.add(user);
    }

    public Optional<User> getUserById(UUID userId){
        return users.stream().filter(user -> user.getUserId().equals(userId)).findFirst();
    }

}
