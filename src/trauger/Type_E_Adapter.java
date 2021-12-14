package trauger;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;


import java.util.LinkedList;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Type_E_Adapter extends GameObject{
	
	private Type_E_UniqueObject e;

	
	public Type_E_Adapter(int x, int y, Type_E_UniqueObject e) {
		super(x, y);
		
		this.e = e;
		
		setDirection(Direction.NONE);

		imageList = new LinkedList<Icon>();
		imageList.add(new ImageIcon("images/redball.png"));

	}


	public void setVelocity(int y) {
		e.setVelocity(y);
	}
	
	public int getVelocity() {
		return e.getVelocity();
	}

	// Method to move unless selected, movement runs from child class, but bounds resetting is read by this adapter
	//bounces diagonal as fedines by child class.
	public void move(Canvas c) {
		 
		Icon icon = getCurrentImage();

		int  iconHeight   = icon.getIconHeight();
		int iconWidth = icon.getIconWidth();
		int canvasWidth = (int)c.getSize().getWidth();
		int  canvasHeight = (int)c.getSize().getHeight();
		
		int x = e.getX();
        int y = e.getY();
        int vx = e.getVelocity();
        int vy = e.getVelocity();
        
        boolean isHighlighted = getHighlight();
       
        x += vx;
        y += vy;
        
        
        if (x  < 0) {
            vx = -vx; 
            x = 0; 
          } else if (x + iconWidth > canvasWidth) {
            vx = -vx;
            x = canvasWidth - iconWidth;
          }
 
          if (y < 0) {
            vy = -vy;
            y = 0;
          } else if (y + iconHeight > canvasHeight) {
            vy = -vy;
            y = canvasHeight - iconHeight;
          }
        
        setX(x);
        setVelocity(vx);
        setY(y);
        setVelocity(vy);
       
        //use the obejct class to actually move the object
		e.unique_move(c, isHighlighted);
		
		
	}

	// Method to select icon image
	public void setImage() {
		currentImage = 0; // Image stays the same no matter the direction
	}





}