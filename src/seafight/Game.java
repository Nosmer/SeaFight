package seafight;

import java.util.*;

public class Game {
    private GameHelper helper = new GameHelper();
    private ArrayList<Ships> enemyShips = new ArrayList<Ships>();
    private int shotsMade = 0;
    
    private void setUpGame(){
        Ships one = new Ships(4);
        Ships two = new Ships(4);
        Ships three = new Ships(3);     
        enemyShips.add(one);
        enemyShips.add(two);
        enemyShips.add(three);
        
        System.out.println("Вы - капитан ракетного катера.");
        System.out.println("Потопите все вражеские корабли!");
        System.out.println("Постарайтесь не израсходовать весь боеприпас :D");
        
        for (Ships shipsSet : enemyShips) {
            ArrayList<String> newLoc = helper.placeShip(shipsSet.getSize());
            shipsSet.setLoc(newLoc);
        }
    }
    
    private void startGame(){
        while(!enemyShips.isEmpty()){
            String playerMove = helper.getUserInput("Пусковые установки заряжены, капитан! ");
            checkPlayerMove(playerMove);
        }
        finishGame();
    }

    private void checkPlayerMove(String playerMove) {
        shotsMade++;
        
        String result = "Мимо!";
        
        for (Ships shipsSet : enemyShips) {
            result = shipsSet.checkShip(playerMove);
            
            if(result.equals("Попал")){
                break;
            }
            if(result.equals("Потопил")){
                enemyShips.remove(shipsSet);
                break;
            }
        }
        
        System.out.println(result);
    }

    private void finishGame() {
        System.out.println("Все корабли потоплены!");
        if(shotsMade <= 30){
            System.out.println("У вас ушло "+shotsMade+" выстрелов");
            System.out.println("Поздравляю! Вы вернулись в порт не израсходовав всего боезапаса");
            System.out.println("Адмиралтейство выписало вам благодарность");
        } else {
            System.out.println("У вас ушло "+shotsMade+" выстрелов");
            System.out.println("Будь это реальный бой, вас бы уже давно потопили");
            System.out.println("Да и нету у катеров такого большого боезапаса :D");
        }
    }
    
    public static void main(String[] args) {
        Game game = new Game();
        game.setUpGame();
        game.startGame();
    }
}
