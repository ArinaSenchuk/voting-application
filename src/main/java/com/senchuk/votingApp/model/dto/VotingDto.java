package com.senchuk.votingApp.model.dto;

import com.senchuk.votingApp.model.Status;

import java.util.List;


public class VotingDto {

    private Long id;
    private String name;
    private Status status;
    private List<OptionDto> options;


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<OptionDto> getOptions() {
        return options;
    }

    public void setOptions(List<OptionDto> options) {
        this.options = options;
    }

    public VotingDto(Long id, String name, Status status, List<OptionDto> options) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.options = options;
    }

    public VotingDto() {
    }
}
