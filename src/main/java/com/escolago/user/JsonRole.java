package com.escolago.user;

import java.io.Serializable;

public class JsonRole implements Serializable {
    private String job;

    private boolean admin;

    private String[] module;

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String[] getModule() {
        return module;
    }

    public void setModule(String[] module) {
        this.module = module;
    }
}
