package com.anjiplus.template.gaea.business.modules.datasettransform.service;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**

 */
public interface IGroovyHandler {

    List<JSONObject> transform(List<JSONObject> data);
}
