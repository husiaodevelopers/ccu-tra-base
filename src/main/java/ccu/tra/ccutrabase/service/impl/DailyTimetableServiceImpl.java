package ccu.tra.ccutrabase.service.impl;

import ccu.tra.ccutrabase.common.constant.Constants;
import ccu.tra.ccutrabase.domain.po.ODAndTrainDateTimetablePo;
import ccu.tra.ccutrabase.domain.vo.DailyTimetableVo;
import ccu.tra.ccutrabase.domain.vo.TrainTimeVo;
import ccu.tra.ccutrabase.service.DailyTimetableService;
import ccu.tra.ccutrabase.utils.AccessTokenUtils;
import ccu.tra.ccutrabase.utils.HttpUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    public List<ODAndTrainDateTimetablePo> queryByODAndTrainDate(DailyTimetableVo dailyTimetableVo)  {
        String jsonObject = JSON.toJSONString(dailyTimetableVo);
        // getAccessToken
        String accessToken = accessTokenUtils.getAccessToken();
        String params = HttpUtils.parseJsonToUrlParams(jsonObject);
        String result = null;
        try {
            result = HttpUtils.doHttpGet(Constants.tdxUrl_v2 + Constants.TDX_DailyTimetable.ODToTrainDate
                    +dailyTimetableVo.getOriginStationID()+"/to/"+dailyTimetableVo.getDestinationStationID()
                    +"/"+dailyTimetableVo.getTrainDate()+"?"+params,accessToken);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        List<ODAndTrainDateTimetablePo> odAndTrainDateTimetablePoList = new ArrayList<>();
        JSONArray trainList = JSONArray.parseArray(result);
        for(int i= 0;i< trainList.size();i++){
            ODAndTrainDateTimetablePo odAndTrainDateTimetablePo = new ODAndTrainDateTimetablePo();
            JSONObject obj = (JSONObject) trainList.get(i);
            /**
             * DailyTrainInfo
             */
            if(obj.containsKey("DailyTrainInfo")){
                //log.info("DailyTrainInfo : ");
                JSONObject dailyTrainobj = JSONObject.parseObject(obj.getString("DailyTrainInfo"));
                //log.info("obj1 : "+dailyTrainobj.toString());
                if(dailyTrainobj.containsKey("TrainNo")){
                    odAndTrainDateTimetablePo.setTrainNo(dailyTrainobj.getString("TrainNo"));log.info("TrainNo : "+dailyTrainobj.getString("TrainNo"));
                }
                if(dailyTrainobj.containsKey("StartingStationID")){
                    odAndTrainDateTimetablePo.setStartingStationID(dailyTrainobj.getString("StartingStationID"));
                }
                if(dailyTrainobj.containsKey("StartingStationName")){
                    JSONObject StartingStationName = JSONObject.parseObject(dailyTrainobj.getString("StartingStationName"));
                    if(StartingStationName.containsKey("Zh_tw")){
                        odAndTrainDateTimetablePo.setStartingStationNameZh(StartingStationName.getString("Zh_tw"));
                    }
                    if(StartingStationName.containsKey("En")){
                        odAndTrainDateTimetablePo.setStartingStationNameEn(StartingStationName.getString("En"));
                    }
                }
                if(dailyTrainobj.containsKey("EndingStationID")){
                    odAndTrainDateTimetablePo.setEndingStationID(dailyTrainobj.getString("EndingStationID"));
                }
                if(dailyTrainobj.containsKey("EndingStationName")){
                    JSONObject EndingStationName = JSONObject.parseObject(dailyTrainobj.getString("EndingStationName"));
                    if(EndingStationName.containsKey("Zh_tw")){
                        odAndTrainDateTimetablePo.setEndingStationNameZh(EndingStationName.getString("Zh_tw"));
                    }
                    if(EndingStationName.containsKey("En")){
                        odAndTrainDateTimetablePo.setEndingStationNameEn(EndingStationName.getString("En"));
                    }
                }
                if(dailyTrainobj.containsKey("TrainTypeID")){
                    odAndTrainDateTimetablePo.setTrainTypeID(dailyTrainobj.getString("TrainTypeID"));
                }
                if(dailyTrainobj.containsKey("TrainTypeName")){
                    JSONObject TrainTypeName = JSONObject.parseObject(dailyTrainobj.getString("TrainTypeName"));
                    if(TrainTypeName.containsKey("Zh_tw")){
                        odAndTrainDateTimetablePo.setTrainTypeNameZh(TrainTypeName.getString("Zh_tw"));
                    }
                    if(TrainTypeName.containsKey("En")){
                        odAndTrainDateTimetablePo.setTrainTypeNameEn(TrainTypeName.getString("En"));
                    }
                }

            }
            /**
             * OriginStopTime
             */
            if(obj.containsKey("OriginStopTime")){
                JSONObject originStopTimeobj = JSONObject.parseObject(obj.getString("OriginStopTime"));
                if(originStopTimeobj.containsKey("StationID")){
                    odAndTrainDateTimetablePo.setOriginStationID(originStopTimeobj.getString("StationID"));
                }
                if(originStopTimeobj.containsKey("StationName")){
                    JSONObject StationName = JSONObject.parseObject(originStopTimeobj.getString("StationName"));
                    if(StationName.containsKey("Zh_tw")){
                        odAndTrainDateTimetablePo.setOriginStationNameZh(StationName.getString("Zh_tw"));
                    }
                    if(StationName.containsKey("En")){
                        odAndTrainDateTimetablePo.setOriginStationNameEn(StationName.getString("En"));
                    }
                }
                if(originStopTimeobj.containsKey("DepartureTime")){
                    odAndTrainDateTimetablePo.setOriginStationDepartureTime(originStopTimeobj.getString("DepartureTime"));
                }
            }
            /**
             * DestinationStopTime
             */
            if(obj.containsKey("DestinationStopTime")){
                JSONObject destinationStopTimeobj = JSONObject.parseObject(obj.getString("DestinationStopTime"));
                if(destinationStopTimeobj.containsKey("StationID")){
                    odAndTrainDateTimetablePo.setDestinationStationID(destinationStopTimeobj.getString("StationID"));
                }
                if(destinationStopTimeobj.containsKey("StationName")){
                    JSONObject StationName = JSONObject.parseObject(destinationStopTimeobj.getString("StationName"));
                    if(StationName.containsKey("Zh_tw")){
                        odAndTrainDateTimetablePo.setDestinationStationNameZh(StationName.getString("Zh_tw"));
                    }
                    if(StationName.containsKey("En")){
                        odAndTrainDateTimetablePo.setDestinationStationNameEn(StationName.getString("En"));
                    }
                }
                if(destinationStopTimeobj.containsKey("ArrivalTime")){
                    odAndTrainDateTimetablePo.setDestinationStationArrivalTime(destinationStopTimeobj.getString("ArrivalTime"));
                }
            }
            odAndTrainDateTimetablePoList.add(odAndTrainDateTimetablePo);
        }
        /*for(int i= 0;i< odAndTrainDateTimetablePoList.size();i++){
            log.info("i = "+i+" : "+odAndTrainDateTimetablePoList.get(i).toString());
        }*/
        return odAndTrainDateTimetablePoList;
    }
}
