package ccu.tra.ccutrabase.service;

import ccu.tra.ccutrabase.domain.po.ODAndTrainDateTimetablePo;
import ccu.tra.ccutrabase.domain.vo.DailyTimetableVo;
import ccu.tra.ccutrabase.domain.vo.TrainTimeVo;

import java.util.List;

public interface DailyTimetableService {

    String pageQueryTrainTimeToday(TrainTimeVo trainTimeVo) throws Exception;

    List<ODAndTrainDateTimetablePo> queryByODAndTrainDate(DailyTimetableVo dailyTimetableVo) throws Exception;
}
