package gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;

import javax.swing.JFrame;
import javax.swing.JPanel;

import game.Control;
import table.Table;

public class GUITable extends JFrame {

	protected Control control;
	private JPanel table;

	private GridBagConstraints gbc;

	public GUITable(Control control) {
		this.gbc = new GridBagConstraints();

		setFrame();
		setTable();
		setButtons();
		setLables();
		this.add(this.table, this.gbc);

	}


	private void setLables() {
		// TODO Auto-generated method stub

	}

	private void setButtons() {
		// TODO Auto-generated method stub

	}

	private void setFrame() {

		this.setTitle("Table");
		this.setSize(new Dimension(500, 600));
		this.setVisible(true);
		this.pack();

	}

	private void setTable() {

		GridBagConstraints gbc = new GridBagConstraints();
		
		int height = this.control.getTable().getHeight();
		int width = this.control.getTable().getWidth();
		
		this.table = new JPanel();
		this.table.setSize(new Dimension(width*32, height*32));
		
		CellPane cp;
		
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				cp = new CellPane(i, j);
				gbc.gridx = i;
				gbc.gridy = j;
				this.table.add(cp, gbc);
				
			}
		}
	}

	private class CellPane extends JPanel {

		private int x;
		private int y;

		public CellPane(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

}
