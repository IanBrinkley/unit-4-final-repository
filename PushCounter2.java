import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PushCounter2 extends Application {

    private int count;
    private Text countText;

    @Override
    public void start(Stage stage) {
        count = 50;
        countText = new Text("Pushes: " + count);

        Button increment = new Button("Up");
        Button decrement = new Button("Down");
        increment.setOnAction(this::incrementPressed);
        decrement.setOnAction(this::decrementPressed);

        FlowPane seen = new FlowPane(increment, countText, decrement);
        seen.setAlignment(Pos.CENTER);
        seen.setHgap(25);
        seen.setStyle("-fx-background-color: green");

        Scene scene = new Scene(seen, 300, 100);

        stage.setTitle("PushCounter2");
        stage.setScene(scene);
        stage.show();
    }

    private void incrementPressed(ActionEvent event) {
        count++;
        countText.setText("Pushes: " + count);
    }
    private void decrementPressed(ActionEvent event) {
        count--;
        countText.setText("Pushes: " + count);
    }
}
