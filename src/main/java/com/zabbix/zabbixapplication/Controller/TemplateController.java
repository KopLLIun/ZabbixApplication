package com.zabbix.zabbixapplication.Controller;

import com.zabbix.zabbixapplication.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TemplateController {

    @Autowired
    private TemplateService templateService;

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private TriggerService triggerService;

    @Autowired
    private GraphService graphService;

    @GetMapping(value = "templates/applications")
    public String showAppsByTemplateId(Model model, @RequestParam ("templateid") Integer id) {
        model.addAttribute("applications", applicationService.getApplicationsByTemplateId(id));
        return "appcontent/applications";
    }

    @GetMapping(value = "templates/items")
    public String showItemsByTemplateId(Model model, @RequestParam ("templateid") Integer id) {
        model.addAttribute("items", itemService.getItemsByTemplateId(id));
        return "itemcontent/items";
    }

    @GetMapping(value = "templates/triggers")
    public String showTriggersByTemplateId(Model model, @RequestParam ("templateid") Integer id) {
        model.addAttribute("triggers", triggerService.getTriggersByTemplateId(id));
        return "triggercontent/triggers";
    }

    @GetMapping(value = "templates/graphs")
    public String showGraphsByTemplateId(Model model, @RequestParam ("templateid") Integer id) {
        model.addAttribute("graphs", graphService.getGraphsByTemplateId(id));
        return "graphcontent/graphs";
    }
}
