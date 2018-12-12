package seafight;

import java.util.*;

class Ships {
    private ArrayList<String> locationCells;

    public void setLoc(ArrayList<String> newLoc) {
        locationCells = newLoc;
    }

    public String checkShip(String playerMove) {
        String result = "Мимо";
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
