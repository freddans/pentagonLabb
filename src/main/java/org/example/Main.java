package org.example;

import org.example.controller.GameController;
import org.example.controller.PlayerController;
import org.example.controller.StaffController;
import org.example.controller.TeamController;
import org.example.entity.Player;
import org.example.view.Menu;

import java.awt.*;

public class Main {
  public static void main(String[] args) {
    GameController gameController = new GameController();
    TeamController teamController = new TeamController();
    PlayerController playerController = new PlayerController();
    StaffController staffController = new StaffController();

    Menu menu = new Menu(gameController, teamController, playerController, staffController);
    menu.showMainMenu();
  }
}