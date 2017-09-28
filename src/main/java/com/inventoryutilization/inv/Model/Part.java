package com.inventoryutilization.inv.Model;

import javax.persistence.*;

@Entity
public class Part {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String partName;
    private Boolean status;
    private Boolean archived;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="package_id")
    private Package aPackage;

    public Part(){
        this.status=true;
        this.archived=false;
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
}
