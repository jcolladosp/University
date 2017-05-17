package controller;

import es.upv.inf.Product;
import es.upv.inf.Product.Category;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Callback;
import model.PC;

/**
 * FXML Controller class
 *
 * @author jcolladosp
 */
public class CreatorController implements Initializable {

    @FXML
    private Button add_button;
    @FXML
    private Button budget_button;
    
    @FXML
    private CheckBox check_cpu;
    @FXML
    private CheckBox check_mother;
    @FXML
    private CheckBox check_ram;
    @FXML
    public CheckBox check_graphic;
    @FXML
    private CheckBox check_disk;
    @FXML
    private CheckBox check_case;
    
    public ObservableList <Product> list ;
    @FXML
    private TableView<Product> productTable;
    @FXML
    private TableColumn<Product, String> descColumn;
    @FXML
    private TableColumn<Product, Number> priceColumn;

    public PC pc;
    @FXML
    private AnchorPane anchonpane;
    @FXML
    private VBox check_vbox;
    @FXML
    private TableColumn<Product,Boolean> col_action;
    
    public static int counter_cpu, counter_mother, counter_ram, counter_graphic,counter_disk, counter_case = 0;
    @FXML
    private HBox hbox_alert;
   
      
        
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        descColumn.setCellValueFactory((e) -> new SimpleStringProperty(e.getValue().getDescription()));
        priceColumn.setCellValueFactory((e)-> new SimpleDoubleProperty(e.getValue().getPrice()));
        
        pc = new PC();
                       
        storePC(pc);
          
