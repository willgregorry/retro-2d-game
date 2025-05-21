package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Stone extends SuperObject {

    public OBJ_Stone() {
        name = "Stone";
        collisionOn = true;
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/stones.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
