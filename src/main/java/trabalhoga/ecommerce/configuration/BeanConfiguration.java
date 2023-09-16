package trabalhoga.ecommerce.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import trabalhoga.ecommerce.EcommerceApplication;
import trabalhoga.ecommerce.application.ports.CategoryRepositoryPort;
import trabalhoga.ecommerce.application.ports.CustomerRepositoryPort;
import trabalhoga.ecommerce.application.ports.OrderRepositoryPort;
import trabalhoga.ecommerce.application.ports.ProductRepositoryPort;
import trabalhoga.ecommerce.application.services.CategoryServiceImpl;
import trabalhoga.ecommerce.application.services.CustomerServiceImpl;
import trabalhoga.ecommerce.application.services.OrderServiceImpl;
import trabalhoga.ecommerce.application.services.ProductServiceImpl;

@Configuration
@ComponentScan(basePackageClasses = EcommerceApplication.class)
public class BeanConfiguration
{

    @Bean
    CategoryServiceImpl categoryServiceImpl (CategoryRepositoryPort repository)
    {
        return new CategoryServiceImpl(repository);
    }

    @Bean
    CustomerServiceImpl customerServiceImpl (CustomerRepositoryPort repository)
    {
        return new CustomerServiceImpl(repository);
    }

    @Bean
    OrderServiceImpl orderServiceImpl (OrderRepositoryPort repository)
    {
        return new OrderServiceImpl(repository);
    }

    @Bean
    ProductServiceImpl productServiceImpl (ProductRepositoryPort repository)
    {
        return new ProductServiceImpl(repository);
    }

    @Bean
    public ModelMapper modelMapper ()
    {
        return new ModelMapper();
    }

}
