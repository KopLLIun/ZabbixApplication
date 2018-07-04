package com.zabbix.zabbixapplication.model;

public class Template {
    //Id
    private Integer templateId;
    //Тех. имя шаблона
    private String host;
    //Описание
    private String description;
    //Видимое имя
    private String name;

    public Integer getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
