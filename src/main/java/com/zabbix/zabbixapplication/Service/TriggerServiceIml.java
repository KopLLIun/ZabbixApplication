package com.zabbix.zabbixapplication.Service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TriggerServiceIml implements TriggerService{

    @Autowired
    private RequestService requestService;

    @Override
    public List<JSONObject> getTriggers() {
        return requestService.doRequest("triiger.get", "output", "extend");
    }

    @Override
    public List<JSONObject> getTriggersByTemplateId(Integer id) {
        return requestService.doRequest("trigger.get", "templateids", id);
    }

    @Override
    public List<JSONObject> getTriggersByItemId(Integer id) {
        return requestService.doRequest("trigger.get", "itemids", id);
    }
}
