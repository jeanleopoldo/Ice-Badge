package gui;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import game.Control;

public class GUIInitMenu extends JFrame {

	protected JFrame frame_;
	protected JPanel panel_;
	protected Control control_;

	public GUIInitMenu(Control control) {

		this.control_ = control;
		this.panel_ = new JPanel();

		this.setFrame();
		this.setButtons();
	}

	public void setFrame() {
		GridBagConstraints gbc = new GridBagConstraints();
		this.setLayout(new GridBagLayout());
		this.add(panel_, gbc);
		this.setVisible(true);
		this.setSize(new Dimension(300, 450));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public void setButtons() {

		GridBagConstraints gbc = new GridBagConstraints();

		// ################## CONNECT ##################
		JButton connect = new JButton("CONNECT");
		gbc.gridx = 0;
		gbc.gridy = 0;
		connect.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand() == "CONNECT") {
					control_.connect();
				}

			}
		});
		this.panel_.add(connect, gbc);

		// ################## START GAME ##################

		JButton startGame = new JButton("START GAME");
		gbc.gridy++;
		startGame.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand() == "START GAME") {
					
					// control_.startGame();

					control_.receiveBeginMessage(1);
				}

			}
		});
		this.panel_.add(startGame, gbc);

		// ################## EXIT ##################

		JButton exit = new JButton("EXIT");
		gbc.gridy++;
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand() == "EXIT") {
					System.exit(0);
				}

			}
		});
		this.panel_.add(exit, gbc);

	}

}
