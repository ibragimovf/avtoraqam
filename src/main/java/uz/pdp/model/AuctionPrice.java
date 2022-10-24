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
public class AuctionPrice implements Base {

    private long auctionId;

    private long userId;

    private Double price;

    private Timestamp date;

    @Override
    public void get(ResultSet resultSet) {
        try {
            this.auctionId = resultSet.getLong("auction_id");
            this.userId = resultSet.getLong("user_id");
            this.price = resultSet.getDouble("price");
            this.date = resultSet.getTimestamp("date");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
