package ccu.tra.ccutrabase.domain.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;


/**
 * @author hu
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("tdx_authorization")
@ApiModel(value="tdxAuthorization", description="")
public class TdxAuthorizationPo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "TDX的access_token")
    private String accessToken;

    @ApiModelProperty(value = "過期時間")
    private Timestamp expiresDate;


}