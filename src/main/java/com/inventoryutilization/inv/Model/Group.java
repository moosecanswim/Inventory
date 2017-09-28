package com.inventoryutilization.inv.Model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Group {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String groupName;
    private Boolean status;
    private Boolean archived;
    @OneToMany(mappedBy="aGroup", cascade= CascadeType.ALL,fetch=FetchType.EAGER)
    private Set<Package> packages;

    public Group(){
        this.setStatus(true);
        this.setArchived(false);
        this.setPackages(new HashSet<Package>());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
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

    public Set<Package> getPackages() {
        return packages;
    }

    public void setPackages(Set<Package> packages) {
        this.packages = packages;
    }
}
