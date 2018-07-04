package com.zabbix.zabbixapplication.Service;

import com.alibaba.fastjson.JSONObject;
import com.zabbix.zabbixapplication.model.Item;

import java.util.List;

public interface ItemService {
    List<JSONObject> getItems();

    List<JSONObject> getItem(Integer id);

    List<JSONObject> getItemsByHostId(Integer id);

    List<JSONObject> getItemsByHostGroupId(Integer id);

    List<JSONObject> getItemsByTemplateId(Integer id);

    List<JSONObject> getItemsByApplicationId(Integer id);

    void saveItem(Item item);

    void updateItem(Item item);

    void deleteItem(Integer id);
}
