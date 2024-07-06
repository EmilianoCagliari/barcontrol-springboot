package egcdev.barcontrol.service;

import egcdev.barcontrol.model.dto.LoginUserDto;
import egcdev.barcontrol.model.dto.RegisterUserDto;
import egcdev.barcontrol.model.entity.Role;
import egcdev.barcontrol.model.entity.User;
import egcdev.barcontrol.model.entity.enums.RoleEnum;
import egcdev.barcontrol.model.repository.IRoleRepository;
import egcdev.barcontrol.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private IRoleRepository roleRepository;


    public User signup(RegisterUserDto input) {

        Optional<Role> optionalRole = this.roleRepository.findByName(RoleEnum.USER);

        if( optionalRole.isEmpty() ) {
            return null;
        }

        User user = new User();
            user.setFullName(input.getFullName());
            user.setEmail(input.getEmail());
            user.setPassword(passwordEncoder.encode(input.getPassword()));
            user.setRole(optionalRole.get());

        return userRepository.save(user);
    }

    public User authenticate( LoginUserDto input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );

        return userRepository.findByEmail(input.getEmail())
                .orElseThrow();
    }

}
