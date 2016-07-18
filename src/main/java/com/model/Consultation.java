package com.model;

import java.util.List;

/**
 * Created by zakaria on 18/07/2016.
 */
public class Consultation {

    private int consId;
    private List<Product> proList;

    public Consultation(int consId, List<Product> proList) {
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

    public List<Product> getProList() {
        return proList;
    }

    public void setProList(List<Product> proList) {
        this.proList = proList;
    }
}
