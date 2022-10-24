package uz.pdp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import uz.pdp.model.Number;
import uz.pdp.model.dao.BaseDAO;
import uz.pdp.model.dto.AuctionDTO;

import java.util.List;
import java.util.Optional;

@Service
public class NumberService {
    @Autowired
    @Qualifier("number")
    private BaseDAO baseDAO;
    public Model getNumberModel(
            Model model,
            Optional<Integer> page,
            Optional<Long> confirm) {

        AuctionDTO auctionDTO = new AuctionDTO();
        System.out.println(page);
        int i = page.orElse(1);
        model.addAttribute("auctionList", auctionDTO.get(i, 5));
        model.addAttribute("isEmpty", auctionDTO.get(i + 1, 5).isEmpty());
        model.addAttribute("pages", i);
        return model;
    }
    public boolean addNumber(String number, String region, Double price, long roleId) {
        final Number number1 = new Number();
        number1.setAutoNumber(number);
        number1.setRegion(region);
        number1.setPrice(price);
        number1.setRoleId(roleId);

        return baseDAO.add(number1);
    }

    public Long getId(long numberId) {
        List<Number> list = baseDAO.getList(String.valueOf(numberId));
        if (!list.isEmpty()){
            Number number = list.get(0);
            Long id = number.getId();
            return id;
        }
        return null;
    }

    public Double getPrice(long numberId) {
        List<Number> list = baseDAO.getList(String.valueOf(numberId));
        if (!list.isEmpty()){
            Number number = list.get(0);
            Double price = number.getPrice();
            return price;
        }
        return null;
    }
}