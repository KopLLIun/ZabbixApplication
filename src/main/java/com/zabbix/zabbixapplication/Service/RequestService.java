package com.zabbix.zabbixapplication.Service;

import com.alibaba.fastjson.JSONObject;

import java.util.List;
import java.util.Map;

public interface RequestService {
    //Запрос на получение JSON-объекта
    JSONObject doRequestForJSON(String methodName, String paramKey, Object paramValue);

    //Запрос на получение JSON-объекта
    JSONObject doRequestForJSON(String methodName, Map<String, Object> params);

    //Запрос на получение JSON-объекта
    JSONObject doRequestForJSON(String methodName, Object paramValue);

    //Запрос на получение JSON-массива
    List<JSONObject> doRequest(String methodName, String paramKey, Object paramValue);

    //Запрос на получение JSON-массива
    List<JSONObject> doRequest(String methodName, Map<String, Object> params);
}
