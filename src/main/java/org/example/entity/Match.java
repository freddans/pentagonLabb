package org.example.entity;

public class Match {
  private int id; // primary key
  private int match_player1_id;
  private int match_player2_id;
  private int match_team1_id;
  private int match_team2_id;
  private int game_id;
  private String match_result;
  private String match_date;
//  FOREIGN KEY (match_player1_id) REFERENCES Players(player_id);
//  FOREIGN KEY (match_player2_id) REFERENCES Players(player_id);
//  FOREIGN KEY (match_team1_id) REFERENCES Teams(team_id);
//  FOREIGN KEY (match_team2_id) REFERENCES Teams(team_id);
//  FOREIGN KEY (game_id) REFERENCES Games(game_id);
}