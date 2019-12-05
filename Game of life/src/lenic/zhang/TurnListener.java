package lenic.zhang;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TurnListener extends MouseAdapter implements MouseListener{

	private GameFrame gameFrame;

	public TurnListener(GameFrame gameFrame) {
        this.gameFrame = gameFrame;
    }

    /* (non-Javadoc)
     * @see java.awt.event.MouseAdapter#mouseClicked(java.awt.event.MouseEvent)
     */
    @Override
    public void mouseClicked(MouseEvent event) {
        this.gameFrame.takeTurn();
        super.mouseClicked(event);
    }
}
