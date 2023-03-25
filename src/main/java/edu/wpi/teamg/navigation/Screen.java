package edu.wpi.teamg.navigation;

public enum Screen {
  ROOT("views/Root.fxml"),
  HOME("views/Home.fxml"),
  MEAL_REQUEST("views/MealServiceRequest.fxml"),
  ROOM_REQUEST("views/RoomServiceRequest.fxml"),
  SIGNAGE_PAGE("views/SignagePage.fxml");

  private final String filename;

  Screen(String filename) {
    this.filename = filename;
  }

  public String getFilename() {
    return filename;
  }
}
