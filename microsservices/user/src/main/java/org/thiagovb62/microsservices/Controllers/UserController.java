package org.thiagovb62.microsservices.Controllers;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thiagovb62.microsservices.Model.DTO.CreateUserDto;
import org.thiagovb62.microsservices.Model.DTO.ResponseUseDto;
import org.thiagovb62.microsservices.Model.User;
import org.thiagovb62.microsservices.Producers.UserProducer;
import org.thiagovb62.microsservices.Repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserRepository userRepository;
    final UserProducer userProducer;

    UserController (UserRepository userRepository, UserProducer userProducer) {
        this.userRepository = userRepository;
        this.userProducer = userProducer;

    }

    @PostMapping("/create")
    @Transactional
    public ResponseEntity<ResponseUseDto> createUser(@RequestBody @Valid CreateUserDto userDTO) {
        User user = new User(userDTO);
        userRepository.save(user);
        userProducer.publishMessageEmail(user);
        return ResponseEntity.ok(new ResponseUseDto(user));
    }



}


