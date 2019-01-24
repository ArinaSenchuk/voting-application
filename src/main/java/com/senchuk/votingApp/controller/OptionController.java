package com.senchuk.votingApp.controller;

import com.senchuk.votingApp.model.dto.OptionDto;
import com.senchuk.votingApp.service.OptionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/option")
public class OptionController {

    @Autowired
    private OptionsService optionsService;

    @GetMapping(value = "/{id}/stats")
    public OptionDto getStats(@PathVariable("id") Long id) {
        return optionsService.getStats(id);
    }

    @PutMapping(value = "/{id}/vote")
    public void vote(@PathVariable("id") Long id) {
        optionsService.vote(id);
    }
}
