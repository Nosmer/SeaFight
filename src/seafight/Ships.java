package seafight;

import java.util.*;

class Ships {
    private ArrayList<String> locationCells;
    private final int size;
    
    Ships(int size){
        this.size = size;
    }
    
//принимает в себя значение адреса из метода placeShip() из GameHelper
    public void setLoc(ArrayList<String> newLoc) {
        locationCells = newLoc;
    }

    public int getSize() {
        return size;
    }

//Обязательно переопределяем equals(), hashCode() и toString() !!!
    @Override
    public boolean equals(Object otherObject){
        if(this == otherObject) return true;
        if(otherObject == null) return false;
        if(getClass() != otherObject.getClass()) return false;
        Ships other = (Ships) otherObject;
        return size == other.size
            && locationCells.equals(other.locationCells);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.locationCells);
        hash = 37 * hash + this.size;
        return hash;
    }
    
    @Override
    public String toString(){
        return getClass().getName()
            + "[locationCells= " + locationCells
            + ", size= " + size
            + "]";
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
