package ccu.tra.ccutrabase.domain.po;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class ODAndTrainDateTimetablePo implements Serializable {
    public interface List {}

    private static final long serialVersionUID = 1L;@NotNull(message = "起點車站代碼", groups = {ODAndTrainDateTimetablePo.List.class})

    private String trainNo;

    private String startingStationID;

    @JsonProperty(value = "startingStationNameZh")
    private String startingStationNameZh;

    @JsonProperty(value = "startingStationNameEn")
    private String startingStationNameEn;

    private String endingStationID;

    @JsonProperty(value = "endingStationNameZh")
    private String endingStationNameZh;

    @JsonProperty(value = "endingStationNameEn")
    private String endingStationNameEn;

    private String trainTypeID;

    @JsonProperty(value = "trainTypeNameZh")
    private String trainTypeNameZh;

    @JsonProperty(value = "trainTypeNameEn")
    private String trainTypeNameEn;

    private String originStationID;

    @JsonProperty(value = "originStationNameZh")
    private String originStationNameZh;

    @JsonProperty(value = "originStationNameEn")
    private String originStationNameEn;

    private String originStationDepartureTime;

    private String destinationStationID;

    @JsonProperty(value = "originStationNameZh")
    private String destinationStationNameZh;

    @JsonProperty(value = "originStationNameEn")
    private String destinationStationNameEn;

    private String destinationStationArrivalTime;

}
