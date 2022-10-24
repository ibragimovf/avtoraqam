package uz.pdp.model.dao;

import org.springframework.stereotype.Service;
import uz.pdp.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service("user")
public class UserDAO implements BaseDAO<User> {

    @Override
    public boolean add(User user) {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select add_user(?,?,?,?,?)");
            preparedStatement.setString(1, user.getFullName());
            preparedStatement.setString(2, user.getPhoneNumber());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setDouble(4, user.getBalance());
            preparedStatement.setLong(5, user.getRoleId());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<User> getList(String id) {
        List<User> userList = new ArrayList<>();
        try (
                Connection connection = getConnection();
                Statement statement = connection.createStatement()
        ) {

            ResultSet resultSet;
            if (id != null)
                resultSet = statement.executeQuery("select * from get_user('" + Long.parseLong(id) + "')");
            else
                resultSet = statement.executeQuery("select * from get_user(null)");

            while (resultSet.next()) {
                User user = new User();
                user.get(resultSet);
                userList.add(user);
            }
            return userList;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void delete(String id) {
        long userId = Long.parseLong(id);
        try (
                Connection connection = getConnection();
                Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery("select * from delete(" + userId + ")");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean update(String id, User user) {
        long userId = Long.parseLong(id);
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from update_user(?,?,?,?,?)");
            preparedStatement.setString(1, user.getFullName());
            preparedStatement.setString(2, user.getPhoneNumber());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setDouble(4, user.getBalance());
            preparedStatement.setLong(5, user.getRoleId());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
