package CodenameFrozenOmega;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.nio.channels.SelectionKey;
import javax.swing.ImageIcon;
public class TileWorld {
	private Rectangle[] blocks;
	private Image[] blockImg;
	private final int arrayNum = 120;
	private BufferedImage tropic, selection;
	private int ix, iy;
	static final int PAN_UP=0,PAN_DOWN=1,PAN_LEFT=2,PAN_RIGHT=3;
	private int x,y,xDirection,yDirection;
	public TileWorld(){
		//Creating the images
		tropic = new BufferedImage(90, 90, BufferedImage.TYPE_INT_RGB);
		selection = new BufferedImage(90, 90, BufferedImage.TYPE_INT_RGB);
		//Coloring the images
		
		//selection
		for(int width=0; width < selection.getWidth(); width++)
		{
		    for(int height=0; height < selection.getHeight(); height++)
		    {
		          Color temp1 = new Color(255, 0, 0);
		          selection.setRGB(width, height, temp1.getRGB());
		    }
		}
		//tropic
		for(int width=0; width < tropic.getWidth(); width++)
		{
		    for(int height=0; height < tropic.getHeight(); height++)
		    {
		          Color temp = new Color(0,255,0);
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
			if (i >= 0 && i < 120) {
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
	
	public void moveMap(){
		for(Rectangle r : blocks){
			r.x += xDirection;
			r.y += yDirection;
		}
	}
	public void stopMoveMap(){
		xDirection=0;
		yDirection=0;
	}
	private void setxDirection(int dir){
		xDirection=dir;
	}
	private void setyDirection(int dir){
		yDirection=dir;
	}
	public void navigateMap(int nav){
		switch(nav){
		default:
			System.out.println("Default entered. No action taken.");
			break;
		case PAN_UP:
			setyDirection(-90);
			break;
		case PAN_DOWN:
			setyDirection(90);
			break;
		case PAN_LEFT:
			setxDirection(-90);
			break;
		case PAN_RIGHT:
			setxDirection(90);
			break;
		}
		}
	}

