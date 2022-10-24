package uz.pdp.model.dto;

import org.springframework.stereotype.Service;
import uz.pdp.model.AuctionDtoElements;
import uz.pdp.model.User;

import java.util.List;

@Service
public class UserDTO implements BaseDTO<User> {

    @Override
    public User get(long id) {
        return null;
    }

    @Override
    public List<AuctionDtoElements> get(int page, int size) {
        return null;
    }
}
