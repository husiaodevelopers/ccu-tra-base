package ccu.tra.ccutrabase.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/DailyStationTimetable")
public class TrainTimeController {


    @ApiOperation(value = "取得當天所有車次的時刻表資料")
    @GetMapping("/Today")
    public String Today() {

        return "hi ccu-tra-base";
    }


}
