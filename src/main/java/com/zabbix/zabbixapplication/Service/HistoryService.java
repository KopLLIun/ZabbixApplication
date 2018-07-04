package com.zabbix.zabbixapplication.Service;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

public interface HistoryService {
    List<JSONObject> getHistory();

    List<JSONObject> getHistoryByItemId(Integer id);
}
