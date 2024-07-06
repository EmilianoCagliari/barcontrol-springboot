package egcdev.barcontrol.controller;

import egcdev.barcontrol.model.dto.RegisterUserDto;
import egcdev.barcontrol.model.entity.User;
import egcdev.barcontrol.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/admins")
@RestController
public class AdminController {

    @Autowired
    private UserService userService;

    public ResponseEntity<User> createAdministrator(@RequestBody RegisterUserDto registerUserDto) {
        User createdAdmin = this.userService.createAdministrator(registerUserDto);

        return ResponseEntity.ok(createdAdmin);
    }

}
