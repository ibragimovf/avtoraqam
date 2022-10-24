package uz.pdp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.ResultSet;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class User implements Base {

    private long id;

    private String fullName;

    private String phoneNumber;

    private String password;

    private Double balance;

    private long roleId;

    @Override
    public void get(ResultSet resultSet) {
        try {
            this.id = resultSet.getLong("id");
            this.fullName = resultSet.getString("name");
            this.phoneNumber = resultSet.getString("phone_number");
            this.password = resultSet.getString("password");
            this.balance = resultSet.getDouble("balance");
            this.roleId = resultSet.getLong("role_id");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
