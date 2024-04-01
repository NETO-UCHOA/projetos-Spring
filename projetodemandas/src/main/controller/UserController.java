import org.hibernate.mapping.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("api/user")

public class UserController {

 private UserService userService;

 //contruir API
 @PostMapping
 public ResponseEntity<User> createUser(@RequestBody User user){
    User saveUser = userservice.createUser(user);
    return new ResponseEntity<>(saveUser,HttpStatus.CREATED);
 }

//construir usuário por ID
// http://localhost:8080/api/users/1
@GetMapping("{id}")
public ResponseEntity<User> getUserById(@PathVariable("id") Long userId){
    User user = userService.getUserById(userId);
    return new ResponseEntity<>(user,HttpStatus.OK);
}

//listar todos os usuários
// http://localhost:8080/api/users
 
@GetMapping
public ResponseEntity<List<User>> getAllUser(){
    List<User> user = userService.getAllUser();
    return new ResponseEntity<>(user,HttpStatus.OK);
}

//Api de Update
// http://localhost:8080/api/users/1

@PutMapping("{id}")
public ResponseEntity<User> updateUser(@PathVariable("id") Long userId, @RequestBody User user){
    user.setId(userId);
    User updateUser = userService.updateUser(user);
    return new ResponseEntity<>(updateUser, HttpStatus.OK);
}

//Api delete
@DeleteMapping("{id}")
public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){
    userService.deleteUser(userId);
    return new ResponseEntity<>("Usuário Deletado", HttpStatusCode.OK);
}


}
