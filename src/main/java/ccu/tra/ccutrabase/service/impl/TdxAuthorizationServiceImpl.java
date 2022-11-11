package ccu.tra.ccutrabase.service.impl;

import ccu.tra.ccutrabase.domain.po.TdxAuthorizationPo;
import ccu.tra.ccutrabase.mapper.TdxAuthorizationMapper;
import ccu.tra.ccutrabase.service.TdxAuthorizationService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hu
 */
@Service("TdxAuthorizationService")
public class TdxAuthorizationServiceImpl extends ServiceImpl<TdxAuthorizationMapper, TdxAuthorizationPo> implements TdxAuthorizationService {

    @Autowired
    private TdxAuthorizationMapper tdxAuthorizationMapper;

    @Override
    public TdxAuthorizationPo getAccessToken() {
        LambdaQueryWrapper<TdxAuthorizationPo> queryWrapper = new LambdaQueryWrapper<>();
        TdxAuthorizationPo selectOne = tdxAuthorizationMapper.selectOne(queryWrapper.orderByDesc(TdxAuthorizationPo::getExpiresDate));
        return selectOne;
    }
}
