package lenic.zhang;

import java.awt.Color;
import javax.swing.JPanel;

public class Plant extends JPanel{
	
	private static final long serialVersionUID = 6561634360503365830L;
	private Cell cell;
	
	/**
	 * take one parameter
	 * @param location
	 */
	public Plant(Cell location)
	{
		setCell(location);
		init();
	}
	/**
	 * set the background color to green
	 */
	public void init()
	{
		setBackground(Color.GREEN);		
	}
	/**
	 * puts plant on specific location
	 * @param location
	 */
	public void setCell(Cell location)
	{
		this.cell = location;
		this.cell.add(this);
	}
}
