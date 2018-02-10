package com.zabbix.zabbixapplication.Controller;

import com.alibaba.fastjson.JSONObject;
import com.zabbix.zabbixapplication.Service.ConnectionServiceImpl;
import com.zabbix.zabbixapplication.Service.RequestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

//@RestController
//@RequestMapping(value = "/index")
@Controller
public class MainController {

    @Autowired
    private ConnectionServiceImpl connectionService;

    @Autowired
    private RequestServiceImpl requestService;

    @RequestMapping(value = "/")
    public String home() {
        connectionService.initConnection("http://192.168.1.50/zabbix/api_jsonrpc.php");
        return "index";//connectionService.getConnection("http://192.168.1.50/zabbix/api_jsonrpc.php");
    }

    @RequestMapping(value = "/devices", method = RequestMethod.GET)
    public String showDevices(Model model /*, @PathVariable ("id") Long id*/) {
        //model.addAttribute("devices", requestService.doRequest("localhost", "host.get"));
        Map<String, Object> params = new HashMap<>();
        params.put("output", new String[] {"hostid", "host"});
        //params.put("filter", new JSONObject().put("host", new String[] {"Zabbix server"}));
        model.addAttribute("devices", requestService.doRequest( "host.get", params));
        return "devices";
    }
}
