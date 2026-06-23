package Utilz;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GameFiles {

    public static BufferedImage PLAYER_SPRITE;
    public static BufferedImage TERRAIN;
    public static BufferedImage LEVEL_TEST;
    public static BufferedImage Background;

    public GameFiles() {
         try {
            // General

            PLAYER_SPRITE = ImageIO.read(new File("Game/res/player/PlayerSpriteSheet.png"));
            TERRAIN = ImageIO.read(new File("Game/res/PalmTreeIsland/Terrain_Sprites.png"));
            // Levels

            LEVEL_TEST = ImageIO.read(new File("Game/res/Levels/Test.png"));
            
            // Decoration

            Background = ImageIO.read(new File("Game/res/PalmTreeIsland/BG Image.png"));

         } catch (IOException e) {
            e.printStackTrace();
         }
    }

}
