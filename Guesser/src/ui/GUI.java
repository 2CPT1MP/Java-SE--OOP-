package ui;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import processing.OptionProcessor;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import processing.Source;

public class GUI extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        setUpStage(primaryStage);

        //CREATE Buttons
        Button deleteButton = new Button("Wipe");
        deleteButton.setFont(Font.font(13));
        deleteButton.setMinSize(80, 10);
        Button addButton = new Button("Add");
        addButton.setFont(Font.font(13));
        addButton.setMinSize(80, 10);
        Button generateButton = new Button("Generate");
        generateButton.setFont(Font.font(13));
        generateButton.setMinSize(180, 10);
        generateButton.setMaxSize(180, 40);

        //CREATE Text
        Label hintLabel = new Label("Submit Option:");
        hintLabel.setFont(Font.font(15));
        TextField input = new TextField();
        input.setMinSize(180, 20);
        input.setMaxSize(180, 40);
        Text output = new Text();
        output.setFill(Color.RED);

        Label outputLabel = new Label("Get random response:");
        outputLabel.setFont(Font.font(15));


        //CONFIG Layout
        GridPane layout = new GridPane();
        layout.setPadding(new Insets(15));
        layout.setVgap(15);
        layout.setHgap(15);
        layout.setPrefSize(400, 200);
        layout.setPrefSize(400, 200);


        //ADD Elements
        layout.add(deleteButton, 1, 3);
        layout.add(addButton, 1, 1);
        layout.add(generateButton, 0, 3);
        layout.add(hintLabel, 0, 0);
        layout.add(input, 0, 1);

        layout.add(outputLabel, 0, 2);
        layout.add(output, 0, 4);


        //EVENT LISTENERS
        addButton.setOnAction(event -> {
            if (input.getText().equalsIgnoreCase(""))
                output.setText("Record is empty");
            else {
                OptionProcessor.getInstance().addOption(input.getText());
                output.setText("Record was added");
                input.clear();
                generateButton.setVisible(true);
                deleteButton.setVisible(true);
        }});

        generateButton.setOnAction(e -> {
            String option = OptionProcessor.getInstance().getOption();

            if (option != null)
                output.setText(option);
            else
                output.setText("No options are avaiable");
        });

        deleteButton.setOnAction(event -> {
                    String option = OptionProcessor.getInstance().getOption();

                    if (option != null) {

                        ConfirmDialog dialog = new ConfirmDialog();
                        dialog.start(new Stage());

                        if (ConfirmDialog.getResponse()) {
                            Source.wipe();
                            output.setText("Wiped successfully");
                        }
                    } else
                        output.setText("No source file found");
                }
        );

        input.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER)
                addButton.fire();
        });


        //DISPLAY SCENE
        Scene scene = new Scene(layout, 300, 220);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void setUpStage(Stage stage) {
        stage.setResizable(false);
        stage.setTitle("Guesser v2");
    }
}
