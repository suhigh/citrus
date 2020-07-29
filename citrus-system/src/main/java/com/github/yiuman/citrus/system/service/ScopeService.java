package com.github.yiuman.citrus.system.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.yiuman.citrus.support.crud.service.BaseDtoService;
import com.github.yiuman.citrus.system.dto.ScopeDto;
import com.github.yiuman.citrus.system.entity.Scope;
import com.github.yiuman.citrus.system.entity.ScopeDefine;
import com.github.yiuman.citrus.system.mapper.ScopeDefineMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 数据范围逻辑层
 *
 * @author yiuman
 * @date 2020/6/1
 */
@Service
public class ScopeService extends BaseDtoService<Scope, Long, ScopeDto> {

    private final ScopeDefineMapper scopeDefineMapper;

    public ScopeService(ScopeDefineMapper scopeDefineMapper) {
        this.scopeDefineMapper = scopeDefineMapper;
    }

    @Override
    public <P extends IPage<ScopeDto>> P page(P page, Wrapper<ScopeDto> queryWrapper) {
        P returnPage = super.page(page, queryWrapper);
        returnPage.getRecords().forEach(item -> item.setScopeDefines(scopeDefineMapper.selectList(Wrappers.<ScopeDefine>query().eq(getKeyColumn(), item.getScopeId()))));
        return returnPage;
    }

    @Override
    public boolean beforeSave(ScopeDto entity) throws Exception {
        if (entity.getOrganId() == null) {
            entity.setOrganId(-1L);
        }
        return true;
    }

    @Override
    public void afterSave(ScopeDto entity) throws Exception {
        //删除旧的
        scopeDefineMapper.delete(Wrappers.<ScopeDefine>lambdaQuery().eq(ScopeDefine::getScopeId, entity.getScopeId()));

        if (!CollectionUtils.isEmpty(entity.getScopeDefines())) {
            scopeDefineMapper.saveBatch(entity.getScopeDefines());
        }
    }

    public Scope getDataScopeByResourceId(Long resourceId) {
        return scopeDefineMapper.getScopeByResourceId(resourceId);
    }

    public List<ScopeDefine> getScopeDefinesByResourceId(Long resourceId) {
        return scopeDefineMapper.getScopeDefinesByResourceId(resourceId);
    }
}
