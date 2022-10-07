package cn.itcast.user.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created 10-07-2022  2:18 PM
 * Author  DIno
 */
@Data
@Component
@ConfigurationProperties(prefix = "pattern")
public class PatternProperties {

    private String dateformat;

    private String sharedEnvironmentValue;
}
