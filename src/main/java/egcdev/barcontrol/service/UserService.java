package egcdev.barcontrol.service;


import egcdev.barcontrol.model.entity.User;
import egcdev.barcontrol.model.repository.UserRepository;
import egcdev.barcontrol.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;

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
}
