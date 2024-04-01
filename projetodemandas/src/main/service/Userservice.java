

public interface Userservice {

User createUser (User user);
User getUserById(Long UserId);
List<User> getAllUser();
User updateUser(User user);

void  deleteUser(Long userId);

}
