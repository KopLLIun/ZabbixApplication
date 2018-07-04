package com.zabbix.zabbixapplication.Service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HostInterfaceImpl implements HostInterface {

    @Autowired
    private RequestService requestService;

    @Override
    public JSONObject getHostInterfaceByHostId(Integer id) {
        return requestService.doRequest("hostinterface.get", "hostids", id).get(0);
    }

    @Override
    public List<JSONObject> getHostInterfacesByHostId(Integer id) {
        return requestService.doRequest("hostinterface.get", "hostids", id);
    }

    @Override
    public List<JSONObject> getHostInterfaces() {
        return requestService.doRequest("hostinterface.get", "output", "extend");
    }
}
