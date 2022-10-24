package uz.pdp.model.dao;

import org.springframework.stereotype.Service;
import uz.pdp.model.Number;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service("number")
public class NumberDAO implements BaseDAO<Number> {

    @Override
    public boolean add(Number number) {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select add_number(?,?,?,?)");
            preparedStatement.setString(1, number.getAutoNumber());
            preparedStatement.setString(2, number.getRegion());
            preparedStatement.setDouble(3, number.getPrice());
            preparedStatement.setLong(4, number.getRoleId());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Number> getList(String id) {
        List<Number> numbers = new ArrayList<>();
        try (
                Connection connection = getConnection();
                Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet;
            if (id != null)
                resultSet = statement.executeQuery("select * from get_number('" + Long.parseLong(id) + "')");
            else
                resultSet = statement.executeQuery("select * from get_number(null)");

            while (resultSet.next()) {
                Number number = new Number();
                number.get(resultSet);
                numbers.add(number);
            }
            return numbers;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void delete(String id) {
        long id1 = Long.parseLong(id);
        try (
                Connection connection = getConnection();
                Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery("select * from delete_number(" + id1 + ")");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean update(String id, Number number) {
        long numberId = Long.parseLong(id);
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from update_number(?,?,?,?,?)");
            preparedStatement.setString(1, number.getAutoNumber());
            preparedStatement.setString(2, number.getRegion());
            preparedStatement.setDouble(3, number.getPrice());
            preparedStatement.setLong(4, number.getRoleId());
            preparedStatement.setLong(5, numberId);
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
