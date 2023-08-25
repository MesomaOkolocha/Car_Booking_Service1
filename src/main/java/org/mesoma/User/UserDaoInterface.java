package org.mesoma.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserDaoInterface {
    List<User> getUsers();
    void addNewUser(User user);

    Optional<User> getUserById(UUID userId);

    void deleteCustomerById(UUID userId);
    boolean existsPersonWithId(UUID id);
}
