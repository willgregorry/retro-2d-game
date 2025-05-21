package main;

import object.OBJ_Stone;

public class AssetSetter {

    GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }

    public void setObject() {

        gp.objects[0] = new OBJ_Stone();
        gp.objects[0] .worldX = 23 * gp.tileSize;
        gp.objects[0] .worldY = 7 * gp.tileSize;

        gp.objects[1] = new OBJ_Stone();
        gp.objects[1] .worldX = 23 * gp.tileSize;
        gp.objects[1] .worldY = 20* gp.tileSize;

    }

}
