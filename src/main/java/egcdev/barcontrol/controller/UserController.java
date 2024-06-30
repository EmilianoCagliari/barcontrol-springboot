package egcdev.barcontrol.controller;

import egcdev.barcontrol.model.entity.User;
import egcdev.barcontrol.service.interfaces.IUserService;
import org.hibernate.sql.results.graph.entity.EntityResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService userService;


    @GetMapping("/")
    public String testUser(){
        return "Test UserController";
    }

    @GetMapping("/getUsers")
    public ResponseEntity<?> getAllUsers() {

        Map<String, Object> response = new HashMap<>();

        ResponseEntity<?> re = null;

        try {
            List<User> users = this.userService.getAllUsers();

            re = new ResponseEntity<List<User>>(users, HttpStatus.OK);


        }catch (Exception ex ) {
            re = new ResponseEntity<Map<String, Object>>( response, HttpStatus.BAD_REQUEST);
        }



        return re;
    }

    @GetMapping("/me")
    public ResponseEntity<User> authenticatedUser() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        User currentUser = (User) authentication.getPrincipal();

        return ResponseEntity.ok(currentUser);
    }


}
