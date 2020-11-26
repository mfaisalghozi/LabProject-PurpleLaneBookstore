package bookstore.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JSplitPane;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import java.awt.Panel;
import java.awt.Label;
import java.awt.Font;
import javax.swing.JLabel;

public class HomeView extends JFrame {

	private JPanel bodyPanel;
	private JPanel mainPanel;
	private Panel homePanel;
	private Panel bookPanel;
	private Panel cartPanel;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeView frame = new HomeView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HomeView() {
		setTitle("Aplikasi Bookstore");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 860, 516);
		bodyPanel = new JPanel();
		bodyPanel.setBackground(new Color(0, 206, 209));
		bodyPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(255, 255, 255), new Color(255, 255, 255), new Color(255, 255, 255)));
		setContentPane(bodyPanel);
		bodyPanel.setLayout(null);
		
		JPanel menuPanel = new JPanel();
		menuPanel.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 255, 255), new Color(255, 255, 255), new Color(255, 255, 255), new Color(255, 255, 255)));
		menuPanel.setBackground(new Color(186, 85, 211));
		menuPanel.setBounds(10, 11, 163, 459);
		bodyPanel.add(menuPanel);
		menuPanel.setLayout(null);
		
		Button btnHome = new Button("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//remove Panel
				mainPanel.removeAll();
				mainPanel.repaint();
				mainPanel.revalidate();
				
				//add panel
				mainPanel.add(homePanel);
				mainPanel.repaint();
				mainPanel.revalidate();
				
			}
		});
		btnHome.setBounds(10, 140, 143, 36);
		menuPanel.add(btnHome);
		
		Button btnBook = new Button("Books");
		btnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//remove Panel
				mainPanel.removeAll();
				mainPanel.repaint();
				mainPanel.revalidate();
				
				//add panel
				mainPanel.add(bookPanel);
				mainPanel.repaint();
				mainPanel.revalidate();
				
				
			}
		});
		btnBook.setBounds(10, 198, 143, 36);
		menuPanel.add(btnBook);
		
		Button btnCart = new Button("Cart");
		btnCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//remove Panel
				mainPanel.removeAll();
				mainPanel.repaint();
				mainPanel.revalidate();
				
				//add panel
				mainPanel.add(cartPanel);
				mainPanel.repaint();
				mainPanel.revalidate();
			}
		});
		btnCart.setBounds(10, 250, 143, 36);
		menuPanel.add(btnCart);
		
		Button btnAbout = new Button("About");
		btnAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AboutView n = new AboutView();
				n.setVisible(true);
			}
		});
		btnAbout.setBounds(10, 304, 143, 36);
		menuPanel.add(btnAbout);
		
		Button btnLogout = new Button("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int dialogBtn = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog(null, "Apakah yakin ingin logged out ?", "Peringatan", dialogBtn);
				
				if(dialogResult==0) {
					//True balik ke auth view
					dispose();
					AuthView a = new AuthView();
					a.setVisible(true);
				}else {
					//False tidak ingin keluar				
				}
			}
		});
		btnLogout.setBounds(10, 358, 143, 36);
		menuPanel.add(btnLogout);
		
		JLabel logo1Lbl = new JLabel("PurpleLane");
		logo1Lbl.setFont(new Font("Century", Font.ITALIC, 20));
		logo1Lbl.setBounds(10, 25, 115, 50);
		menuPanel.add(logo1Lbl);
		
		JLabel logo2Lbl = new JLabel("Bookstore");
		logo2Lbl.setFont(new Font("Century", Font.ITALIC, 20));
		logo2Lbl.setBounds(58, 67, 95, 25);
		menuPanel.add(logo2Lbl);
		
		mainPanel = new JPanel();
		mainPanel.setBackground(new Color(0, 255, 255));
		mainPanel.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 255, 255), new Color(255, 255, 255), new Color(255, 255, 255), new Color(255, 255, 255)));
		mainPanel.setBounds(183, 11, 644, 459);
		bodyPanel.add(mainPanel);
		mainPanel.setLayout(new CardLayout(0, 0));
		
		homePanel = new Panel();
		homePanel.setFont(new Font("Arial Black", Font.BOLD, 14));
		homePanel.setBackground(new Color(60, 179, 113));
		mainPanel.add(homePanel, "name_880672469796400");
		homePanel.setLayout(null);
		
		Label menuLabel = new Label("MENU HOME");
		menuLabel.setFont(new Font("Arial Black", Font.BOLD, 14));
		menuLabel.setBounds(10, 10, 95, 45);
		homePanel.add(menuLabel);
		
		bookPanel = new Panel();
		bookPanel.setBackground(new Color(255, 192, 203));
		mainPanel.add(bookPanel, "name_881002896137600");
		bookPanel.setLayout(null);
		
		Label bookLabel = new Label("Books Menu");
		bookLabel.setFont(new Font("Arial Black", Font.BOLD, 14));
		bookLabel.setBounds(10, 10, 125, 38);
		bookPanel.add(bookLabel);
		
		cartPanel = new Panel();
		cartPanel.setBackground(new Color(119, 136, 153));
		mainPanel.add(cartPanel, "name_881133832908100");
		cartPanel.setLayout(null);
		
		Label cartLabel = new Label("List of your cart");
		cartLabel.setFont(new Font("Arial Black", Font.BOLD, 14));
		cartLabel.setBounds(10, 10, 183, 50);
		cartPanel.add(cartLabel);
	}
}
