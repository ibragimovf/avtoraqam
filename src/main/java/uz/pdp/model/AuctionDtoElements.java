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
public class AuctionDtoElements implements Base {

    private long id;
    private String number;
    private String role;
    private Double startPrice;
    private Double currentPrice;
    private Timestamp finishDate;
    private String region;

    @Override
    public void get(ResultSet resultSet) {
        try {
            this.id = resultSet.getLong("id");
            this.number = resultSet.getString("number");
            this.role = resultSet.getString("role");
            this.startPrice = resultSet.getDouble("start_price");
            this.currentPrice = resultSet.getDouble("current_price");
            this.finishDate = resultSet.getTimestamp("finish_date");
            this.region = resultSet.getString("region");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
