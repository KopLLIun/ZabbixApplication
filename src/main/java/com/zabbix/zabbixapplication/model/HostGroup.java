package com.zabbix.zabbixapplication.model;

public class HostGroup {
    private Integer groupId;
    private String name;
    private Integer flags;
    private Integer internal;

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getFlags() {
        return flags;
    }

    public void setFlags(Integer flags) {
        this.flags = flags;
    }

    public Integer getInternal() {
        return internal;
    }

    public void setInternal(Integer internal) {
        this.internal = internal;
    }

    @Override
    public String toString() {
        return "HostGroup{" +
                "groupId=" + groupId +
                ", name='" + name + '\'' +
                ", flags=" + flags +
                ", internal=" + internal +
                '}';
    }
}
