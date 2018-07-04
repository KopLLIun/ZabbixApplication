package com.zabbix.zabbixapplication.Service;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

public interface ApplicationService {
    List<JSONObject> getApplications();

    List<JSONObject> getApplicationsByTemplateId(Integer id);

    List<JSONObject> getApplicationsByHostId(Integer id);
}
