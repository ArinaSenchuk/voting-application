package com.senchuk.votingApp.service;

import com.senchuk.votingApp.model.Option;
import com.senchuk.votingApp.model.dto.OptionDto;

import java.util.List;

public interface OptionsService {

    OptionDto getStats(Long id);

    void vote(Long id);

    void save(Option option);

    List<Option> getOptions(Long id);
}
