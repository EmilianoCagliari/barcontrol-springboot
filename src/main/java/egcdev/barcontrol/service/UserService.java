package egcdev.barcontrol.service;


import egcdev.barcontrol.model.dto.RegisterUserDto;
import egcdev.barcontrol.model.entity.Role;
import egcdev.barcontrol.model.entity.User;
import egcdev.barcontrol.model.entity.enums.RoleEnum;
import egcdev.barcontrol.model.repository.IRoleRepository;
import egcdev.barcontrol.model.repository.UserRepository;
import egcdev.barcontrol.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private IRoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public User getUser(Integer id) {
        return null;
    }

    @Override
    public User createUser(User user) {
        return null;
    }

    @Override
    public Integer deleteUser(Integer user_id) {
        return 0;
    }

    public User createAdministrator(RegisterUserDto input) {
        Optional<Role> optionalRole = roleRepository.findByName(RoleEnum.ADMIN);

        if (optionalRole.isEmpty()) {
            return null;
        }

        User user = new User();
        user.setFullName(input.getFullName());
        user.setEmail(input.getEmail());
        user.setPassword(passwordEncoder.encode(input.getPassword()));
        user.setRole(optionalRole.get());

        return userRepository.save(user);
    }
}
