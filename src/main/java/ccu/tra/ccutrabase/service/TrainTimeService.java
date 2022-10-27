package ccu.tra.ccutrabase.service;

import ccu.tra.ccutrabase.domain.vo.TraTimeVo;

public interface TrainTimeService {

    String pageQueryTrainTimeToday(String url, TraTimeVo traTimeVo) throws Exception;
}
