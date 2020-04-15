package com.github.yiuman.citrus.support.crud.service;

import com.baomidou.mybatisplus.core.metadata.TableInfo;
import com.baomidou.mybatisplus.core.metadata.TableInfoHelper;
import com.baomidou.mybatisplus.core.toolkit.ReflectionKit;

import java.io.Serializable;

/**
 * 基于主键的Service
 *
 * @author yiuman
 * @date 2020/4/15
 */
public interface KeyBasedService<E, K extends Serializable> extends EntityTypeService<E> {

    String DEFAULT_KEY_FIELD_NAME = "id";

    /**
     * 获取主键类型
     */
    @SuppressWarnings("unchecked")
    default Class<K> getKeyType() {
        return (Class<K>) ReflectionKit.getSuperClassGenericType(getClass(), 1);
    }

    /**
     * 根据实体类型获取主键
     *
     * @param entity 实体类型
     * @return 主键
     */
    @SuppressWarnings("unchecked")
    default K getKey(E entity) throws Exception {
        Class<K> keyType = getKeyType();
        TableInfo tableInfo = TableInfoHelper.getTableInfo(keyType);
        return (K) ReflectionKit.getMethodValue(keyType, entity, tableInfo.getKeyProperty());
    }

}