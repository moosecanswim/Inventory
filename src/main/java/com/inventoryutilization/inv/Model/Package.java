package com.inventoryutilization.inv.Model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Package {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String packageName;
    private Boolean status;
    private Boolean archived;
    @OneToMany(mappedBy="aPackage", cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    private Set<Part> parts;
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="group_id")
    private Group aGroup;

    public Package(){
        this.setStatus(true);
        this.setArchived(false);
        this.setParts(new HashSet<Part>());
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
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

    public Set<Part> getParts() {
        return parts;
    }

    public void setParts(Set<Part> parts) {
        this.parts = parts;
    }

    public Group getaGroup() {
        return aGroup;
    }

    public void setaGroup(Group aGroup) {
        this.aGroup = aGroup;
    }
}
