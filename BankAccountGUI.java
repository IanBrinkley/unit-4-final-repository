import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextField;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class BankAccountGUI extends Application{

    //private BankAccount myAccount;
    private BankAccount userAccount;
    private Text outputField;
    private TextField iUsernameH;
    private TextField iPinH;
    private Button createAccountBtn;
    private Text accountCreated;
    private Text userLbl;
    private Text PINLbl;
    private TextField depositField;
    private TextField withdrawField;
    private Text depositLbl;
    private Text withdrawLbl;
    private Button depositBtn;
    private Button withdrawBtn;
    private Button hideAccountInfoBtn;
    private Button showAccountInfoBtn;
    private Text errorMessage;
    private Text displayInfo;
    private Button compoundInterestBtn;

    @Override
    public void start(Stage stage) {
        //myAccount = new BankAccount(98527, "ur mom", 100.0, 2);
        /*outputField = new Text("User: " + myAccount.getUsername() + "\npin: " + myAccount.getPin());
        outputField.setX(60.0);
        outputField.setY(60.0);*/

        //creating a new account
        iUsernameH = new TextField();
        iPinH = new TextField();
        createAccountBtn = new Button("Create account");
        accountCreated = new Text("");
        iUsernameH.setPrefWidth(100.0);
        iPinH.setPrefWidth(70.0);
        HBox createAccount = new HBox(iUsernameH, iPinH, createAccountBtn);

        userLbl = new Text("Username");
        PINLbl = new Text("PIN");

        depositLbl = new Text("Deposit");
        withdrawLbl = new Text("With \"The\" Draw");

        accountCreated.setFill(Color.GREEN);

        depositField = new TextField();
        withdrawField = new TextField();

        depositField.setPrefWidth(80.0);
        withdrawField.setPrefWidth(80.0);

        depositBtn = new Button(" Deposit ");
        withdrawBtn = new Button("Withdraw");
        hideAccountInfoBtn = new Button("Hide info");
        showAccountInfoBtn = new Button("Show info");
        compoundInterestBtn = new Button("Compound interest");

        errorMessage = new Text("");
        displayInfo = new Text("");

        accountCreated.setLayoutX(20.0);
        accountCreated.setLayoutY(20.0);

        GridPane gridPain = new GridPane();
        gridPain.setHgap(10.0);
        gridPain.setVgap(10.0);
        gridPain.setConstraints(userLbl, 0, 0);
        gridPain.setConstraints(PINLbl, 0, 1);
        gridPain.setConstraints(iUsernameH, 1, 0);
        gridPain.setConstraints(iPinH, 1, 1);
        gridPain.setConstraints(createAccountBtn, 2, 1);
        gridPain.setConstraints(hideAccountInfoBtn, 3, 1);
        gridPain.setConstraints(showAccountInfoBtn, 3, 0);
        gridPain.getChildren().addAll(userLbl, PINLbl, iUsernameH, iPinH, createAccountBtn, hideAccountInfoBtn, showAccountInfoBtn);

        gridPain.setStyle("-fx-background-color: #c0c0c0; -fx-padding: 20 20 20 20;");

        GridPane gridPain2 = new GridPane();
        gridPain2.setHgap(10.0);
        gridPain2.setVgap(10.0);
        gridPain2.setConstraints(depositLbl, 0, 0);
        gridPain2.setConstraints(withdrawLbl, 0, 1);
        gridPain2.setConstraints(depositField, 1, 0);
        gridPain2.setConstraints(withdrawField, 1, 1);
        gridPain2.setConstraints(depositBtn, 2, 0);
        gridPain2.setConstraints(withdrawBtn, 2, 1);
        gridPain2.setConstraints(errorMessage,3, 1);
        gridPain2.setConstraints(compoundInterestBtn, 3, 0);
        gridPain2.getChildren().addAll(depositLbl, withdrawLbl, depositField, withdrawField, depositBtn, withdrawBtn, errorMessage, compoundInterestBtn);

        gridPain2.setStyle("-fx-background-color: #cfcfcf; -fx-padding: 20 20 20 20;");

        createAccount.setSpacing(30.0);
        createAccount.setLayoutX(20.0);
        createAccount.setLayoutY(35.0);

        createAccountBtn.setOnAction(this::createAccountPress);
        hideAccountInfoBtn.setOnAction(this::hideAccountInfo);
        showAccountInfoBtn.setOnAction(this::showAccountInfo);
        depositBtn.setOnAction(this::depositPress);
        withdrawBtn.setOnAction(this::withdrawPress);
        compoundInterestBtn.setOnAction(this::compoundInterestBtnPress);

        VBox spacingG = new VBox(accountCreated, gridPain, gridPain2, displayInfo);
        spacingG.setSpacing(10.0);
        spacingG.setLayoutX(10.0);
        spacingG.setLayoutY(10.0);
        Group root = new Group(spacingG);

        Scene scene = new Scene(root, 445.0, 400.0);

        stage.setTitle("BankAccountGUI");
        stage.setScene(scene);
        stage.show();
    }
    private void createAccountPress(ActionEvent event) {
        errorMessage.setText("");
        try {
            userAccount = new BankAccount(Integer.parseInt(iPinH.getText()), iUsernameH.getText(), (int)(Math.random()*10)/2.5);
            userLbl.setText("Username");
            PINLbl.setText("PIN");
            iUsernameH.setText("");
            iPinH.setText("");
            accountCreated.setText("Account created!");
            accountCreated.setFill(Color.GREEN);
            displayInfo.setText(userAccount.toString());
        } catch (Exception E) {
            accountCreated.setText("Invalid inputs! (PIN must be an integer)");
            accountCreated.setFill(Color.RED);
        }
    }
    private void depositPress(ActionEvent event) {
        errorMessage.setText("");
        try {
            if (userAccount.getUsername().equals(iUsernameH.getText()) && userAccount.getPin() == Integer.parseInt(iPinH.getText())) {
                userAccount.deposit(Double.parseDouble(depositField.getText()));
                accountCreated.setText("Deposit successful.");
                depositField.setText("");
                iUsernameH.setText("");
                iPinH.setText("");
                accountCreated.setFill(Color.GREEN);
                displayInfo.setText(userAccount.toString());
            } else {
                accountCreated.setText("Incorrect details.");
                accountCreated.setFill(Color.RED);
            }
        } catch (Exception E) {
            accountCreated.setText("Invalid inputs! (Must deposit a number amount)");
            accountCreated.setFill(Color.RED);
            if (userAccount == null) {
                accountCreated.setText("You must make an account.");
            }
        }
    }
    private void withdrawPress(ActionEvent event) {
        try {
            if (userAccount.getUsername().equals(iUsernameH.getText()) && userAccount.getPin() == Integer.parseInt(iPinH.getText())) {
                userAccount.withdraw(Double.parseDouble(withdrawField.getText()));
                accountCreated.setText("Withdrawal successful.");
                withdrawField.setText("");
                iUsernameH.setText("");
                iPinH.setText("");
                accountCreated.setFill(Color.GREEN);
                displayInfo.setText(userAccount.toString());
                if (userAccount.getBalance() == 0.0) {
                    errorMessage.setText("Reached $0 in account.");
                    errorMessage.setFill(Color.RED);
                    accountCreated.setText("");
                } else {
                    errorMessage.setText("");
                }
            } else {
                accountCreated.setText("Incorrect details.");
                accountCreated.setFill(Color.RED);
            }
        } catch (Exception E) {
            accountCreated.setText("Invalid inputs! (Must withdraw a number amount)");
            accountCreated.setFill(Color.RED);
            if (userAccount == null) {
                accountCreated.setText("You must make an account.");
            }
        }
    }
    private void hideAccountInfo(ActionEvent event) {
        displayInfo.setText("");
        accountCreated.setText("");
        errorMessage.setText("");
    }
    private void showAccountInfo(ActionEvent event) {
        errorMessage.setText("");
        try {
            if (userAccount.getUsername().equals(iUsernameH.getText()) && userAccount.getPin() == Integer.parseInt(iPinH.getText())) {
                displayInfo.setText(userAccount.toString());
                iUsernameH.setText("");
                iPinH.setText("");
                accountCreated.setText("Account info displayed.");
                accountCreated.setFill(Color.GREEN);
            } else {
                accountCreated.setText("Incorrect details.");
                accountCreated.setFill(Color.RED);
            }
        } catch (Exception E) {
            accountCreated.setText("Invalid inputs! (PIN must be an integer)");
            accountCreated.setFill(Color.RED);
            if (userAccount == null) {
                accountCreated.setText("You must make an account.");
            }
        }
    }
    private void compoundInterestBtnPress(ActionEvent event) {
        errorMessage.setText("");
        try {
            if (userAccount.getUsername().equals(iUsernameH.getText()) && userAccount.getPin() == Integer.parseInt(iPinH.getText())) {
                userAccount.compoundInterest();
                displayInfo.setText(userAccount.toString());
                iUsernameH.setText("");
                iPinH.setText("");
                accountCreated.setText("Interest added.");
                accountCreated.setFill(Color.GREEN);
            } else {
                accountCreated.setText("Incorrect details.");
                accountCreated.setFill(Color.RED);
            }
        } catch (Exception E) {
            accountCreated.setText("Invalid inputs! (PIN must be an integer)");
            accountCreated.setFill(Color.RED);
            if (userAccount == null) {
                accountCreated.setText("You must make an account.");
            }
        }
    }
}

