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
    private long consId;
    @OneToMany
    private List<ConsultationProduct> proList;


    public Consultation() {
        super();
    }

    public long getConsId() {
        return consId;
    }

    public void setConsId(long consId) {
        this.consId = consId;
    }

    public List<ConsultationProduct> getProList() {
        return proList;
    }

    public void setProList(List<ConsultationProduct> proList) {
        this.proList = proList;
    }

    public void addProduct(ConsultationProduct p)
    {
        if(this.proList.isEmpty())
            this.proList.add(p);
        else
        {
            ConsultationProduct prod=null;

            while(this.proList.iterator().hasNext())
            {
                prod=this.proList.iterator().next();
                if(prod.getProductId()==p.getProductId())
                    System.out.println("Product already exists");
            }
            this.proList.add(p);
        }
    }

    public void deleteProduct(ConsultationProduct p)
    {
        if(this.proList.isEmpty())
            System.out.println("Product not found in the List");
        else
        {
            ConsultationProduct prod=null;

            while(this.proList.iterator().hasNext())
            {
                prod=this.proList.iterator().next();
                if(prod.getProductId()==p.getProductId())
                    this.proList.remove(p);
            }
            this.proList.add(p);
        }
    }
}
