package org.mesoma.User;

import java.io.File;
import java.io.IOException;
import java.util.*;

//Data access class for users, we are going to store users using an array
public class UserFileDataAccessService implements UserDaoInterface {

    static List<User> users = new ArrayList<>();
    static {
        File FILE = new File(Objects.requireNonNull(UserFileDataAccessService.class.
                getClassLoader().getResource("users.csv")).getPath());
        try {
            Scanner scanner = new Scanner(FILE);
            while (scanner.hasNext()) {
                String[] data = scanner.nextLine().split(",");
                users.add(new User(UUID.fromString(data[0]), data[1]));
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
