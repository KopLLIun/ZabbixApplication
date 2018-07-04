package com.zabbix.zabbixapplication.Service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GraphServiceImpl implements GraphService{

    @Autowired
    private RequestService requestService;

    @Override
    public List<JSONObject> getGraphs() {
        return requestService.doRequest("graph.get", "output", "extend");
    }

    @Override
    public List<JSONObject> getGraphsByTemplateId(Integer id) {
        return requestService.doRequest("graph.get", "templateids", id);
    }
}
