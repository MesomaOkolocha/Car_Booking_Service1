package org.mesoma.User;

import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.*;

//Data access class for users, we are going to store users using an array
@Repository("UserFile")
public class UserFileDataAccessRepository implements UserDaoInterface {

    static List<User> users = new ArrayList<>();
    static {
        File FILE = new File(Objects.requireNonNull(UserFileDataAccessRepository.class.
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

    public void addNewUser(User user){
        //check if UUID is not taken
        users.add(user);
    }

    public Optional<User> getUserById(UUID userId){
        return users.stream().filter(user -> user.getUserId().equals(userId)).findFirst();
    }

    @Override
    public void deleteCustomerById(UUID userId) {
        users.stream().filter(user -> user.getUserId().equals(userId)).
                findFirst().ifPresent(users::remove);
    }

    @Override
    public boolean existsPersonWithId(UUID id) {
        return users.stream().anyMatch(user -> user.getUserId().equals(id));
    }

}
