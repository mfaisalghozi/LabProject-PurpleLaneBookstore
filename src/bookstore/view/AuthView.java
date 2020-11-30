package bookstore.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import bookstore.controller.HomeController;
import bookstore.model.User;

import java.awt.Panel;
import java.awt.Color;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.CardLayout;

public class AuthView extends JFrame {

	private JPanel contentPane;
	private JTextField registerUsernameField;
	private JTextField registerPasswordField;
	private JTextField registerEmailField;
	private JTextField loginUsernameField;
	private JTextField loginPasswordField;
	private JPanel loginPanel;
	private Panel mainPanel;
	private Panel registerPanel;
	private HomeController home = new HomeController();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AuthView frame = new AuthView();
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
	public AuthView() {
		setTitle("Purple Lane Bookstore");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 856, 521);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel menuPanel = new Panel();
		menuPanel.setBackground(new Color(169, 169, 169));
		menuPanel.setBounds(0, 0, 252, 482);
		contentPane.add(menuPanel);
		menuPanel.setLayout(null);
		
		JLabel logo1Lbl = new JLabel("PurpleLane");
		logo1Lbl.setFont(new Font("Century", Font.ITALIC, 20));
		logo1Lbl.setBounds(38, 38, 146, 52);
		menuPanel.add(logo1Lbl);
		
		JLabel logo2Lbl = new JLabel("Bookstore");
		logo2Lbl.setFont(new Font("Century", Font.ITALIC, 20));
		logo2Lbl.setBounds(96, 79, 146, 34);
		menuPanel.add(logo2Lbl);
		
		Button btnMenuRegister = new Button("Register");
		btnMenuRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//remove Panel
				mainPanel.removeAll();
				mainPanel.repaint();
				mainPanel.revalidate();
				
