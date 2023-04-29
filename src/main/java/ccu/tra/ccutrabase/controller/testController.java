package ccu.tra.ccutrabase.controller;

import ccu.tra.ccutrabase.domain.po.TdxAuthorizationPo;
import ccu.tra.ccutrabase.service.TdxAuthorizationService;


import com.common.util.RedisUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class testController {
/*123test*/
    @Autowired
    private TdxAuthorizationService tdxAuthorizationService;
    @Autowired
    private RedisUtils redisUtils;

    @ApiOperation(value = "test")
    @GetMapping("/hi")
    public String addAccount() {
        return "hi ccu-tra-base";
    }

    @ApiOperation(value = "getAccessTokenFromTdx")
    @GetMapping("/getAccessTokenFromTdx")
    public String getAccessTokenFromTdx() {
        return tdxAuthorizationService.getAccessTokenFromTdx();
    }
    @ApiOperation(value = "getAccessToken")
    @GetMapping("/getAccessToken")
    public String getAccessToken() {

        return tdxAuthorizationService.getAccessToken();
    }
    @ApiOperation(value = "/redis/set")
    @GetMapping("/redis/set")
    public String set() {
        redisUtils.set("key", "value");
        return "success";
    }
    @ApiOperation(value = "/redis/get")
    @GetMapping("/redis/get")
    public Object get() {
        return redisUtils.get("key");
    }
    @ApiOperation(value = "redis/delete")
    @GetMapping("/redis/delete")
    public String delete() {
        redisUtils.delete("key");
        return "success";
    }
}
