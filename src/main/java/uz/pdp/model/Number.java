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
public class Number implements Base {

    private long id;

    private String autoNumber;

    private String region;

    private Double price;

    private boolean isSold;

    private long roleId;

    @Override
    public void get(ResultSet resultSet) {
        try {
            this.id = resultSet.getLong("id");
            this.autoNumber = resultSet.getString("auto_number");
            this.region = resultSet.getString("region");
            this.price = resultSet.getDouble("price");
            this.isSold = resultSet.getBoolean("is_sold");
            this.roleId = resultSet.getLong("role_id");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
