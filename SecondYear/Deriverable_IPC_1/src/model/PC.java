package model;

import es.upv.inf.Product;
import java.util.ArrayList;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement 
public class PC {
    
    private StringProperty name = new SimpleStringProperty();
    private ArrayList <Product> productList;
    
   
     
    public PC(){ 
        productList = new ArrayList<Product>();
        
    }
   
    public void addProduct(Product product){
        productList.add(product); 
    }
    
     public void removeProduct(Product product){
        productList.remove(product); 
    }
    
    public ArrayList<Product> getList(){
         return productList;
    }
    
    public void setList (ArrayList<Product> lista){
        productList = lista;
    }
    public void setName (String nombre){
        name.set(nombre);
    }
    
     public StringProperty getName (){
        return name;
    }
    
}
