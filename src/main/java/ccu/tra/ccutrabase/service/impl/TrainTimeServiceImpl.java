package ccu.tra.ccutrabase.service.impl;

import ccu.tra.ccutrabase.common.constant.Constants;
import ccu.tra.ccutrabase.domain.vo.TraTimeVo;
import ccu.tra.ccutrabase.service.TrainTimeService;
import ccu.tra.ccutrabase.utils.HttpUtils;
import com.alibaba.fastjson.JSON;
import org.apache.http.NameValuePair;

import java.util.ArrayList;
import java.util.List;

public class TrainTimeServiceImpl implements TrainTimeService {

    @Override
    public String pageQueryTrainTimeToday(String url, TraTimeVo traTimeVo) throws Exception {
        String jsonObject = JSON.toJSONString(traTimeVo);
        String params = HttpUtils.parseJsonToUrlParams(jsonObject);
        List<NameValuePair> tokenParams = new ArrayList<>();
        return HttpUtils.doHttpGet(Constants.tdxUrl_v2+ Constants.DailyTimetable_Today+"?"+params);
    }
}
