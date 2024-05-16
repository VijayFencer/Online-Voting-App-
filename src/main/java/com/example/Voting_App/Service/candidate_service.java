package com.example.Voting_App.Service;

import com.example.Voting_App.Entity.User;
import com.example.Voting_App.Entity.Voter;
import com.example.Voting_App.Repository.candidate_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class candidate_service {
    @Autowired
    private candidate_Repository candi;

    public Voter updatevote(String name)
    {
        Voter existuser=candi.findByName(name);
        if(existuser!=null)
        {
            int votes=existuser.getVotes();
            System.out.println(votes);
            existuser.setVotes(votes+1);
            System.out.println(votes+1);
            candi.save(existuser);
        }
        else{
            System.out.println("npt");
        }
        return null;
    }
}
