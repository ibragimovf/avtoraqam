package uz.pdp.model.dao;

import org.springframework.stereotype.Service;
import uz.pdp.model.Auction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service("auction")
public class AuctionDAO implements BaseDAO<Auction> {

    @Override
    public boolean add(Auction auction) {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select add_auction (?,?)");
            preparedStatement.setLong(1, auction.getNumberId());
            preparedStatement.setTimestamp(2, auction.getFinishDate());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Auction> getList(String id) {
        List<Auction> auctions = new ArrayList<>();
        try (
                Connection connection = getConnection();
                Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet;
            if (id != null)
                resultSet = statement.executeQuery("select * from get_auction('" + Long.parseLong(id) + "')");
            else
                resultSet = statement.executeQuery("select * from get_auction(null)");

            while (resultSet.next()) {
                Auction auction = new Auction();
                auction.get(resultSet);
                auctions.add(auction);
            }
            return auctions;

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
            ResultSet resultSet = statement.executeQuery("select * from delete_auction(" + id1 + ")");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean update(String id, Auction auction) {
        long auctionId = Long.parseLong(id);
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from update_auction(?,?,?)");
            preparedStatement.setLong(1, auction.getNumberId());
            preparedStatement.setTimestamp(2, auction.getFinishDate());
            preparedStatement.setLong(3, auctionId);
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
