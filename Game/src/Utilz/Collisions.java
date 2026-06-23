package Utilz;

import Background.TileManager;
import Entities.Player;

public class Collisions {
    
    static TileManager tileManager;

    public static Boolean IsPositionValid(Player plr, TileManager tileManageer) {
        tileManager = tileManageer;
        
        Boolean topLeft = checkTileLocation(plr.hitbox.getX(), plr.hitbox.getY());
        Boolean topRight = checkTileLocation(plr.hitbox.getX() + plr.hitbox.getWidth(), plr.hitbox.getY());
        Boolean bottomLeft = checkTileLocation(plr.hitbox.getX(), plr.hitbox.getY() + plr.hitbox.getHeight());
        Boolean bottomRight = checkTileLocation(plr.hitbox.getX() + plr.hitbox.getWidth(), plr.hitbox.getY() + plr.hitbox.getHeight());
        
        if(topLeft || topRight || bottomLeft || bottomRight) {
            return false;
        } else {
            return true;
        }
    }

    public static int returnDirection(Player plr, TileManager tileManageer) {
        tileManager = tileManageer;
        
        Boolean topLeft = checkTileLocation(plr.hitbox.getX(), plr.hitbox.getY());
        Boolean topRight = checkTileLocation(plr.hitbox.getX() + plr.hitbox.getWidth(), plr.hitbox.getY());
        Boolean bottomLeft = checkTileLocation(plr.hitbox.getX(), plr.hitbox.getY() + plr.hitbox.getHeight());
        Boolean bottomRight = checkTileLocation(plr.hitbox.getX() + plr.hitbox.getWidth(), plr.hitbox.getY() + plr.hitbox.getHeight());
        
        if(topLeft){
            return 0;
        } else if(topRight){
            return 1;
        } else if(bottomLeft){
            return 2;
        } else {
            return 3;
        }
    }

    private static Boolean checkTileLocation(double x, double y) {
        x /= Variables.TILE_SIZE;
        y /= Variables.TILE_SIZE;


        return tileManager.checkBlockCollidable((int)x, (int)y);
    }

}
