package edu.wpi.teamg.controllers;

import edu.wpi.teamg.navigation.Navigation;
import edu.wpi.teamg.navigation.Screen;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.fxml.FXML;

public class RoomServiceRequestController {

  @FXML MFXButton roomBackButton;

  @FXML
  public void initialize() {
    roomBackButton.setOnMouseClicked(event -> Navigation.navigate(Screen.HOME));
  }
}
