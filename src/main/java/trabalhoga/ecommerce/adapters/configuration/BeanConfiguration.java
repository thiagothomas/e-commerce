package trabalhoga.ecommerce.adapters.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import trabalhoga.ecommerce.EcommerceApplication;

@Configuration
@ComponentScan(basePackageClasses = EcommerceApplication.class)
public class BeanConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
