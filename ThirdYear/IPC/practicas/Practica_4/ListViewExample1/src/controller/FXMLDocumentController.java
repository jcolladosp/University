/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Person;

/**
 *
 * @author fjabad
 */
public class FXMLDocumentController implements Initializable {
    @FXML
    private ListView<Person> listView;
    @FXML
    private Button buttonAdd;
    @FXML
    private Button buttonRemove;
    @FXML
    private TextField firstNameText;
    @FXML
    private TextField lastNameText;
    @FXML
    private Button button_modify;

    private ObservableList<Person> data = null;
    private Stage myOwnStage;
    
    public ArrayList<Person> backupList = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        backupList.add(new Person("John", "Doe"));
        backupList.add(new Person("Jane", "Doe"));
        data = FXCollections.observableArrayList(backupList);
        
        
        listView.setItems(data);
        listView.setCellFactory(c-> new PersonListCell());

        buttonRemove.disableProperty().bind(
                Bindings.equal(-1,
                        listView.getSelectionModel().selectedIndexProperty()));
        
        button_modify.disableProperty().bind(
                Bindings.equal(-1,
                        listView.getSelectionModel().selectedIndexProperty()));

        
    }

    @FXML
    private void onAddItem(ActionEvent event) {
       try {
           
            Stage aNewStage = new Stage();
            FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/view/Window2.fxml"));
            Parent root = (Parent) myLoader.load();
            myLoader.<Window2Controller>getController().initStage(aNewStage);
            Scene scene = new Scene(root, 355, 170);
            aNewStage.setScene(scene);
            aNewStage.initModality(Modality.APPLICATION_MODAL);
            aNewStage.show();
            
            Window2Controller personController = myLoader.<Window2Controller>getController();
            personController.modifyPerson(data, listView.getSelectionModel().getSelectedItem(), listView.getSelectionModel().getSelectedIndex(),false);
            
        
       } catch (IOException e) {
            e.printStackTrace();
            }
        
       }

    @FXML
    private void onRemoveItem(ActionEvent event) {
        data.remove(listView.getSelectionModel().getSelectedIndex());
    }
    
    @FXML
    private void onModify(ActionEvent event) {
       try {
           
            Stage aNewStage = new Stage();
            FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/view/Window2.fxml"));
            Parent root = (Parent) myLoader.load();
            myLoader.<Window2Controller>getController().initStage(aNewStage);
            Scene scene = new Scene(root, 355, 170);
            aNewStage.setScene(scene);
            aNewStage.initModality(Modality.APPLICATION_MODAL);
            aNewStage.show();
            
            Window2Controller personController = myLoader.<Window2Controller>getController();
            personController.modifyPerson(data, listView.getSelectionModel().getSelectedItem(), listView.getSelectionModel().getSelectedIndex(),true);
            
        
       } catch (IOException e) {
            e.printStackTrace();
            }
       
      
    }

    @FXML
    private void onLastNameEntered(ActionEvent event) {
        onAddItem(null);
    }

    
     public void editPerson(String firstName, String lastName){
       data.get(listView.getSelectionModel().getSelectedIndex()).setFirstName(firstName);
       data.get(listView.getSelectionModel().getSelectedIndex()).setLastName(lastName);
        }
      public void initStage(Stage stage) {
        myOwnStage = stage;
        myOwnStage.setTitle("Add or Modify");
}

}
