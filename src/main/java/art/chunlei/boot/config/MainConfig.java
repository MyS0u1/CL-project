package art.chunlei.boot.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("art.chunlei.boot.mapper")
public class MainConfig {
}
