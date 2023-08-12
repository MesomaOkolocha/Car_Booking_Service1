package org.mesoma.User;

import org.mesoma.utils.UserIdException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
//Service class for User
@Service
public class UserService {
    private final UserDaoInterface userDaoInterface;


    public UserService(@Qualifier("userFakerDataAccessRepository") UserDaoInterface userDaoInterface){
        this.userDaoInterface = userDaoInterface;
    }

    public List<User> getUsers(){
        return (userDaoInterface.getUsers());
    }

    public User getUserById(UUID userId){
        return userDaoInterface.getUserById(userId).orElseThrow(() ->
                new UserIdException("customer with id [%s] not found".formatted(userId))
        );
    }
    public void addNewUser(User user){
        userDaoInterface.addNewUser(user);
    }
}
