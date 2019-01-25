package com.senchuk.votingApp.model.dto;

import com.senchuk.votingApp.model.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class VotingDto {

    private Long id;
    private String name;
    private Status status;
    private List<OptionDto> options;
}
