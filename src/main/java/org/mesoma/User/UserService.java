package org.mesoma.User;

import java.util.List;
import java.util.UUID;

//Service class for User
public class UserService {

    private UserFileDataAccessService userFileDataAccessService;
    private UserFakerDataAccessService userFakerDataAccessService;
    public UserService(UserFileDataAccessService userFileDataAccessService) {
        this.userFileDataAccessService = userFileDataAccessService;
    }
    public UserService(UserFakerDataAccessService userFakerDataAccessService){
        this.userFakerDataAccessService = userFakerDataAccessService;
    }

    //retrieve All Users from database
    public List<User> getUsers(){
        return (userFakerDataAccessService.getUsers());
    }

    //retrieve a specific user from database
    public User getUserById(UUID userId){
        List<User> users = userFakerDataAccessService.getUsers();
        try{
            //used java streams for functional programming for fast processing
            return users.stream().filter(user -> user.getUserId().equals(userId)).findFirst().orElse(null);
        }catch(NullPointerException e){
            throw new NullPointerException();
        }
    }

    public void addNewUser(User user){
        userFakerDataAccessService.addNewUser(user);
    }
}
