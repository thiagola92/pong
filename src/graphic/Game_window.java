package graphic;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

import logic.Game;
import logic.Keys;

@SuppressWarnings("serial")
public class Game_window extends JFrame {
	
	private Game game;
	
	// largura e altura
	private int rect_width;
	private int rect_height;
	
	// bordas para ficar melhor posicionado
	private int edge_x;
	private int edge_y;
	
	// tamanho da janela
	private int window_width;
	private int window_height;
	
	public Game_window(Game g, Keys k) {
		game = g;
		
		rect_width = 50;
		rect_height = 50;
		
		edge_x = 5;
		edge_y = 30;
		
		window_width = 2*edge_x + rect_width*g.getWidth();
		window_height = 2*edge_y + rect_height*g.getHeight();
				
		setVisible(true);
		setLayout(new GridBagLayout());
		setSize(new Dimension(window_width, window_height));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		addKeyListener(k);
		
	}
	
	public void paint(Graphics g) {
		if (g==null)
			g = getGraphics();
		
		for(int j=0; j < game.getHeight(); j++) {
			
			for(int i=0; i < game.getWidth(); i++) {
				if(game.getMatrix()[j][i] == 1) {
					g.setColor(Color.LIGHT_GRAY);
					g.fillRect(5 + rect_width*i, 30 + rect_height*j, rect_width, rect_height);
				} else if(game.getMatrix()[j][i] == 2) {
					g.setColor(Color.RED);
					g.fillRect(5 + rect_width*i, 30 + rect_height*j, rect_width, rect_height);
				} else {
					g.setColor(Color.GRAY);
					g.fillRect(5 + rect_width*i, 30 + rect_height*j, rect_width, rect_height);
				}
			}
		}
		
	}

}
