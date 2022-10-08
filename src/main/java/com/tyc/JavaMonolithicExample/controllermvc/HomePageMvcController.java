package com.tyc.JavaMonolithicExample.controllermvc;

import com.tyc.JavaMonolithicExample.dto.response.FindAllCategoryResponse;
import com.tyc.JavaMonolithicExample.mvcmodels.HomeModel;
import com.tyc.JavaMonolithicExample.repository.entity.Product;
import com.tyc.JavaMonolithicExample.repository.entity.User;
import com.tyc.JavaMonolithicExample.service.CategoryService;
import com.tyc.JavaMonolithicExample.service.ProductService;
import com.tyc.JavaMonolithicExample.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

import static com.tyc.JavaMonolithicExample.constant.EndPoint.*;

@Controller
@RequiredArgsConstructor
@RequestMapping(HOME_PAGE)
public class HomePageMvcController {
    private final UserService userService;
    private final CategoryService categoryService;
    private final ProductService productService;
    @GetMapping(HOME)
    public ModelAndView home(String email) {
        User user = userService.findByEmail(email);
        List<FindAllCategoryResponse> category = categoryService.findAllCategory();
        List<Product> productList = productService.findAll();

        String gender = user.getUserGender().toString().toLowerCase();
        HomeModel homeModel = HomeModel.builder()
                .header("Home Page")
                .categoryList(category.stream().map(x-> x.getName()).collect(Collectors.toList()))
                .productList(productList)
                .build();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("gender", gender);
        modelAndView.addObject("model", homeModel);
        modelAndView.addObject("user", user);
        modelAndView.setViewName("home");
        return modelAndView;
    }
}
