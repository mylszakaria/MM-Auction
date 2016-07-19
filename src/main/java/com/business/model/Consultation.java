package com.business.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by zakaria on 18/07/2016.
 */
@Entity
public class Consultation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int consId;
    @OneToMany
    private List<ConsultationProduct> proList;

    public Consultation(int consId, List<ConsultationProduct> proList) {
        this.consId = consId;
        this.proList = proList;
    }

    public Consultation() {
    }

    public int getConsId() {
        return consId;
    }

    public void setConsId(int consId) {
        this.consId = consId;
    }

    public List<ConsultationProduct> getProList() {
        return proList;
    }

    public void setProList(List<ConsultationProduct> proList) {
        this.proList = proList;
    }
}
