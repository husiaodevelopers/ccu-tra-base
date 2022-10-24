package ccu.tra.ccutrabase.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class testController {

    @ApiOperation(value = "test")
    @GetMapping("/hi")
    public String addAccount() {
        return "hi ccu-tra-base";
    }
}
