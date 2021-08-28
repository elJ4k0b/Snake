import java.util.Vector;

public class SnakeBody
{
	protected GameManager gameManager = GameManager.instance();	
	protected int[] position = new int[2];
	public int[] lastPosition = new int[2];
	public SnakeBody vorgaenger;
	
	public SnakeBody(int[] position)
	{
		this.position[0] = position[0];
		this.position[1] = position[1];
	}
	public void Move()
	{
		lastPosition[0] = position[0];
		lastPosition[1] = position[1];
		position[0] = vorgaenger.lastPosition[0];
		position[1] = vorgaenger.lastPosition[1];			
	}
}
