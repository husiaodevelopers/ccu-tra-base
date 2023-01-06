package ccu.tra.ccutrabase.service;

import ccu.tra.ccutrabase.domain.vo.DailyTimetableVo;
import ccu.tra.ccutrabase.domain.vo.TrainTimeVo;

public interface DailyTimetableService {

    String pageQueryTrainTimeToday(TrainTimeVo trainTimeVo) throws Exception;

    String queryByODAndTrainDate(DailyTimetableVo dailyTimetableVo) throws Exception;
}
