/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerprac1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author colla
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label counter;
    @FXML
    private Button boton_1;
    @FXML
    private Button boton_5;
    @FXML
    private Button boton_10;
    @FXML
    private CheckBox check_subs;
    @FXML
    private TextField textfield;
    @FXML
    private Button boton_add;
    @FXML
    private Label label_sub;

    private double contador = 0;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
         check_subs.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
             if(label_sub.isVisible()){label_sub.setVisible(false);}
             else{label_sub.setVisible(true);}
             
        });
       
       
        boton_1.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            if(check_subs.isSelected()){contador--;}
            else{contador++;}
            counter.setText(Double.toString(contador));
        });
        
        boton_5.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            if(check_subs.isSelected()){contador=contador-5;}
            else{contador=contador+5;}
            counter.setText(Double.toString(contador));
        });
        
        boton_10.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            if(check_subs.isSelected()){contador=contador-10;}
            else{contador=contador+10;}
            counter.setText(Double.toString(contador));
        });
        boton_add.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            try{
             if(check_subs.isSelected()){contador=contador - Double.parseDouble(textfield.getText());}
             else{contador=contador+ Double.parseDouble(textfield.getText());}   
            
            counter.setText(Double.toString(contador));
            }
            catch(Exception e){ textfield.setText("ONLY INTEGERS!!!!!");}
        });
    }    
        
    
   
    
}
