package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;
    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
    @Transactional
    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }
    @Transactional
    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }
    @Transactional
    @Override
    public void deleteUser(Long id) {
      userDao.deleteUser(id);
    }
    @Transactional
    @Override
    public User updateUser(User user) {
        return userDao.updateUser(user);
    }
}
