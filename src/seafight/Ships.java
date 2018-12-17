package seafight;

import java.util.*;

class Ships {
    private ArrayList<String> locationCells;
    private final int size;
    
    Ships(int size){
        this.size = size;
    }

    public int getSize() {
        return size;
    }

//принимает в себя значение адреса из метода placeShip() из GameHelper
    public void setLoc(ArrayList<String> newLoc) {
        locationCells = newLoc;
    }

    public String checkShip(String playerMove) {
        String result = "Мимо";
        
//Если playerMove совпадает с одним из элементов ArrayList,
//то indexOf() вернет его местоположение, 
//если не совпадает, то вернет -1
        int index = locationCells.indexOf(playerMove);
        if(index >= 0){
            locationCells.remove(index);
            
            if(locationCells.isEmpty()){
                result = "Потопил";
                System.out.println("Корабль потоплен!");
            } else {
                result = "Попал";
            }
        }
                
        return result;   
    }
    
}
