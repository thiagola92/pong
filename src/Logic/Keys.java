package Logic;

import java.io.IOException;

public class Keys extends Thread {
	
	private Game game;
	
	public Keys(Game g) {
		super();
		game = g;
	}
	
	public void run() {
		
		int key;
		
		while(true) {
			
			try {
				
				do {
					key = System.in.read();
				} while(key == 10 || key == 13);
				key_pressed(key);
				
			} catch (IOException e) {
				System.out.println(">> IOException - if an I/O error occurs.");
				e.printStackTrace();
			}
			
		}
		
	}
	
	public void key_pressed(int key) {
		
		if(key == 'w')
			game.move_up_p1();
		else if(key == 's')
			game.move_down_p1();
		else if(key == 'i')
			game.move_up_p2();
		else if(key == 'k')
			game.move_down_p2();
		
		game.update_game();
	}

}
