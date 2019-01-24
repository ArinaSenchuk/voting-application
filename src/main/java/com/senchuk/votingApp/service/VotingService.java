package com.senchuk.votingApp.service;

import com.senchuk.votingApp.model.Status;
import com.senchuk.votingApp.model.dto.UrlDto;
import com.senchuk.votingApp.model.dto.VotingDto;

import java.util.List;

public interface VotingService {

    VotingDto createVoting(String name, List<String> optionNames);

    void updateStatus(Long id, Status status);

    UrlDto openVoting(Long id);

    VotingDto getVoting(Long id);
}
