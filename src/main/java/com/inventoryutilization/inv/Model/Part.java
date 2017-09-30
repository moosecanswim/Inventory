package com.inventoryutilization.inv.Model;

import javax.persistence.*;

@Entity
public class Part {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String partName;
    private String description;
    private String internalNotes;
    private Boolean status;
    private Boolean archived;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="package_id")
    private Package aPackage;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="inv_id")
    private PartInventory partInv;


    public Part(){
        this.setStatus(true);
        this.archived=false;
        this.partInv.setQuantity(0);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean getArchived() {
        return archived;
    }

    public void setArchived(Boolean archived) {
        this.archived = archived;
    }

    public Package getaPackage() {
        return aPackage;
    }

    public void setaPackage(Package aPackage) {
        this.aPackage = aPackage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PartInventory getPartInv() {
        return partInv;
    }

    public void setPartInv(PartInventory partInv) {
        this.partInv = partInv;
    }

    public String getInternalNotes() {
        return internalNotes;
    }

    public void setInternalNotes(String internalNotes) {
        this.internalNotes = internalNotes;
    }
}
