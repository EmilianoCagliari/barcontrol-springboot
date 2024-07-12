package egcdev.barcontrol.model.bootstrap;

import egcdev.barcontrol.model.dto.RegisterUserDto;
import egcdev.barcontrol.model.entity.Role;
import egcdev.barcontrol.model.entity.User;
import egcdev.barcontrol.model.entity.enums.RoleEnum;
import egcdev.barcontrol.model.repository.IRoleRepository;
import egcdev.barcontrol.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AdminSeeder implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private IRoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        this.createSuperAdministrator();
    }

    private  void createSuperAdministrator() {

        RegisterUserDto userDto = new RegisterUserDto();
        userDto.setFullName(
                System.getenv("SU_F_NAME")
        );
        userDto.setEmail(
                System.getenv("SU_EMAIL")
        );
        userDto.setPassword(
                System.getenv("SU_PASS")
        );

        Optional<Role> optionalRole = this.roleRepository.findByName(RoleEnum.SUPER_ADMIN);
        Optional<User> optionalUser = this.userRepository.findByEmail(userDto.getEmail());

        //Si esta vacio o ya existe
        if ( optionalRole.isEmpty() || optionalUser.isPresent() ) {
            return;
        }

        //Se crea el objeto a insertar.
        User user = new User();
        user.setFullName( userDto.getFullName() );
        user.setEmail( userDto.getEmail() );
        user.setPassword( passwordEncoder.encode( userDto.getPassword() ) );
        user.setRole( optionalRole.get() );

        this.userRepository.save(user);

    }
}
