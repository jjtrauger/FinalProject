package trauger;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Type_E_UniqueObject extends UniqueObject {

	// constructor
	public Type_E_UniqueObject(int x, int y) {
		super(x, y);
		setVelocity(5);

		imageList = new LinkedList<Icon>();
		imageList.add(new ImageIcon("images/redball.png"));
		setDirection(Direction.UP);

	}

	// implement abstract method move

	public void unique_move(Canvas c, boolean isHighlight) {

		// System.out.println(getHighlight());
		// System.out.println(getY());
		// System.out.println(getDirection());
		// System.out.println(c.highlighted);

		Icon icon = getCurrentImage();

		int iconHeight = icon.getIconHeight();
		int canvasHeight = (int) c.getSize().getHeight();

		// dont move when highlighted

		if (isHighlight) {
			setDirection(Direction.NONE);
			currentImage = 0;
			setX(getX());
			setY(getY());
		} else {
			if (getDirection() == Direction.UP) {
				setY(getY() - getVelocity());
				setX(getY() + getVelocity());
				currentImage = 0;
				if (getY() < 0) {
					setX(getX());
					setY(0);
					setDirection(Direction.DOWN);
				}
			} else {
				setY(getY() + getVelocity());
				setX(getY() - getVelocity());
				currentImage = 0;
				if (getY() + iconHeight > canvasHeight) {
					setY((int) (canvasHeight - iconHeight));
					setX(getY() + getVelocity());
					setDirection(Direction.UP);
				}
			}
		}

	}

	@Override
	public void setImage() {
		// TODO Auto-generated method stub

	}

}
