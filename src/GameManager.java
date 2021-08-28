import java.util.Random;
public class GameManager
{
	public boolean gameIsRunning = true;
	
	private int waitInterval = 200;
	public int rows = 10;
	public int cols = 10;
	public int cellCount = rows*cols;
	public int cellSize ;
	
	int[] playerStartPosition = {4,4};
	
	public Food food = new Food(CalculateFoodPosition());
	public InputManager input;
	public SnakeHead player;
	public gui GUI;
	
	private static GameManager _instance;
	private GameManager ()
	{
	}
	
	
	
	//Singleton Behaviour
	public static GameManager instance ()
	{
		if(_instance == null)
		{
			_instance = new GameManager();
		}
		return _instance;	
	}
	
	//Initialise Board
	public void InitBoard()
	{
		input = new InputManager();
		GUI = new gui();
		GUI.InitialzeGameWindow();
		GUI.LoadContents();
		player = new SnakeHead(playerStartPosition);
	}
	
	//Update Board
	public void Update()
	{
		player.Move();
		for(SnakeBody body : player.bodyParts)
		{
			body.Move();
			if(ComparePosition(body.position, player.position))
			{
				gameIsRunning = false;
				return;
			}
		}
		if(ComparePosition(player.position, food.position))
		{
			player.AddBodyPart();
			food.position = CalculateFoodPosition();
		}
		GUI.Repaint(player);
		try
		{
			Thread.sleep(waitInterval);
		} 
		catch (InterruptedException e)
		{
			System.out.println("Wait Fehler");
		}
	}
	
	private int[] CalculateFoodPosition()
	{
		Random rnd = new Random();
		int[] randomPosition = {rnd.nextInt(rows),rnd.nextInt(cols)};
		return randomPosition;
	}
	
	public boolean ComparePosition(int[] position1, int[] position2)
	{
		if(position1[0] == position2[0] && position1[1] == position2[1])
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
}
