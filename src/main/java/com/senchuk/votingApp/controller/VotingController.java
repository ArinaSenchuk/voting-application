package com.senchuk.votingApp.controller;

import com.senchuk.votingApp.model.Status;
import com.senchuk.votingApp.model.dto.CreateVotingDto;
import com.senchuk.votingApp.model.dto.UrlDto;
import com.senchuk.votingApp.model.dto.VotingDto;
import com.senchuk.votingApp.service.VotingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/voting", produces = "application/json")
public class VotingController {

    @Autowired
    private VotingService votingService;

    @PostMapping(value = "/create")
    public VotingDto createVoting(@RequestBody CreateVotingDto dto) {
        return votingService.createVoting(dto.getName(), dto.getOptionNames());
    }

    @PostMapping("/{id}/status/opened")
    public UrlDto openVoting(@PathVariable("id") Long id) {
        return votingService.openVoting(id);
    }

    @PostMapping("/{id}/status/completed")
    public void completeVoting(@PathVariable("id") Long id) {
        votingService.updateStatus(id, Status.COMPLETED);
    }

    @GetMapping("/{id}")
    public VotingDto getVoting(@PathVariable("id") Long id) {
        return votingService.getVoting(id);
    }
}
