package ccu.tra.ccutrabase.service.impl;

import ccu.tra.ccutrabase.common.constant.Constants;
import ccu.tra.ccutrabase.domain.vo.TraTimeVo;
import ccu.tra.ccutrabase.service.TrainTimeService;
import ccu.tra.ccutrabase.utils.AccessTokenUtils;
import ccu.tra.ccutrabase.utils.HttpUtils;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TrainTimeServiceImpl implements TrainTimeService {

    @Value("${tdx.client.id}")
    private String clientId;
    @Value("${tdx.client.secret}")
    private String clientSecret;
    @Autowired
    private AccessTokenUtils accessTokenUtils;

    @Override
    public String pageQueryTrainTimeToday(TraTimeVo traTimeVo) throws Exception {
        String jsonObject = JSON.toJSONString(traTimeVo);
        // getAccessToken
        String accessToken = accessTokenUtils.getAccessToken();
        String params = HttpUtils.parseJsonToUrlParams(jsonObject);

        return HttpUtils.doHttpGet(Constants.tdxUrl_v2 + Constants.TDX_DailyTimetable.Today+"?"+params,accessToken);
    }
}
