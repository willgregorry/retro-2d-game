package tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;

public class TileManager {

    GamePanel gp;
    public Tile[] tile;

    public int[][] mapTileNumber;

    public TileManager(GamePanel gp) {
        this.gp = gp;
        tile = new Tile[100];
        mapTileNumber = new int[gp.maxWorldCol][gp.maxWorldRow];
        getTileImage();
        drawMap("/maps/world01.txt");
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
            tile[0].collision = true;

            // Grass dirt top
            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass_dirt/grass_dirt_top.png"));
            tile[1].collision = true;

            // Grass dirt right top
            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass_dirt/grass_dirt_right_top.png"));
            tile[2].collision = true;

            // Grass dirt left
            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass_dirt/grass_dirt_left.png"));
            tile[3].collision = true;

            // Grass
            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass_dirt/grass.png"));
            tile[4].collision = false;

            // Grass dirt right
            tile[5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass_dirt/grass_dirt_right.png"));
            tile[5].collision = true;

            // Grass dirt left bottom
            tile[6] = new Tile();
            tile[6].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass_dirt/grass_dirt_left_bottom.png"));
            tile[6].collision = true;

            // Grass dirt bottom
            tile[7] = new Tile();
            tile[7].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass_dirt/grass_dirt_bottom.png"));
            tile[7].collision = true;

            // Grass dirt right bottom
            tile[8] = new Tile();
            tile[8].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass_dirt/grass_dirt_right_bottom.png"));
            tile[8].collision = true;

            // Grass dirt top left corner
            tile[9] = new Tile();
            tile[9].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass_dirt/grass_dirt_left_top_corner.png"));
            tile[9].collision = true;

            // Grass dirt top right corner
            tile[10] = new Tile();
            tile[10].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass_dirt/grass_dirt_right_top_corner.png"));
            tile[10].collision = true;

            // Grass dirt bottom left corner
            tile[11] = new Tile();
            tile[11].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass_dirt/grass_dirt_left_bottom_corner.png"));
            tile[11].collision = true;

            // Grass dirt bottom right corner
            tile[12] = new Tile();
            tile[12].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass_dirt/grass_dirt_right_bottom_corner.png"));
            tile[12].collision = true;

            // Grass decoration 1
            tile[13] = new Tile();
            tile[13].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass_dirt/grass_dirt_decoration1.png"));
            tile[13].collision = false;

            // Grass decoration 2
            tile[14] = new Tile();
            tile[14].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass_dirt/grass_dirt_decoration2.png"));
            tile[14].collision = false;

            // Sand water left top
            tile[15] = new Tile();
            tile[15].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sand_water/sand_water_left_top.png"));
            tile[15].collision = true;

            // Sand water top
            tile[16] = new Tile();
            tile[16].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sand_water/sand_water_top.png"));
            tile[16].collision = true;

            // Sand water right top
            tile[17] = new Tile();
            tile[17].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sand_water/sand_water_right_top.png"));
            tile[17].collision = true;

            // Sand water left
            tile[18] = new Tile();
            tile[18].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sand_water/sand_water_left.png"));
            tile[18].collision = true;

            // Sand
            tile[19] = new Tile();
            tile[19].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sand_water/sand.png"));
            tile[19].collision = false;

            // Sand water right
            tile[20] = new Tile();
            tile[20].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sand_water/sand_water_right.png"));
            tile[20].collision = true;

            // Sand water left bottom
            tile[21] = new Tile();
            tile[21].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sand_water/sand_water_left_bottom.png"));
            tile[21].collision = true;

            // Sand water bottom
            tile[22] = new Tile();
            tile[22].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sand_water/sand_water_bottom.png"));
            tile[22].collision = true;

            // Sand water right bottom
            tile[23] = new Tile();
            tile[23].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sand_water/sand_water_right_bottom.png"));
            tile[23].collision = true;

            // Sand water top left corner
            tile[24] = new Tile();
            tile[24].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sand_water/sand_water_left_top_corner.png"));
            tile[24].collision = true;

            // Sand water top right corner
            tile[25] = new Tile();
            tile[25].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sand_water/sand_water_right_top_corner.png"));
            tile[25].collision = true;

            // Sand water bottom left corner
            tile[26] = new Tile();
            tile[26].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sand_water/sand_water_left_bottom_corner.png"));
            tile[26].collision = true;

            // Sand water bottom right corner
            tile[27] = new Tile();
            tile[27].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sand_water/sand_water_right_bottom_corner.png"));
            tile[27].collision = true;

            // Dirt sand left top
            tile[28] = new Tile();
            tile[28].image = ImageIO.read(getClass().getResourceAsStream("/tiles/dirt_sand/dirt_sand_left_top.png"));
            tile[28].collision = false;

            // Dirt sand top
            tile[29] = new Tile();
            tile[29].image = ImageIO.read(getClass().getResourceAsStream("/tiles/dirt_sand/dirt_sand_top.png"));
            tile[29].collision = false;

            // Dirt sand right top
            tile[30] = new Tile();
            tile[30].image = ImageIO.read(getClass().getResourceAsStream("/tiles/dirt_sand/dirt_sand_right_top.png"));
            tile[30].collision = false;

            // Dirt sand left
            tile[31] = new Tile();
            tile[31].image = ImageIO.read(getClass().getResourceAsStream("/tiles/dirt_sand/dirt_sand_left.png"));
            tile[31].collision = false;

            // Dirt
            tile[32] = new Tile();
            tile[32].image = ImageIO.read(getClass().getResourceAsStream("/tiles/dirt_sand/dirt.png"));
            tile[32].collision = false;

            // Dirt sand right
            tile[33] = new Tile();
            tile[33].image = ImageIO.read(getClass().getResourceAsStream("/tiles/dirt_sand/dirt_sand_right.png"));
            tile[33].collision = false;

            // Dirt sand left bottom
            tile[34] = new Tile();
            tile[34].image = ImageIO.read(getClass().getResourceAsStream("/tiles/dirt_sand/dirt_sand_left_bottom.png"));
            tile[34].collision = false;

            // Dirt sand bottom
            tile[35] = new Tile();
            tile[35].image = ImageIO.read(getClass().getResourceAsStream("/tiles/dirt_sand/dirt_sand_bottom.png"));
            tile[35].collision = false;

            // Dirt sand right bottom
            tile[36] = new Tile();
            tile[36].image = ImageIO.read(getClass().getResourceAsStream("/tiles/dirt_sand/dirt_sand_right_bottom.png"));
            tile[36].collision = false;

            // Water Grass left top
            tile[37] = new Tile();
            tile[37].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water_grass/water_grass_left_top.png"));
            tile[37].collision = false;

            // Water Grass top
            tile[38] = new Tile();
            tile[38].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water_grass/water_grass_top.png"));
            tile[38].collision = false;

            // Water Grass right top
            tile[39] = new Tile();
            tile[39].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water_grass/water_grass_right_top.png"));
            tile[39].collision = false;

            // Water Grass left
            tile[40] = new Tile();
            tile[40].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water_grass/water_grass_left.png"));
            tile[40].collision = false;

            // Water
            tile[41] = new Tile();
            tile[41].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water_grass/water.png"));
            tile[41].collision = true;

            // Water Grass right
            tile[42] = new Tile();
            tile[42].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water_grass/water_grass_right.png"));
            tile[42].collision = false;

            // Water Grass left bottom
            tile[43] = new Tile();
            tile[43].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water_grass/water_grass_left_bottom.png"));
            tile[43].collision = false;

            // Water Grass bottom
            tile[44] = new Tile();
            tile[44].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water_grass/water_grass_bottom.png"));
            tile[44].collision = false;

            // Water Grass right bottom
            tile[45] = new Tile();
            tile[45].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water_grass/water_grass_right_bottom.png"));
            tile[45].collision = false;

            // Water Grass left top corner
            tile[46] = new Tile();
            tile[46].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water_grass/water_grass_left_top_corner.png"));
            tile[46].collision = false;

            // Water Grass right top corner
            tile[47] = new Tile();
            tile[47].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water_grass/water_grass_right_top_corner.png"));
            tile[47].collision = false;

            // Water Grass left bottom corner
            tile[48] = new Tile();
            tile[48].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water_grass/water_grass_left_bottom_corner.png"));
            tile[48].collision = false;

            // Water Grass right bottom corner
            tile[49] = new Tile();
            tile[49].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water_grass/water_grass_right_bottom_corner.png"));
            tile[49].collision = false;

            // Water decoration 1
            tile[50] = new Tile();
            tile[50].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water_grass/water_decoration1.png"));
            tile[50].collision = false;

            // Pinky grass left top
            tile[51] = new Tile();
            tile[51].image = ImageIO.read(getClass().getResourceAsStream("/tiles/pinky_grass/pinky_grass_left_top.png"));
            tile[51].collision = false;

            // Pinky grass top
            tile[52] = new Tile();
            tile[52].image = ImageIO.read(getClass().getResourceAsStream("/tiles/pinky_grass/pinky_grass_top.png"));
            tile[52].collision = false;

            // Pinky grass right top
            tile[53] = new Tile();
            tile[53].image = ImageIO.read(getClass().getResourceAsStream("/tiles/pinky_grass/pinky_grass_right_top.png"));
            tile[53].collision = false;

            // Pinky grass left
            tile[54] = new Tile();
            tile[54].image = ImageIO.read(getClass().getResourceAsStream("/tiles/pinky_grass/pinky_grass_left.png"));
            tile[54].collision = false;

            // Pinky
            tile[55] = new Tile();
            tile[55].image = ImageIO.read(getClass().getResourceAsStream("/tiles/pinky_grass/pinky.png"));
            tile[55].collision = false;

            // Pinky grass right
            tile[56] = new Tile();
            tile[56].image = ImageIO.read(getClass().getResourceAsStream("/tiles/pinky_grass/pinky_grass_right.png"));
            tile[56].collision = false;

            // Pinky grass left bottom
            tile[57] = new Tile();
            tile[57].image = ImageIO.read(getClass().getResourceAsStream("/tiles/pinky_grass/pinky_grass_left_bottom.png"));
            tile[57].collision = false;

            // Pinky grass bottom
            tile[58] = new Tile();
            tile[58].image = ImageIO.read(getClass().getResourceAsStream("/tiles/pinky_grass/pinky_grass_bottom.png"));
            tile[58].collision = false;

            // Pinky grass right bottom
            tile[59] = new Tile();
            tile[59].image = ImageIO.read(getClass().getResourceAsStream("/tiles/pinky_grass/pinky_grass_right_bottom.png"));
            tile[59].collision = false;

            // Pinky grass left top corner
            tile[60] = new Tile();
            tile[60].image = ImageIO.read(getClass().getResourceAsStream("/tiles/pinky_grass/pinky_grass_left_top_corner.png"));
            tile[60].collision = false;

            // Pinky grass right top corner
            tile[61] = new Tile();
            tile[61].image = ImageIO.read(getClass().getResourceAsStream("/tiles/pinky_grass/pinky_grass_right_top_corner.png"));
            tile[61].collision = false;

            // Pinky grass left bottom corner
            tile[62] = new Tile();
            tile[62].image = ImageIO.read(getClass().getResourceAsStream("/tiles/pinky_grass/pinky_grass_left_bottom_corner.png"));
            tile[62].collision = false;

            // Pinky grass right bottom corner
            tile[63] = new Tile();
            tile[63].image = ImageIO.read(getClass().getResourceAsStream("/tiles/pinky_grass/pinky_grass_right_bottom_corner.png"));
            tile[63].collision = false;

            // Pacul
            tile[64] = new Tile();
            tile[64].image = ImageIO.read(getClass().getResourceAsStream("/tiles/pinky_grass/pacul.png"));
            tile[64].collision = false;

            // Dirt Grass left top
            tile[65] = new Tile();
            tile[65].image = ImageIO.read(getClass().getResourceAsStream("/tiles/dirt_grass/dirt_grass_left_top.png"));
            tile[65].collision = false;

            // Dirt Grass top
            tile[66] = new Tile();
            tile[66].image = ImageIO.read(getClass().getResourceAsStream("/tiles/dirt_grass/dirt_grass_top.png"));
            tile[66].collision = false;

            // Dirt Grass right top
            tile[67] = new Tile();
            tile[67].image = ImageIO.read(getClass().getResourceAsStream("/tiles/dirt_grass/dirt_grass_right_top.png"));
            tile[67].collision = false;

            // Dirt Grass left
            tile[68] = new Tile();
            tile[68].image = ImageIO.read(getClass().getResourceAsStream("/tiles/dirt_grass/dirt_grass_left.png"));
            tile[68].collision = false;

            // Dirt
            tile[69] = new Tile();
            tile[69].image = ImageIO.read(getClass().getResourceAsStream("/tiles/dirt_grass/dirt.png"));
            tile[69].collision = false;

            // Dirt Grass right
            tile[70] = new Tile();
            tile[70].image = ImageIO.read(getClass().getResourceAsStream("/tiles/dirt_grass/dirt_grass_right.png"));
            tile[70].collision = false;

            // Dirt Grass left bottom
            tile[71] = new Tile();
            tile[71].image = ImageIO.read(getClass().getResourceAsStream("/tiles/dirt_grass/dirt_grass_left_bottom.png"));
            tile[71].collision = false;

            // Dirt Grass bottom
            tile[72] = new Tile();
            tile[72].image = ImageIO.read(getClass().getResourceAsStream("/tiles/dirt_grass/dirt_grass_bottom.png"));
            tile[72].collision = false;

            // Dirt Grass right bottom
            tile[73] = new Tile();
            tile[73].image = ImageIO.read(getClass().getResourceAsStream("/tiles/dirt_grass/dirt_grass_right_bottom.png"));
            tile[73].collision = false;

            // Dirt Grass left top corner
            tile[74] = new Tile();
            tile[74].image = ImageIO.read(getClass().getResourceAsStream("/tiles/dirt_grass/dirt_grass_left_top_corner.png"));
            tile[74].collision = false;

            // Dirt Grass right top corner
            tile[75] = new Tile();
            tile[75].image = ImageIO.read(getClass().getResourceAsStream("/tiles/dirt_grass/dirt_grass_right_top_corner.png"));
            tile[75].collision = false;

            // Dirt Grass left bottom corner
            tile[76] = new Tile();
            tile[76].image = ImageIO.read(getClass().getResourceAsStream("/tiles/dirt_grass/dirt_grass_left_bottom_corner.png"));
            tile[76].collision = false;

            // Dirt Grass right bottom corner
            tile[77] = new Tile();
            tile[77].image = ImageIO.read(getClass().getResourceAsStream("/tiles/dirt_grass/dirt_grass_right_bottom_corner.png"));
            tile[77].collision = false;

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
