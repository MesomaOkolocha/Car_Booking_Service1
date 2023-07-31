package org.mesoma.User;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mesoma.utils.UserIdExistsException;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class UserFakerDataAccessRepositoryTest {


    @Test
    void getUsers() {
        UserFakerDataAccessRepository actualUserFakerDataAccessRepository = new UserFakerDataAccessRepository();
        List<User> expectedUsers = actualUserFakerDataAccessRepository.users;
        assertSame(expectedUsers, actualUserFakerDataAccessRepository.getUsers());
    }

    @Test
    void addNewUser() {
        UserFakerDataAccessRepository actualUserFakerDataAccessRepository = new UserFakerDataAccessRepository();
        User userAdded = new User(UUID.fromString("3fda7774-b948-42fa-ad35-7eb1a7248e34"),"Jan");
        actualUserFakerDataAccessRepository.addNewUser(userAdded);
        User userNotAdded = new User(UUID.fromString("4fda7774-b948-42fa-ad35-7eb1a7248e36"),"Queen");
        List<User> expectedUsers = actualUserFakerDataAccessRepository.users;
        assertTrue(expectedUsers.contains(userAdded));
        assertFalse(expectedUsers.contains(userNotAdded));
        //Test exception
        User userAdded2 = new User(UUID.fromString("3fda7774-b948-42fa-ad35-7eb1a7248e34"),"King2");
        assertThatExceptionOfType(UserIdExistsException.class)
                .isThrownBy(() -> {
                    actualUserFakerDataAccessRepository.addNewUser(userAdded2);
                }).withMessage("User Id taken, Use a different User Id");
    }

}