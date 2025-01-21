package com.inn.cashflow.server.core.baseimpl;

import java.time.LocalDateTime;

import com.inn.cashflow.server.core.baseimpl.config.UserContext;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

@MappedSuperclass
public abstract class BaseEntity {
    
    @Column(name = "created_time", nullable = false, updatable = false)
    private LocalDateTime createdTime;

    @Column(name = "creator_id", updatable = false)
    private Long createdById;

    @Column(name = "creator_name", updatable = false)
    private String createdByName;

    @Column(name = "modified_time")
    private LocalDateTime modifiedTime;

    @Column(name = "modifier_id")
    private Long modifiedById;

    @Column(name = "modifier_name")
    private String modifiedByName;

    @PrePersist
    public void prePersist() {
        this.createdTime = LocalDateTime.now();
        this.modifiedTime = LocalDateTime.now();

        UserContext currentUser = UserContext.getCurrentUser();
        if(currentUser != null) {
            this.createdById = currentUser.getId();
            this.createdByName = currentUser.getFirstName() + " " + currentUser.getLastName();
        }else {
            this.createdByName = "API USER";
        }
    }

    @PreUpdate
    public void preUpdate() {
        this.modifiedTime = LocalDateTime.now();
        
        UserContext currentUser = UserContext.getCurrentUser();
        if (currentUser != null) {
            this.modifiedById = currentUser.getId();
            this.modifiedByName = currentUser.getFirstName() + " " + currentUser.getLastName();
        } else {
            this.modifiedByName = "SYSTEM";
        }
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public Long getCreatedById() {
        return createdById;
    }

    public void setCreatedById(Long createdById) {
        this.createdById = createdById;
    }

    public String getCreatedByName() {
        return createdByName;
    }

    public void setCreatedByName(String createdByName) {
        this.createdByName = createdByName;
    }

    public LocalDateTime getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(LocalDateTime modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public Long getModifiedById() {
        return modifiedById;
    }

    public void setModifiedById(Long modifiedById) {
        this.modifiedById = modifiedById;
    }

    public String getModifiedByName() {
        return modifiedByName;
    }

    public void setModifiedByName(String modifiedByName) {
        this.modifiedByName = modifiedByName;
    }

    
}
