package uz.pdp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import uz.pdp.model.AuctionPrice;
import uz.pdp.model.dao.BaseDAO;

@Service
public class AuctionPriceService {
    @Autowired
    @Qualifier("auctionPrice")
    private BaseDAO baseDAO;

    public void addAuctionPrice(long auctionId, long userId, double price) {
        final AuctionPrice auctionPrice = new AuctionPrice();
        auctionPrice.setAuctionId(auctionId);
        auctionPrice.setUserId(userId);
        auctionPrice.setPrice(price);
        baseDAO.add(auctionPrice);
    }

}