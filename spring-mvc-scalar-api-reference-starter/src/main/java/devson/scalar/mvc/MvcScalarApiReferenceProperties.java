package devson.scalar.mvc;

import org.springframework.boot.context.properties.ConfigurationProperties;

//@Component
@ConfigurationProperties(prefix = "scalar-api-reference")
public class MvcScalarApiReferenceProperties {
    private boolean enabled = true;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