				//add panel
				mainPanel.add(registerPanel);
				mainPanel.repaint();
				mainPanel.revalidate();
			}
		});
		btnMenuRegister.setForeground(new Color(0, 0, 0));
		btnMenuRegister.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		btnMenuRegister.setBackground(new Color(211, 211, 211));
		btnMenuRegister.setBounds(38, 338, 177, 44);
		menuPanel.add(btnMenuRegister);
		
		Button btnMenuLogin = new Button("Login");
		btnMenuLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//remove Panel
				mainPanel.removeAll();
				mainPanel.repaint();
				mainPanel.revalidate();
				
				//add panel
				mainPanel.add(loginPanel);
				mainPanel.repaint();
				mainPanel.revalidate();
			}
		});
		btnMenuLogin.setForeground(Color.BLACK);
		btnMenuLogin.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		btnMenuLogin.setBackground(new Color(211, 211, 211));
		btnMenuLogin.setBounds(38, 267, 177, 44);
		menuPanel.add(btnMenuLogin);
		
		Button btnMenuExit = new Button("Exit");
		btnMenuExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int dialogBtn = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog(null, "Apakah yakin ingin logged out ?", "Peringatan", dialogBtn);
				
				if(dialogResult == 0) {
					//True balik ke auth view
					System.exit(0);
				}else {
					//False tidak ingin keluar				
				}
			}
		});
		btnMenuExit.setForeground(Color.BLACK);
		btnMenuExit.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		btnMenuExit.setBackground(new Color(211, 211, 211));
		btnMenuExit.setBounds(38, 403, 177, 44);
		menuPanel.add(btnMenuExit);
		
		mainPanel = new Panel();
		mainPanel.setBackground(new Color(188, 143, 143));
		mainPanel.setBounds(253, 0, 587, 482);
		contentPane.add(mainPanel);
		mainPanel.setLayout(new CardLayout(0, 0));
		
		registerPanel = new Panel();
		registerPanel.setBackground(new Color(205, 92, 92));
		mainPanel.add(registerPanel, "name_897138540706100");
		registerPanel.setLayout(null);
		
		Button btnSignup = new Button("Signup");
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String registerUsername = registerUsernameField.getText();
				String registerPassword = registerPasswordField.getText();
				String registerEmail = registerEmailField.getText();
				
				boolean reg = home.Register(registerUsername, registerPassword, registerEmail);
				
				if(reg == true) {
					JOptionPane.showMessageDialog(btnSignup, "Register Complete !");
					//remove Panel
					mainPanel.removeAll();
					mainPanel.repaint();
					mainPanel.revalidate();
					
					//add panel
					mainPanel.add(loginPanel);
					mainPanel.repaint();
					mainPanel.revalidate();
				}else {
					JOptionPane.showMessageDialog(btnSignup, "Please fill all the form");
				}
			}
		});
		btnSignup.setForeground(Color.WHITE);
		btnSignup.setFont(new Font("Arial Black", Font.BOLD, 14));
		btnSignup.setBackground(new Color(220, 20, 60));
		btnSignup.setBounds(121, 366, 331, 45);
		registerPanel.add(btnSignup);
		
		registerUsernameField = new JTextField();
		registerUsernameField.setColumns(10);
		registerUsernameField.setBounds(121, 130, 331, 31);
		registerPanel.add(registerUsernameField);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(121, 160, 331, 2);
		registerPanel.add(separator);
		
		JLabel usernameLbl = new JLabel("USERNAME");
		usernameLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		usernameLbl.setBounds(121, 98, 149, 31);
		registerPanel.add(usernameLbl);
		
		registerPasswordField = new JPasswordField();
		registerPasswordField.setColumns(10);
		registerPasswordField.setBounds(121, 202, 331, 31);
		registerPanel.add(registerPasswordField);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(121, 232, 331, 2);
		registerPanel.add(separator_1);
		
		JLabel passwordLbl = new JLabel("PASSWORD");
		passwordLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passwordLbl.setBounds(121, 172, 149, 31);
		registerPanel.add(passwordLbl);
		
		JLabel lblNewLabel = new JLabel("Register Account");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 17));
		lblNewLabel.setBounds(10, 11, 567, 53);
		registerPanel.add(lblNewLabel);
		
		registerEmailField = new JTextField();
		registerEmailField.setColumns(10);
		registerEmailField.setBounds(121, 272, 331, 31);
		registerPanel.add(registerEmailField);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(121, 302, 331, 2);
		registerPanel.add(separator_1_1);
		
		JLabel emailLbl = new JLabel("EMAIL");
		emailLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		emailLbl.setBounds(121, 244, 149, 31);
		registerPanel.add(emailLbl);
		
		loginPanel = new JPanel();
		loginPanel.setBackground(new Color(210, 180, 140));
		mainPanel.add(loginPanel, "name_897138553120800");
		loginPanel.setLayout(null);
		
		Button btnLogin = new Button("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String loginUsername = loginUsernameField.getText();
				String loginPassword = loginPasswordField.getText();
				boolean login = home.Login(loginUsername, loginPassword);
				if(login == true) {
					dispose();
					//if userRoleId == 1  => adminHomeView()
					//else if userRoleId == 2 => promotionHomeView()
					//else if userRoleId == 3 => managerHomeView()
					//else => HomeView()
					
					HomeView n = new HomeView();
					n.setVisible(true);
					JOptionPane.showMessageDialog(btnLogin, "You have successfully Logged in");
				}else {
					JOptionPane.showMessageDialog(btnLogin, "Wrong Password or Username");
				}
			}
		});
		btnLogin.setForeground(new Color(255, 245, 238));
		btnLogin.setFont(new Font("Arial Black", Font.BOLD, 14));
		btnLogin.setBackground(new Color(238, 130, 238));
		btnLogin.setBounds(121, 351, 331, 45);
		loginPanel.add(btnLogin);
		
		loginUsernameField = new JTextField();
		loginUsernameField.setColumns(10);
		loginUsernameField.setBounds(121, 149, 331, 31);
		loginPanel.add(loginUsernameField);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(121, 179, 331, 2);
		loginPanel.add(separator_2);
		
		JLabel usernameLbl_1 = new JLabel("USERNAME");
		usernameLbl_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		usernameLbl_1.setBounds(121, 107, 149, 31);
		loginPanel.add(usernameLbl_1);
		
		loginPasswordField = new JTextField();
		loginPasswordField.setColumns(10);
		loginPasswordField.setBounds(121, 246, 331, 31);
		loginPanel.add(loginPasswordField);
		
		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setBounds(121, 276, 331, 2);
		loginPanel.add(separator_1_2);
		
		JLabel passwordLbl_1 = new JLabel("PASSWORD");
		passwordLbl_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passwordLbl_1.setBounds(121, 204, 149, 31);
		loginPanel.add(passwordLbl_1);
		
		JLabel loginLbl = new JLabel("Login Account");
		loginLbl.setHorizontalAlignment(SwingConstants.CENTER);
		loginLbl.setFont(new Font("Arial", Font.BOLD, 17));
		loginLbl.setBounds(10, 11, 567, 53);
		loginPanel.add(loginLbl);
	}
}
