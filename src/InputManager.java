import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputManager
{
	GameManager gameManager = GameManager.instance();
	public KeyListener listener = new KeyListener()
	{
		@Override
		public void keyTyped(KeyEvent e)
		{
	         char key = e.getKeyChar();
	        switch (key)
	        {
	        	case 'w':
	        		gameManager.player.direction[0] = 0;
	        		gameManager.player.direction[1] = -1;
	        		break;
	        	case 's':
	        		gameManager.player.direction[0] = 0;
	        		gameManager.player.direction[1] = 1;
	        		break;
	        	case 'a':
	        		gameManager.player.direction[0] = -1;
	        		gameManager.player.direction[1] = 0;
	        		break;
	        	case 'd':
	        		gameManager.player.direction[0] = 1;
	        		gameManager.player.direction[1] = 0;
	        		break;
	        }
	    }

		@Override
		public void keyPressed(KeyEvent f) {
			
			
		}

		@Override
		public void keyReleased(KeyEvent g) {
			
			
		}
	};
}
