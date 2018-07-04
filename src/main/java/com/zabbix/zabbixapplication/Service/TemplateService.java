package com.zabbix.zabbixapplication.Service;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

public interface TemplateService {
    List<JSONObject> getTemplate(Integer id);

    List<JSONObject> getTemplates();

    List<JSONObject> getTemplatesByHostId(Integer id);

    List<JSONObject> getTemplatesByGroupId(Integer id);
}
