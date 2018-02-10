package com.zabbix.zabbixapplication.Service;

import com.alibaba.fastjson.JSONObject;

import java.util.List;
import java.util.Map;

public interface RequestService {

    List<JSONObject> doRequest(String methodName, String paramKey, Object paramValue);

    List<JSONObject> doRequest(String methodName, Map<String, Object> params);
}
