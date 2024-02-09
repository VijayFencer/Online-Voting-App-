package com.example.Voting_App.DTO;

import com.example.Voting_App.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String userName;
    private String mobnum;
    private int age;
    private String voterid;
    private String password;
    private String voterName;
    public User toUser(){
        return new User(
                this.userName,
                this.mobnum,
                this.voterid,
                this.age,
                this.password,
                this.voterName
        );
    }

}
