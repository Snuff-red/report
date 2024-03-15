package com.anjiplus.template.gaea.business.modules.accessrole.dao;

import org.apache.ibatis.annotations.Mapper;
import com.anji.plus.gaea.curd.mapper.GaeaBaseMapper;
import com.anjiplus.template.gaea.business.modules.accessrole.dao.entity.AccessRole;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
* AccessRole Mapper
**/
@Mapper
public interface AccessRoleMapper extends GaeaBaseMapper<AccessRole> {

    List<String> checkedAuthoritys(@Param("roleCode")String roleCode);
}