package uz.pdp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import uz.pdp.service.AuctionPriceService;
import uz.pdp.service.AuctionService;
import uz.pdp.service.NumberService;

@Controller
@RequestMapping("/adminPage")
public class AdminController {
    private final NumberService numberService;
    private final AuctionService auctionService;
    private final AuctionPriceService auctionPriceService;

    public AdminController(NumberService adminService, AuctionService auctionService, AuctionPriceService auctionPriceService) {
        this.numberService = adminService;
        this.auctionService = auctionService;
        this.auctionPriceService = auctionPriceService;
    }

    @GetMapping("")
    public String getAdminPage() {
        return "adminPage";
    }

    @PostMapping("/addNumber")
    public String addNumber(
            @RequestParam("number") String number,
            @RequestParam("region") String region,
            @RequestParam("price") Double price,
            @RequestParam("roleId") long roleId
    ) {
        if (numberService.addNumber(number, region, price, roleId)) {
            return "redirect: /adminPage/addAuction";
        } else {
            return "redirect: /adminPage";
        }
    }

    @PostMapping("/addAuction")
    public String addAuction(
            Model model,
            @RequestParam("numberId") long numberId,
            @RequestParam("date") long finishDate
    ) {
        Long id = numberService.getId(numberId);
        if (auctionService.addAuction(id, finishDate)) {
            model.addAttribute("auctionId", auctionService.getId());
            model.addAttribute("userId", 0);
            model.addAttribute("price", numberService.getPrice(numberId));
            model.addAttribute("isAdded", true);
        } else {
            model.addAttribute("isAdded", false);
        }
        return "redirect: /adminPage/addAuctionPrice";
    }

    @GetMapping("/addAuction")
    public String addAuction() {
        return "addAuction";
    }

    @GetMapping("/addAuctionPrice")
    public String addAuction(
            @RequestParam("auctionId") long auctionId,
            @RequestParam("userId") long userId,
            @RequestParam("price") double price
    ) {
        auctionPriceService.addAuctionPrice(auctionId, userId, price);
        return "redirect: /";
    }

}
