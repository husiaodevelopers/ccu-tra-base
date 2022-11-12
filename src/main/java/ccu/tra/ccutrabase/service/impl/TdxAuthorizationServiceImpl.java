package ccu.tra.ccutrabase.service.impl;

import ccu.tra.ccutrabase.common.constant.Constants;
import ccu.tra.ccutrabase.domain.po.TdxAuthorizationPo;
import ccu.tra.ccutrabase.mapper.TdxAuthorizationMapper;
import ccu.tra.ccutrabase.service.TdxAuthorizationService;
import ccu.tra.ccutrabase.utils.HttpUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

/**
 * @author hu
 */
@Service
@Slf4j
public class TdxAuthorizationServiceImpl extends ServiceImpl<TdxAuthorizationMapper, TdxAuthorizationPo> implements TdxAuthorizationService {
    @Value("${tdx.client.id}")
    private String clientId;
    @Value("${tdx.client.secret}")
    private String clientSecret;
    @Autowired
    private TdxAuthorizationMapper tdxAuthorizationMapper;

    @Override
    public TdxAuthorizationPo getAccessToken() {
        LambdaQueryWrapper<TdxAuthorizationPo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByDesc(TdxAuthorizationPo::getExpiresDate);
        TdxAuthorizationPo selectOne = tdxAuthorizationMapper.selectOne(queryWrapper);
        return selectOne;
    }

    @Override
    public String getAccessTokenFromTdx() {
        String accessToken = HttpUtils.getAccessToken(clientId,clientSecret);
        Timestamp expireDate = new Timestamp(System.currentTimeMillis()+ Constants.TimestampOfDate.oneDay);
        tdxAuthorizationMapper.insert(TdxAuthorizationPo.builder().accessToken(accessToken).expiresDate(expireDate).build());
        return accessToken;
    }

}
