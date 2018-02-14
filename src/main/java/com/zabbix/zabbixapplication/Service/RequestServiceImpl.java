package com.zabbix.zabbixapplication.Service;

import io.github.hengyunabc.zabbix.api.*;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class RequestServiceImpl implements RequestService {

    @Autowired
    private ConnectionServiceImpl connectionService;

    @Override
    public List<JSONObject> doRequest(String methodName, String paramKey, Object paramValue) {

        Request request = RequestBuilder.newBuilder()
                .method(methodName)
                .paramEntry(paramKey, paramValue)
                .build();
        JSONObject response = connectionService.initConnection("http://192.168.1.50/zabbix/api_jsonrpc.php").
                call(request);
        System.err.println(response);
        List<JSONObject> list = new ArrayList<>();
        for (Object jsonObject : response.getJSONArray("result")) {
            list.add((JSONObject) jsonObject);
/*            JSONObject out = ((JSONObject) jsonObject);
            System.out.println(out.getString("hostid")  + ", " + out.getString("host"));*/
        }
        return list;
    }

    @Override
    public List<JSONObject> doRequest(String methodName, Map<String, Object> params) {

        //---------- set request method and parameters ---------------------
        Request request = RequestBuilder.newBuilder()
                .method(methodName)
                .build();
        request.setParams(params);
        //------------ call request ----------------------------------------
        JSONObject response = connectionService.initConnection("http://192.168.1.50/zabbix/api_jsonrpc.php").
                call(request);
        //------------ displays response at the window ---------------------
        System.err.println(response);
        List<JSONObject> list = new ArrayList<>();
        for (Object jsonObject : response.getJSONArray("result")) {
            list.add((JSONObject) jsonObject);
/*            JSONObject out = ((JSONObject) jsonObject);
            System.out.println(out.getString("hostid")  + ", " + out.getString("host"));*/
        }
        return list;
    }
}
