package com.sg.rest.webservices.restfulwebservices.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import jakarta.validation.Valid;

@RestController
public class UserResource {
private UserDAOService userDAOService;

    public UserResource(UserDAOService userDAOService) {
        this.userDAOService = userDAOService;
    }

    @GetMapping(path ="/users" )
    public List<User> findAll(){
        return userDAOService.findAll();
    }

    @PostMapping(path = "/postusers")
    public ResponseEntity<User> saveUser(@Valid @RequestBody User user){
        User saveUser=userDAOService.saveUser(user);
       URI location =ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saveUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping(path="/users/{id}")
    public User findUser(@PathVariable Integer id){
        User user = userDAOService.findUser(id);
        if(user==null){
            throw new UserNotFoundException("id: "+id);
        }
        return user;
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        userDAOService.deleteByID(id);
    }



}
