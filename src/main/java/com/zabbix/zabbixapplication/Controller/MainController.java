package com.zabbix.zabbixapplication.Controller;

import com.zabbix.zabbixapplication.Service.ConnectionService;
import com.zabbix.zabbixapplication.Service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private ConnectionService connectionService;

    @Autowired
    private RequestService requestService;

    @GetMapping(value = "/")
    public String indexPage(Model model) {
        connectionService.initConnection("http://192.168.1.50/zabbix/api_jsonrpc.php");
        Map<String, Object> params = new HashMap<>();
        params.put("output", new String[] {"hostid", "host"});
        model.addAttribute("hosts", requestService.doRequest("host.get", params));
        return "index";
    }

    @GetMapping(value = "/login")
    public String loginZabbix() {

        return "login";
    }

/*    @GetMapping(value = "/history")
    public String showHistory(Model model, @RequestParam("item_id") Integer id) {
        model.addAttribute("history", requestService.doRequest("history.get", "itemids", id));
        return "history";
    }*/

/*    @RequestMapping(value = "/devices", method = RequestMethod.GET)
    public String showDevices(Model model *//*, @PathVariable ("id") Long id*//*) {
        Map<String, Object> params = new HashMap<>();
        params.put("output", new String[] {"hostid", "host"});
        //params.put("filter", new JSONObject().put("host", new String[] {"Zabbix server"}));
        List<JSONObject> list = new ArrayList<>();
        requestService.doRequest( "host.get", params)
                .forEach(i -> list.addAll(requestService.doRequest(
                        "item.get",
                        "hostids",
                        i.getString("hostid"))));
        model.addAttribute("devices", list);
        return "devices";
    }*/

/*    @RequestMapping(value = "/devices", method = RequestMethod.GET)
    public String show(Model model, @RequestParam("items_id") Integer id) {
        //Map<String, Object> params = new HashMap<>();
        //params.put("output", new String[] {"hostid", "host"});
        //params.put("filter", new JSONObject().put("host", new String[] {"Zabbix server"}));
        //List<JSONObject> list = requestService.doRequest("item.get", "hostids", id);
        //model.addAttribute("process", list);
        //System.out.println(list.toString());
        //requestService.doRequest("host.get", params);
        return requestService.doRequest("item.get", "hostids", id).toString();
    }*/
}
