package org.example.controller;

import org.example.entity.Staff;
import org.example.entity.Team;

import javax.persistence.*;

public class StaffController {
  public static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("hibernate");
  public boolean save(Staff staff) {
    EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
    EntityTransaction transaction = null;

    try {
      transaction = entityManager.getTransaction();
      transaction.begin();
      entityManager.persist(staff); // Saves team to database
      transaction.commit();
      return true;
    } catch (Exception e) { // if transaction does not work
      if (transaction != null) {
        System.out.println("StaffController -> Transaction failed: Performing rollback");
        transaction.rollback();
      }
      System.out.println("StaffController -> transaction failed: " + e.getMessage());
      System.out.print("More detailed error: ");
      e.printStackTrace();
    } finally {
      System.out.println("Closing: StaffController -> entityManager");
      entityManager.close();
    }
    return false;
  }
}