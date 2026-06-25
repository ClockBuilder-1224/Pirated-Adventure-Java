package Utilz;

import Background.TileManager;
import Entities.Player;

public class Collisions {
    
    static TileManager tileManager;

    public static Boolean IsPositionValid(Player plr, TileManager tileManageer) {
        tileManager = tileManageer;
        
        Boolean TOP = checkTileLocation(plr.hitbox.getX(), plr.hitbox.getY(), plr.hitbox.getX() + plr.hitbox.getWidth(), plr.hitbox.getY());
        Boolean Bottom = checkTileLocation(plr.hitbox.getX(), plr.hitbox.getY() + plr.hitbox.getHeight(), plr.hitbox.getX() + plr.hitbox.getWidth(), plr.hitbox.getY() + plr.hitbox.getHeight());
        Boolean Left = checkTileLocation(plr.hitbox.getX(), plr.hitbox.getY(), plr.hitbox.getX(), plr.hitbox.getY() + plr.hitbox.getHeight());
        Boolean Right = checkTileLocation(plr.hitbox.getX() + plr.hitbox.getWidth(), plr.hitbox.getY(), plr.hitbox.getX() + plr.hitbox.getWidth(), plr.hitbox.getY() + plr.hitbox.getHeight());

        if(TOP || Bottom || Left || Right) {
            return false;
        } else {
            return true;
        }
        
    }

    public static int returnDirection(Player plr, TileManager tileManageer) {
        tileManager = tileManageer;
        
        Boolean TOP = checkTileLocation(plr.hitbox.getX(), plr.hitbox.getY(), plr.hitbox.getX() + plr.hitbox.getWidth(), plr.hitbox.getY());
        Boolean Bottom = checkTileLocation(plr.hitbox.getX(), plr.hitbox.getY() + plr.hitbox.getHeight(), plr.hitbox.getX() + plr.hitbox.getWidth(), plr.hitbox.getY() + plr.hitbox.getHeight());
        Boolean Left = checkTileLocation(plr.hitbox.getX(), plr.hitbox.getY(), plr.hitbox.getX(), plr.hitbox.getY() + plr.hitbox.getHeight());
        Boolean Right = checkTileLocation(plr.hitbox.getX() + plr.hitbox.getWidth(), plr.hitbox.getY(), plr.hitbox.getX() + plr.hitbox.getWidth(), plr.hitbox.getY() + plr.hitbox.getHeight());

        if(TOP) {
            return 0;
        } else if(Bottom) {
            return 1;
        }  else if(Left) {
            return 2;
        }  else if(Right) {
            return 3;
        } else {
            return 5;
        }
        
    }

    private static Boolean checkTileLocation(double x, double y, double x2, double y2) {
        
        double centerX = 0;
        double centerY = 0;

        if(y == y2) {
            centerX = (x + x2)/2;
            centerY = y;
        } else if(x == x2) {
            centerX = x;
            centerY = (y + y2)/2;
        }

        centerX /= Variables.TILE_SIZE;
        centerY /= Variables.TILE_SIZE;

        return tileManager.checkBlockCollidable((int)centerX, (int)centerY);
    }

}
