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
    public String queryByODAndTrainDate(DailyTimetableVo dailyTimetableVo)  {
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
                    JSONObject StartingStationName = JSONObject.parseObject(obj.getString("StartingStationName"));
                    if(dailyTrainobj.containsKey("Zh_tw")){
                        odAndTrainDateTimetablePo.setStartingStationNameZh(StartingStationName.getString("Zh_tw"));
                    }
                    if(dailyTrainobj.containsKey("En")){
                        odAndTrainDateTimetablePo.setStartingStationNameEn(StartingStationName.getString("En"));
                    }
                }
                if(dailyTrainobj.containsKey("EndingStationID")){
                    odAndTrainDateTimetablePo.setEndingStationID(dailyTrainobj.getString("EndingStationID"));
                }
                if(dailyTrainobj.containsKey("EndingStationName")){
                    JSONObject EndingStationName = JSONObject.parseObject(obj.getString("EndingStationName"));
                    if(dailyTrainobj.containsKey("Zh_tw")){
                        odAndTrainDateTimetablePo.setEndingStationNameZh(EndingStationName.getString("Zh_tw"));
                    }
                    if(dailyTrainobj.containsKey("En")){
                        odAndTrainDateTimetablePo.setEndingStationNameEn(EndingStationName.getString("En"));
                    }
                }
                if(dailyTrainobj.containsKey("TrainTypeID")){
                    odAndTrainDateTimetablePo.setTrainTypeID(dailyTrainobj.getString("TrainTypeID"));
                }
                if(dailyTrainobj.containsKey("TrainTypeName")){
                    JSONObject TrainTypeName = JSONObject.parseObject(obj.getString("TrainTypeName"));
                    if(dailyTrainobj.containsKey("Zh_tw")){
                        odAndTrainDateTimetablePo.setTrainTypeNameZh(TrainTypeName.getString("Zh_tw"));
                    }
                    if(dailyTrainobj.containsKey("En")){
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
                    odAndTrainDateTimetablePo.setTrainTypeID(originStopTimeobj.getString("TrainTypeID"));
                }
                if(originStopTimeobj.containsKey("StartingStationName")){
                    JSONObject StartingStationName = JSONObject.parseObject(obj.getString("StartingStationName"));
                    if(originStopTimeobj.containsKey("Zh_tw")){
                        odAndTrainDateTimetablePo.setStartingStationNameZh(StartingStationName.getString("Zh_tw"));
                    }
                    if(originStopTimeobj.containsKey("En")){
                        odAndTrainDateTimetablePo.setStartingStationNameEn(StartingStationName.getString("En"));
                    }
                }

            }
            /**
             * DestinationStopTime
             */
            if(obj.containsKey("DestinationStopTime")){
                /*log.info("DestinationStopTime : ");
                //JSONArray dailyTrainArr = obj.getJSONArray("DestinationStopTime");
                //JSONObject obj1 = (JSONObject) dailyTrainArr.get(0);
                log.info("obj3 : "+obj.toString());
                log.info("obj3 : "+obj.getString("DestinationStopTime"));*/
            }
            odAndTrainDateTimetablePoList.add(odAndTrainDateTimetablePo);
        }
        /*for(int i= 0;i< odAndTrainDateTimetablePoList.size();i++){
            log.info("i = "+i+" : "+odAndTrainDateTimetablePoList.get(i).toString());
        }*/
        return result;
    }
}
