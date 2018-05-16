package graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class JNewGameMenu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JFrame newGameMenu = this;
	private JComboBox<String> levelsList = new JComboBox<String>();
	private JButton btnStart;
	private JPanel mainPanel = new JPanel();
	private JLabel lblTitle = new JLabel("New Game");
	
	private final int width = 20 + 200 + 40 + 200 + 20;
	private final int  height = 300;
	
	/** Label font used for most labels */
	public static final Font SysLabelFontB = new Font("SansSerif", Font.BOLD, 20);
	
	public JNewGameMenu() {
		
		final Dimension btnSize = new Dimension(200, 40);	// Gombok mérete
		this.setTitle("Soko - New Game: Settings");
		this.setSize(width, height);
		this.setLocation(425 + 50, 100 + 50);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);	
		
		// Init the main panel
		mainPanel.setSize(width, height);
		mainPanel.setLocation(0, 0);
		mainPanel.setLayout(null);
		mainPanel.setBackground(Color.LIGHT_GRAY);
		mainPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		this.getContentPane().add(mainPanel);
		
		// Init the title label
		lblTitle.setSize(300, 20);
		lblTitle.setFont(SysLabelFontB);
		lblTitle.setLocation(width/2 - 50, 30);
		mainPanel.add(lblTitle);
		
		
		// Create and add the Border demo button
		btnStart = new JButton("START");
		btnStart.setSize(btnSize);
		btnStart.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		btnStart.setLocation(20, 100); 
		btnStart.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						String strLevel = (String) levelsList.getSelectedItem();
						JGame jGame = new JGame(newGameMenu, listBoxInterpreter(strLevel));	
						jGame.setVisible(true);
						//newGameMenu.dispose();
						newGameMenu.setEnabled(false);
					}
				});
		mainPanel.add(btnStart);
		
		levelsList.setSize(btnSize);
		levelsList.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		levelsList.setLocation(200 + 50, 100); 
		levelsList.addItem("Demo");
		levelsList.addItem("Demo 2");
		levelsList.addItem("Level");
		
		mainPanel.add(levelsList);
	}
	private String listBoxInterpreter(String listItem) {
		if (listItem.equals("Demo")) {
			return "bemutato";
		}
		if (listItem.equals("Level")) {
			return "level1";
		}
		if (listItem.equals("Demo 2")) {
			return "bemutato2";
		}
		return "";
	}
	/**
	 * A program belépési pontja
	 * @param args
	 */
	public static void main(String args[]) {
	       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                 new JNewGameMenu().setVisible(true);
            }
        });  
	}
}
