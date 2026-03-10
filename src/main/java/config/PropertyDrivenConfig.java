package config;

import dao.IDao;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource("classpath:app.properties")
public class PropertyDrivenConfig {

    @Value("${dao.target:daoImpl}")
    private String target;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean(name = "dao")
    public IDao selectedDao(
            @Qualifier("daoImpl")  IDao daoImpl,
            @Qualifier("dao2")     IDao daoImpl2,
            @Qualifier("daoFile")  IDao daoFile,
            @Qualifier("daoApi")   IDao daoApi
    ) {
        return switch (target) {
            case "daoImpl" -> daoImpl;
            case "dao2"    -> daoImpl2;
            case "daoFile" -> daoFile;
            case "daoApi"  -> daoApi;
            default -> throw new IllegalArgumentException(
                    "Implémentation inconnue: " + target +
                            " — valeurs valides : daoImpl | dao2 | daoFile | daoApi"
            );
        };
    }
}