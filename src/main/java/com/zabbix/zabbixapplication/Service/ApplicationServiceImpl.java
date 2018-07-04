package com.zabbix.zabbixapplication.Service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    private RequestService requestService;


    @Override
    public List<JSONObject> getApplications() {
        return requestService.doRequest("application.get", "output","extend");
    }

    @Override
    public List<JSONObject> getApplicationsByTemplateId(Integer id) {
        return requestService.doRequest("application.get", "templateids", id);
    }

    @Override
    public List<JSONObject> getApplicationsByHostId(Integer id) {
        //Map<String, Object> params = new HashMap<>();
        //params.put("output", new String[] {"hostids", "name"});
        //Set<JSONObject> applications = new HashSet<>();
        //requestService.doRequest("host.get", "output", new String[] {"hostid","host"}).
        //        forEach(i -> applications.addAll(
        return requestService.doRequest("application.get", "hostids", id);

    }
}
