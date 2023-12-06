package org.example.controller;

import org.example.entity.Player;
import org.example.entity.Team;

import javax.persistence.*;

public class PlayerController {
  public static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("hibernate");
  public boolean save(Player player) {
    EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
    EntityTransaction transaction = null;

    try {
      transaction = entityManager.getTransaction();
      transaction.begin();
      entityManager.persist(player); // Saves player to database
      transaction.commit();
      return true;
    } catch (Exception e) { // if transaction does not work
      if (transaction != null) {
        System.out.println("PlayerController -> Transaction failed: Performing rollback");
        transaction.rollback();
      }
      System.out.println("PlayerController -> transaction failed: " + e.getMessage());
      System.out.print("More detailed error: ");
      e.printStackTrace();
    } finally {
      System.out.println("Closing: PlayerController -> entityManager");
      entityManager.close();
    }
    return false;
  }
}