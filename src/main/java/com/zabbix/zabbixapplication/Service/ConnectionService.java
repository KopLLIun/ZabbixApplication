package com.zabbix.zabbixapplication.Service;

import io.github.hengyunabc.zabbix.api.ZabbixApi;

public interface ConnectionService {
    ZabbixApi initConnection(String url);

/*    String authUser(String login, String password);*/
}
