package ccu.tra.ccutrabase.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DailyTimetableVo implements Serializable {
    public interface List {}

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "起點車站代碼", required = true)
    @NotNull(message = "起點車站代碼", groups = {DailyTimetableVo.List.class})
    private String OriginStationID;
    @ApiModelProperty(value = "迄點車站代碼", required = true)
    @NotNull(message = "迄點車站代碼", groups = {DailyTimetableVo.List.class})
    private String DestinationStationID;
    @ApiModelProperty(value = "欲查詢的日期(格式: yyyy-MM-dd)", required = true)
    @NotNull(message = "欲查詢的日期(格式: yyyy-MM-dd)", groups = {DailyTimetableVo.List.class})
    private String TrainDate;

    /**
     * 挑選
     */
    private String select;
    /**
     * 過濾
     */
    private String filter;
    /**
     * 排序
     */
    private String orderby;
    /**
     * 取前幾筆
     */
    private Integer top;
    /**
     * 跳過前幾筆
     */
    private String skip;
    /**
     * 加入參數'?health=true'即可查詢此API服務的健康狀態
     */
    private String health;
    /**
     * 指定來源格式
     */
    @ApiModelProperty(value = "指定來源格式", required = true)
    private String format;
}