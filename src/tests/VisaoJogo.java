package tests;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import game.Control;


public class VisaoJogo extends JFrame {

	private Control controle;
	private JPanel tabuleiro;
	private JPanel personagens;
	private JPanel botoes;
	private JLabel mensagem;
	private JLabel eVezJogar;
	
	
	public VisaoJogo(Control c){
		super();
		controle = c;
		tabuleiro = new JPanel();
		personagens = new JPanel();
		botoes = new JPanel();
		mensagem = new JLabel();
		eVezJogar = new JLabel();
		if(controle.getPlayer().isTurn())
			eVezJogar.setText(controle.getPlayer().isTurn() + ".   É sua Vez de Jogar");
		else 
			eVezJogar.setText(controle.getPlayer().isTurn() + ".   Não sua Vez de Jogar");

		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		setTabuleiro();
		setPersonagens();
		mensagem.setText("Novo Jogo Começado, preparara para a batalha");
		setBotoes();
		
		this.add(tabuleiro, gbc);
		gbc.gridx = 1;
		gbc.gridy = 0;
		this.add(personagens, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		this.add(botoes, gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		this.add(mensagem, gbc);
		gbc.gridx = 1;
		gbc.gridy = 3;
		this.add(eVezJogar, gbc);
		

		this.pack();
		this.setVisible(true);
	}

	private void setBotoes() {
		botoes.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		JButton passarVez = new JButton("Passar A Vez");
		passarVez.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				controle.changeTurn();		
			}
		});
		JButton desistir = new JButton("Desistir");
		desistir.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				controle.quit();		
			}
		});
		JButton mostrarArea = new JButton("Mostra area Movimento");
		mostrarArea.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
			//	controle.passarAvez();		
			}
		});
		botoes.add(passarVez,c);
		c.gridx++;
		//botoes.add(mostrarArea,c);
		//c.gridx++;
		botoes.add(desistir,c);
		c.gridx++;
	}

	public void atualizarTabuleiro(){
		for(Component c : tabuleiro.getComponents())
			if(c instanceof CellPane){
				c.repaint();	
		}
		
		personagens.removeAll();
		setPersonagens();
		
		if(controle.getPlayer().isTurn())
			eVezJogar.setText("É sua Vez de Jogar");
		else 
			eVezJogar.setText("Não sua Vez de Jogar");
	}
	
	public void atualizarMensagem(String msg){
		mensagem.setText(msg);
	}
	
	private void setPersonagens(){
		personagens.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridy = 0;
		c.gridx = 0;
		personagens.add(new JLabel(controle.getGame().getPlayer().getNome()), c);

		c.gridy++;
		
		personagens.add(new JLabel("Nome:"), c);
		c.gridx = 1;
		
		personagens.add(new JLabel("Vida Atual:"), c);
		for(Personagem p : controle.getGame().getPlayer().getPersonagens()){
			c.gridx = 0;
			c.gridy++;
			personagens.add(new JLabel(p.getTipo()), c);
			c.gridx = 1;
			personagens.add(new JLabel("" + p.getVida()), c);
		}	
		c.gridy++;
		c.gridx = 0;
		personagens.add(new JLabel(controle.getGame().getPlayer().getTorre().getTipo()), c);
		c.gridx = 1;
		personagens.add(new JLabel("" + controle.getGame().getPlayer().getTorre().getVida()), c);
		c.gridx = 0;
		c.gridy++;
		personagens.add(new JLabel(" "), c);
		c.gridy++;
		personagens.add(new JLabel(" "), c);
		c.gridy++;
		personagens.add(new JLabel(" "), c);
		c.gridy++;
		personagens.add(new JLabel(controle.getGame().getJogador2().getNome()), c);
		c.gridy++;		
		personagens.add(new JLabel("Nome:"), c);
		c.gridx = 1;		
		personagens.add(new JLabel("Vida Atual:"), c);
		for(Personagem p : controle.getGame().getJogador2().getPersonagens()){
			c.gridx = 0;
			c.gridy++;
			personagens.add(new JLabel(p.getTipo()), c);
			c.gridx = 1;
			personagens.add(new JLabel("" + p.getVida()), c);
		}
		c.gridy++;
		c.gridx = 0;
		personagens.add(new JLabel(controle.getGame().getJogador2().getTorre().getTipo()), c);
		c.gridx = 1;
		personagens.add(new JLabel("" + controle.getGame().getJogador2().getTorre().getVida()), c);
	}
	
	
	private void setTabuleiro(){
		Tabuleiro tab = controle.getTabuleiro();
		int columnCount = tab.getComprimento();
		int rowCount = tab.getAltura();
		tabuleiro.setSize(columnCount * 32, rowCount * 32);		
		tabuleiro.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();		
        for (int row = 0; row < rowCount; row++) {
            for (int col = 0; col < columnCount; col++) {
                gbc.gridx = col;
                gbc.gridy = row;
                CellPane cellPane = new CellPane(row, col, tab.getPosicao(row , col));
                tabuleiro.add(cellPane,gbc);
            }
        }      
	}

	private BufferedImage getImagem(String caminho){
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File(caminho));
		} catch (IOException e) {
			e.printStackTrace();
		}	
		return image;
	}
	
	
	
	public class CellPane extends JPanel {

        private Posicao posicao;
        
        public CellPane(final int x, final int y) {
        	super();
        	this.setSize(32, 32);
        	
            addMouseListener(new MouseListener() {			
				@Override
				public void mouseReleased(MouseEvent e) {}
				
				@Override
				public void mousePressed(MouseEvent e) {}
				
				@Override
				public void mouseExited(MouseEvent e) {}
				
				@Override
				public void mouseEntered(MouseEvent e) {}
				
				@Override
				public void mouseClicked(MouseEvent e) {	
					controle.clikPosicao(x, y);
				}
			});
            
       	 	this.setVisible(true);
        }

		@Override
        public Dimension getPreferredSize() {
            return new Dimension(32, 32);
        }
        
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            String caminhoImagem = "";
            if(posicao.verificaPersonagemPosicao()){
            	if(controle.getJogador().verificaPertencePersonagem( posicao.getPersonagemPosicao())){
            		caminhoImagem = posicao.getPersonagemPosicao().getImagem1();
            	}           		
            	else{
            		caminhoImagem = posicao.getPersonagemPosicao().getImagem2(); //posicao.getPersonagemPosicao().getImagem();
            	}           		
            }
            else{
            	caminhoImagem = posicao.getImagem();
            } 	
            BufferedImage image = getImagem(caminhoImagem);
            g.drawImage(image, 0, 0, null);             
        }
        
    }
	
}
