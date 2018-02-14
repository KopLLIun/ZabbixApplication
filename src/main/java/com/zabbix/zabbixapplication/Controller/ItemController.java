package com.zabbix.zabbixapplication.Controller;

import com.zabbix.zabbixapplication.Service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ItemController {

    @Autowired
    private RequestService requestService;

    @GetMapping(value = "/devices")
    public String show(@RequestParam("host_id") Integer id) {
        //Map<String, Object> params = new HashMap<>();
        //params.put("output", new String[] {"hostid", "host"});
        //params.put("filter", new JSONObject().put("host", new String[] {"Zabbix server"}));
        //List<JSONObject> list = requestService.doRequest("item.get", "hostids", id);
        //model.addAttribute("process", list);
        //System.out.println(list.toString());
        //requestService.doRequest("host.get", params);
        Map<String, Object> params = new HashMap<>();
        params.put("output", "extend");
        //params.put("sortfield", "name");
        params.put("sortorder", "DESC");
        params.put("hostids", id);
        return requestService.doRequest("item.get", params).toString();
    }

    @GetMapping(value = "/history")
    public String showHistory(@RequestParam("item_id") Integer id) {
        Map<String, Object> params = new HashMap<>();
        params.put("output", "extend");
        params.put("history", 0);
        params.put("itemids", id);
        params.put("sortfield", "clock");
        params.put("sortorder", "DESC");
        params.put("limit", 10);
        return requestService.doRequest("history.get", params).toString();
    }
}
