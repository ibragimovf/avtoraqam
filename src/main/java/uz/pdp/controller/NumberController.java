package uz.pdp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import uz.pdp.service.NumberService;

import java.util.Optional;

@Controller
@RequestMapping("/home")
public class NumberController {

    private NumberService numberService;

    public NumberController(NumberService numbersService) {
        this.numberService = numbersService;
    }

    @GetMapping("")
    public String getNumbers(
            Model model,
            @RequestParam("page") Optional<Integer> page,
            @RequestParam("confirm") Optional<Long> confirm
    ) {
        model.addAttribute(numberService.getNumberModel(
                model,
                page,
                confirm
        ));
        return "home";
    }
}
