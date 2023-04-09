package ccu.tra.ccutrabase.utils;

import ccu.tra.ccutrabase.domain.po.TdxAuthorizationPo;
import ccu.tra.ccutrabase.service.TdxAuthorizationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * @author Hu
 */
@Slf4j
@Component
public class AccessTokenUtils {

    @Value("${tdx.client.id}")
    private String clientId;
    @Value("${tdx.client.secret}")
    private String clientSecret;
    @Autowired
    private TdxAuthorizationService tdxAuthorizationService;

    public String getAccessToken(){
        // getAccessToken
        String accessToken = tdxAuthorizationService.getAccessToken();
        if(accessToken.isEmpty()){
            return tdxAuthorizationService.getAccessTokenFromTdx();
        }else{
            return accessToken;
        }
    }
}
