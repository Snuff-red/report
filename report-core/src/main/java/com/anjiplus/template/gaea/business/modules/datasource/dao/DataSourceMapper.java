package com.anjiplus.template.gaea.business.modules.datasource.dao;

import org.apache.ibatis.annotations.Mapper;

import com.anji.plus.gaea.curd.mapper.GaeaBaseMapper;
import com.anjiplus.template.gaea.business.modules.datasource.dao.entity.DataSource;

/**
* DataSource Mapper

**/
@Mapper
public interface DataSourceMapper extends GaeaBaseMapper<DataSource> {

}
