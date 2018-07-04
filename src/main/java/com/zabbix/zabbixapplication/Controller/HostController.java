package com.zabbix.zabbixapplication.Controller;

import com.alibaba.fastjson.JSON;
import com.zabbix.zabbixapplication.Service.*;
import com.zabbix.zabbixapplication.model.Host;
import com.zabbix.zabbixapplication.model.Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HostController {

    @Autowired
    private HostService hostService;

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private TemplateService templateService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private HostInterface hostInterface;

    @GetMapping(value = "hosts/create")
    public String createHost(Model model) {
        model.addAttribute("host", new Host());
        model.addAttribute("interface", new Interface());
        return "hostcontent/form";
    }

    @PostMapping(value = "hosts/create/submit")
    public String submitHost(@ModelAttribute Host host, @ModelAttribute Interface anInterface) {
        host.setAnInterface(anInterface);
        hostService.saveHost(host);
        return "redirect:/hosts";
    }

    @GetMapping(value = "/hosts/edit")
    public String editHost(Model model, @RequestParam("hostid") Integer id) {
        Host host = JSON.parseObject(hostService.getHostById(id).toString(), Host.class);
        Interface anInterface = JSON.parseObject(hostInterface.getHostInterfaceByHostId(id).toString(), Interface.class);
        host.setAnInterface(anInterface);
        model.addAttribute("host", host);
        model.addAttribute("interface", anInterface);
        return "hostcontent/update";
    }

    @PostMapping(value = "hosts/edit/update")
    public String updateHost(@ModelAttribute Host host) {
        hostService.updateHost(host);
        return "redirect:/hosts";
    }

    @GetMapping(value = "hosts/items")
    public String showItemsByHostId(Model model, @RequestParam("hostid") Integer id) {
        model.addAttribute("items", itemService.getItemsByHostId(id));
        return "itemcontent/items";
    }

    @GetMapping(value = "hosts/applications")
    public String showApplicationsByHostId(Model model, @RequestParam("hostid") Integer id) {
/*        String input = applications.get(0).getString("templateids");
        System.out.println(input);
        Pattern pattern = Pattern.compile("[\"(\\d*)\"]");
        System.out.println(pattern);
        Matcher matcher = pattern.matcher(input);
        while(matcher.find())
            System.out.println(matcher.group());
        //System.out.println(Integer.parseInt(templateIds[0]));*/
        model.addAttribute("applications", applicationService.getApplicationsByHostId(id));
        //model.addAttribute("template", templateService.getTemplatesByHostId(id));
        return "appcontent/applications";
    }
}
