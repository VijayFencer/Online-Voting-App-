package com.example.Voting_App.Repository;

import com.example.Voting_App.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface user_Repository extends JpaRepository<User,Integer> {
    User findByUserName(String name);
    User findByVoterName(String name);
    User findByVoterNameAndPassword(String name,String password);
}
