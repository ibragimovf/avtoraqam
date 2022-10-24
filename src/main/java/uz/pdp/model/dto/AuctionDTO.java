package uz.pdp.model.dto;

import org.springframework.stereotype.Service;
import uz.pdp.model.AuctionDtoElements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class AuctionDTO implements BaseDTO<AuctionDtoElements> {

    @Override
    public AuctionDtoElements get(long id) {
        return null;
    }

    @Override
    public List<AuctionDtoElements> get(int page, int size) {
        List<AuctionDtoElements> auctionDtoElementsList = new ArrayList<>();
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from get_number_page(?,?)");
            preparedStatement.setInt(1, page);
            preparedStatement.setInt(2, size);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                AuctionDtoElements auctionDtoElements = new AuctionDtoElements();
                auctionDtoElements.get(resultSet);
                auctionDtoElementsList.add(auctionDtoElements);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return auctionDtoElementsList;
    }
}
