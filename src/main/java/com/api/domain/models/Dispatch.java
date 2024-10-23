package com.api.domain.models;

import com.api.domain.models.auth.Client;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import java.util.Date;

@Entity
public class Dispatch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    @ManyToOne
    @JoinColumn(name = "logistic_id")
    private Logistic logistic;
    private String guideNumber;
    
    @Column(name = "registration_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private Date registrationDate;

    @PrePersist
    public void setRegistrationDate() {
        this.registrationDate = new Date();
    }
 
    @Override
    public String toString() {
        return "Dispatch{"
                + "id=" + id + '}';
    }

    public Dispatch() {
    }

    public Dispatch(Client client, Logistic logistic, String guideNumber) {
        this.client = client;
        this.logistic = logistic;
        this.guideNumber = guideNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Logistic getLogistic() {
        return logistic;
    }

    public void setLogistic(Logistic logistic) {
        this.logistic = logistic;
    }

    public String getGuideNumber() {
        return guideNumber;
    }

    public void setGuideNumber(String guideNumber) {
        this.guideNumber = guideNumber;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

}
