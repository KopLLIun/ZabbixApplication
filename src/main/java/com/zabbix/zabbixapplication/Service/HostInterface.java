package com.zabbix.zabbixapplication.Service;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

public interface HostInterface {
    JSONObject getHostInterfaceByHostId(Integer id);

    List<JSONObject> getHostInterfacesByHostId(Integer id);

    List<JSONObject> getHostInterfaces();
}
