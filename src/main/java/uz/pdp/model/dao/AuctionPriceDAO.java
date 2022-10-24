package uz.pdp.model.dao;

import org.springframework.stereotype.Service;
import uz.pdp.model.AuctionPrice;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service("auctionPrice")
public class AuctionPriceDAO implements BaseDAO<AuctionPrice> {

    @Override
    public boolean add(AuctionPrice auctionPrice) {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select add_auction_price(?,?,?)");
            preparedStatement.setLong(1, auctionPrice.getAuctionId());
            preparedStatement.setLong(2, auctionPrice.getUserId());
            preparedStatement.setDouble(3, auctionPrice.getPrice());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<AuctionPrice> getList(String id) {
        List<AuctionPrice> auctionPrices = new ArrayList<>();
        try (
                Connection connection = getConnection();
                Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet;
            if (id != null)
                resultSet = statement.executeQuery("select * from get_auction_price('" + Long.parseLong(id) + "')");
            else
                resultSet = statement.executeQuery("select * from get_auction_price(null)");

            while (resultSet.next()) {
                AuctionPrice auctionPrice = new AuctionPrice();
                auctionPrice.get(resultSet);
                auctionPrices.add(auctionPrice);
            }
            return auctionPrices;

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
            ResultSet resultSet = statement.executeQuery("select * from delete_auction_price(" + id1 + ")");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean update(String id, AuctionPrice auctionPrice) {
        long auctionId = Long.parseLong(id);
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from update_auction_price(?,?,?,?)");
            preparedStatement.setLong(1, auctionPrice.getAuctionId());
            preparedStatement.setLong(2, auctionPrice.getUserId());
            preparedStatement.setDouble(3, auctionPrice.getPrice());
            preparedStatement.setLong(4, auctionId);
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
