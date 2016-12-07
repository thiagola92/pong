package graphic;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

import logic.Game;
import logic.Keys;

@SuppressWarnings("serial")
public class Game_window extends JFrame {
	
	private Game game;
	
	private JLabel game_state[];
	
	public Game_window(Game g, Keys k) {
		game = g;
		
		game_state = new JLabel[g.getHeight()];
				
		setVisible(true);
		setLayout(new GridBagLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		GridBagConstraints constraints = new GridBagConstraints();
		
		for(int i=0; i < g.getHeight(); i++) {
			constraints.gridy = i;
			game_state[i] = new JLabel(".");
			add(game_state[i], constraints);
		}
		
		addKeyListener(k);
		
		pack();
	}
	
	public void update_window() {
		String line = "";
		
		for(int j=0; j < game.getHeight(); j++) {
			
			for(int i=0; i < game.getWidth(); i++) {
				line += " " + game.getMatrix()[j][i] + " ";
			}
			
			game_state[j].setText(line);
			line = "";
		}
		
		pack();
	}

}
