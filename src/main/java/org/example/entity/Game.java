package org.example.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "games")
public class Game {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "game_id")
  private int id; // primary key
  @Column(name = "game_title", length = 30)
  private String name;


  // List
  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "game")
  private List<Team> addedTeams = new ArrayList<>();

  // Empty Constructor
  public Game() {
  }

  // Constructor w/o id
  public Game(String name) {
    this.name = name;
  }

  // Full Constructor
  public Game(int id, String name) {
    this.id = id;
    this.name = name;
  }

  // Methods


  // Getters and Setters
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  // List
  public List<Team> getAddedTeams() {
    return addedTeams;
  }

  public void setAddedTeams(List<Team> addedTeams) {
    this.addedTeams = addedTeams;
  }

}