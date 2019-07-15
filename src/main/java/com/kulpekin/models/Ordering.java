package com.kulpekin.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="ordering")
public class Ordering {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "General_Price")
    private String generalPrice;

    @Column(name = "Date_Ordering")
    private String dateOrdering;

    @Column(name = "Number_Service")
    private String numberService;

    @Column(name = "Id_Client")
    private int idClient;

    @Column(name = "Id_Worker")
    private int idWorker;

    @Column(name = "Id_Name_Service")
    private int idNameService;

    public Ordering() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGeneralPrice() {
        return generalPrice;
    }

    public void setGeneralPrice(String generalPrice) {
        this.generalPrice = generalPrice;
    }

    public String getDateOrdering() {
        return dateOrdering;
    }

    public void setDateOrdering(String dateOrdering) {
        this.dateOrdering = dateOrdering;
    }

    public String getNumberService() {
        return numberService;
    }

    public void setNumberService(String numberService) {
        this.numberService = numberService;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getIdWorker() {
        return idWorker;
    }

    public void setIdWorker(int idWorker) {
        this.idWorker = idWorker;
    }

    public int getIdNameService() {
        return idNameService;
    }

    public void setIdNameService(int idNameService) {
        this.idNameService = idNameService;
    }
}
