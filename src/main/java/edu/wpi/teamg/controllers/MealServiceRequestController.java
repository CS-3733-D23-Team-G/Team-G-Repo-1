package edu.wpi.teamg.controllers;

import edu.wpi.teamg.navigation.Navigation;
import edu.wpi.teamg.navigation.Screen;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.fxml.FXML;

public class MealServiceRequestController {

  @FXML MFXButton mealBackButton;
  @FXML MFXButton mealSubmitButton;
  @FXML MFXButton roomButton;
  @FXML MFXButton signagePageButton;

  @FXML
  public void initialize() {
    mealSubmitButton.setOnMouseClicked(event -> Navigation.navigate(Screen.MEAL_REQUEST_SUBMIT));
    //    this.mealSubmitButton.setOnAction(
    //        event -> {
    //          Navigation.navigate(Screen.MEAL_REQUEST_SUBMIT);
    //        });
    roomButton.setOnMouseClicked(event -> Navigation.navigate(Screen.ROOM_REQUEST));
    signagePageButton.setOnMouseClicked(event -> Navigation.navigate(Screen.SIGNAGE_PAGE));
    mealBackButton.setOnMouseClicked(event -> Navigation.navigate(Screen.HOME));
  }
}
