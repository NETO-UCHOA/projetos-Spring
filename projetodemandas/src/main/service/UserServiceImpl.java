import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor

public class UserServiceImpl implements Userservice {

private UserRepository userRepository;

@Override
public User createdUser(User user){
    return userRepository.save(user);
}
@Override
public User getUserById(Long userId){
    Optional<User> opitionalUser = userRepository.findById(userId);
    return opitionalUser.get();
}

@Override
public List<User> getAllUser(){
    return userRepository.findByAll();
}

@Override
public User updateUser(User user){
User existinUser = userRepository.findById(user.getId()).get();
existinUser.setnome(user.getnome());
existinUser.setsobrenome(user.getsobrenome());
existinUser.setemail(user.getemail());
existinUser.setsenha(user.getsenha());
existinUser.settelefone(user.gettelefone());
existinUser.setendereço(user.getendereço());
User updateUser = userRepository.save(existinUser);
return updateUser;
}

@Override
public void deleteUser (Long userId){
    userRepository.deleteById(userId);
}


}