        col_action.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Product, Boolean>, 
                ObservableValue<Boolean>>() {

            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Product, Boolean> p) {
                return new SimpleBooleanProperty(p.getValue() != null);
            }
        });

        //Adding the Button to the cell
        col_action.setCellFactory(
                new Callback<TableColumn<Product, Boolean>, TableCell<Product, Boolean>>() {

            @Override
            public TableCell<Product, Boolean> call(TableColumn<Product, Boolean> p) {
                return new ButtonCell();
            }
        
        });
         
        
        
        add_button.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/images/component.png"))));
       budget_button.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/images/cart.png"))));
      
    }    
   
    
    
   
    @FXML
    private void onBudget(ActionEvent event) {
         
        ArrayList<CheckBox> sol = checkSelected();
        if(sol.isEmpty()){
        
            try{  
                 FXMLLoader charger = new FXMLLoader(getClass().getResource("/view/BudgetScreen.fxml"));
                 Parent root = charger.load();   
                 Scene scene = new Scene(root);
                 
                 
                BudgetController passerPC = charger.<BudgetController>getController();
                passerPC.storePC(pc);
                 
                Stage window = new Stage();
                window.setTitle("Budget - RotoSoft");
                window.setScene(scene);
                window.setResizable(true);
                window.setMinHeight(450.0);
                window.setMinWidth(700.0);
                window.show();
            ((Stage) ((Node) event.getSource()).getScene().getWindow()).close(); 
         
                }
      catch (IOException e){System.out.println(e);}
        
        }
        else{
            hbox_alert.setVisible(true);
            for (int i = 0; i < sol.size(); i++) {
                sol.get(i).setTextFill(Color.RED);
            }
        
        } 
    }

    
    public  ArrayList<CheckBox> checkSelected(){
    ArrayList<CheckBox> sol = new ArrayList<>();
    if(!check_cpu.isSelected()) sol.add(check_cpu);
    if(!check_mother.isSelected()) sol.add(check_mother);
    if(!check_ram.isSelected()) sol.add(check_ram);
    if(!check_graphic.isSelected()) sol.add(check_graphic);
    if(!check_disk.isSelected()) sol.add(check_disk);
    if(!check_case.isSelected()) sol.add(check_case);
    
    
    return sol;
    }
    
    @FXML
    private void onComponent(ActionEvent event) {
            try{  
                
                 FXMLLoader charger = new FXMLLoader(getClass().getResource("/view/AddCompScreen.fxml"));
                 Parent root = charger.load();   
                 Scene scene = new Scene(root);
                               
                                
                 AddCompScreenController passerPC = charger.<AddCompScreenController>getController();
                passerPC.storeListandPC(list);
                passerPC.storeCheckBox(check_cpu, check_mother, check_ram, check_graphic, check_disk, check_case);
                
                
                Stage window = new Stage();
                window.setTitle("Add Component - RotoSoft");
                window.setScene(scene);
                window.setResizable(true);
                window.setMinHeight(470.0);
                window.setMinWidth(735.0);
                window.show();
                
                
        
    }
      catch (IOException e){}
    }

   
  
    
    //Define the button cell
    private class ButtonCell extends TableCell<Product, Boolean> {
        final Button cellButton = new Button("");
        
        
        ButtonCell(){
          BackgroundImage backgroundImage = new BackgroundImage( new Image( getClass().getResource("/images/delete.png").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
            Background background = new Background(backgroundImage);
        	//Action when the button is pressed
            cellButton.setMinHeight(20);
            cellButton.setMinWidth(30);
            cellButton.setPrefHeight(20);
            cellButton.setPrefWidth(30);
            cellButton.setBackground(background);
            cellButton.setOnAction(new EventHandler<ActionEvent>(){
             

                @Override
                public void handle(ActionEvent t) {
                    // get Selected Item
                	Product product = (Product) ButtonCell.this.getTableView().getItems().get(ButtonCell.this.getIndex());
                	
                        list.remove(product);
                        
                        
                        switch(product.getCategory()){
                            
                            case MOTHERBOARD: {
                            counter_mother--;
                            if(counter_mother==0){    
                            check_disk.setTextFill(Color.BLACK);    
                            check_mother.setSelected(false);
                            }
                                                        
                            break;
                                 }
                        case GPU: {
                         counter_graphic--;
                            if(counter_graphic==0){  
                            check_disk.setTextFill(Color.BLACK);    
                            check_graphic.setSelected(false);
                            }
                        break;
                         }
                         case CPU: {
                       counter_cpu--;
                            if(counter_cpu==0){    
                            check_disk.setTextFill(Color.BLACK);    
                            check_cpu.setSelected(false);
                            }
                         break;
                        }
                        case HDD: {
                            counter_disk--;
                            if(counter_disk==0){   
                            check_disk.setTextFill(Color.BLACK);    
                            check_disk.setSelected(false);
                            }
                        break;
                             }
                        case CASE: {
                         counter_case--;
                            if(counter_case==0){    
                            check_disk.setTextFill(Color.BLACK);    
                            check_case.setSelected(false);
                            }
                          break;
                        }
                        case RAM: {
                            counter_ram--;
                            
                            if(counter_ram==0){   
                            check_disk.setTextFill(Color.BLACK);
                            check_ram.setSelected(false);
                            }
                        break;
                        }
                        case HDD_SSD:{
                            counter_disk--;
                            if(counter_disk==0){  
                            check_disk.setTextFill(Color.BLACK);    
                            check_disk.setSelected(false);
                            }
                          break;
                         }
        
                        }
                	
                        
                       
                }
            });
        }

        //Display button if the row is not empty
        @Override
        protected void updateItem(Boolean t, boolean empty) {
            super.updateItem(t, empty);
            if(!empty){
                setGraphic(cellButton);}
            else{setGraphic(null);}
            
        }
        
    }
    public void storePC(PC pc1){
    
     pc = pc1;
     list =  FXCollections.observableList(pc.getList());
       
    productTable.setItems(list);
    if(pc1.getName() != null){selectAfterSave(pc1);}
    
        
    }
    
    public void selectAfterSave(PC pc1){
    ArrayList<Product> products = pc1.getList();
    ObservableList<Product> list1 = null;
            ArrayList<Product> xddd = new ArrayList<>();
    for (int i = 0; i < pc1.getList().size(); i++) {
           Category cat = products.get(i).getCategory();
            
            xddd.add(products.get(i));
            
           switch(cat){
            case MOTHERBOARD: {
               check_mother.setSelected(true);
               check_mother.setTextFill(Color.GREEN);
               counter_mother++;
                break;
            }
            case GPU: {
               check_graphic.setSelected(true);
               check_graphic.setTextFill(Color.GREEN);
              counter_graphic++;
                break;
            }
            case CPU: {
               check_cpu.setSelected(true);
               check_cpu.setTextFill(Color.GREEN);
               counter_cpu++;
                break;
            }
             case HDD: {
            check_disk.setSelected(true);
            check_disk.setTextFill(Color.GREEN);
           counter_disk++;
                break;
            }
            case CASE: {
              check_case.setSelected(true);
              check_case.setTextFill(Color.GREEN);
             counter_case++;
                break;
            }
            case RAM: {
                check_ram.setSelected(true);
                check_ram.setTextFill(Color.GREEN);
                counter_ram++;
                
                break;
            }
            case HDD_SSD:{
            check_disk.setSelected(true);
            check_disk.setTextFill(Color.GREEN);
            counter_disk++;
                break;
            }
         
        }
          
           
        }
    
   
    }
           
}