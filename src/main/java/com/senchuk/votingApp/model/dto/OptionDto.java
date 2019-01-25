package com.senchuk.votingApp.model.dto;


public class OptionDto {

    private Long id;
    private String name;
    private int vote;


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }

    public OptionDto(Long id, String name, int vote) {
        this.id = id;
        this.name = name;
        this.vote = vote;
    }

    public OptionDto() {
    }
}
