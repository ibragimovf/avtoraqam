package uz.pdp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import uz.pdp.model.User;
import uz.pdp.model.dao.BaseDAO;

import java.util.List;

@Service
public class UserService {
    @Autowired
    @Qualifier("user")
    private BaseDAO baseDAO;


    public boolean login(String phoneNumber, String password) {
        List<User> list = baseDAO.getList(null);
        System.out.println(list);

        for (User user : list) {
            if (user.getPhoneNumber().equals(phoneNumber) &&
                    user.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }

    public boolean fizRegister(
            String fullName, String phoneNumber,
            String password, Double balance) {

        final User user = new User();
        user.setFullName(fullName);
        user.setPhoneNumber(phoneNumber);
        user.setPassword(password);
        user.setBalance(balance);
        user.setRoleId(1);
        return baseDAO.add(user);
    }

    public boolean yurRegister(String fullName, String phoneNumber,
                               String password, Double balance) {

        final User user = new User();
        user.setFullName(fullName);
        user.setPhoneNumber(phoneNumber);
        user.setPassword(password);
        user.setBalance(balance);
        user.setRoleId(2);
        return baseDAO.add(user);
    }

    public boolean isAdmin(String phoneNumber, String password) {
        List<User> list = baseDAO.getList(null);
        System.out.println(list);

        for (User user : list) {
            if (user.getPhoneNumber().equals(phoneNumber) &&
                    user.getPassword().equals(password) && user.getRoleId() == 3) {
                return true;
            }
        }

        return false;
    }
}
