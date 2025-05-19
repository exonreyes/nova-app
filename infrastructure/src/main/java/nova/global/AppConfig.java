package nova.global;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "app-config")
@Getter
public class AppConfig {
    private int defaultRows;
    private int defaultPage;
}
