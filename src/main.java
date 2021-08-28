import javax.swing.JFrame;
public class main
{
	public static void main(String[] args)
	{
		GameManager gameManager = GameManager.instance();
		gameManager.InitBoard();
		do
		{
			gameManager.Update();
		}while(gameManager.gameIsRunning);
		gameManager.GUI.ExitGame();
	}

}
