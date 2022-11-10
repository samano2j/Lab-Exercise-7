package signup;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class SignUpController implements Initializable {
    SignUpModel signUpModel = null;

    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private Button signupBtn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.signUpModel = new SignUpModel();  
    }

    @FXML
    public void SignUp(ActionEvent event){
        signUpModel.signUp(this.username.getText(), this.password.getText());

        Stage stage = (Stage) this.signupBtn.getScene().getWindow();
        stage.close();

        Stage homeStage = new Stage();
        try {
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/login/Login.fxml")));

            homeStage.setScene(scene);
            homeStage.setTitle("Login Page");
            homeStage.show();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
