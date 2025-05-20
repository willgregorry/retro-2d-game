package tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {

    GamePanel gp;
    public Tile[] tile;

    public int[][] mapTileNumber;

    public TileManager(GamePanel gp) {
        this.gp = gp;
        tile = new Tile[100];
        mapTileNumber = new int[gp.maxWorldCol][gp.maxWorldRow];
        getTileImage();
        drawMap("/maps/map01.txt");
    }

    public void drawMap(String mapPath) {
        try {

            InputStream is = getClass().getResourceAsStream(mapPath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while (col < gp.maxWorldCol && row < gp.maxWorldRow) {
                String line = br.readLine();
                while (col < gp.maxWorldCol) {
                    String[] numbers = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);
                    mapTileNumber[col][row] = num;
                    col++;
                }
                if (col == gp.maxWorldCol) {
                    col = 0;
                    row++;
                }
            }

            br.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void draw(Graphics2D g2) {
        int worldCol = 0;
        int worldRow = 0;

        while (worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {
            int tileNum = mapTileNumber[worldCol][worldRow];

            int worldX = worldCol * gp.tileSize;
            int worldY = worldRow * gp.tileSize;
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;

            if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
                worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
                worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
                worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {
                g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
            }

            worldCol++;
            if (worldCol == gp.maxWorldCol) {
                worldCol = 0;
                worldRow++;
            }
        }

    }

    public void getTileImage() {
        try {
            // Grass dirt left top
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass_dirt/grass_dirt_left_top.png"));
            tile[0].collision = false;

            // Grass dirt top
            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass_dirt/grass_dirt_top.png"));
            tile[1].collision = false;

            // Grass dirt right top
            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass_dirt/grass_dirt_right_top.png"));
            tile[2].collision = false;

            // Grass dirt left
            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass_dirt/grass_dirt_left.png"));
            tile[3].collision = false;

            // Grass
            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass_dirt/grass.png"));
            tile[4].collision = false;

            // Grass dirt right
            tile[5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass_dirt/grass_dirt_right.png"));
            tile[5].collision = false;

            // Grass dirt left bottom
            tile[6] = new Tile();
            tile[6].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass_dirt/grass_dirt_left_bottom.png"));
            tile[6].collision = false;

            // Grass dirt bottom
            tile[7] = new Tile();
            tile[7].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass_dirt/grass_dirt_bottom.png"));
            tile[7].collision = false;

            // Grass dirt right bottom
            tile[8] = new Tile();
            tile[8].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass_dirt/grass_dirt_right_bottom.png"));
            tile[8].collision = false;

            // Grass decoration 1
            tile[9] = new Tile();
            tile[9].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass_dirt/grass_decoration1.png"));
            tile[9].collision = false;

            // Grass decoration 2
            tile[10] = new Tile();
            tile[10].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass_dirt/grass_decoration2.png"));
            tile[10].collision = false;

            // Dirt grass left top
            tile[11] = new Tile();
            tile[11].image = ImageIO.read(getClass().getResourceAsStream("/tiles/dirt_grass/dirt_grass_left_top.png"));
            tile[11].collision = false;

            // Dirt grass top
            tile[12] = new Tile();
            tile[12].image = ImageIO.read(getClass().getResourceAsStream("/tiles/dirt_grass/dirt_grass_top.png"));
            tile[12].collision = false;

            // Dirt grass right top
            tile[13] = new Tile();
            tile[13].image = ImageIO.read(getClass().getResourceAsStream("/tiles/dirt_grass/dirt_grass_right_top.png"));
            tile[13].collision = false;

            // Dirt grass left
            tile[14] = new Tile();
            tile[14].image = ImageIO.read(getClass().getResourceAsStream("/tiles/dirt_grass/dirt_grass_left.png"));
            tile[14].collision = false;

            // Dirt
            tile[15] = new Tile();
            tile[15].image = ImageIO.read(getClass().getResourceAsStream("/tiles/dirt_grass/dirt.png"));
            tile[15].collision = true;

            // Dirt grass right
            tile[16] = new Tile();
            tile[16].image = ImageIO.read(getClass().getResourceAsStream("/tiles/dirt_grass/dirt_grass_right.png"));
            tile[16].collision = false;

            // Dirt grass left bottom
            tile[17] = new Tile();
            tile[17].image = ImageIO.read(getClass().getResourceAsStream("/tiles/dirt_grass/dirt_grass_left_bottom.png"));
            tile[17].collision = false;

            // Dirt grass bottom
            tile[18] = new Tile();
            tile[18].image = ImageIO.read(getClass().getResourceAsStream("/tiles/dirt_grass/dirt_grass_bottom.png"));
            tile[18].collision = false;

            // Dirt grass right bottom
            tile[19] = new Tile();
            tile[19].image = ImageIO.read(getClass().getResourceAsStream("/tiles/dirt_grass/dirt_grass_right_bottom.png"));
            tile[19].collision = false;

            // Dirt decoration 1
            tile[20] = new Tile();
            tile[20].image = ImageIO.read(getClass().getResourceAsStream("/tiles/dirt_grass/dirt_decoration1.png"));
            tile[20].collision = false;

            // Dirt decoration 2
            tile[21] = new Tile();
            tile[21].image = ImageIO.read(getClass().getResourceAsStream("/tiles/dirt_grass/dirt_decoration2.png"));
            tile[21].collision = false;

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
