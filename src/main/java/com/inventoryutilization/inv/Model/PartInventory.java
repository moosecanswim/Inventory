package com.inventoryutilization.inv.Model;

import javax.persistence.*;

@Entity
public class PartInventory {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    @OneToOne(fetch= FetchType.LAZY, mappedBy="partInv")
    private Part aPart;
    private int quantity;
    private double price;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Part getaPart() {
        return aPart;
    }

    public void setaPart(Part aPart) {
        this.aPart = aPart;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
