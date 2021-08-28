import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.RootPaneUI;
public class gui
{
	private GameManager gameManager = GameManager.instance();
	
	public JFrame window  = new JFrame("snake");
	public JPanel main = new JPanel(null);
	private ArrayList<JLabel> fields = new ArrayList<JLabel>();
	
	
	
	public void InitialzeGameWindow()
	{
		window.setSize(800,800);
		window.setResizable(false);
	    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    window.setVisible(true);
	}
	
	
	
	public void LoadContents()
	{
		main.setFocusable(true);
		
		main.addKeyListener(gameManager.input.listener);
		
		gameManager.cellSize = (int) window.getHeight()/gameManager.cols;
		
		for(int x = 0; x < gameManager.rows; x++)
		{
			for(int y = 0; y < gameManager.cols; y++ )
			{
				JLabel gameField = GenerateField();
				gameField.setBounds(x*gameManager.cellSize, y*gameManager.cellSize, gameManager.cellSize, gameManager.cellSize);
				fields.add(gameField);
				main.add(gameField);	
			}
		}
		window.add(main);
		main.repaint();
	}
	
	
	
	public void Repaint (SnakeHead head)
	{
		int felderOhneSchlangenKopf = 0;
		
		for(JLabel field : fields)
		{
			int [] fieldPosition = {field.getX()/gameManager.cellSize,field.getY()/gameManager.cellSize};
			
			if(gameManager.ComparePosition(head.position, fieldPosition))
			{
				field.setOpaque(true);
				field.setBackground(Color.red);
			}
			
			else
			{
				felderOhneSchlangenKopf ++;
				field.setOpaque(true);
				field.setBackground(Color.white);
				main.repaint();
			}
			
			if(gameManager.ComparePosition(gameManager.food.position, fieldPosition))
			{
				field.setOpaque(true);
				field.setBackground(Color.green);
			}
			
			for (SnakeBody body : head.bodyParts)
			{
				if(gameManager.ComparePosition(body.position, fieldPosition))
				{
					field.setOpaque(true);
					field.setBackground(Color.red);
				}
				main.repaint();
			}
			
		}
		gameManager.gameIsRunning = IsSnakeOnField(felderOhneSchlangenKopf);
	}
	
	private JLabel GenerateField()
	{
		JLabel gameField = new JLabel();
		gameField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		gameField.setOpaque(true);
		gameField.setFocusable(true);
		return gameField;
	}
	
	
	
	public void ExitGame()
	{
		window.dispose();
	}
	
	
	
	private boolean IsSnakeOnField(int leereFelder)
	{
		if(leereFelder >= fields.size())
		{
			return false;
			
		}
		else
		{
			return true;
		}
	}
}
