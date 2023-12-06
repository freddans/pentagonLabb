package org.example.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "teams")
public class Team {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "team_id")
  private int id; // primary key
  @Column(name = "team_name", length = 30)
  private String name;
//  @Column(name = "game_id")
//  private int game_id; // FOREIGN KEY (game_id) REFERENCES Game(id);

  @ManyToOne
  @JoinColumn(name = "game_id")
  private Game game;

  // Empty Constructor
  public Team() {
  }

  // Constructor w/o id
  public Team(String name) {
    this.name = name;
  }

  // Full Constructor
  public Team(String name, int id) {
    this.name = name;
    this.id = id;
  }

  // Methods


  // Setters and Getters
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

  public Game getGame() {
    return game;
  }

  public void setGame(Game game) {
    this.game = game;
  }
}