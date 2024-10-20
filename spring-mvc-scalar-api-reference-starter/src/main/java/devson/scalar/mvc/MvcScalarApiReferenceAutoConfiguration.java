package devson.scalar.mvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@AutoConfiguration
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
@EnableConfigurationProperties(MvcScalarApiReferenceProperties.class)
@ConditionalOnProperty(name = "scalar-api-reference.enabled", havingValue = "true")
public class MvcScalarApiReferenceAutoConfiguration implements WebMvcConfigurer {
    private static Logger logger = LoggerFactory.getLogger(MvcScalarApiReferenceAutoConfiguration.class);

    private final MvcScalarApiReferenceProperties properties;

    public MvcScalarApiReferenceAutoConfiguration(MvcScalarApiReferenceProperties properties) {
        this.properties = properties;
        logger.info("Scalar API Reference is enabled");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        var url = properties.getUrl();
        if (!url.startsWith("/")) {
            url = "/" + url;
        }

        registry
            .addResourceHandler(url + "/**")
            .addResourceLocations("classpath:/api-reference/");
    }
}
