package ccu.tra.ccutrabase;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//@MapperScan("ccu.tra.ccutrabase.mapper")
@SpringBootApplication
@MapperScan("ccu.tra.ccutrabase.mapper")
public class CcuTraBaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(CcuTraBaseApplication.class, args);
    }

}
