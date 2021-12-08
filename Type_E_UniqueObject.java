package trauger;

import java.awt.event.KeyEvent;
import java.util.LinkedList;

import java.awt.event.KeyListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;



public class Type_E_UniqueObject extends UniqueObject implements KeyListener {

	public Type_E_UniqueObject(int x, int y) {
		super(x, y);
		setVelocity(5);

		imageList = new LinkedList<Icon>();
		imageList.add(new ImageIcon("images/ballRed.png"));
		
		
	}

	public void move(Canvas c) {
		Icon icon = getCurrentImage();
		int iconHeight = icon.getIconHeight();
		int iconWidth = icon.getIconWidth();
		int canvasHeight = (int) c.getSize().getHeight();
		int canvasWidth = (int) c.getSize().getWidth();

		if (getHighlight() == true) {
			// move the object
			switch (getDirection()) {
			case Direction.LEFT:
				currentImage = 0;
				setX(getX() - getVelocity());
				if (getX() < 0) {
					setX(0);
				}
				break;
			case Direction.RIGHT:
				currentImage = 0;
				setX(getX() + getVelocity());
				if (getX() + iconWidth > canvasWidth) {
					setX((int) (canvasWidth - iconWidth));
				}
				break;
			case Direction.UP:
				currentImage = 0;
				setY(getY() - getVelocity());
				if (getY() < 0) {
					setY(0);
				}
				break;
			case Direction.DOWN:
				currentImage = 0;
				setY(getY() + getVelocity());
				if (getY() + iconHeight > canvasHeight) {
					setY((int) (canvasHeight - iconHeight));
				}
				break;
			}
		} else {
			if (getDirection() == Direction.LEFT) {
				setX(getX() - getVelocity());
				currentImage = 0;
				if (getX() < 0) {
					setX(0);
					setDirection(Direction.DOWN);
					currentImage = 0;
				}
			} else if (getDirection() == Direction.RIGHT) {
				setX(getX() + getVelocity());
				currentImage = 0;
				if (getX() + iconWidth > canvasWidth) {
					setX((int) (canvasWidth - iconWidth));
					setDirection(Direction.UP);
					currentImage = 0;
				}
			} else if (getDirection() == Direction.UP) {
				currentImage = 0;
				setY(getY() - getVelocity());
				if (getY() < 0) {
					setY(0);
					setDirection(Direction.LEFT);
					currentImage = 0;
				}
			} else {
				setY(getY() + getVelocity());
				currentImage = 0;
				if (getY() + iconHeight > canvasHeight) {
					setY((int) (canvasHeight - iconHeight));
					setDirection(Direction.RIGHT);
					currentImage = 0;
				}
			}
		}

	}
	
	public void keyTyped(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
		if (getHighlight() == true) {
			if (e.getKeyCode() != KeyEvent.VK_TAB) {
				setDirection(Direction.NONE);
			}
		}

	}

	public void keyPressed(KeyEvent e) {
		if (getHighlight() == true) {
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				setDirection(Direction.UP);
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				setDirection(Direction.DOWN);
			}
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				setDirection(Direction.RIGHT);
			}
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				setDirection(Direction.LEFT);
			}
		}

	}

	@Override
	public void setImage() {
		// TODO Auto-generated method stub
		
	}

}
