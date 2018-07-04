package com.zabbix.zabbixapplication.Service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HistoryServiceImpl implements HistoryService{

    @Autowired
    private RequestService requestService;

    @Override
    public List<JSONObject> getHistory() {
        return requestService.doRequest("history.get", "output", "extend");
    }

    @Override
    public List<JSONObject> getHistoryByItemId(Integer id) {
        Map<String, Object> params = new HashMap<>();
        params.put("output", "extend");
        params.put("history", 0);
        params.put("itemids", id);
        params.put("sortfield", "clock");
        params.put("sortorder", "DESC");
        params.put("limit", 10);
        return requestService.doRequest("history.get", params);
    }
}
