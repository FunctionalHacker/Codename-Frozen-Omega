package CodenameFrozenOmega;
import java.awt.*;
import java.awt.image.BufferedImage;

import javax.security.auth.x500.X500Principal;
import javax.swing.ImageIcon;
import javax.swing.text.html.HTMLDocument.HTMLReader.BlockAction;

public class TileWorld {
	private Rectangle[] blocks;
	private Image[] blockImg;
	private final int arrayNum = 120;
	private BufferedImage tropic;
	private int ix, iy;
	public TileWorld(){
		//Creating the images
		tropic = new BufferedImage(90, 90, BufferedImage.TYPE_INT_RGB);
		int rgb=new Color(0,255,255).getRGB();
		for(int width=0; width < tropic.getWidth(); width++)
		{
		    for(int height=0; height < tropic.getHeight(); height++)
		    {
		          Color temp = new Color(0, 255, 255);
		          tropic.setRGB(width, height, temp.getRGB());
		    }
		}
		blocks = new Rectangle[120];
		blockImg = new Image[120];
	loadArrays();
	//Loading the arrays
	}
	private void loadArrays(){
		for (int i = 0; i < arrayNum; i++) {
			if (ix >= 1000){
				ix = 0;
				iy += 90;
			}
			if (i >= 0 && i < 500) {
				blockImg[i]=tropic;
				blocks[i] = new Rectangle(ix,iy,90,90);
			}
		ix+=90;
		}
	}
	//Drawing the tilemap
	public void draw(Graphics g){
		for (int i = 0; i < arrayNum; i++) {
			g.drawImage(blockImg[i],blocks[i].x, blocks[i].y, null);
			
		}
	}
}
