package com.zabbix.zabbixapplication.model;

public class Host {
    //Id
    private Integer hostid;

    //Имя узла
    private String host;

    //Видимое имя
    private String name;

    //Группа
    private Integer group;

    //Описание
    private String description;

    //Доступность Zabbix агента
    private  Integer available;

    //Интерфейс
    private Interface anInterface;

    public Integer getHostid() {
        return hostid;
    }

    public void setHostid(Integer hostid) {
        this.hostid = hostid;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGroup() {
        return group;
    }

    public void setGroup(Integer group) {
        this.group = group;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    public Interface getAnInterface() {
        return anInterface;
    }

    public void setAnInterface(Interface anInterface) {
        this.anInterface = anInterface;
    }

    @Override
    public String toString() {
        return "Host{" +
                "hostid=" + hostid +
                ", host='" + host + '\'' +
                ", name='" + name + '\'' +
                ", group=" + group +
                ", description='" + description + '\'' +
                ", available=" + available +
                ", anInterface=" + anInterface +
                '}';
    }

    /*    public void setDnsAnInterface(String dns) {
        this.anInterface.setDns(dns);
    }

    public void setIpAnInterface(String ip) {
        this.anInterface.setIp(ip);
    }
    public void setPortAnInterface(Integer port) {
        this.anInterface.setPort(port);
    }
    public void setUseIpAnInterface(Integer useip) {
        this.anInterface.setUseip(useip);
    }

    public void setTypeAnInterface(Integer type) {
        this.anInterface.setType(type);
    }

    public void setMainAnInterface(Integer main) {
        this.anInterface.setMain(main);
    }*/
}
