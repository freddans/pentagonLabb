package org.example.entity;

import javax.persistence.*;

@Entity
@Table(name = "staff")
public class Staff {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "staff_id")
  private int id; // primary key
  @Column(name = "name", length = 30)
  private String name;

  // Empty Constructor
  public Staff() {
  }

  // Constructor w/o id
  public Staff(String name) {
    this.name = name;
  }

  // Full Constructor
  public Staff(int id, String name) {
    this.id = id;
    this.name = name;
  }
}