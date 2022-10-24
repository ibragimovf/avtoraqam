package uz.pdp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.ResultSet;
import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Auction implements Base {

    private long id;

    private long numberId;

    private Timestamp startDate;

    private Timestamp finishDate;

    private boolean isOpen;

    @Override
    public void get(ResultSet resultSet) {
        try {
            this.id = resultSet.getLong("id");
            this.numberId = resultSet.getLong("number_id");
            this.startDate = resultSet.getTimestamp("start_date");
            this.finishDate = resultSet.getTimestamp("finish_date");
            this.isOpen = resultSet.getBoolean("is_open");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
