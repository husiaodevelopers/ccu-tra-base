package ccu.tra.ccutrabase;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@MapperScan("ccu.tra.ccutrabase.mapper")
@SpringBootApplication
@EnableSwagger2
@MapperScan("ccu.tra.ccutrabase.mapper")
public class CcuTraBaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(CcuTraBaseApplication.class, args);
    }

}
