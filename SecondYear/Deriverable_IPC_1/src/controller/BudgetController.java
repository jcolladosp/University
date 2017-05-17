
package controller;

import es.upv.inf.Product;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.transform.Scale;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import model.PC;

/**
 * FXML Controller class
 *
 * @author jcolladosp
 */
public class BudgetController implements Initializable {

    @FXML
    private TableColumn<Product, Number> colPrice;
    @FXML
    private TableColumn<Product, Number> colTotal;
    @FXML
    private Button modifyButton;
    @FXML
    private Button printButton;
    @FXML
    private Button saveButton;
    
    public ObservableList <Product> list = null;
    public PC pc;
    
    @FXML
    private TableView<Product> tableView;
    @FXML
    private TableColumn<Product, String> descColumn;
    @FXML
    private Label label_outVAT;
    @FXML
    private Label label_totalPrice;
    @FXML
    private TableColumn<Product, Number> colVat;
    @FXML
    private Label vat_label;
    @FXML
    private AnchorPane anchor;
    @FXML
    private Button newButton;
    @FXML
    private Label nameLabel;
    @FXML
    private TextField nameField;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         descColumn.setCellValueFactory((e) -> new SimpleStringProperty(e.getValue().getDescription()));
         colPrice.setCellValueFactory((e)-> new SimpleDoubleProperty(e.getValue().getPrice()));  
         colVat.setCellValueFactory((e)-> new SimpleDoubleProperty(Math.round((e.getValue().getPrice())*21.0/100.0)));   
         colTotal.setCellValueFactory((e)-> percen(e.getValue().getPrice()));
         
        modifyButton.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/images/modify.png"))));
       newButton.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/images/new.png"))));
       saveButton.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/images/save.png"))));         
        printButton.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/images/print.png"))));
    }    
    public SimpleDoubleProperty percen(double xd){
             
        double time = Math.round((xd +(xd*(21.0/100.0))));
        SimpleDoubleProperty saludos = new SimpleDoubleProperty(time);
        return saludos ;
        
    }
    @FXML
    private void onModify(ActionEvent event) {
           
                try{
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
      catch (Exception e){System.out.println(e);}
    }
    
    @FXML
    private void onPrint(ActionEvent event) {
        Node x = (Node) event.getSource();
        modifyButton.setOpacity(0);saveButton.setOpacity(0);printButton.setOpacity(0);newButton.setOpacity(0);
        
        
        x.getScene().getWindow().setOpacity(0);
        print(anchor,event);
    }

    @FXML
    private void onSave(ActionEvent event) {
            pc.setName(nameField.getText());
            FileChooser chooser = new FileChooser();
            chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PC Configurator", "*.colli"));
            chooser.setInitialFileName(nameField.getText());
            
            
            File file = chooser.showSaveDialog(((Node) event.getSource()).getScene().getWindow());
        
            if (file != null) {
            // Make sure it has the correct extension
             if (!file.getPath().endsWith(".colli")) {
                file = new File(file.getPath() + ".colli");
            }
            savePCDataToFile(file);
        }
        
    }
    
    public void storePC(PC pc1){
    pc = pc1;
     list =  FXCollections.observableList(pc.getList());
     tableView.setItems(list);
     
     double withoutVAT = 0;
     double total = 0;
     double VAT = 0;
    
        for (int i = 0; i < pc.getList().size(); i++) {
           double price = pc.getList().get(i).getPrice();
           VAT += Math.round((price*21.0)/100.0);
           total += Math.round(((price*21.0)/100.0)+price);
           withoutVAT += Math.round(price);
           
        }
        
        vat_label.setText("V.A.T: " + VAT + " €");
        label_outVAT.setText("Price without V.A.T: " + withoutVAT + " €");
        label_totalPrice.setText("Total price: " + total + " €");
    }    
    public void print(final Node node, ActionEvent event){
        node.getTransforms().add(new Scale(0.5,0.5));
        PrinterJob pj = PrinterJob.createPrinterJob();
        if(pj!=null && pj.showPrintDialog(node.getScene().getWindow())) {
            boolean scc = pj.printPage(node);
            if(scc){pj.endJob();}
        }
        node.getTransforms().add(new Scale(2,2));
        
        Node x = (Node) event.getSource();
        x.getScene().getWindow().setOpacity(1);
        modifyButton.setOpacity(1); printButton.setOpacity(1);saveButton.setOpacity(1);newButton.setOpacity(1);
    }

    @FXML
    private void onNew(ActionEvent event) {
         try{  
                 FXMLLoader charger = new FXMLLoader(getClass().getResource("/view/MainScreen.fxml"));
                 Parent root = charger.load();   
                 Scene scene = new Scene(root);
                 
            
                Stage window = new Stage();
                window.setTitle("PC Configurator - RotoSoft");
                window.setScene(scene);
                window.setResizable(true);
                window.setMinHeight(430.0);
                window.setMinWidth(400.0);
                window.show();
            
      ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();     
                }
      catch (IOException e){System.out.println(e);}
    }
    public void savePCDataToFile(File file) {
    try {
        JAXBContext context = JAXBContext.newInstance(PC.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        // Marshalling and saving XML to the .colli file.
        m.marshal(pc, file);
        //m.marshal(pc, System.out); // echo to the console
      
    } catch (Exception e) { 
        e.printStackTrace();
    }
    }
}