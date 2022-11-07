package ccu.tra.ccutrabase.domain.po;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("tdx_authorization")
@ApiModel(value="tdxAuthorization", description="")
public class TdxAuthorizationPo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @ApiModelProperty(value = "TDX的access_token")
    private String accesstoken;

    @ApiModelProperty(value = "過期時間")
    private Timestamp expiresDate;


}