package bookstore.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.CardLayout;

public class ManagerView extends JFrame {

	private JPanel BodyPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerView frame = new ManagerView();
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
	public ManagerView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 914, 516);
		BodyPanel = new JPanel();
		BodyPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(BodyPanel);
		BodyPanel.setLayout(null);
		
		JPanel menuPanel = new JPanel();
		menuPanel.setLayout(null);
		menuPanel.setBackground(Color.GREEN);
		menuPanel.setBounds(10, 11, 879, 61);
		BodyPanel.add(menuPanel);
		
		JLabel logo1Lbl = new JLabel("PurpleLane");
		logo1Lbl.setFont(new Font("Century", Font.ITALIC, 20));
		logo1Lbl.setBounds(10, 5, 107, 25);
		menuPanel.add(logo1Lbl);
		
		JLabel logo2Lbl = new JLabel("Bookstore");
		logo2Lbl.setFont(new Font("Century", Font.ITALIC, 20));
		logo2Lbl.setBounds(49, 25, 92, 25);
		menuPanel.add(logo2Lbl);
		
		JButton btnFinancialReport = new JButton("Financial Report");
		btnFinancialReport.setBounds(282, 11, 154, 39);
		menuPanel.add(btnFinancialReport);
		
		JButton btnStaff = new JButton("Staff");
		btnStaff.setBounds(477, 10, 154, 39);
		menuPanel.add(btnStaff);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(Color.WHITE);
		mainPanel.setBounds(10, 91, 879, 375);
		BodyPanel.add(mainPanel);
		mainPanel.setLayout(new CardLayout(0, 0));
	}

}
