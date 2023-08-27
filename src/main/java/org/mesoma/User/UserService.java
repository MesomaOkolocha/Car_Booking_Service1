package org.mesoma.User;

import org.mesoma.utils.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
//Service class for User
@Service
public class UserService {
    private final UserDaoInterface userDaoInterface;


    public UserService(@Qualifier("UserJPA") UserDaoInterface userDaoInterface){
        this.userDaoInterface = userDaoInterface;
    }

    public List<User> getUsers(){
        return (userDaoInterface.getUsers());
    }

    public User getUserById(UUID userId){
        return userDaoInterface.getUserById(userId).orElseThrow(() ->
                new ResourceNotFoundException("customer with id [%s] not found".formatted(userId))
        );
    }
    public void addNewUser(User user){
        userDaoInterface.addNewUser(user);
    }

    public void registerNewUser(UserRegistrationRequest userRegistrationRequest){
        User user = new User(userRegistrationRequest.name());
        userDaoInterface.addNewUser(user);
    }

    public void deleteUserById(UUID userId){
        //check if id exists
        if (!userDaoInterface.existsPersonWithId(userId)){
            throw new ResourceNotFoundException(
                    "user with id [%s] not found".formatted(userId)
            );
        }
        userDaoInterface.deleteCustomerById(userId);
    }
}
