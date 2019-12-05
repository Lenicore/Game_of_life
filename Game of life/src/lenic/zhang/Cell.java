package lenic.zhang;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Point;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Cell extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8949368571639428506L;

	private int row;
	private int column;
	private Cell[] adjacentCells;
	
	World world;

	/**
	 * 
	 * @param world
	 * @param row
	 * @param column
	 */
	public Cell(World world, int row, int column) {
		this.world = world;
		setRow(row);
		setColumn(column);
		init();		
	}

	/**
	 * set up the layout
	 */
	public void init() {
		setLayout(new GridLayout(1,1));
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		
	}

	/**
	 * @return the location of the Cell on the World
	 */
	@Override
	public Point getLocation() {
		return new Point(row, column);
	}

	/**
	 * @return the adjacent Cells corners only return 3 Cells sides only return
	 *         5 Cells all others return 8 Cells
	 */
	public Cell[] getAdjacentCells() {
		boolean top = false;
		boolean bottom = false;
		boolean left = false;
		boolean right = false;
		int count = 0;
		int index = 0;

		if (this.getRow() > 0) {
			top = true;
			count++;
		}

		if (this.getRow() < world.getRowCount() - 1) {
			bottom = true;
			count++;
		}

		if (this.getColumn() > 0) {
			left = true;
			count++;
		}

		if (this.getColumn() < world.getColumnCount() - 1) {
			right = true;
			count++;
		}

		if (top && left) {
			count++;
		}

		if (top && right) {
			count++;
		}

		if (bottom && left) {
			count++;
		}

		if (bottom && right) {
			count++;
		}
		
		adjacentCells = new Cell[count];
		
		if (row > 0) {
            top = true;
            if(world.getCellAt(row, column) == null)
            System.out.println("null");
            adjacentCells[index] = world.getCellAt(row - 1, column);
            index++;
        }
        // the cell on the bottom
        if (row < world.getRowCount() - 1) {
            bottom = true;
            adjacentCells[index] = world.getCellAt(row + 1, column);
            index++;
        }
        // the cell on the left
        if (column > 0) {
            left = true;
            adjacentCells[index] = world.getCellAt(row, column - 1);
            index++;
        }
        // the cell on the right
        if (column < world.getColumnCount() - 1) {
            right = true;
            adjacentCells[index] = world.getCellAt(row, column + 1);
            index++;
        }
        // the cell on the top left
        if (top && left) {
        	adjacentCells[index] = world.getCellAt(row - 1, column - 1);
        	index++;
        }
        // the cell on the top right
        if (top && right) {
        	adjacentCells[index] = world.getCellAt(row - 1, column + 1);
        	index++;
        }
        // the cell on the bottom left
        if (bottom && left) {
        	adjacentCells[index] = world.getCellAt(row + 1, column - 1);
        	index++;
        }
        // the cell on the bottom right
        if (bottom && right) {
        	adjacentCells[index] = world.getCellAt(row + 1, column + 1);
        	index++;
        }
		
		return adjacentCells;

	}	

	/**
	 * @return the row
	 */
	public int getRow() {
		return row;
	}

	/**
	 * @param row
	 *            the row to set
	 */
	public void setRow(int row) {
		this.row = row;
	}

	/**
	 * @return the column
	 */
	public int getColumn() {
		return column;
	}

	/**
	 * @param column
	 *            the column to set
	 */
	public void setColumn(int column) {
		this.column = column;
	}

}
