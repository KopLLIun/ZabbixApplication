package com.zabbix.zabbixapplication.Service;

import com.alibaba.fastjson.JSONObject;
import com.zabbix.zabbixapplication.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    private RequestService requestService;

    @Override
    public List<JSONObject> getItems() {
        return requestService.doRequest("item.get", "output", "extend");
    }

    @Override
    public List<JSONObject> getItem(Integer id) {
        return requestService.doRequest("item.get", "itemids", id);
    }

    @Override
    public List<JSONObject> getItemsByHostId(Integer id) {
        //Map<String, Object> params = new HashMap<>();;
        Map<String, Object> params = new HashMap<>();
        //params.put("output", "extend");
        //JSONObject js = new JSONObject();
        //js.put("key_", "vfs.fs.size[C:,pfree]");
        params.put("sortfield", "key_");
        params.put("sortorder", "DESC");
        params.put("hostids", id);
        return requestService.doRequest("item.get", params);
    }

    @Override
    public List<JSONObject> getItemsByHostGroupId(Integer id) {
        Map<String, Object> params = new HashMap<>();
        params.put("sortfield", "key_");
        params.put("sortorder", "DESC");
        params.put("groupids", id);
        return requestService.doRequest("item.get", params);
    }

    @Override
    public List<JSONObject> getItemsByTemplateId(Integer id) {
        return requestService.doRequest("item.get", "templateids", id);
    }

    @Override
    public List<JSONObject> getItemsByApplicationId(Integer id) {
        return requestService.doRequest("item.get", "applicationids", id);
    }

    @Override
    public void saveItem(Item item) {

    }

    @Override
    public void updateItem(Item item) {

    }

    @Override
    public void deleteItem(Integer id) {

    }
}
