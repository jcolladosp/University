
package controller;

import es.upv.inf.Database;
import es.upv.inf.Product;
import es.upv.inf.Product.Category;
import java.net.URL;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.util.List;
import javafx.animation.FadeTransition;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import model.PC;
import org.controlsfx.control.RangeSlider;

/**
 * FXML Controller class
 *
 * @author colla
 */
public class AddCompScreenController implements Initializable {

    
    @FXML
    private TableColumn<Product, Number> priceCol;
    @FXML
    private TableColumn<Product, Number> stockCol;
    @FXML
    private TextField nameField;
    @FXML
    private Button returnBut;
    @FXML
    private Button addBut;
    
    private ObservableList <Product> listComp = null;
    @FXML
    private TableView<Product> componentTable;
    @FXML
    private TextField minField;
    @FXML
    private TextField maxField;
    @FXML
    private RangeSlider range_slider;
    @FXML
    private CheckBox stockBox;
    @FXML
    private Button filterButton;
  
   
    
    private TableView<Product> creatorTable;
    
    private CheckBox check_cpu;
    
    private CheckBox check_mother;
    
    private CheckBox check_ram;
    
    public CheckBox check_graphic;
    
    private CheckBox check_disk;
    
    private CheckBox check_case;
    
    
    @FXML
    private TableColumn<Product, String> descriptionCol;
    
    public Product.Category category;
    @FXML
    private ComboBox<Category> comboBox;
    
    public PC computer;
    private boolean stock;
    private DoubleProperty minPrice, maxPrice;
    @FXML
    private HBox hbox_alert;
    @FXML
    private HBox hbox_lateral;
    @FXML
    private HBox hbox_added;
    public PC pc;
    public VBox check_vbox;
    public Scene check_scene;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        stock = false;
        
                
         //initialise transitions
        initTransitions();
        
        //create list with categories
        List<Category> enumlist = Arrays.asList(Product.Category.values());
        ObservableList<Category> observableEnum = FXCollections.observableArrayList(enumlist);
        
       
                         
        //combobox settings
        comboBox.setItems(observableEnum);
        //comboBox.setValue(observableEnum.get(0));
        
        
        descriptionCol.setCellValueFactory((e) -> new SimpleStringProperty(e.getValue().getDescription()));
        priceCol.setCellValueFactory((e)-> new SimpleDoubleProperty(e.getValue().getPrice()));
        stockCol.setCellValueFactory((e)-> new SimpleIntegerProperty(e.getValue().getStock()));
        
        //initialise the rangeslider
        setrange(0, 288);
        
        addBut.disableProperty().bind(Bindings.equal(-1,componentTable.getSelectionModel().selectedIndexProperty()));
    
