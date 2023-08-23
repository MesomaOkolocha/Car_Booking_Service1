package org.mesoma.User;
//
//import org.junit.jupiter.api.Test;
//import org.mesoma.utils.UserIdException;
//import java.util.UUID;
//import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
//import org.junit.jupiter.api.BeforeEach;
//import org.mockito.MockitoAnnotations;
//import java.util.Optional;
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//
//public class UserFakerDataAccessRepositoryTest {
//
//    private UserFakerDataAccessRepository userRepository;
//
//    @BeforeEach
//    public void setUp() {
//        MockitoAnnotations.openMocks(this);
//        userRepository = new UserFakerDataAccessRepository();
//        userRepository.getUsers().clear();
//    }
//
//    @Test
//    public void testAddNewUser() {
//        User newUser = new User("John");
//
//        userRepository.addNewUser(newUser);
//        assertThat(newUser).isIn(userRepository.getUsers());
//    }
//
//    @Test
//    public void testAddNewUserWithTakenUserId() {
//        User existingUser = new User("Alice");
//        userRepository.getUsers().add(existingUser);
//        User newUser = new User(existingUser.getUserId(), "Bob");
//
//        assertThatThrownBy(() -> userRepository.addNewUser(newUser))
//                .isInstanceOf(UserIdException.class)
//                .hasMessage("User Id taken, Use a different User Id");
//    }
//
//    @Test
//    public void testGetUserById() {
//        UUID userId = UUID.randomUUID();
//        User user = new User(userId, "Jane");
//        userRepository.getUsers().add(user);
//
//        Optional<User> result = userRepository.getUserById(userId);
//
//        assertThat(result).isPresent().contains(user);
//    }
//
//    @Test
//    public void testGetUserByIdNonExistent() {
//        UUID userId = UUID.randomUUID();
//
//        Optional<User> result = userRepository.getUserById(userId);
//
//        assertThat(result).isEmpty();
//    }
//}
