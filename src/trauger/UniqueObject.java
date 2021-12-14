package trauger;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import javax.swing.Icon;

public abstract class UniqueObject{
	// EACH GAME OBJECT HAS AN X,Y LOCATION, VELOCITY, AND A DIRECTION

	private int x;
	private int y;
	private int velocity;
	private int direction;
	private boolean highlight;

	// EACH GAME OBJECT CAN HAVE A COLLECTION OF IMAGES
	protected List<Icon> imageList;
	protected int currentImage;

	public UniqueObject(int x, int y) {
		this.x = x;
		this.y = y;
		velocity = 3;
		currentImage = 0;
		highlight = false;
	}

	public void draw(Component c, Graphics g) {
		imageList.get(currentImage).paintIcon(c, g, x, y);
	}

	// SETTERS AND GETTERS

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}

	public int getVelocity() {
		return velocity;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public Icon getCurrentImage() {
		return imageList.get(currentImage);
	}
	public void setHighlight(Boolean b) {
		this.highlight = b;
	}
	public boolean getHighlight() {
		return highlight;
	}

	// ABSTRACT METHODS
	public abstract void unique_move(Canvas c, boolean isHighlight);

	public abstract void setImage();
	
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}



	

}
