package com.zabbix.zabbixapplication.Controller;

import com.zabbix.zabbixapplication.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class MainController {

    @Autowired
    private RequestService requestService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private HistoryService historyService;

    @Autowired
    private HostService hostService;

    @Autowired
    private HostGroupService hostGroupService;

    @Autowired
    private TemplateService templateService;

    //Главная страница
    @GetMapping(value = {"/", "index"})
    public String indexPage(Model model) {
        //connectionService.initConnection("http://192.168.1.50/zabbix/api_jsonrpc.php");
        Map<String, Object> params = new HashMap<>();
        params.put("output", new String[] {"hostid", "host"});
        model.addAttribute("hosts", requestService.doRequest("host.get",  params));
        //model.addAttribute("apid", requestService.doRequest("application.get"))
        return "index";
    }

    //Графики
    @GetMapping(value = "/charts")
    public String showCharts(Model model) {
        model.addAttribute("hostgroups", hostGroupService.getHostGroupsByHosts());
        return "charts";
    }

    //Авторизация
    @GetMapping(value = "/login")
    public String loginZabbix(Model model) {
        model.addAttribute("user", new ConnectionServiceImpl());
        return "login";
    }

    @PostMapping(value = "/login/submit")
    public String authUser(@ModelAttribute ConnectionServiceImpl auth) {
        return "redirect:/index";
    }

    @GetMapping(value = "/devices")
    public String showValue(Model model) {
        model.addAttribute("devices", requestService.doRequest("application.get", "output", "extend"));
        //model.addAttribute("devices", requestService.doRequest("valuemap.get", "output", "extend"));
        return "devices";
    }

    //Последние данные
    @GetMapping(value = "/last-data")
    public String showLastData(Model model) {
        model.addAttribute("hostgroups", hostGroupService.getHostGroupsByHosts());
        return "latest";
    }

    @GetMapping(value = "/last-data/graph")
    public String showGraphByItemId(@RequestParam("item_id") Integer id, Model model) {
        //"http://192.168.1.50/zabbix/chart.php?itemids="
        //                +
        model.addAttribute("graph", itemService.getItem(id).get(0).getString("itemid"));
        return "history";
    }

    @GetMapping(value = "/last-data/last-value")
    public String showLastValueByItemId(@RequestParam("item_id") Integer id, Model model) {
        model.addAttribute("values", historyService.getHistoryByItemId(id));//historyService!!!
        return "history";
    }

    @GetMapping(value = "/hostgroups")
    public String showHostGroupsPage(Model model) {
        model.addAttribute("hostgroups", hostGroupService.getHostGroups());
        //model.addAttribute("hosts", hostService.getHostsByHostGroups());
        return "groupcontent/hostgroups";
    }

    @GetMapping(value = "/templates")
    public String showTemplatesPage(Model model) {
        model.addAttribute("templates", templateService.getTemplates());
        return "templatecontent/templates";
    }

    @GetMapping(value = "report")
    public String showStatusReport(Model model) {
        return "report";
    }

    @GetMapping(value = "/hosts")
    public String showHostsPage(Model model) {
        model.addAttribute("hosts", hostService.getHosts());
/*        model.addAttribute("applications", null);
        model.addAttribute("items", itemService.getItemsByHostId(10084));
        model.addAttribute("graphs", null);
        model.addAttribute("interface", null);
        model.addAttribute("templates", null);*/
        return "hostcontent/hosts";
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
