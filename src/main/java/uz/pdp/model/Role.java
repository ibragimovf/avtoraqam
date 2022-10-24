package uz.pdp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.ResultSet;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Role implements Base {
    private long id;

    private String userRoleEnumName;

    @Override
    public void get(ResultSet resultSet) {
        try {
            this.id = resultSet.getLong("id");
            this.userRoleEnumName = resultSet.getString("name");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
