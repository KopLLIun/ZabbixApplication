package com.zabbix.zabbixapplication.Service;

import com.alibaba.fastjson.JSONObject;
import com.zabbix.zabbixapplication.model.HostGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class HostGroupServiceImpl implements HostGroupService {

    @Autowired
    private RequestService requestService;

    @Override
    public List<JSONObject> getHostGroups() {
        return requestService.doRequest("hostgroup.get", "output", "extend");
    }

    @Override
    public List<JSONObject> getHostGroupById(Integer id) {
        return requestService.doRequest("hostgroup.get", "groupids", id);
    }

    @Override
    public Set<JSONObject> getHostGroupsByHosts() {
        //Map<String, Object> params = new HashMap<>();
        //params.put("output", new String[] {"groupids", "name"});
        Set<JSONObject> hostgroups = new HashSet<>();
        requestService.doRequest("host.get", "output", new String[] {"hostid","host"}).
                forEach(i -> hostgroups.addAll(
                        requestService.doRequest("hostgroup.get", "hostids", i.getString("hostid"))));
        return hostgroups;
    }

    @Override
    public void saveHostGroup(HostGroup hostGroup) {
        requestService.doRequestForJSON("hostgroup.create", "name", hostGroup.getName());
    }

    @Override
    public void updateHostGroup(HostGroup hostGroup) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("groupid", hostGroup.getGroupId());
        params.put("name", hostGroup.getName());
        requestService.doRequestForJSON("hostgroup.update", params);
    }

    @Override
    public void deleteHostGroup(Integer id) {
/*        JSONObject js = new JSONObject();
        js.put("", new String[] {id.toString()});
        System.out.println(js);*/
        String[] paramValue = {id.toString()};
        requestService.doRequestForJSON("hostgroup.delete", paramValue);
    }
}
