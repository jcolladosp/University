/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import model.PC;

/**
 * FXML Controller class
 *
 * @author colla
 */
public class PreBuildScreenController implements Initializable {

    @FXML
    private TableColumn<PC, String> buildsCol;
    @FXML
    private Button backBut;
    @FXML
    private TableView<PC> tableView;
    @FXML
    private Button editBuild;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         buildsCol.setCellValueFactory((e) -> e.getValue().getName());
        ArrayList<PC> prebuildList = new ArrayList<PC>();
        ObservableList<PC> observableEnum = FXCollections.observableArrayList(prebuildList);
      
        tableView.setItems(observableEnum);
        
        try {
          URL root = getClass().getResource("/prebuilds/Gaming PC.colli");
         URL root2 = getClass().getResource("/prebuilds/Home PC.colli");
         URL root3 = getClass().getResource("/prebuilds/Pc of the year.colli");
            
            JAXBContext jaxbContext = JAXBContext.newInstance(PC.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
             PC pc = (PC) jaxbUnmarshaller.unmarshal(root);
             PC pc2 = (PC) jaxbUnmarshaller.unmarshal(root2);
             PC pc3 = (PC) jaxbUnmarshaller.unmarshal(root3);
             pc.setName("Gaming PC");
             pc2.setName("Home PC");
              pc3.setName("Pc of the year");
             observableEnum.add(pc);observableEnum.add(pc2);observableEnum.add(pc3);
        }
         catch (Exception e) { e.printStackTrace();}

    }    

    @FXML
    private void onBack(ActionEvent event) {
         try{  
                 FXMLLoader charger = new FXMLLoader(getClass().getResource("/view/MainScreen.fxml"));
                 Parent root = charger.load();   
                 Scene scene = new Scene(root);
                 
                Stage window = new Stage();
                window.setTitle("PC Configurator - RotoSoft");
                window.setScene(scene);
                window.setResizable(true);
                window.setMinHeight(450.0);
                window.setMinWidth(600.0);
                window.show();
            
      ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();     
    }
      catch (IOException e){}
    
    }

    @FXML
    private void onNew(ActionEvent event) {
         try {
     
            PC pcload = tableView.getSelectionModel().getSelectedItem();
            
                  
            
             FXMLLoader charger = new FXMLLoader(getClass().getResource("/view/CreatorScreen.fxml"));
             Parent root = charger.load();   
             Scene scene = new Scene(root);
                 
                CreatorController passerPC = charger.<CreatorController>getController();
                passerPC.storePC(pcload);
                
             
                Stage window = new Stage();
                window.setTitle("New PC - RotoSoft");
                window.setScene(scene);
                window.setResizable(true);
                window.setMinHeight(450.0);
                window.setMinWidth(600.0);
                window.show();
            
      ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();  
            
     }
        catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Problem with the file");
            alert.setContentText("There was a problem with the file, choose a correct one.");
            alert.showAndWait();
        }
    
}
}
