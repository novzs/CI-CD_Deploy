package com.example.demo.Service;

import com.example.demo.entity.Vote;
import com.example.demo.Repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoteService {

    @Autowired
    private VoteRepository voteRepository;

    public Vote saveVote(String option) {
        Vote vote = new Vote();
        vote.setOption(option);
        return voteRepository.save(vote);
    }

    public long countVotesByOption(String option) {
        return voteRepository.countByOption(option);
    }
}
