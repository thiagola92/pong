package Logic;

public class Game {
	
	private int height = 10;	// cima <---> baixo
	private int width = 10;		// esquerda <--> direita
	private int size = 4;		// tamanho das barras
	private int pair;			// se o tamanho for par então essa variavel é -1
	
	private int matrix[][];		// matriz do jogo
	
	private int center_p1;			// centro da barra do P1
	private int center_p2;			// centro da barra do P2
	
	private int ball_position_x;	// posicao x da bola
	private int ball_position_y;	// posicao y da bola
	private int ball_speed_x;		// velocidade em x // -1 esquerda <---> 1 direita 
	private int ball_speed_y;		// velocidade em y // -1 cima <---> 1 baixo
	
	private Keys keyboard;		// classe responsavel por pegar as teclas
	
	public Game() {
		matrix = new int[height][width];
		keyboard = new Keys(this); 
		
		center_p1 = size/2;
		center_p2 = size/2;
		
		ball_position_x = width/2;
		ball_position_y = 0;
		ball_speed_x = 1;
		ball_speed_y = 1;

		pair = size%2 == 1 ? 0 : -1;
		
		update_game();
	}

	public void print_game() {
		
		for(int i=0; i < height; i++)
			System.out.println("");
		
		for(int j=0; j < height; j++) {
			for(int i=0; i < width; i++) {
				System.out.print("[" + matrix[i][j] + "]");
			}
			System.out.print("\n");
		}
	}
	
	public void start_game() {
		keyboard.start();
		move_ball();
	}
	
	public void update_game() {
		
		int start_p1;
		int end_p1;
		
		int start_p2;
		int end_p2;
		
		start_p1 = center_p1 - size/2;
		end_p1 = center_p1 + size/2 + pair;

		start_p2 = center_p2 - size/2;
		end_p2 = center_p2 + size/2 + pair;
		
		for(int j=0; j < height; j++) {
			for(int i=0; i < width; i++) {
				
				if( (i==0 && j >= start_p1 && j <= end_p1) || (i == width-1 && j >= start_p2 && j <= end_p2))
					matrix[i][j] = 1;
				else
					matrix[i][j] = 0;
			}
		}
		
		matrix[ball_position_x][ball_position_y] = 1;
		
		print_game();
	}
	
	/////////////////// GAME ////////////////////
	
	public void move_ball() {
		
		while(true) {
			
			update_game();
		
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println(">> IllegalArgumentException - if the value of millis is negative");
				System.out.println(">> InterruptedException - if any thread has interrupted the current thread. The interrupted status of the current thread is cleared when this exception is thrown");
				e.printStackTrace();
			}
			
			// bola passou dos jogadores
			if(ball_position_x + ball_speed_x < 0 || ball_position_x + ball_speed_x >= width) {

				ball_position_x = width/2;
				ball_position_y = 0;
				
				ball_speed_x = 1;
				ball_speed_y = 1;
				
				continue;
			}
			
			// Se bola encostou no teto ou chão inverte a direção y
			if(ball_position_y + ball_speed_y < 0 || ball_position_y + ball_speed_y >= height)
				ball_speed_y *= -1; 
			
			// Encontrando outro jogador

			int start_p1 = center_p1 - size/2;
			int end_p1 = center_p1 + size/2 + pair;
			if(ball_position_x + ball_speed_x ==  0 &&
					ball_position_y + ball_speed_y >= start_p1 &&
					ball_position_y + ball_speed_y <= end_p1)
				ball_speed_x *= -1;
			
			int start_p2 = center_p2 - size/2;
			int end_p2 = center_p2 + size/2 + pair;
			if(ball_position_x + ball_speed_x == width-1 &&
					ball_position_y + ball_speed_y >= start_p2 &&
					ball_position_y + ball_speed_y <= end_p2)
				ball_speed_x *= -1;
			
			// Nova posição da bola
			ball_position_x += ball_speed_x;
			ball_position_y += ball_speed_y;
		
		}
		
	}
	
	/////////////////// PLAYERS ///////////////////////
	
	public void move_up_p1() {
		
		if( (center_p1 - size/2) - 1 < 0)
			return;
		
		center_p1--;
		
	}
	
	public void move_down_p1() {
		
		if( (center_p1 + size/2 + pair) + 1 >= height )
			return;
		
		center_p1++;
		
	}
	
	public void move_up_p2() {
		
		if( (center_p2 - size/2) - 1 < 0)
			return;
		
		center_p2--;
		
	}
	
	public void move_down_p2() {
		
		if( (center_p2 + size/2 + pair) + 1 >= height )
			return;
		
		center_p2++;
		
	}
}
