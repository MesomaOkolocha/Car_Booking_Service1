package org.mesoma.User;

import java.util.List;
import java.util.UUID;

//Service class for User
public class UserService {

    private UserFakerDataAccessRepository userFakerDataAccessRepository;

    public UserService(UserFakerDataAccessRepository userFakerDataAccessRepository){
        this.userFakerDataAccessRepository = userFakerDataAccessRepository;
    }

    //retrieve All Users from database
    public List<User> getUsers(){
        return (userFakerDataAccessRepository.getUsers());
    }

    //retrieve a specific user from database
    public User getUserById(UUID userId){
        List<User> users = userFakerDataAccessRepository.getUsers();
        try{
            //used java streams for functional programming for fast processing
            return users.stream().filter(user -> user.getUserId().equals(userId)).findFirst().orElse(null);
        }catch(NullPointerException e){
            throw new NullPointerException();
        }
    }

    public void addNewUser(User user){
        userFakerDataAccessRepository.addNewUser(user);
    }
}
