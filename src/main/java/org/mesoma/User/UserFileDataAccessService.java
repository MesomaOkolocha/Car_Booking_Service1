package org.mesoma.User;

import java.io.File;
import java.io.IOException;
import java.util.*;

//Data access class for users, we are going to store users using an array
public class UserFileDataAccessService implements UserDaoInterface {
    File FILE = new File(Objects.requireNonNull(getClass().
            getClassLoader().getResource("users.csv")).getPath());

    //retrieve users from the database
    @Override
    public List<User> getUsers(){
        List<User> users = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(FILE);
            while (scanner.hasNext()) {
                String[] data = scanner.nextLine().split(",");
                users.add(new User(UUID.fromString(data[0]), data[1]));
            }
            scanner.close(); // Close the scanner after reading the file
            return users;
        } catch (IOException e ) {
            throw new IllegalStateException(e);
        }
    }
}
