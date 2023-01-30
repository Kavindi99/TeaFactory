package lk.ijse.teafactory.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.teafactory.util.Navigation;
import lk.ijse.teafactory.util.Routes;

import java.io.IOException;

/**
 * author - kavindi
 * version - 1.0.0 1:10 AM 11/20/2022
 **/
public class LoginFormController {

    public JFXTextField txtUserName;
    public Button btnLogin;
    public JFXPasswordField txtPassword;
    public AnchorPane pane;
    public JFXButton btnClose;


    public void btnLoginOnAction(ActionEvent actionEvent) throws IOException {
        if(txtUserName.getText().equals("Owner") && txtPassword.getText().equals("Owner1234")){
            Navigation.navigate(Routes.OWNER_DASHBOARD, pane);//setUi("AdminForm");

        } else if (txtUserName.getText().equals("Admin") && txtPassword.getText().equals("Admin1234")){
            Navigation.navigate(Routes.ADMIN_DASHBOARD, pane);//setUi("ReceptionForm");
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);// line 1
            alert.setTitle("Incorrect Password");// line 2
            alert.setHeaderText("INVALID USER NAME OR PASSWORD!!!");// line 3
            alert.setContentText("Please, check your User Name and Password, and try again!");// line 4
            alert.showAndWait(); // line 5
        }
    }


    public void btnCloseOnAction(ActionEvent actionEvent) {
        System.exit(0);
    }
}
