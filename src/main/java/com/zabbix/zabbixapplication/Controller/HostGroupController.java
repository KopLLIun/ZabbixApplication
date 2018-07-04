package com.zabbix.zabbixapplication.Controller;

import com.alibaba.fastjson.JSONObject;
import com.zabbix.zabbixapplication.Service.*;
import com.zabbix.zabbixapplication.model.HostGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HostGroupController {

    @Autowired
    private HostGroupService hostGroupService;

    @Autowired
    private HostService hostService;

    @Autowired
    private TemplateService templateService;

    @GetMapping(value = "/hostgroups/create")
    public String createHostGroup(Model model) {
        model.addAttribute("hostgroup", new HostGroup());
        return "groupcontent/form";
    }

    @PostMapping(value = "/hostgroups/create/submit")
    public String submitHostGroup(@ModelAttribute HostGroup hostGroup) {
        hostGroupService.saveHostGroup(hostGroup);
        return "redirect:/hostgroups";
    }

    @GetMapping(value = "/hostgroups/update") //edit
    public String editHostGroup(Model model, @RequestParam("groupid") Integer id) {
        JSONObject getHostGroup = hostGroupService.getHostGroupById(id).get(0);
        HostGroup hostGroup = new HostGroup();
        hostGroup.setName(getHostGroup.getString("name"));
        hostGroup.setGroupId(Integer.parseInt(getHostGroup.getString("groupid")));
        //System.out.println(hostGroup.getName() + " " + hostGroup.getGroupId());
        model.addAttribute("update", hostGroup);
        return "groupcontent/update";
    }

    @PostMapping(value = "/hostgroups/update/submit") //edit/update
    public String updateHostGroup(@ModelAttribute HostGroup hostGroup) {
        hostGroupService.updateHostGroup(hostGroup);
        return "redirect:/hostgroups";
    }

    @RequestMapping(value = "hostgroups/delete") //edit/delete
    public  String deleteHostGroup(@RequestParam("groupid") Integer id) {
        hostGroupService.deleteHostGroup(id);
        return "redirect:/hostgroups";
    }

    @GetMapping(value = "hostgroups/hosts")
    public String showHostsByGroupID(Model model, @RequestParam("groupid") Integer id) {
        model.addAttribute("hosts", hostService.getHostsByHostGroupId(id));
        return "hostcontent/hosts";
    }

    @GetMapping(value = "hostgroups/templates")
    public String showTemplatesByGroupId(Model model, @RequestParam("groupid") Integer id) {
        List<JSONObject> templates = templateService.getTemplatesByGroupId(id);
        if (templates.size() != 0) {
            model.addAttribute("templates", templates);
        } else {
            model.addAttribute("templates", templateService.getTemplates());
        }
        return "templatecontent/templates";
    }
}
