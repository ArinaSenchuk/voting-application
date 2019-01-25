package com.senchuk.votingApp.model.dto;


import java.util.List;

public class CreateVotingDto {

    private String name;
    private List<String> optionNames;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getOptionNames() {
        return optionNames;
    }

    public void setOptionNames(List<String> optionNames) {
        this.optionNames = optionNames;
    }

    public CreateVotingDto(String name, List<String> optionNames) {
        this.name = name;
        this.optionNames = optionNames;
    }

    public CreateVotingDto() {
    }
}
