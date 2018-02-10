package com.zabbix.zabbixapplication.Service;

import com.alibaba.fastjson.JSONObject;
import io.github.hengyunabc.zabbix.api.*;
import org.springframework.stereotype.Service;

@Service
public class ConnectionServiceImpl implements ConnectionService {

    @Override
    public ZabbixApi initConnection(String url) {
        //url = "http://192.168.56.101/zabbix";
        ZabbixApi zabbixApi = new DefaultZabbixApi(url);
        zabbixApi.init();


        boolean login = zabbixApi.login("Admin", "zabbix");
        System.err.println("login:" + login);

        return zabbixApi;
        //return zabbixApi.apiVersion();

/*

        String host = "127.0.0.1";

        //GSONObject filter = new JSONObject();
        JSONObject filter = new JSONObject();
        //Gson filter = new GsonBuilder().setPrettyPrinting().create();
        //JsonObject json = new JsonObject();
        Request getRequest = RequestBuilder.newBuilder()
                .method("host.get").paramEntry("filter", filter)
                .build();
        JSONObject getResponse = zabbixApi.call(getRequest);
        System.err.println(getResponse);
        String hostid = getResponse.getJSONArray("result")
                .getJSONObject(0).getString("hostid");
        return hostid;
        //System.err.println(hostid);*/
    }

    public String login(String user, String password) {
        String auth;
        Request request = RequestBuilder.newBuilder().paramEntry("user", user).paramEntry("password", password).method("user.login").build();
        JSONObject response = new DefaultZabbixApi("http://192.168.1.50/zabbix/api_jsonrpc.php").call(request);
        auth = response.getString("result");
        /*if (auth == null || auth.isEmpty()) {
            System.out.println("Error");
        }*/
        return auth;
    }
}