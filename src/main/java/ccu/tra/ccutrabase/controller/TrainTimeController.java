package ccu.tra.ccutrabase.controller;

import ccu.tra.ccutrabase.domain.vo.TraTimeVo;
import ccu.tra.ccutrabase.service.TrainTimeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/DailyStationTimetable")
public class TrainTimeController {

    @Autowired
    private TrainTimeService trainTimeService;

    @ApiOperation(value = "取得當天所有車次的時刻表資料")
    @PostMapping("/Today")
    public String Today(@RequestBody TraTimeVo traTimeVo) {
        try {
            return trainTimeService.pageQueryTrainTimeToday(traTimeVo);
        } catch (Exception e) {
            return e.getMessage();
        }
    }


}
