package trauger;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

import java.awt.event.KeyListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Type_E_Adapter extends GameObject {
	
	private Type_E_UniqueObject e;
	
	public Type_E_Adapter(Type_E_UniqueObject e) {
		super(e.getX(), e.getY());
		this.e = e;
		imageList = e.imageList;
		//setVelocity(e.getVelocity());
	}


	@Override
	public void move(Canvas c) {
		e.move(c);
		
	}

	@Override
	public void setImage() {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
