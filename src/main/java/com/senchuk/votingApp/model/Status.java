package com.senchuk.votingApp.model;


public enum Status {
    CREATED("CREATED"),
    OPENED("OPENED"),
    COMPLETED("COMPLETED");

    private String label;

    public String getLabel() {
        return label;
    }

    Status(String label) {
        this.label = label;
    }

    Status() {
    }
}
