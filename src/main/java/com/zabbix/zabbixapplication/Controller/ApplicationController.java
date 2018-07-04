package com.zabbix.zabbixapplication.Controller;

import com.zabbix.zabbixapplication.Service.ApplicationService;
import com.zabbix.zabbixapplication.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private ItemService itemService;

    @GetMapping(value = "/applications/items")
    public String showItemsByAppId(Model model, @RequestParam ("applicationid") Integer id) {
        model.addAttribute("items", itemService.getItemsByApplicationId(id));
        return "itemcontent/items";
    }
}
