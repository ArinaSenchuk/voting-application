package com.senchuk.votingApp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum Status {
    CREATED("CREATED"),
    OPENED("OPENED"),
    COMPLETED("COMPLETED");

    private String label;
}
