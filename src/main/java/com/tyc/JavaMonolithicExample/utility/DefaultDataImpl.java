package com.tyc.JavaMonolithicExample.utility;

import com.tyc.JavaMonolithicExample.repository.entity.*;
import com.tyc.JavaMonolithicExample.service.CategoryService;
import com.tyc.JavaMonolithicExample.service.ProductService;
import com.tyc.JavaMonolithicExample.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@RequiredArgsConstructor
@Component
public class DefaultDataImpl {
    private final UserService userService;
    private final CategoryService categoryService;
    private final ProductService productService;

    @PostConstruct
    private void create() {
        saveUser();
        saveProductAndCategory();
    }

    private void saveProductAndCategory() {
        Product product = Product.builder()
                .brand("Lumberjack")
                .model("Shell 2PR")
                .price(900.0)
                .piece(1000)
                .image("img/male_shoes_1.webp")
                .build();

        Product product2 = Product.builder()
                .brand("U.S. Polo Assn.")
                .model("Eldorado 2PR")
                .price(530.0)
                .piece(1000)
                .image("img/male_shoes_2.webp")
                .build();

        Product product3 = Product.builder()
                .brand("Adidas")
                .model("Breaknet")
                .price(1009.0)
                .piece(1000)
                .image("img/male_shoes_3.webp")
                .build();

        Product product4 = Product.builder()
                .brand("Nike")
                .model("City Rep Tr")
                .price(1250.0)
                .piece(1000)
                .image("img/female_shoes_1.webp")
                .build();

        Product product5 = Product.builder()
                .brand("Adidas")
                .model("Breaknet")
                .price(1009.0)
                .piece(1000)
                .image("img/female_shoes_2.webp")
                .build();

        Product product6 = Product.builder()
                .brand("Lumberjack")
                .model("Dakota 2Fx")
                .price(600.0)
                .piece(1000)
                .image("img/female_shoes_3.webp")
                .build();

        Category manShoes = Category.builder()
                .name("Man Shoes")
                .product(List.of(product, product2, product3))
                .build();

        Category womanShoes = Category.builder()
                .name("Woman Shoes")
                .product(List.of(product4, product5, product6))
                .build();

        product.setCategory(manShoes);
        product2.setCategory(manShoes);
        product3.setCategory(manShoes);
        product4.setCategory(womanShoes);
        product5.setCategory(womanShoes);
        product6.setCategory(womanShoes);

//        manShoes.setProduct(List.of(product, product2, product3));
//        womanShoes.setProduct(List.of(product4, product5, product6));

        productService.saveAll(List.of(product, product2, product3, product4, product5, product6));
//        categoryService.saveAll(List.of(manShoes, womanShoes));
    }

    private void saveUser() {
        User user = User.builder()
                .name("Taha Yasin")
                .surname("CINAR")
                .email("yasin@mynet.com")
                .telephone("541 000 00 00")
                .password("1234")
                .userGender(EUserGender.MALE)
                .userType(EUserType.ADMIN)
                .build();

        User user2 = User.builder()
                .name("Ipek")
                .surname("CINAR")
                .email("ipek@mynet.com")
                .telephone("544 568 06 14")
                .password("1234")
                .userGender(EUserGender.FEMALE)
                .userType(EUserType.USER)
                .build();

        User user3 = User.builder()
                .name("Aybuke")
                .surname("ASLAN")
                .email("aybuke@mynet.com")
                .telephone("532 983 24 67")
                .password("1234")
                .userGender(EUserGender.FEMALE)
                .userType(EUserType.USER)
                .build();

        User user4 = User.builder()
                .name("Mithat")
                .surname("ORHAN")
                .email("mithat@mynet.com")
                .telephone("555 483 27 02")
                .password("1234")
                .userGender(EUserGender.MALE)
                .userType(EUserType.USER)
                .build();

        User user5 = User.builder()
                .name("Fikri")
                .surname("KUYUCU")
                .email("fikri@mynet.com")
                .telephone("544 035 47 63")
                .password("1234")
                .userGender(EUserGender.OTHER)
                .userType(EUserType.USER)
                .build();

        User user6 = User.builder()
                .name("Kamuran")
                .surname("GUNES")
                .email("kamuran@mynet.com")
                .telephone("544 634 34 68")
                .password("1234")
                .userGender(EUserGender.OTHER)
                .userType(EUserType.USER)
                .build();
        userService.saveAll(List.of(user, user2, user3, user4, user5, user6));
    }


}
