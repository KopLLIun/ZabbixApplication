package com.zabbix.zabbixapplication.Controller;

import com.zabbix.zabbixapplication.Service.HistoryService;
import com.zabbix.zabbixapplication.Service.HostService;
import com.zabbix.zabbixapplication.Service.ItemService;
import com.zabbix.zabbixapplication.Service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class WebController {

    @Autowired
    private RequestService requestService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private HostService hostService;

    @Autowired
    private HistoryService historyService;

    @GetMapping(value = "/script")
    public String executeScript() {
        //Map<String, Object> params = new HashMap<>();
        //params.put("scriptid", 1);
        //params.put("hostid", 10084);
        //return requestService.doRequest("script.execute", params).toString();
        return requestService.doRequest("script.execute", "output", "extend").toString();
    }

    @GetMapping(value = "/hosts/groupids")
    public String showHosts(@RequestParam("hostgroup_id") Integer id) {
        return hostService.getHostsByHostGroupId(id).toString();
    }

    @GetMapping(value = "/charts/chart")
    public String showCharts(@RequestParam("host_id") Integer id) {
        return requestService.doRequest("graph.get", "hostids", id).toString();
    }

    @GetMapping(value = "/items")
    public String showItems(@RequestParam("host_id") Integer id) {
        return itemService.getItemsByHostId(id).toString();
    }

    @GetMapping(value = "/history")
    public String showLatest(@RequestParam("item_id") Integer id) {
        return historyService.getHistoryByItemId(id).toString();
    }

    //Последние данные по host_id
    @GetMapping(value = "/last-data/host_ids")
    public String showLastDataByHostId(@RequestParam("host_id") Integer id, Model model) {
        return model.addAttribute("last_data", itemService.getItemsByHostId(id)).toString();
    }

    //Последние данные по host_group_id
    @GetMapping(value = "/last-data/hostgroup_ids")
    public String showLastDataByHostGroupId(@RequestParam("hostgroup_id") Integer id, Model model) {
        return model.addAttribute("last_data", itemService.getItemsByHostGroupId(id)).toString();
    }

    @GetMapping(value = "/graph")
    public String showGraph() {
        return requestService.doRequest("graph.get", "itemids", 28340).toString();
    }
}
