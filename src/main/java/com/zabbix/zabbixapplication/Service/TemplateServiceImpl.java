package com.zabbix.zabbixapplication.Service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemplateServiceImpl implements TemplateService{

    @Autowired
    private RequestService requestService;

    @Override
    public List<JSONObject> getTemplate(Integer id) {
        return requestService.doRequest("template.get", "templateids", id);
    }

    @Override
    public List<JSONObject> getTemplates() {
        return requestService.doRequest("template.get", "output", "extend");
    }

    @Override
    public List<JSONObject> getTemplatesByHostId(Integer id) {
        return requestService.doRequest("template.get", "hostids", id);
    }

    @Override
    public List<JSONObject> getTemplatesByGroupId(Integer id) {
        return requestService.doRequest("template.get", "groupids", id);
    }
}
