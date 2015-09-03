/**
 * 
 */
package controller;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import model.WoodItem;
import java.util.HashMap;
/**
 * @author Esteban
 *
 */
public class HardwoodSeller {

	/**
	 * @param args
	 */
    HashMap<String, WoodItem> hm;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        HardwoodSeller hs = new HardwoodSeller();
	}
	
    public HardwoodSeller(){
        hm = new HashMap<>();
        hm.put("Cherry", new WoodItem("Cherry", 2.5, 5.95));
        hm.put("Curly Maple", new WoodItem("Curly Maple", 1.5, 6.0));
        hm.put("Genuine Mahogany", new WoodItem("Genuine Mahogany", 3.0, 9.6));
        hm.put("Wenge", new WoodItem("Wenge", 5.0, 22.35));
        hm.put("White Oak", new WoodItem("White Oak", 2.3, 6.7));
        hm.put("Sawdust", new WoodItem("Sawdust", 1.0, 1.5));
    }
    
	public void readInputFile(String inputFilePath){
		
        
        
        
        
	}
	
	public Double deliveryTime(){
		Double deliveryETA = 0.0;
		return deliveryETA;
	}
	
}
