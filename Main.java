package sample;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    Stage originWindow;
    Scene origin;
    Button genB = new Button("Generate");
    Text outputA = new Text();
    Text outputB = new Text();
    Label genL = new Label("Generate a triangle on a circle with a radius of 40");
    @Override
    public void start(Stage primaryStage) throws Exception {
        genB.setOnAction(e -> {
            String[] array = CircleandT.toStringTri();
            String outAng, outPoi;
            outAng = array[0];
            outPoi = array[1];
            outputA.setText(outAng);
            outputB.setText(outPoi);
        });
        originWindow = primaryStage;

        GridPane gridA = new GridPane();
        gridA.setAlignment(Pos.CENTER);
        gridA.setPadding(new Insets(10,10,10,10));
        gridA.setVgap(10);
        gridA.setHgap(5);
        gridA.add(genB, 0, 1);
        gridA.add(outputA, 0, 2);
        gridA.add(genL, 0, 0);
        gridA.add(outputB, 0, 3);
        origin = new Scene(gridA, 1000,500);
        primaryStage.setScene(origin);
        originWindow.show();
    }
}



