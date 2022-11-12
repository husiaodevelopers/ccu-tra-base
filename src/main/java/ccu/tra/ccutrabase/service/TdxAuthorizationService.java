package ccu.tra.ccutrabase.service;

import ccu.tra.ccutrabase.domain.po.TdxAuthorizationPo;
import com.baomidou.mybatisplus.extension.service.IService;

public interface TdxAuthorizationService extends IService<TdxAuthorizationPo> {

    TdxAuthorizationPo getAccessToken();

    String getAccessTokenFromTdx();
}
