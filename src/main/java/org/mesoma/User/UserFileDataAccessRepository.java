package org.mesoma.User;

import org.mesoma.utils.UserIdException;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.*;

//Data access class for users, we are going to store users using an array
@Repository("file")
public class UserFileDataAccessRepository implements UserDaoInterface {

    static List<User> users = new ArrayList<>();
    static {
        File FILE = new File(Objects.requireNonNull(UserFileDataAccessRepository.class.
                getClassLoader().getResource("users.csv")).getPath());
        try {
            Scanner scanner = new Scanner(FILE);
            while (scanner.hasNext()) {
                String[] data = scanner.nextLine().split(",");
                users.add(new User(Integer.parseInt(data[0]), data[1]));
            }
            scanner.close(); // Close the scanner after reading the file
        } catch (IOException e ) {
            throw new IllegalStateException(e);
        }
    }

    @Override
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

    public Optional<User> getUserById(Integer userId){
        return users.stream().filter(user -> user.getUserId().equals(userId)).findFirst();
    }

}
