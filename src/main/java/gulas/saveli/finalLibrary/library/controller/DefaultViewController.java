package gulas.saveli.finalLibrary.library.controller;

import gulas.saveli.finalLibrary.library.controller.builder.ThymeleafModelAndViewBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class DefaultViewController {

    private final ThymeleafModelAndViewBuilder thymeleafModelAndViewBuilder;

    @GetMapping
    public ModelAndView defaultView() {
        return thymeleafModelAndViewBuilder.build("index");
    }

}
