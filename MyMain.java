package trauger;

public class MyMain {

	public static void main(String[] args) {

		// TASK 1: CREATE A CANVAS FOR ANIMATION
		Canvas canvas = new Canvas();
		canvas.requestFocus();

		// TASK 2: ADD A USER GAME OBJECT
		Type_A_GameObject a = new Type_A_GameObject(200, 200);

		canvas.addKeyListener(a);
		canvas.addGameObject(a);
		
		Type_B_GameObject b = new Type_B_GameObject(600,600);
		
		canvas.addKeyListener(b);
		canvas.addGameObject(b);

		Type_C_GameObject c = new Type_C_GameObject(200, 200);

		canvas.addKeyListener(c);
		canvas.addGameObject(c);

		Type_D_GameObject d = new Type_D_GameObject(200, 200);

		canvas.addKeyListener(d);
		canvas.addGameObject(d);
		
		Type_E_UniqueObject e = new Type_E_UniqueObject (100,100);
		Type_E_Adapter e2 = new Type_E_Adapter(e);
		
		canvas.addGameObject(e2);

	}

}
