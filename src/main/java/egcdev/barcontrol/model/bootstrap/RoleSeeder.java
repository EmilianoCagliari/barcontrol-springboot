package egcdev.barcontrol.model.bootstrap;

import egcdev.barcontrol.model.entity.Role;
import egcdev.barcontrol.model.entity.enums.RoleEnum;
import egcdev.barcontrol.model.repository.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

@Component
public class RoleSeeder implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private IRoleRepository iRoleRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        this.loadRoles();
    }

    private void loadRoles() {
        RoleEnum[] roleNames = new RoleEnum[] {
                RoleEnum.USER,
                RoleEnum.ADMIN,
                RoleEnum.SUPER_ADMIN
        };

        Map<RoleEnum, String> roleDescriptionMap = Map.of(
                RoleEnum.USER, "Default user role",
                RoleEnum.ADMIN, "Administrator role",
                RoleEnum.SUPER_ADMIN, "Super Administrator role"
        );

        Arrays.stream(roleNames).forEach( (roleName) -> {
            Optional<Role> optionalRole = this.iRoleRepository.findByName(roleName);

            optionalRole.ifPresentOrElse(System.out::print, () -> {

                Role roleToCreate = new Role();

                roleToCreate.setName(roleName);
                roleToCreate.setDescription(roleDescriptionMap.get(roleName));

                this.iRoleRepository.save(roleToCreate);
            });


        });

    }
}
