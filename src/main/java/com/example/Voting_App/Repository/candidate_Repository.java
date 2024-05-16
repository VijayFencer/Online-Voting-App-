package com.example.Voting_App.Repository;

import com.example.Voting_App.Entity.Voter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface candidate_Repository extends JpaRepository<Voter,Integer> {
    Voter findByName(String name);
}
