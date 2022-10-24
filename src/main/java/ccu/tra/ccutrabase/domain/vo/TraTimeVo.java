package ccu.tra.ccutrabase.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TraTimeVo implements Serializable {


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
    private String format;
}
