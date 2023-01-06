package ccu.tra.ccutrabase.service.impl;

import ccu.tra.ccutrabase.common.constant.Constants;
import ccu.tra.ccutrabase.domain.vo.DailyTimetableVo;
import ccu.tra.ccutrabase.domain.vo.TrainTimeVo;
import ccu.tra.ccutrabase.service.DailyTimetableService;
import ccu.tra.ccutrabase.utils.AccessTokenUtils;
import ccu.tra.ccutrabase.utils.HttpUtils;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DailyTimetableServiceImpl implements DailyTimetableService {


    @Autowired
    private AccessTokenUtils accessTokenUtils;

    @Override
    public String pageQueryTrainTimeToday(TrainTimeVo trainTimeVo) throws Exception {
        String jsonObject = JSON.toJSONString(trainTimeVo);
        // getAccessToken
        String accessToken = accessTokenUtils.getAccessToken();
        String params = HttpUtils.parseJsonToUrlParams(jsonObject);

        return HttpUtils.doHttpGet(Constants.tdxUrl_v2 + Constants.TDX_DailyTimetable.Today+"?"+params,accessToken);
    }
    @Override
    public String queryByODAndTrainDate(DailyTimetableVo dailyTimetableVo) throws Exception {
        String jsonObject = JSON.toJSONString(dailyTimetableVo);
        // getAccessToken
        String accessToken = accessTokenUtils.getAccessToken();
        String params = HttpUtils.parseJsonToUrlParams(jsonObject);

        return HttpUtils.doHttpGet(Constants.tdxUrl_v2 + Constants.TDX_DailyTimetable.ODToTrainDate
                +dailyTimetableVo.getOriginStationID()+"/to/"+dailyTimetableVo.getDestinationStationID()
                +"/"+dailyTimetableVo.getTrainDate()+"?"+params,accessToken);
    }
}
