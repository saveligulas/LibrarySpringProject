package gulas.saveli.finalLibrary.library.controller.builder;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ThymeleafModelAndViewBuilderConfig {

    @Bean
    public ThymeleafModelAndViewBuilder thymeleafModelAndViewBuilder() {
        return new ThymeleafModelAndViewBuilder();
    }
}