         filterButton.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/images/filter.png"))));
       returnBut.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/images/modify.png"))));
       addBut.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/images/plus.png"))));         
        
    }    

    @FXML
    private void onAvailable(ActionEvent event) {
        stock = true;
        if(stock == true) stock = false;            
       
    }

    @FXML
    private void onFilter(ActionEvent event) {
       if(comboBox.getValue() == null){
        hbox_alert.setVisible(true);
        fadeIn2.playFromStart();
       
       }
       else{       
       filter();
       }
      
    }
  private void filter(){
        double maxi = range_slider.getHighValue();
        double mini = range_slider.getLowValue();
        List<Product> searchList = Database.getProductByCategoryDescriptionAndPrice(comboBox.getValue(), nameField.getText(), mini, maxi, stock);
        componentTable.setItems(FXCollections.observableList(searchList));
        setrange(searchList);
        }
    @FXML
    private void onReturn(ActionEvent event) {
        ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();
    }

    @FXML
    private void onAdd(ActionEvent event) {
        Product xd = componentTable.getSelectionModel().getSelectedItem();
      
        
        listComp.add(xd);
        
        
        if (!hbox_added.isVisible()) {
        hbox_added.setVisible(true);
        fadeIn.playFromStart();
        fadeOut.playFromStart(); }
        
         switch(xd.getCategory()){
            case MOTHERBOARD: {
               check_mother.setSelected(true);
               check_mother.setTextFill(Color.GREEN);
                CreatorController.counter_mother++;
                break;
            }
            case GPU: {
               check_graphic.setSelected(true);
               check_graphic.setTextFill(Color.GREEN);
               CreatorController.counter_graphic++;
                break;
            }
            case CPU: {
               check_cpu.setSelected(true);
               check_cpu.setTextFill(Color.GREEN);
               CreatorController.counter_cpu++;
                break;
            }
             case HDD: {
            check_disk.setSelected(true);
            check_disk.setTextFill(Color.GREEN);
            CreatorController.counter_disk++;
                break;
            }
            case CASE: {
              check_case.setSelected(true);
              check_case.setTextFill(Color.GREEN);
              CreatorController.counter_case++;
                break;
            }
            case RAM: {
                check_ram.setSelected(true);
                check_ram.setTextFill(Color.GREEN);
                CreatorController.counter_ram++;
                
                break;
            }
            case HDD_SSD:{
            check_disk.setSelected(true);
            check_disk.setTextFill(Color.GREEN);
            CreatorController.counter_disk++;
                break;
            }
        
        }
    
    }

    
    @FXML
    private void onCombo(ActionEvent event) {
            componentTable.setItems(FXCollections.observableList(Database.getProductByCategory(comboBox.getValue())));
            List<Product> xd = Database.getProductByCategory(comboBox.getValue());
            setrange(xd);
        
            hbox_alert.setVisible(false);

            
    }
    private FadeTransition fadeIn = new FadeTransition(
    Duration.millis(1500)
);
      private FadeTransition fadeIn2 = new FadeTransition(
    Duration.millis(100)
);
    private FadeTransition fadeOut = new FadeTransition(
    Duration.millis(1500)
);
    public void setrange(double min, double max){
        
        minPrice = new SimpleDoubleProperty(min);
        maxPrice = new SimpleDoubleProperty(max);
        range_slider.setMin(minPrice.get());
        range_slider.setMax(maxPrice.get());
        range_slider.lowValueProperty().bindBidirectional(minPrice);
        range_slider.highValueProperty().bindBidirectional(maxPrice);
        Bindings.bindBidirectional(minField.textProperty(), minPrice, NumberFormat.getInstance());
        Bindings.bindBidirectional(maxField.textProperty(), maxPrice, NumberFormat.getInstance());
    }
    
    public void setrange(List<Product> xd){
            double min = 999.0;
            double max = 0.0;
            for(int x = 0;x < xd.size();x++){
            double price = xd.get(x).getPrice();
            if(price<min) min = price;
            if(price>max) max = price;           
            }
        minPrice = new SimpleDoubleProperty(min);
        maxPrice = new SimpleDoubleProperty(max);
        range_slider.setMin(minPrice.get());
        range_slider.setMax(maxPrice.get());
        range_slider.lowValueProperty().bindBidirectional(minPrice);
        range_slider.highValueProperty().bindBidirectional(maxPrice);
        Bindings.bindBidirectional(minField.textProperty(), minPrice, NumberFormat.getInstance());
        Bindings.bindBidirectional(maxField.textProperty(), maxPrice, NumberFormat.getInstance());
    }
   public void initTransitions(){
   
        fadeIn.setNode(hbox_added);

        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.setCycleCount(1);
        fadeIn.setAutoReverse(false);  
        
        fadeOut.setNode(hbox_added);

        fadeOut.setFromValue(1.0);
        fadeOut.setToValue(0.0);
        fadeOut.setCycleCount(1);
        fadeOut.setAutoReverse(false); 
        
        
        fadeIn2.setNode(hbox_alert);

        fadeIn2.setFromValue(0.0);
        fadeIn2.setToValue(1.0);
        fadeIn2.setCycleCount(1);
        fadeIn2.setAutoReverse(false); 
        
        
        fadeIn.setOnFinished(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
            hbox_added.setVisible(false);
                }
                });}
   
  
   public void storeListandPC(ObservableList<Product> listComp1){
       listComp = listComp1;   
       
       
}
    public void storeCheckBox(CheckBox c1,CheckBox c2,CheckBox c3,CheckBox c4,CheckBox c5,CheckBox c6){
     check_cpu = c1; check_mother=c2;check_ram=c3;check_graphic=c4;check_disk=c5;check_case=c6;
       
}
     
   
}
