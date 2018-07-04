package com.zabbix.zabbixapplication.Service;

import com.alibaba.fastjson.JSONObject;
import com.zabbix.zabbixapplication.model.HostGroup;

import java.util.List;
import java.util.Set;

public interface HostGroupService {
    List<JSONObject> getHostGroups();

    List<JSONObject> getHostGroupById(Integer id);

    Set<JSONObject> getHostGroupsByHosts();

    void saveHostGroup(HostGroup hostGroup);

    void updateHostGroup(HostGroup hostGroup);

    void deleteHostGroup(Integer id);
}
