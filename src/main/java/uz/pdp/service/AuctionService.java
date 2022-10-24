package uz.pdp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import uz.pdp.model.Auction;
import uz.pdp.model.dao.BaseDAO;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AuctionService {
    @Autowired
    @Qualifier("auction")
    private BaseDAO baseDAO;

    public boolean addAuction(Long numberId, long finishDate) {

        if (numberId != null && finishDate > 0) {
            final Auction auction = new Auction();
            auction.setNumberId(numberId);
            LocalDateTime localDateTime = LocalDateTime.now();
            LocalDateTime localDateTime1 = localDateTime.plusHours(finishDate);
            auction.setFinishDate(Timestamp.valueOf(localDateTime1));
            baseDAO.add(auction);
            return true;
        }

        return false;
    }


    public long getId() {
        List<Auction> list = baseDAO.getList(null);
        return list.get(list.size() - 1).getId();
    }
}