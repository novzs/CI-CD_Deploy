package com.example.demo.Controller;

import com.example.demo.entity.Vote;
import com.example.demo.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/votes")
public class VoteController {

    @Autowired
    private VoteService voteService;

    @PostMapping
    public ResponseEntity<Vote> vote(@RequestBody Map<String, String> body) {
        String option = body.get("option");
        return new ResponseEntity<>(voteService.saveVote(option), HttpStatus.CREATED);
    }

    @GetMapping("/count")
    public long getCount(@RequestParam String option) {
        return voteService.countVotesByOption(option);
    }
}
