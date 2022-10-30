package ccu.tra.ccutrabase.service;

import ccu.tra.ccutrabase.domain.vo.TraTimeVo;

public interface TrainTimeService {

    String pageQueryTrainTimeToday(TraTimeVo traTimeVo) throws Exception;
}
