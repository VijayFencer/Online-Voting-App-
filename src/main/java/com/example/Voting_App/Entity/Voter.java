package com.example.Voting_App.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="candidate_detail")
public class Voter {
    @Id
    @Column(name = "id", length = 50)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name="Candidates")
    private String name;
    @Column(name="votes", columnDefinition = "int default 0")
    private int votes;
    public Voter(String name)
    {
        this.name=name;
    }
    public Voter(int count)
    {
        this.votes+=count;
    }
}
