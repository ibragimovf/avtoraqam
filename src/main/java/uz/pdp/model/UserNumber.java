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
public class UserNumber implements Base {

    private long userId;

    private long numberId;

    @Override
    public void get(ResultSet resultSet) {
        try {
            this.userId = resultSet.getLong("user_id");
            this.numberId = resultSet.getLong("number_id");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
