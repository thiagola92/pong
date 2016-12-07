package logic;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keys implements KeyListener {
	
	private Game game;
	
	public Keys(Game g) {
		super();
		game = g;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		System.out.println(e.getKeyCode());
		
		// Controles p1: W, S
		// Controles p2: Seta para cima, Seta para baixo
		if(e.getKeyCode() == 87)
			game.move_up_p1();
		else if(e.getKeyCode() == 83)
			game.move_down_p1();
		else if(e.getKeyCode() == 38)
			game.move_up_p2();
		else if(e.getKeyCode() == 40)
			game.move_down_p2();

		game.update_game();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
