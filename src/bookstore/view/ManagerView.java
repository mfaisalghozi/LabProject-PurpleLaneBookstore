package bookstore.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bookstore.controller.TransactionController;
import bookstore.controller.UserController;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.Panel;
import java.awt.Label;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Component;
import java.awt.Button;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Enumeration;
import java.util.Vector;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManagerView extends JFrame {

	private JPanel BodyPanel;
	private JTextField userIdTxtField;
	private JTextField userRoleIdTxtField;
	private JTextField usernameTxtField;
	private JPanel mainPanel;
	private TransactionController tc;
	private UserController uc;
	private Vector<Object> headerTransaction;
	private Vector<Object> headerUser;
	private Vector<Object> trans;
	private DefaultTableModel dtm;
	private JTable financialTable;
	private Panel financialPanel;
	private Panel staffPanel;

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
	
	public void getTransaction() {
		trans = null;
		dtm = new DefaultTableModel(headerTransaction, 0);
		trans = tc.getAllTransaction();
		Enumeration<Object> n = trans.elements();
		while(n.hasMoreElements()) {
			dtm.addRow((Vector<?>) n.nextElement());
		}
		financialTable.setModel(dtm);
	}
	
	
	/**
	 * Create the frame.
	 */
	public ManagerView() {
		tc = new TransactionController();
		uc = new UserController();
		defaultView();
		getTransaction();
	}
	
	void defaultView() {
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
		btnFinancialReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainPanel.removeAll();
				mainPanel.repaint();
				mainPanel.revalidate();
				
				//add panel
				mainPanel.add(financialPanel);
				mainPanel.repaint();
				mainPanel.revalidate();
			}
		});
		btnFinancialReport.setBounds(282, 11, 154, 39);
		menuPanel.add(btnFinancialReport);
		
		JButton btnStaff = new JButton("Staff");
		btnStaff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainPanel.removeAll();
				mainPanel.repaint();
				mainPanel.revalidate();
				
				//add panel
				mainPanel.add(staffPanel);
				mainPanel.repaint();
				mainPanel.revalidate();
			}
		});
		btnStaff.setBounds(477, 10, 154, 39);
		menuPanel.add(btnStaff);
		
		mainPanel = new JPanel();
		mainPanel.setBackground(Color.WHITE);
		mainPanel.setBounds(10, 91, 879, 375);
		BodyPanel.add(mainPanel);
		mainPanel.setLayout(new CardLayout(0, 0));
		
		financialPanel = new Panel();
		financialPanel.setLayout(null);
		financialPanel.setBackground(new Color(255, 192, 203));
		mainPanel.add(financialPanel, "name_226754023375100");
		
		Label financialLabel = new Label("Financial Report Menu");
		financialLabel.setFont(new Font("Arial Black", Font.BOLD, 14));
		financialLabel.setBounds(10, 10, 173, 24);
		financialPanel.add(financialLabel);
		
		Panel financialReportPanel = new Panel();
		financialReportPanel.setLayout(null);
		financialReportPanel.setBackground(Color.WHITE);
		financialReportPanel.setBounds(10, 40, 859, 300);
		financialPanel.add(financialReportPanel);
		
		headerTransaction = new Vector<>();
		headerTransaction.add("productId");
		headerTransaction.add("transactionId");
		headerTransaction.add("transactionQty");
		headerTransaction.add("transactionType");
		headerTransaction.add("Card Number");
		dtm = new DefaultTableModel(headerTransaction, 0);
		financialTable = new JTable(dtm);
		
	
		JScrollPane sp_financial = new JScrollPane(financialTable);
		sp_financial.setBounds(0, 0, 859, 301);
		financialReportPanel.add(sp_financial);
		
		staffPanel = new Panel();
		staffPanel.setLayout(null);
		staffPanel.setBackground(Color.ORANGE);
		mainPanel.add(staffPanel, "name_226830113942400");
		
		Label userLabel = new Label("User List");
		userLabel.setFont(new Font("Arial Black", Font.BOLD, 14));
		userLabel.setBounds(10, 10, 92, 24);
		staffPanel.add(userLabel);
		
		Panel staffListPanel = new Panel();
		staffListPanel.setLayout(null);
		staffListPanel.setBackground(Color.WHITE);
		staffListPanel.setBounds(10, 40, 859, 325);
		staffPanel.add(staffListPanel);
		
		JScrollPane sp_user = new JScrollPane((Component) null);
		sp_user.setBounds(0, 0, 859, 195);
		staffListPanel.add(sp_user);
		
		Panel staffSetttingPanel = new Panel();
		staffSetttingPanel.setLayout(null);
		staffSetttingPanel.setBackground(Color.GRAY);
		staffSetttingPanel.setBounds(0, 195, 859, 138);
		staffListPanel.add(staffSetttingPanel);
		
		Button btnAddBook_1 = new Button("Add Staff");
		btnAddBook_1.setActionCommand("Add New Book");
		btnAddBook_1.setBounds(193, 84, 125, 33);
		staffSetttingPanel.add(btnAddBook_1);
		
		userIdTxtField = new JTextField();
		userIdTxtField.setColumns(10);
		userIdTxtField.setBounds(256, 11, 167, 20);
		staffSetttingPanel.add(userIdTxtField);
		
		JLabel userIdLbl = new JLabel("User ID");
		userIdLbl.setForeground(Color.WHITE);
		userIdLbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		userIdLbl.setBounds(152, 14, 94, 17);
		staffSetttingPanel.add(userIdLbl);
		
		JLabel userRoleIdLbl = new JLabel("User Role ID");
		userRoleIdLbl.setForeground(Color.WHITE);
		userRoleIdLbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		userRoleIdLbl.setBounds(152, 43, 72, 17);
		staffSetttingPanel.add(userRoleIdLbl);
		
		userRoleIdTxtField = new JTextField();
		userRoleIdTxtField.setColumns(10);
		userRoleIdTxtField.setBounds(256, 42, 167, 20);
		staffSetttingPanel.add(userRoleIdTxtField);
		
		Button btnUpdateBook_1 = new Button("Update User");
		btnUpdateBook_1.setBounds(377, 84, 125, 33);
		staffSetttingPanel.add(btnUpdateBook_1);
		
		Button btnDeleteBook_1 = new Button("Delete Staff");
		btnDeleteBook_1.setBounds(570, 84, 125, 33);
		staffSetttingPanel.add(btnDeleteBook_1);
		
		usernameTxtField = new JTextField();
		usernameTxtField.setColumns(10);
		usernameTxtField.setBounds(558, 11, 167, 20);
		staffSetttingPanel.add(usernameTxtField);
		
		JLabel lblProductStock_1 = new JLabel("Username");
		lblProductStock_1.setForeground(Color.WHITE);
		lblProductStock_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblProductStock_1.setBounds(454, 14, 94, 17);
		staffSetttingPanel.add(lblProductStock_1);
	}
	
}
