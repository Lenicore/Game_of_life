package lenic.zhang;

import java.awt.Color;
import java.util.Random;

import javax.swing.JPanel;

public class Herbivore extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6594636539245853412L;
	
	private Cell cell;	
	int deathCount;

	/**
	 * 
	 * @param location
	 */
	public Herbivore(Cell location)
	{		
		setCell(location);	
		init();
		deathCount = 5;
	}
	
	/**
	 * Sets the background to be yellow
	 */	
	public void init()
	{		
		setBackground(Color.YELLOW);		
	}
	
	/**
	 * 
	 * @param location puts the Herbivore on the specified Cell
	 */
	public void setCell(Cell location)
	{
		this.cell = location;
		this.cell.add(this);
	}
	
	/**
	 * Moves the Herbivore one cell (where it eats a Plant if the Cell contains a Plant)
	 */
	public void move()
	{
		if(deathCount == 0)
		{
			this.cell.remove(this);
		}
		Random r = new Random();
		int randomLocation = 0;
		Cell nextCell = null;
		Cell[] adjacent = new Cell[cell.getAdjacentCells().length];
		
		adjacent = this.cell.getAdjacentCells();
		randomLocation = r.nextInt(cell.getAdjacentCells().length - 1);
		nextCell = adjacent[randomLocation];
		if(nextCell != null)
		{
			if(nextCell.getComponentCount() != 0)
			{
				if(nextCell.getComponent(0) instanceof Plant)
				{
					nextCell.remove(0);
					deathCount = 4;						
					nextCell.add(this);						
					this.cell.remove(this);
					this.cell = nextCell;
					
				}					
				else
				{
					deathCount--;						
				}
			}
			else
			{
				deathCount--;					
				nextCell.add(this);
				this.cell.remove(this);
				this.cell = nextCell;
				
			}						
		}		
		
	}
}
