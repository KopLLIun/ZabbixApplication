package com.zabbix.zabbixapplication.Service;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

public interface TriggerService {
    List<JSONObject> getTriggers();

    List<JSONObject> getTriggersByTemplateId(Integer id);

    List<JSONObject> getTriggersByItemId(Integer id);

}
