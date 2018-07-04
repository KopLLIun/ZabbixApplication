package com.zabbix.zabbixapplication.model;

public class Interface {
    //Id
    private Integer id;

    //DNS
    private String dns;

    //host id
    private Integer hostid;

    //ip
    private String ip;

    //Используется ли по умолчанию
    private Integer main;

    //№ порта
    private Integer port;

    //Тип 	Тип интерфейса.
    //
    //Возможные значения:
    //1 - агент;
    //2 - SNMP;
    //3 - IPMI;
    //4 - JMX.
    private Integer type;

    //Выполняется ли соединение через IP адрес
    private Integer useip;

    //Необходимо ли использовать массовые запросы
    private Boolean bulk;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDns() {
        return dns;
    }

    public void setDns(String dns) {
        this.dns = dns;
    }

    public Integer getHostid() {
        return hostid;
    }

    public void setHostid(Integer hostid) {
        this.hostid = hostid;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getMain() {
        return main;
    }

    public void setMain(Integer main) {
        this.main = main;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getUseip() {
        return useip;
    }

    public void setUseip(Integer useip) {
        this.useip = useip;
    }

    public Boolean getBulk() {
        return bulk;
    }

    public void setBulk(Boolean bulk) {
        this.bulk = bulk;
    }

    @Override
    public String toString() {
        return "Interface{" +
                "id=" + id +
                ", dns='" + dns + '\'' +
                ", hostid=" + hostid +
                ", ip='" + ip + '\'' +
                ", main=" + main +
                ", port=" + port +
                ", type=" + type +
                ", useip=" + useip +
                ", bulk=" + bulk +
                '}';
    }
}
