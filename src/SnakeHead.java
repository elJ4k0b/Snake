import java.awt.List;
import java.util.ArrayList;

public class SnakeHead extends SnakeBody
{
	public ArrayList <SnakeBody> bodyParts = new ArrayList <SnakeBody>();
	public int[] direction = {1,0};
	public SnakeHead(int[] position)
	{
		super(position);
	}
	
	
	public void TouchingFood(Food food)
	{
		if(position[0] == food.position[0] && this.position[1] == food.position[1])
		{
			AddBodyPart();
		}
	}
	public void AddBodyPart()
	{
		SnakeBody lastBodyPart;
		if(bodyParts.size() > 0)
		{
			lastBodyPart = bodyParts.get(bodyParts.size()-1);	
		}
		
		else
		{
			lastBodyPart = this;
		}
		
		SnakeBody NewBodyPart = new SnakeBody(lastBodyPart.lastPosition);
		NewBodyPart.vorgaenger = lastBodyPart;
		bodyParts.add(NewBodyPart);
	}
	
	@Override
	public void Move()
	{
		lastPosition[0] = position[0];
		lastPosition[1] = position[1];
		int [] newPosition = {position[0] += direction[0], position[1] += direction[1]};
		position = newPosition;
	}
	
}
