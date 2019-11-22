import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.control.TextField;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;

public class CircleBuilder extends Application {
    private int radius;
    private int strokeWidth;
    private Circle myCircle;
    private TextField getRadius;
    private TextField getStrokeWidth;
    private Text errorMessage;

    @Override
    public void start(Stage stage) {
        radius = 50;
        strokeWidth = 10;
        myCircle = new Circle(150, 150, radius);
        errorMessage = new Text("");
        errorMessage.setVisible(false);

        getRadius = new TextField();
        getRadius.setPrefWidth(40);
        getRadius.setAlignment(Pos.CENTER);
        getRadius.setOnAction(this::drawCircle);
        getRadius.setLayoutX(130.0);
        getRadius.setLayoutY(117.5);

        getStrokeWidth = new TextField();
        getStrokeWidth.setPrefWidth(40);
        getStrokeWidth.setAlignment(Pos.CENTER);
        getStrokeWidth.setOnAction(this::setStrokeWidth);
        getStrokeWidth.setLayoutX(130.0);
        getStrokeWidth.setLayoutY(157.5);

        myCircle.setFill(Color.WHITE);
        myCircle.setStroke(Color.BLACK);

        errorMessage.setX(5);
        errorMessage.setY(15);
        errorMessage.setFill(Color.rgb(127,127,127));

        Group root = new Group(myCircle, getRadius, getStrokeWidth, errorMessage);

        Scene scene = new Scene(root, 300, 300);
        stage.setTitle("Circle Builder");
        stage.setScene(scene);
        stage.show();

    }
    public void drawCircle(ActionEvent event) {
        try {
            radius = Integer.parseInt(getRadius.getText());
            if (radius < 0 || radius > 500) {
                errorMessage.setText("Radius should be between 0 and 500.");
                errorMessage.setVisible(true);
            } else {
                myCircle.setRadius(radius);
                errorMessage.setVisible(false);
            }
        } catch (Exception E) {
            errorMessage.setText("Try to input only integers.");
            errorMessage.setVisible(true);
        }
        getRadius.setText("");
    }
    public void setStrokeWidth(ActionEvent event) {
        try {
            strokeWidth = Integer.parseInt(getStrokeWidth.getText());
            if (strokeWidth < 0 || strokeWidth > 1000) {
                errorMessage.setText("Stroke width should be between 0 and 1000.");
                errorMessage.setVisible(true);
            } else {
                myCircle.setStrokeWidth(strokeWidth / 10.0);
                errorMessage.setVisible(false);
            }
        } catch (Exception E) {
            errorMessage.setText("Try to input only integers.");
            errorMessage.setVisible(true);
        }
        getStrokeWidth.setText("");
    }
}
