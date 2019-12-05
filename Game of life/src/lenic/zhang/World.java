package lenic.zhang;

import java.util.Random;

public class World {
	private int rowCount;
	private int columnCount;
	
	Cell[][] cell;
	/**
	 * 
	 * @param rows
	 * @param columns
	 */
	public World(int rows, int columns)
	{
		setRowCount(rows);
		setColumnCount(columns);
		cell = new Cell[rows][columns];		
	}
	
	/**
	 * puts the Cells on the world and adds the appropriate number of Herbivores and
	 * Plants
	 */
	public void init()
	{
		Random d = new Random();
		for(int i = 0; i < rowCount; i++)
		{
			for(int j = 0; j < columnCount; j++)
			{
				this.cell[i][j] = new Cell(this, i, j);
				
				int n = d.nextInt(100);
				if (n <= 10) {
					new Herbivore(cell[i][j]);
				} else if (n <= 40) {
					new Plant(cell[i][j]);
				} else {
					
				}
			}
		}
	}
	
	/**
	 * 
	 * @param row
	 * @param column
	 * @return retrieves the requested Cell from the specified location
	 * in the World
	 */
	public Cell getCellAt(int row, int column)
	{
		return cell[row][column];
	}
	
	/**
	 * removes dead herbivores and then moves remaining living Herbivores one
	 * Cell (and they eat, if possible)
	 */
	public void takeTurn()
	{
		Cell c;
		for(int i = 0; i < getRowCount(); i++)
		{
			for(int j = 0; j < getColumnCount(); j++)
			{
				c = this.cell[i][j];
				if((c.getComponentCount() != 0) && (c.getComponent(0) instanceof Herbivore))
				{
					if(((Herbivore) c.getComponent(0)).deathCount > 0)
					{
						((Herbivore) c.getComponent(0)).move();
					}
					else
					{
						c.remove((Herbivore) c.getComponent(0));
					}
					
				}
			}
		}
	}

	/**
	 * @return the rowCount
	 */
	public int getRowCount() {
		return rowCount;
	}

	/**
	 * @param rowCount the rowCount to set
	 */
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	/**
	 * @return the columnCount
	 */
	public int getColumnCount() {
		return columnCount;
	}

	/**
	 * @param columnCount the columnCount to set
	 */
	public void setColumnCount(int columnCount) {
		this.columnCount = columnCount;
	}
}
