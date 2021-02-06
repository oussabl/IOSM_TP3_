package com.example.tp4;

import java.util.List;

public class Services {
     List list ;
    private String serv ;


    public Services(String service) {
        this.serv = service;
    }

    public void setList(List list) {
        this.list = list;
    }

    public String getServ() {
        return serv;
    }

    public void setServ(String serv) {
        this.serv = serv;
    }

    public List getList() {
        return list;
    }

    @Override
    public String toString() {
        return "Services{" +
                "Resulta= '" + serv + '\'' +
                '}';
    }
}
