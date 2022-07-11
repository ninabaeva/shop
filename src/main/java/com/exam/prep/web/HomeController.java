package com.exam.prep.web;

import com.exam.prep.model.entity.enums.CategoryNameEnum;
import com.exam.prep.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    private final ProductService productService;


    public HomeController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String index(HttpSession httpSession, Model model) {

        if (httpSession.getAttribute("user") == null) {
            return "index";
        }

        model.addAttribute("totalSum", productService.getTotalProductPrice());

        model.addAttribute("drinks", productService
                .findAllProductsByCategoryName(CategoryNameEnum.DRINK));

        model.addAttribute("foods", productService
                .findAllProductsByCategoryName(CategoryNameEnum.FOOD));

        model.addAttribute("households", productService
                .findAllProductsByCategoryName(CategoryNameEnum.HOUSEHOLD));

        model.addAttribute("other", productService
                .findAllProductsByCategoryName(CategoryNameEnum.OTHER));


        return "home";
    }
}
