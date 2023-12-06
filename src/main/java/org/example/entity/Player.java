package org.example.entity;

import javax.persistence.*;

@Entity
@Table(name = "players")
public class Player {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "player_id")
  private int id; // primary key
  @Column(name = "first_name", length = 30)
  private String firstName;
  @Column(name = "last_name", length = 30)
  private String lastName;
  @Column(name = "nickname", length = 30)
  private String nickName;
  @Column(name = "adress", length = 30)
  private String adress;
  @Column(name = "zip_code", length = 30)
  private String zipCode;
  @Column(name = "postal_adress", length = 30)
  private String postalAdress;
  @Column(name = "country", length = 30)
  private String country;
  @Column(name = "email", length = 30)
  private String eMail;
  @Column(name = "team_id")
  private int team_id; // FOREIGN KEY (game_id) REFERENCES Game(id);

  // Empty Constructor
  public Player() {
  }

  // Constructor w/o id
  public Player(String firstName, String lastName, String nickName, String adress, String zipCode, String postalAdress, String country, String eMail, int team_id) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.nickName = nickName;
    this.adress = adress;
    this.zipCode = zipCode;
    this.postalAdress = postalAdress;
    this.country = country;
    this.eMail = eMail;
    this.team_id = team_id;
  }

  // Full Constructor
  public Player(int id, String firstName, String lastName, String nickName, String adress, String zipCode, String postalAdress, String country, String eMail, int team_id) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.nickName = nickName;
    this.adress = adress;
    this.zipCode = zipCode;
    this.postalAdress = postalAdress;
    this.country = country;
    this.eMail = eMail;
    this.team_id = team_id;
  }

  // Setters and Getters
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getNickName() {
    return nickName;
  }

  public void setNickName(String nickName) {
    this.nickName = nickName;
  }

  public String getAdress() {
    return adress;
  }

  public void setAdress(String adress) {
    this.adress = adress;
  }

  public String getZipCode() {
    return zipCode;
  }

  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }

  public String getPostalAdress() {
    return postalAdress;
  }

  public void setPostalAdress(String postalAdress) {
    this.postalAdress = postalAdress;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String geteMail() {
    return eMail;
  }

  public void seteMail(String eMail) {
    this.eMail = eMail;
  }

  public int getTeam_id() {
    return team_id;
  }

  public void setTeam_id(int team_id) {
    this.team_id = team_id;
  }
}