package trauger;

import java.awt.event.KeyEvent;
import java.util.LinkedList;

import java.awt.event.KeyListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;



public class Type_B_GameObject extends GameObject implements KeyListener {

	public Type_B_GameObject(int x, int y) {
		super(x, y);
		setVelocity(5);

		imageList = new LinkedList<Icon>();
		imageList.add(new ImageIcon("images/Type_B__Up.png"));
		imageList.add(new ImageIcon("images/Type_B_Right.png"));
		imageList.add(new ImageIcon("images/Type_B_Down.png"));
		imageList.add(new ImageIcon("images/Type_B_Left.png"));
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
				currentImage = 1;
				setX(getX() - getVelocity());
				if (getX() < 0) {
					setX(0);
				}
				break;
			case Direction.RIGHT:
				currentImage = 3;
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
				currentImage = 2;
				setY(getY() + getVelocity());
				if (getY() + iconHeight > canvasHeight) {
					setY((int) (canvasHeight - iconHeight));
				}
				break;
			}
		} else {
			if (getDirection() == Direction.LEFT) {
				setX(getX() - getVelocity());
				currentImage = 1;
				if (getX() < 0) {
					setX(0);
					setDirection(Direction.DOWN);
					currentImage = 2;
				}
			} else if (getDirection() == Direction.RIGHT) {
				setX(getX() + getVelocity());
				currentImage = 3;
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
					currentImage = 1;
				}
			} else {
				setY(getY() + getVelocity());
				currentImage = 2;
				if (getY() + iconHeight > canvasHeight) {
					setY((int) (canvasHeight - iconHeight));
					setDirection(Direction.RIGHT);
					currentImage = 3;
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
