/**
 * 
 */
package controller;
import java.io.*;
import model.WoodItem;
import java.util.*;
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
        if(args.length != 1){
            System.out.println("Input file is not given");
            return;
        }
        HardwoodSeller hs = new HardwoodSeller();
        
        hs.readInputFile(args[0]);
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
		
        try{
            BufferedReader br = new BufferedReader(new FileReader(inputFilePath));
            String oneline;
            System.out.println("------------------------------------------------------");
            while((oneline = br.readLine())!= null){
                String[] buyerInfo = oneline.split(";");
                System.out.println("Buyer Name: " + buyerInfo[0]);
                System.out.println("Address: " + buyerInfo[1]);
                System.out.println("Date: " + buyerInfo[2]);
                oneline = br.readLine();
                String[] woodInfo = oneline.split(";");
                Double totalPrice = 0.0;
                Double maxDtime = 0.0;
                System.out.format("%15s %10s %10s %10s\n", "TYPE", "PRICE", "BORD FOOT", "TOTAL");
                for(int i = 0; i < woodInfo.length; i++){
                    String[] item = woodInfo[i].split(":");
                    
                    Double subTotal= Double.parseDouble(item[1]) * hm.get(item[0]).getPrice();
                    totalPrice += subTotal;
                    Double dTime = deliveryTime(Integer.parseInt(item[1]), hm.get(item[0]).getDaseDeliveryTime());
                    if(dTime > maxDtime){
                        maxDtime = dTime;
                    }
                    
                    System.out.format("%15s %10.2f %10.2f %10.2f\n", item[0], hm.get(item[0]).getPrice(), Double.parseDouble(item[1]), subTotal);
                }
                System.out.format("%48.2f\n", totalPrice);
                System.out.println("Estimated Delivery Time " + maxDtime + " Hours");
                
                
               System.out.println("------------------------------------------------------");
            }
        }
        catch(IOException e){
            System.out.println("I/O error: "+ e);
        }
        
        
        
	}
	
	public Double deliveryTime(int BF, Double bdTime){
        Double para = 0.0;
        if(BF < 1 || BF > 1000){
            System.out.println("BF is out of range");
        }
        else if (BF > 500){
            para = 5.5;
        }
        else if(BF % 100 == 0){
            para = (double)BF/100;
        }
        else {
            para = (double)(BF/100 +1);
        }
        return para * bdTime;
	}
    
    
	
}
