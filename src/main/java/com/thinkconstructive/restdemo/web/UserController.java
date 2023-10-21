package com.thinkconstructive.restdemo.web;

import com.thinkconstructive.restdemo.model.User;
import com.thinkconstructive.restdemo.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private final UserRepository repository;

    public UserController(UserRepository repositoryArg) {
        repository= repositoryArg;
    }

    @GetMapping( "/users" )
    public List<User> getAll() {
        List<User>result= repository.findAll();
        for(User user: result) {
            user.setVorname(user.getVorname()+" "+user.getNachname());
            user.setNachname("");
        }
        return result;
    }

    @PostMapping( "/users" )
    @ResponseStatus( HttpStatus.CREATED )
    public User create( @RequestBody User user ) throws Exception
    {
        if(user.getNachname().isEmpty() || user.getEmail().isEmpty()) throw new Exception();
        return repository.save( user );
    }

    @DeleteMapping( "users/{id}" )
    public void delete( @PathVariable Long id ) throws Exception {
        repository.findById( id ).orElseThrow( Exception::new );
        repository.deleteById( id );
    }
}
