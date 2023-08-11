package org.mesoma.User;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.*;
import org.mesoma.utils.UserIdException;
import java.util.ArrayList;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    private UserService userService;
    private UserDaoInterface userDaoInterface;

    @BeforeEach
    public void setUp() {
        userDaoInterface = mock(UserDaoInterface.class);
        userService = new UserService(userDaoInterface);
    }

    @AfterEach
    public void tearDown() {
        userDaoInterface = null;
        userService = null;
    }

    @Test
    public void testGetUsers() {
        List<User> mockUsers = new ArrayList<>();
        when(userDaoInterface.getUsers()).thenReturn(mockUsers);

        List<User> users = userService.getUsers();

        assertNotNull(users);
        assertEquals(mockUsers, users);

        verify(userDaoInterface, times(1)).getUsers();
    }

    @Test
    public void testGetUserById() {
        UUID userId = UUID.randomUUID();
        User mockUser = new User(userId, "TestUser");
        when(userDaoInterface.getUserById(userId)).thenReturn(Optional.of(mockUser));

        User user = userService.getUserById(userId);

        assertNotNull(user);
        assertEquals(mockUser, user);

        verify(userDaoInterface, times(1)).getUserById(userId);
    }

    @Test
    public void testGetUserByIdNotFound() {
        UUID userId = UUID.randomUUID();
        when(userDaoInterface.getUserById(userId)).thenReturn(Optional.empty());

        assertThrows(UserIdException.class, () -> userService.getUserById(userId));

        verify(userDaoInterface, times(1)).getUserById(userId);
    }

    @Test
    public void testAddNewUser() {
        User newUser = new User(UUID.randomUUID(), "NewUser");

        userService.addNewUser(newUser);

        verify(userDaoInterface, times(1)).addNewUser(newUser);
    }
}
