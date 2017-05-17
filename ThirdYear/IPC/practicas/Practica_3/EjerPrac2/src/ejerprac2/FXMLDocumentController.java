/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerprac2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.util.converter.NumberStringConverter;

/**
 * FXML Controller class
 *
 * @author colla
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Slider slider;
    @FXML
    private Label rate_label;
    @FXML
    private TextField input_field;
    @FXML
    private TextField output_field;
    @FXML
    private Button convert_button;
    @FXML
    private Button clear_button;
    @FXML
    private CheckBox automatic;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
         rate_label.textProperty().bind(Bindings.format("Conversion Rate: %.2f", slider.valueProperty()));
         
         convert_button.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            output_field.setText(String.format("%.2f",(Double.parseDouble(input_field.getText()) * slider.getValue())));
        });
         
         clear_button.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            output_field.setText("");
            input_field.setText("");
        });
         
         automatic.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            if(!automatic.isSelected())
             convert_button.setDisable(false);
            else {convert_button.setDisable(true);}
            
            
        });
         
         slider.valueProperty().addListener((observable, oldVal, newVal) ->
            { 
            if(automatic.isSelected()){
           output_field.setText(String.format("%.2f",(Double.parseDouble(input_field.getText()) * slider.getValue())));
           }
            
            });
           
        
    }    
    
}
