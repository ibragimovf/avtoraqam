package uz.pdp.model.dto;

import org.springframework.stereotype.Repository;
import uz.pdp.model.AuctionDtoElements;
import uz.pdp.model.DatabaseInit;

import java.util.List;

@Repository
public interface BaseDTO<T> extends DatabaseInit {

    T get(long id);

    List<AuctionDtoElements> get(int page, int size);
}
