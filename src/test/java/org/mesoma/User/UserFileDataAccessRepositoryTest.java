package org.mesoma.User;

import org.junit.jupiter.api.Test;
import org.mesoma.utils.UserIdExistsException;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class UserFileDataAccessRepositoryTest {

    @Test
    void getUsers() {
        UserFileDataAccessRepository actualUserFileDataAccessRepository = new UserFileDataAccessRepository();
        List<User> expectedUsers = actualUserFileDataAccessRepository.users;
        assertSame(expectedUsers, actualUserFileDataAccessRepository.getUsers());
    }

    @Test
    void addNewUser() {
        UserFileDataAccessRepository actualUserFileDataAccessRepository = new UserFileDataAccessRepository();
        User userAdded = new User(UUID.fromString("2fda7774-b948-42fa-ad35-7eb1a7248e34"),"King");
        actualUserFileDataAccessRepository.addNewUser(userAdded);
        User userNotAdded = new User(UUID.fromString("4fda7774-b948-42fa-ad35-7eb1a7248e36"),"Queen");
        List<User> expectedUsers = actualUserFileDataAccessRepository.users;
        assertTrue(expectedUsers.contains(userAdded));
        assertFalse(expectedUsers.contains(userNotAdded));
        //Test exception
        User userAdded2 = new User(UUID.fromString("2fda7774-b948-42fa-ad35-7eb1a7248e34"),"King2");
        assertThatExceptionOfType(UserIdExistsException.class)
                .isThrownBy(() -> {
                    actualUserFileDataAccessRepository.addNewUser(userAdded2);
                }).withMessage("User Id taken, Use a different User Id");
    }
}