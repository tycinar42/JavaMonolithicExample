package com.tyc.JavaMonolithicExample.controllermvc;

import com.tyc.JavaMonolithicExample.dto.request.SaveUserRequestDto;
import com.tyc.JavaMonolithicExample.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import static com.tyc.JavaMonolithicExample.constant.EndPoint.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class LoginRegisterMvcController {
    private final UserService userService;
    private final HomePageMvcController homePageMvcController;

    @GetMapping("/")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("login");

        return modelAndView;
    }

    @PostMapping("/dologin")
    public ModelAndView doLogin(String txtemail, String txtpassword) {
        if(userService.isExistUser(txtemail, txtpassword)) {
            return homePageMvcController.home(txtemail);
        } else System.out.println("Kullanici adi veya sifre hatali");
        return null;
    }

    @GetMapping("/register")
    public  ModelAndView register() {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("register");

        return modelAndView;
    }

    @PostMapping("/doregister")
    public ModelAndView doRegister(SaveUserRequestDto dto) {
//        dto.setUserGender(EUserGender.valueOf(gender));
        userService.save(dto);
        return new ModelAndView("redirect:/");
    }
}
