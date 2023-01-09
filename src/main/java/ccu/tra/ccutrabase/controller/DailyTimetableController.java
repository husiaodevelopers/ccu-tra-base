package ccu.tra.ccutrabase.controller;

import ccu.tra.ccutrabase.domain.po.ODAndTrainDateTimetablePo;
import ccu.tra.ccutrabase.domain.vo.DailyTimetableVo;
import ccu.tra.ccutrabase.domain.vo.TrainTimeVo;
import ccu.tra.ccutrabase.service.DailyTimetableService;
import ccu.tra.ccutrabase.service.TdxAuthorizationService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.bridge.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Hu
 */
@RestController
@RequestMapping("/DailyTimetable")
@Slf4j
public class DailyTimetableController {

    @Autowired
    private DailyTimetableService dailyTimetableService;
    @Autowired
    private TdxAuthorizationService tdxAuthorizationService;
    @ApiOperation(value = "取得當天所有車次的時刻表資料")
    @PostMapping("/Today")
    public String Today(@RequestBody TrainTimeVo trainTimeVo) {
        try {
            return dailyTimetableService.pageQueryTrainTimeToday(trainTimeVo);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @ApiOperation(value = "取得指定[日期],[起迄站間]之站間時刻表資料")
    @PostMapping("/queryByODAndTrainDate")
    public List<ODAndTrainDateTimetablePo> queryByODAndTrainDate(@RequestBody @Validated(DailyTimetableVo.List.class)  DailyTimetableVo dailyTimetableVo) {
        try {
            return dailyTimetableService.queryByODAndTrainDate(dailyTimetableVo);

        } catch (Exception e) {
            log.info(e.getMessage());

        }
        return null;
    }
}
