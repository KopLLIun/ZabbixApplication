package com.zabbix.zabbixapplication.Controller;

import com.zabbix.zabbixapplication.Service.ItemService;
import com.zabbix.zabbixapplication.Service.TriggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private TriggerService triggerService;

    @GetMapping(value = "items/triggers")
    public String getTriggersByItemId(Model model, @RequestParam ("itemid") Integer id) {
        model.addAttribute("triggers", triggerService.getTriggersByItemId(id));
        return "triggercontent/triggers";
    }

}
