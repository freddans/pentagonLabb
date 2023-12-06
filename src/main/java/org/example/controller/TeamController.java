package org.example.controller;
import org.example.entity.Game;
import org.example.entity.Player;
import org.example.entity.Team;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class TeamController {

  public static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("hibernate");
  public boolean save(Team team) {
    EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
    EntityTransaction transaction = null;

    try {
      transaction = entityManager.getTransaction();
      transaction.begin();

      if (!entityManager.contains(team)) {
        team = entityManager.merge(team);
      }

      entityManager.persist(team); // Saves team to the database
      transaction.commit();
      return true;
    } catch (Exception e) {
      if (transaction != null) {
        System.out.println("TeamController -> Transaction failed: Performing rollback");
        transaction.rollback();
      }
      System.out.println("TeamController -> transaction failed: " + e.getMessage());
      System.out.print("More detailed error: ");
      e.printStackTrace();
    } finally {
      System.out.println("Closing: TeamController -> entityManager");
      entityManager.close();
    }
    return false;
  }

  // READ - KAN TA BORT
  public List<Team> getAll(boolean printOut) {
    EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
    EntityTransaction transaction = null;
    List<Team> teamListToReturn = new ArrayList<>();
    try {
      transaction = entityManager.getTransaction();
      transaction.begin();
      TypedQuery<Team> resultList = entityManager.createQuery("FROM Team", Team.class);
      teamListToReturn.addAll(resultList.getResultList());
      transaction.commit();
      // ++ kan ta bort
      if (printOut) {
        for (Team team : teamListToReturn) {
          System.out.println(team.getId() + ". " + team.getName());

          // obtain the associated game for each team:
          Game game = team.getGame();

          // Iterate over the players of the team
          for (Player player : team.getAddedPlayers()) {  // Assuming you have a method like getAddedPlayers()
            System.out.println("\t - " + player.getNickName());
          }
        }
      }
      return teamListToReturn;
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
  public Team getTeamById(int id) {
    EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
    EntityTransaction transaction = null;
    try {
      transaction = entityManager.getTransaction();
      transaction.begin();
      Team teamToReturn = entityManager.find(Team.class, id);
      transaction.commit();
      return teamToReturn;
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
  public boolean updateTeam(Team team){
    EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
    EntityTransaction transaction = null;
    try {
      transaction = entityManager.getTransaction();
      transaction.begin();
      entityManager.merge(team);
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