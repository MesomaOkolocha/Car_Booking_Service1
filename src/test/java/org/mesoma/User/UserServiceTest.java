package org.mesoma.User;

import org.junit.jupiter.api.Test;
import org.mesoma.utils.UserIdExistsException;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    @Test
    void getUsers() {
        UserFakerDataAccessRepository actualUserFakerDataAccessRepository = new UserFakerDataAccessRepository();
        UserService actualUserService = new UserService(actualUserFakerDataAccessRepository);
        List<User> expectedUsers = actualUserService.getUsers();
        assertThat(actualUserService.getUsers()).isEqualTo(expectedUsers);

    }

    @Test
    void getUserById() {
        UserFakerDataAccessRepository actualUserFakerDataAccessRepository = new UserFakerDataAccessRepository();
        UserService actualUserService = new UserService(actualUserFakerDataAccessRepository);
        User userAdded = new User(UUID.fromString("2fda7774-b948-42fa-ad35-7eb1a7248e34"),"King");
        actualUserService.addNewUser(userAdded);
        assertThat(actualUserService.getUserById(UUID.fromString("2fda7774-b948-42fa-ad35-7eb1a7248e34"))
        ).isEqualTo(userAdded);
        assertThat(actualUserService.getUserById(UUID.fromString("2fda7774-b948-42fa-ad35-7eb1a7248e35"))
        ).isEqualTo(null);

    }

}