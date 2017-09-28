package com.inventoryutilization.inv.Model;

import javax.persistence.*;
@Entity
public class PackageInventory {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    @OneToOne(fetch= FetchType.LAZY, mappedBy="PackageInv")
    private Part aPart;
    private int quantityl;
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

    public int getQuantityl() {
        return quantityl;
    }

    public void setQuantityl(int quantityl) {
        this.quantityl = quantityl;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
