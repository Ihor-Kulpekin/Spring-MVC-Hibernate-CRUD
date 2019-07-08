package com.kulpekin.models;

import javax.persistence.*;

@Entity
@Table(name = "nameservice")
public class NameService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Name_Service")
    private String nameService;

    @Column(name = "Kind_Service")
    private String kindService;

    @Column(name = "Price")
    private double price;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public String getKindService() {
        return kindService;
    }

    public void setKindService(String kindService) {
        this.kindService = kindService;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
