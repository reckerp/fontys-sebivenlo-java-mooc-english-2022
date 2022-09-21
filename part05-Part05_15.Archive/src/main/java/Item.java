/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Paul Recker - 518962 - {@code p.recker@student.fontys.nl}
 */
public class Item {
    
        private String identifier;
        private String name;
    
        public Item(String identifier, String name) {
            this.identifier = identifier;
            this.name = name;
        }
    
        public String getIdentifier() {
            return identifier;
        }
    
        public String getName() {
            return name;
        }
    
        @Override
        public String toString() {
            return identifier + ": " + name;
        }
    
        @Override
        public boolean equals(Object compared) {
            if (this == compared) {
                return true;
            }
    
            if (!(compared instanceof Item)) {
                return false;
            }
    
            Item comparedItem = (Item) compared;
    
            if (this.identifier.equals(comparedItem.identifier)) {
                return true;
            }
    
            return false;
        }
    
    
}
