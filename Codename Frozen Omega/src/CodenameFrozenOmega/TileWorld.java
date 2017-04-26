package CodenameFrozenOmega;
import java.awt.*;

import javax.security.auth.x500.X500Principal;
import javax.swing.ImageIcon;
import javax.swing.text.html.HTMLDocument.HTMLReader.BlockAction;

public class TileWorld {
	private Rectangle[] blocks;
	private Image[] blockImg;
	private final int arrayNum = 121;
	private Image tropic;
	private int ix, iy;
	public TileWorld(){
		tropic = new ImageIcon(this.getClass().getResource("/CodenameFrozenOmega/Images/tropical.png")).getImage();
		blocks = new Rectangle[121];
		blockImg = new Image[121];
	loadArrays();
	}
	private void loadArrays(){
		for (int i = 0; i < arrayNum; i++) {
			if (ix >= 1000){
				ix = 0;
				iy += 90;
			}
			if (i >= 0 && i < 1000) {
				blockImg[i]=tropic;
				blocks[i] = new Rectangle(ix,iy,90,90);
			}
		ix+=90;
		}
	}
	public void draw(Graphics g){
		for (int i = 0; i < arrayNum; i++) {
			g.drawImage(blockImg[i],blocks[i].x, blocks[i].y, null);
			
		}
	}
}
