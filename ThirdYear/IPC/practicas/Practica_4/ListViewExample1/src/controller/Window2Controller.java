/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Person;

/**
 * FXML Controller class
 *
 * @author colla
 */
public class Window2Controller implements Initializable {

    @FXML
    private TextField first_name_field;
    @FXML
    private TextField last_name_field;
    @FXML
    private Button cancel_button;
    @FXML
    private Button save_button;

    private Stage myOwnStage;
    
    public Person persona;
    
    private ObservableList<Person> data2 = null;
     
    private int inde;
    
    private boolean mod;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onCancel(ActionEvent event) {
        
         Node n = (Node) event.getSource();
           n.getScene().getWindow().hide();
    }

    @FXML
    private void onSave(ActionEvent event) {
            Person person = new Person(first_name_field.getText(),last_name_field.getText()); 
            
            if(mod) data2.set(inde, person);
            else data2.add(person);
                
           Node n = (Node) event.getSource();
           n.getScene().getWindow().hide();
        
     
    }
    
    public void initStage(Stage stage) {
        myOwnStage = stage;
        myOwnStage.setTitle("Add or modify");
}
     public void modifyPerson(ObservableList<Person> data,Person p,int index,boolean modify){
        
        if(modify){ 
        first_name_field.setText(p.getFirstName());
        last_name_field.setText(p.getLastName());}
        
        data2 = data;
        
        persona = p;
        
        inde = index;
        
        mod = modify;
        }
   
}
