package com.zabbix.zabbixapplication.Service;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

public interface GraphService {
    List<JSONObject> getGraphs();

    List<JSONObject> getGraphsByTemplateId(Integer id);
}
