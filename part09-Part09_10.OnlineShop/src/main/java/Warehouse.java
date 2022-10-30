
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Paul Recker - 518962 - {@code p.recker@student.fontys.nl}
 */
public class Warehouse {
    private Map<String, Integer> inventoryPrice;
    private Map<String, Integer> inventoryStock;
    
    public Warehouse(){
        inventoryPrice = new HashMap<>();
        inventoryStock = new HashMap<>();
    }
    
    public void addProduct(String product, int price, int stock){
        inventoryPrice.put(product, price);
        inventoryStock.put(product, stock);
    }
    
    public int price(String product){
        if (inventoryPrice.containsKey(product)) {
			return inventoryPrice.get(product);
		}
        return -99;
    }

    public int stock(String product){
        if (inventoryStock.containsKey(product)) {
            return inventoryStock.get(product);
        }
        return 0;
    }

    public boolean take(String product){
        if (inventoryStock.containsKey(product)) {
            if (inventoryStock.get(product) > 0) {
                inventoryStock.put(product, inventoryStock.get(product) - 1);
                return true;
            }
        }
        return false;
    }   

    public Set<String> products(){
        return inventoryPrice.keySet();
    }

        
}

