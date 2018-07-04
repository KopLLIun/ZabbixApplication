package com.zabbix.zabbixapplication.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zabbix.zabbixapplication.model.Host;
import com.zabbix.zabbixapplication.model.Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class HostServiceImpl implements HostService {

    @Autowired
    private RequestService requestService;

    @Override
    public List<JSONObject> getHosts() {
        //Map<String, Object> params = new HashMap<>();
        //params.put("output", new String[] {"hostid", "host"});
        //JSONObject search = new JSONObject();
        //search.put("ip", "127.0.0.1");
        //params.put("search", search);
        //return requestService.doRequest("host.get", params);
        return requestService.doRequest("host.get", "output", new String[] {"hostid", "host"});
    }

    @Override
    public JSONObject getHostById(Integer id) {
        return requestService.doRequest("host.get", "hostids", id).get(0);
    }

    @Override
    public Set<JSONObject> getHostsByHostGroups() {
        //Map<String, Object> params = new HashMap<>();
        //params.put("groupids", id);
        Set<JSONObject> hosts = new HashSet<>();
        requestService.doRequest("hostgroup.get", "output", "extend").
                forEach(i -> hosts.addAll(
                        requestService.doRequest("host.get", "groupids", i.getString("groupid"))));
        return hosts;
    }

    @Override
    public void saveHost(Host host) {
        Map<String, Object> params = new HashMap<>();
        params.put("host", host.getHost());
        //Interface anInterface = new Interface();
/*        anInterface.setType(1);
        anInterface.setMain(1);
        anInterface.setUseip(1);
        anInterface.setIp("127.0.0.23");
        anInterface.setDns("");
        anInterface.setPort(2312);
        host.setAnInterface(anInterface);*/
        JSONArray interfaces = new JSONArray();
        JSONObject anInterface = (JSONObject)JSON.toJSON(host.getAnInterface());
        interfaces.add(anInterface);
        JSONArray groups = new JSONArray();
        JSONObject group = new JSONObject();
        group.put("groupid", 5);
        groups.add(group);
/*        JSONArray templates = new JSONArray();
        JSONObject template = new JSONObject();
        templates.add(template);
        template.put("templateid", 1016);*/
        System.err.println(groups);
        System.err.println(interfaces);
        System.err.println(host.getHost());
        params.put("interfaces", interfaces);
        params.put("groups", groups);
        //params.put("templates", templates);
/*        JSONObject inv = new JSONObject();
        inv.put("macaddress_a", "01234");
        inv.put("macaddress_b", "56768");
        params.put("inventory_mode",0);
        params.put("inventory", inv);*/
        requestService.doRequestForJSON("host.create", params);
    }

    @Override
    public void updateHost(Host host) {

    }

    @Override
    public void deleteHost(Integer host) {

    }

    @Override
    public List<JSONObject> getHostsByHostGroupId(Integer id) {
        Map<String, Object> params = new HashMap<>();
        params.put("groupids", id);
        return requestService.doRequest("host.get", params);
    }
}
