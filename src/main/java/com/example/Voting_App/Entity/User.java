package com.example.Voting_App.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Voters")
public class User {
    @Id
    @Column(name = "user_Id", length = 50)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userid;
    @Column(name = "user_Name", length = 20)
    private String userName;
    private int age;
    @Column(name = "Voter_ID", length = 10)
    private String voterid;
    @Column(name = "user_Mobile", length = 10)
    private String mobnum;
    @Column(name = "Password", length = 10)
    private String password;
    @Column (name="Voter_Name",length = 20)
    private  String voterName;

    public User(String userName, String num, String voterid,int age,String name) {
        this.userName=userName;
        this.mobnum=num;
        this.voterid=voterid;
        this.age=age;
        this.voterName=name;
    }
    public User(String userName,String num,String voterid,int age,String password,String name)
    {
        this.userName=userName;
        this.mobnum=num;
        this.voterid=voterid;
        this.age=age;
        this.password=password;
        this.voterName=name;
    }
}
