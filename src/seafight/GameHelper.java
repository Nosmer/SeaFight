package seafight;

import java.io.*;
import java.util.*;

class GameHelper {
    
    private static final String alphabet = "abcdefghij";
    private int gridLength = 10;
    private int gridSize = 100;
    private int[] grid = new int[gridSize];
    private int shipCount = 0;
    
    public String getUserInput(String prompt) {
        String inputLine = null;
        System.out.println(prompt+" ");
        try{
            BufferedReader input = new BufferedReader(
                new InputStreamReader(System.in));
            inputLine = input.readLine();
            if(inputLine.length() == 0)
                return null;
        } catch(IOException e) {
            System.out.println(e);
        }
        
        return inputLine.toLowerCase();
    }

    public ArrayList<String> placeShip(int shipSize) {
        ArrayList<String> alphaCells = new ArrayList<String>();
        String[] alphacoords = new String[shipSize];
        String temp = null;
        int[] coords = new int[shipSize];
        int attempts = 0;
        boolean success = false;
        int location = 0;
        
        shipCount++;
        int increment = 1;
        if((shipCount % 2) == 1){
            increment = gridLength;
        }
        
        while(!success && attempts++ < 200){
            location = (int) (Math.random() *gridSize);
//            System.out.println("location " + location);
            
            int x = 0;
            success = true;
            while(success && x < shipSize){
                if(grid[location] == 0){
                    coords[x++] = location;
                    location += increment;
                    if(location >= gridSize){
                        success = false;
                    }
                    if(x > 0 && (location % gridLength == 0)){
                        success = false;
                    }
                } else {
//                    System.out.println("trying... "+ location);
                    success = false;
                }
            }
        }
        
        int x = 0;
        int row = 0;
        int column = 0;
//        System.out.println("\n");
        
        while(x < shipSize){
            grid[coords[x]] = 1;
            row = (int) (coords[x] / gridLength);
            column = coords[x] % gridLength;
            temp = String.valueOf(alphabet.charAt(column));
            
            alphaCells.add(temp.concat(Integer.toString(row)));
            x++;
//            System.out.println("coord" +x+ " = " +alphaCells.get(x-1));
        }
//        System.out.println("\n");
        
        return alphaCells;
    }
       
}
