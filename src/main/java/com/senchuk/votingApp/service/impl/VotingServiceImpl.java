package com.senchuk.votingApp.service.impl;

import com.senchuk.votingApp.model.Option;
import com.senchuk.votingApp.model.Status;
import com.senchuk.votingApp.model.Voting;
import com.senchuk.votingApp.model.dto.OptionDto;
import com.senchuk.votingApp.model.dto.UrlDto;
import com.senchuk.votingApp.model.dto.VotingDto;
import com.senchuk.votingApp.repository.VotingRepository;
import com.senchuk.votingApp.service.OptionsService;
import com.senchuk.votingApp.service.VotingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class VotingServiceImpl implements VotingService {

    @Autowired
    private VotingRepository votingRepository;
    @Autowired
    private OptionsService optionsService;

    @Override
    public VotingDto createVoting(String name, List<String> optionNames) {
        Voting voting = new Voting();
        voting.setName(name);
        voting.setStatus(Status.CREATED);
        Voting savedVoting = votingRepository.save(voting);

        List<OptionDto> options = optionNames.stream()
                .map(optionName -> {
                    Option option = new Option();
                    option.setName(optionName);
                    option.setVoting(savedVoting);
                    optionsService.save(option);
                    return new OptionDto(option.getId(), option.getName(), option.getVote());
                })
                .collect(Collectors.toList());


        return new VotingDto(savedVoting.getId(), savedVoting.getName(), savedVoting.getStatus(), options);
    }

    @Override
    public void updateStatus(Long id, Status status) {
        Voting voting = votingRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Voting " + id + " is not found"));
        voting.setStatus(status);
        votingRepository.save(voting);
    }

    @Override
    public UrlDto openVoting(Long id) {
        updateStatus(id, Status.OPENED);
        return new UrlDto("http://localhost:8080/voting/" + id);
    }

    @Override
    public VotingDto getVoting(Long id) {
        Voting voting = votingRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Voting " + id + " is not found"));
        List<OptionDto> options = optionsService.getOptions(id).stream()
                .map(option -> new OptionDto(option.getId(), option.getName(), option.getVote()))
                .collect(Collectors.toList());
        return new VotingDto(voting.getId(), voting.getName(), voting.getStatus(), options);
    }
}
