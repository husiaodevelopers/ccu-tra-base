package ccu.tra.ccutrabase.service.impl;
import cn.hutool.core.util.ObjectUtil;
import ccu.tra.ccutrabase.domain.po.TdxAuthorizationPo;
import ccu.tra.ccutrabase.mapper.TdxAuthorizationMapper;
import ccu.tra.ccutrabase.service.TdxAuthorizationService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class TdxAuthorizationServiceImpl extends ServiceImpl<TdxAuthorizationMapper, TdxAuthorizationPo> implements TdxAuthorizationService {

    @Autowired
    private TdxAuthorizationMapper tdxAuthorizationMapper;
    /*
    @Override
    public TdxAuthorizationPo getAccessToken() {
        LambdaQueryWrapper<TdxAuthorizationPo> queryWrapper = new LambdaQueryWrapper<>();
        TdxAuthorizationPo selectOne = tdxAuthorizationMapper.(queryWrapper);
        return queryWrapper;
    }*/
}
