package com.sociallapp.controller;

import com.sociallapp.daoimpl.UserDaoImpl;
import com.sociallapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserDaoImpl userDaoImpl;

    @PostMapping("/addOrUpdate")
    public User addOrUpdate(@Valid @RequestBody User user){
        return this.userDaoImpl.addOrUpdate(user);
    }

    @GetMapping("/getById/{id}")
    public User getById(@PathVariable("id") Integer id) {
        return this.userDaoImpl.getById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        int res = this.userDaoImpl.delete(id);
        if (res > 0)
            return "Deleted Successfully.";
        return "Something went worng. Can't delete.";
    }

    @GetMapping("/getAll")
    public List<User> getAll(){
        return this.userDaoImpl.getAll();
    }

    @PostMapping("/bulkAddOrUpdate")
    public List<User> bulkAddOrUpdate(@RequestBody List<User> users){
        List<User> addedUsers = new ArrayList<>();
        for (User user:users){
            User u = this.userDaoImpl.addOrUpdate(user);
            addedUsers.add(u);
        }

        return users;
    }

    // Exception handler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
