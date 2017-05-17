
package controller;

import javafx.scene.image.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import model.PC;

/**
 * FXML Controller class
 *
 * @author colla
 */
public class MainScreenController implements Initializable {

    @FXML
    private Button new_button;
    @FXML
    private Button load_button;
    @FXML
    private Button precon_button;
    
    Image image ;
    
    
    /**
     * Initializes the controller class.
     */
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
       load_button.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/images/add.png"))));
       new_button.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/images/computer.png"))));
       precon_button.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/images/preconfig.png"))));
      
       
    }    

    @FXML
    private void onNew(ActionEvent event) {
        
             try{  
                 
                
                 FXMLLoader charger = new FXMLLoader(getClass().getResource("/view/CreatorScreen.fxml"));
                 Parent root = charger.load();   
                 Scene scene = new Scene(root);
                                  
                 
                Stage window = new Stage();
                window.setTitle("New PC - RotoSoft");
                window.setScene(scene);
                window.setResizable(true);
                window.setMinHeight(450.0);
                window.setMinWidth(600.0);
                window.show();
            
      ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();     
    }
      catch (Exception e){System.out.println(e);}
    
    }
    

    @FXML
    private void onLoad(ActionEvent event) {
     try {
            FileChooser chooser = new FileChooser();
            chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PC Configurator", "*.colli"));
            File file = chooser.showOpenDialog(((Node) event.getSource()).getScene().getWindow());
            
            JAXBContext jaxbContext = JAXBContext.newInstance(PC.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
             PC pc = (PC) jaxbUnmarshaller.unmarshal(file);
            
            
             FXMLLoader charger = new FXMLLoader(getClass().getResource("/view/CreatorScreen.fxml"));
             Parent root = charger.load();   
             Scene scene = new Scene(root);
                 
                CreatorController passerPC = charger.<CreatorController>getController();
                passerPC.storePC(pc);
                
             
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

    @FXML
    private void onPrecon(ActionEvent event) {
        try{  
                 FXMLLoader charger = new FXMLLoader(getClass().getResource("/view/PrebuildScreen.fxml"));
                 Parent root = charger.load();   
                 Scene scene = new Scene(root);
                 
                Stage window = new Stage();
                window.setTitle("New PC - RotoSoft");
                window.setScene(scene);
                window.setResizable(true);
                window.setMinHeight(400.0);
                window.setMinWidth(300.0);
                window.show();
            
      ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();     
    }
      catch (IOException e){}
    }
    
}
