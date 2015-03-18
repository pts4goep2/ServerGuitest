/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication5;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafxapplication5.Server.Server;

/**
 * FXML Controller class
 *
 * @author pieter
 */
public class ServerGUIController implements Initializable {

    /**
     * Initializes the controller class.
     * 
     */
    @FXML TextArea input;
    @FXML ListView OutPut;
    @FXML TextArea present;
    private Server server;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        server = new Server(this);
    } 
    
    @FXML
    public void btnChat_Click()
    {
        String bericht = input.getText();
        server.sendMessage(bericht, "Hallo");
    }
    
    public void AddItemListview(String item)
    {
        Platform.runLater(new Runnable() {

            @Override
            public void run() 
            {
                OutPut.getItems().add(item);            
            }
        });
    }
    
}
