package org.mesoma.User;
//
//import org.junit.jupiter.api.Test;
//import org.mesoma.utils.UserIdException;
//import java.util.List;
//import java.util.UUID;
//import static org.junit.jupiter.api.Assertions.*;
//import org.junit.jupiter.api.*;
//import java.util.Optional;
//public class UserFileDataAccessRepositoryTest {
//
//    private UserFileDataAccessRepository userRepository;
//
//    @BeforeEach
//    public void setUp() {
//        userRepository = new UserFileDataAccessRepository();
//    }
//
//    @AfterEach
//    public void tearDown() {
//        userRepository = null;
//    }
//
//    @Test
//    public void testGetUsers() {
//        List<User> users = userRepository.getUsers();
//        assertNotNull(users);
//        assertFalse(users.isEmpty());
//    }
//
//    @Test
//    public void testAddNewUser() {
//        User newUser = new User(UUID.randomUUID(), "NewUser");
//        userRepository.addNewUser(newUser);
//
//        List<User> users = userRepository.getUsers();
//        assertTrue(users.contains(newUser));
//    }
//
//    @Test
//    public void testAddUserWithExistingId() {
//        User existingUser = userRepository.getUsers().get(0);
//
//        assertThrows(UserIdException.class, () -> userRepository.addNewUser(existingUser));
//    }
//
//    @Test
//    public void testGetUserById() {
//        List<User> users = userRepository.getUsers();
//        if (!users.isEmpty()) {
//            User user = users.get(0);
//            Optional<User> retrievedUser = userRepository.getUserById(user.getUserId());
//            assertTrue(retrievedUser.isPresent());
//            assertEquals(user, retrievedUser.get());
//        }
//    }
//
//    @Test
//    public void testGetNonExistentUserById() {
//        UUID nonExistentUserId = UUID.randomUUID();
//        Optional<User> retrievedUser = userRepository.getUserById(nonExistentUserId);
//        assertFalse(retrievedUser.isPresent());
//    }
//}
