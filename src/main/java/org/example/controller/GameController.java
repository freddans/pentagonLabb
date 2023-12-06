package org.example.controller;

import org.example.entity.Game;
import org.example.entity.Team;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class GameController {

  public static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("hibernate");

  // CREATE
  public boolean save(Game game) {
    EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
    EntityTransaction transaction = null;

    try {
      transaction = entityManager.getTransaction();
      transaction.begin();
      entityManager.persist(game); // Saves game to database
      transaction.commit();
      return true;
    } catch (Exception e) { // if transaction does not work
      if (transaction != null) {
        System.out.println("GameController -> Transaction failed: Performing rollback");
        transaction.rollback();
      }
      System.out.println("GameController -> transaction failed: " + e.getMessage());
      System.out.print("More detailed error: ");
      e.printStackTrace();
    } finally {
      System.out.println("Closing: GameController -> entityManager");
      entityManager.close();
    }
    return false;
  }

  // READ
  public List<Game> getAll(boolean printOut) {
    EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
    EntityTransaction transaction = null;
    List<Game> gameListToReturn = new ArrayList<>();
    try {
      transaction = entityManager.getTransaction();
      transaction.begin();
      TypedQuery<Game> resultList = entityManager.createQuery("FROM Game", Game.class);
      gameListToReturn.addAll(resultList.getResultList());
      transaction.commit();
      // ++ kan ta bort
      if (printOut) {
        for (Game game :
            gameListToReturn) {
          System.out.println(game.getId() + ". " + game.getName());
          for (Team team :
              game.getAddedTeams()) {
            System.out.println("\t - " + team.getName());
          }
        }
      }
      return gameListToReturn;
      // -- kan ta bort EGENTLIGEN HELA ALLTET
    } catch (Exception e) {
      if (transaction != null) {
        transaction.rollback();
      }
      e.printStackTrace();
    } finally {
      entityManager.close();
    }
    return null;
  }

    // READ 1
    public Game getGameById(int id) {
      EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
      EntityTransaction transaction = null;
      try {
        transaction = entityManager.getTransaction();
        transaction.begin();
        Game gameToReturn = entityManager.find(Game.class, id);
        transaction.commit();
        return gameToReturn;
      } catch (Exception e) {
        if (transaction != null) {
          transaction.rollback();
        }
        e.printStackTrace();
      } finally {
        entityManager.close();
      }
      return null;
    }

    // Update
    public boolean updateGame(Game game){
      EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
      EntityTransaction transaction = null;
      try {
        transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(game);
        transaction.commit();
        return true;
      } catch (Exception e) {
        if (transaction != null) {
          transaction.rollback(); // rollback
        }
        e.printStackTrace();
      } finally {
        entityManager.close();
      }
      return false;
    }



  }