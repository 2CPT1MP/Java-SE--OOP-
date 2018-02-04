package ui;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ConfirmDialog extends Application {

    private static boolean response;
    public static boolean getResponse() { return  response;}

    @Override
    public void start(Stage primaryStage) {

        setUpStage(primaryStage);

        Text text = new Text("Are you sure you want to delete all records?");
        Button yesButton = new Button("Yes");
        yesButton.setMinSize(100, 10);
        Button noButton = new Button("No");
        noButton.setMinSize(100, 10);

        GridPane layout = new GridPane();
        layout.setAlignment(Pos.CENTER);
        layout.setVgap(12);
        layout.setHgap(12);
        layout.setPadding(new Insets(15, 15, 15, 15));


        layout.add(text, 0, 0, 2, 1);
        layout.add(yesButton, 0, 1, 1, 1);
        layout.add(noButton, 1, 1, 1, 1);


        yesButton.setOnAction(e -> {
            response = true;
            primaryStage.close();

        });
        noButton.setOnAction(event -> {
            response = false;
            primaryStage.close();
        });

        Scene scene = new Scene(layout);
        primaryStage.setScene(scene);
        primaryStage.showAndWait();
    }

    private void setUpStage(Stage stage) {
        stage.setTitle("Confirmation");
        stage.setResizable(false);
        stage.setAlwaysOnTop(true);
    }
}
