package com.example.Voting_App.Service;

import com.example.Voting_App.Entity.User;
import com.example.Voting_App.Repository.user_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Voter_Service {
    @Autowired
    private user_Repository voter;

    public boolean saveVoter(User user)
    {
        if(getVoterByVoterName(user.getVoterName())==null)
        {
            voter.save(user);
            return true;
        }else{
            return false;
        }
    }

    public List<User> saveVoters(List<User> users)
    {

        return voter.saveAll(users);
    }

    public List<User> getVoters() {
        return voter.findAll();
    }
    public User getVoterById(int id)
    {
        return voter.findById(id).orElse(null);
    }

    public User getVoterByName(String name)
    {
        return voter.findByUserName(name);
    }

    public  User getVoterByVoterName(String name)
    {
        return voter.findByVoterName(name);
    }
    public String deleteVoter(int id)
    {
        voter.deleteById(id);
        return "Voter removerd";
    }
    public User login(String username,String password)
    {
        return voter.findByVoterNameAndPassword(username,password);
    }
    public User updateUser(User user)
    {
        User existuser=voter.findById(user.getUserid()).orElse(null);
        if (existuser != null) {
            existuser.setUserName(user.getUserName());
            existuser.setMobnum(user.getMobnum());
            existuser.setVoterid(user.getVoterid());
            existuser.setAge(user.getAge());
            existuser.setVoterName(user.getVoterName());
            return voter.save(existuser);
        }
        return null;
    }
}

