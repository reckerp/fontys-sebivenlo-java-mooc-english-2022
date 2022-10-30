/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Paul Recker - 518962 - {@code p.recker@student.fontys.nl}
 */
public class ProductWarehouseWithHistory extends ProductWarehouse{
    
    private final ChangeHistory history;
    
    public ProductWarehouseWithHistory(String productName, double capacity, double initialBalance){
        super(productName, capacity);
        history = new ChangeHistory();
        addToWarehouse(initialBalance);
    }
    
    public String history(){
        return history.toString();
    }
    
    
    @Override
    public final void addToWarehouse(double amount) {
        super.addToWarehouse(amount);
        history.add(super.getBalance());
    }
    
    /**
     *
     * @param amount
     * @return
     */
    @Override
    public double takeFromWarehouse(double amount) {
        
        if ( getBalance() < amount ) {
                history.add(getBalance());
                return getBalance();
        }
        super.takeFromWarehouse(amount);
        history.add(getBalance());

        return getBalance();
    }

	public void printAnalysis() {
            System.out.println("Product: " + getName());
            System.out.println("History: " + history());
            System.out.println("Largest amount of product: " + history.maxValue());
            System.out.println("Smallest amount of product: " + history.minValue());
            System.out.println("Average: " + history.average());
	}
}
