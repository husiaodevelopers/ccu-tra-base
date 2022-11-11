package ccu.tra.ccutrabase.controller;

import ccu.tra.ccutrabase.domain.po.TdxAuthorizationPo;
import ccu.tra.ccutrabase.service.TdxAuthorizationService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class testController {

    @Autowired
    private TdxAuthorizationService tdxAuthorizationService;

    @ApiOperation(value = "test")
    @GetMapping("/hi")
    public String addAccount() {
        return "hi ccu-tra-base";
    }

    @ApiOperation(value = "getAccessToken")
    @GetMapping("/getAccessToken")
    public TdxAuthorizationPo getAccessToken() {

        return tdxAuthorizationService.getAccessToken();
    }
}
