package com.zabbix.zabbixapplication.Service;

import com.alibaba.fastjson.JSONObject;
import com.zabbix.zabbixapplication.model.Host;

import java.util.List;
import java.util.Set;

public interface HostService {
    List<JSONObject> getHosts();

    JSONObject getHostById(Integer id);

    List<JSONObject> getHostsByHostGroupId(Integer id);

    Set<JSONObject> getHostsByHostGroups();

    void saveHost(Host host);

    void updateHost(Host host);

    void deleteHost(Integer host);
}
