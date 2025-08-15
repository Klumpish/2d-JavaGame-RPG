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
    Tile[] tile;
    int[][] mapTileNum;

    public TileManager(GamePanel gp) {
        this.gp = gp;

        tile = new Tile[10];
        mapTileNum = new int[gp.maxScreenCol][gp.maxScreenRow];
        getTileImage();
        loadMap("/Maps/map01.txt");
    }

    public void getTileImage() {
        try {
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(
              getClass().getResourceAsStream("/Tiles/Old_version/grass.png"));
            tile[1] = new Tile();
            tile[1].image = ImageIO.read(
              getClass().getResourceAsStream("/Tiles/Old_version/wall.png"));
            tile[2] = new Tile();
            tile[2].image = ImageIO.read(
              getClass().getResourceAsStream("/Tiles/Old_version/water.png"));
            tile[3] = new Tile();
            tile[3].image = ImageIO.read(
              getClass().getResourceAsStream("/Tiles/Old_version/earth.png"));
            tile[4] = new Tile();
            tile[4].image = ImageIO.read(
              getClass().getResourceAsStream("/Tiles/Old_version/tree.png"));
            tile[5] = new Tile();
            tile[5].image = ImageIO.read(
              getClass().getResourceAsStream("/Tiles/Old_version/sand.png"));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadMap(String filePath) {
        try {
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            //loops through the map grid
            while (col < gp.maxScreenCol && row < gp.maxScreenRow) {
                //reading one line of the map file
                String line = br.readLine();

                //loops each column of the current line to get the tile numbers
                while (col < gp.maxScreenCol) {

                    String numbers[] = line.split(" ");

                    //changing from string to number
                    int num = Integer.parseInt(numbers[col]);
                    //stores tile number in the map array
                    mapTileNum[col][row] = num;
                    //moves to next col in current row
                    col++;
                }
                if (col == gp.maxScreenCol) {
                    col = 0;
                    row++;
                }
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void draw(Graphics2D g2) {
        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;

        while (col < gp.maxScreenCol && row < gp.maxScreenRow) {
            int tileNum = mapTileNum[col][row];

            g2.drawImage(tile[tileNum].image, x, y, gp.tileSize, gp.tileSize,
              null);
            col++;
            x += gp.tileSize;
            if (col >= gp.maxScreenCol) {
                col = 0;
                x = 0;
                row++;
                y += gp.tileSize;
            }
        }
    }

}
