package com.senchuk.votingApp.service.impl;


import com.senchuk.votingApp.model.Option;
import com.senchuk.votingApp.model.Status;
import com.senchuk.votingApp.model.dto.OptionDto;
import com.senchuk.votingApp.repository.OptionRepository;
import com.senchuk.votingApp.service.OptionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class OptionsServiceImpl implements OptionsService {

    @Autowired
    private OptionRepository optionRepository;

    @Override
    public OptionDto getStats(Long id) {
        Option option = optionRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Option " + id + " is not found"));
        return new OptionDto(option.getId(), option.getName(), option.getVote());
    }

    @Override
    public void vote(Long id) {
        Option option = optionRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Option " + id + " is not found"));
        if (option.getVoting().getStatus() == Status.OPENED) {
            int vote = option.getVote();
            option.setVote(++vote);
            optionRepository.save(option);
        } else {
            throw new IllegalStateException("The voting has not started yet");
        }
    }

    @Override
    public List<Option> getOptions(Long id) {
        return optionRepository.findByVotingId(id);
    }

    @Override
    public void save(Option option) {
        optionRepository.save(option);
    }
}
