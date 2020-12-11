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
import java.awt.Panel;
import java.awt.Label;
import javax.swing.JScrollPane;
import java.awt.Component;
import java.awt.Button;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PromoTeamView extends JFrame {

	private CouponController cpn;
	private HomeController home;
	private JPanel contentPane;
	private JTextField couponCodeField;
	private JTextField textField_1;
	private JTextField couponDiscounTxtField;
	private JTextField couponNoteTxtField;
	Vector<Object> tHeader;
	Vector<Object> coupon;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PromoTeamView frame = new PromoTeamView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
//	Get Coupon Information from controller
	void getCoupon() {
		
	}
	
//	Fill coupon textField from selected row at table
	void fillCoupon() {
		
	}

	/**
	 * Create the frame.
	 */
	public PromoTeamView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 915, 536);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel bodyPanel = new JPanel();
		bodyPanel.setLayout(null);
		bodyPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		bodyPanel.setBounds(0, 0, 903, 500);
		contentPane.add(bodyPanel);
		
		JPanel menuPanel = new JPanel();
		menuPanel.setLayout(null);
		menuPanel.setBackground(Color.GREEN);
		menuPanel.setBounds(10, 11, 879, 61);
		bodyPanel.add(menuPanel);
		
		JLabel logo1Lbl = new JLabel("PurpleLane");
		logo1Lbl.setFont(new Font("Century", Font.ITALIC, 20));
		logo1Lbl.setBounds(251, 11, 107, 25);
		menuPanel.add(logo1Lbl);
		
		JLabel logo2Lbl = new JLabel("Bookstore for Promotion Team");
		logo2Lbl.setFont(new Font("Century", Font.ITALIC, 20));
		logo2Lbl.setBounds(302, 30, 304, 20);
		menuPanel.add(logo2Lbl);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(Color.WHITE);
		mainPanel.setBounds(10, 83, 879, 404);
		bodyPanel.add(mainPanel);
		mainPanel.setLayout(new CardLayout(0, 0));
		
		Panel couponPanel = new Panel();
		couponPanel.setLayout(null);
		couponPanel.setBackground(new Color(255, 192, 203));
		mainPanel.add(couponPanel, "name_59258227594400");
		
		Label couponLabel = new Label("Coupon Menu");
		couponLabel.setFont(new Font("Arial Black", Font.BOLD, 14));
		couponLabel.setBounds(10, 10, 125, 24);
		couponPanel.add(couponLabel);
		
		Panel couponListPanel = new Panel();
		couponListPanel.setLayout(null);
		couponListPanel.setBackground(Color.WHITE);
		couponListPanel.setBounds(10, 40, 859, 354);
		couponPanel.add(couponListPanel);
		
		JScrollPane sp = new JScrollPane((Component) null);
		sp.setBounds(0, 0, 859, 195);
		couponListPanel.add(sp);
		
		Panel couponSettingPanel = new Panel();
		couponSettingPanel.setLayout(null);
		couponSettingPanel.setBackground(Color.GRAY);
		couponSettingPanel.setBounds(0, 195, 859, 159);
		couponListPanel.add(couponSettingPanel);
		
		Button btnAddCoupon = new Button("Add Coupon");
		btnAddCoupon.setActionCommand("Add Coupon");
		btnAddCoupon.setBounds(191, 98, 125, 33);
		couponSettingPanel.add(btnAddCoupon);
		
		couponCodeField = new JTextField();
		couponCodeField.setColumns(10);
		couponCodeField.setBounds(208, 11, 167, 20);
		couponSettingPanel.add(couponCodeField);
		
		JLabel couponCodeLbl = new JLabel("Coupon Code");
		couponCodeLbl.setForeground(Color.WHITE);
		couponCodeLbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		couponCodeLbl.setBounds(104, 14, 94, 17);
		couponSettingPanel.add(couponCodeLbl);
		
		JLabel couponIdLbl = new JLabel("coupon ID");
		couponIdLbl.setForeground(Color.WHITE);
		couponIdLbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		couponIdLbl.setBounds(104, 42, 72, 17);
		couponSettingPanel.add(couponIdLbl);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(208, 42, 167, 20);
		couponSettingPanel.add(textField_1);
		
		Button btnUpdateCoupon = new Button("Update Coupon");
		btnUpdateCoupon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnUpdateCoupon.setBounds(377, 98, 125, 33);
		couponSettingPanel.add(btnUpdateCoupon);
		
		Button btnDeleteCoupon = new Button("Delete Coupon");
		btnDeleteCoupon.setBounds(570, 98, 125, 33);
		couponSettingPanel.add(btnDeleteCoupon);
		
		couponDiscounTxtField = new JTextField();
		couponDiscounTxtField.setColumns(10);
		couponDiscounTxtField.setBounds(528, 11, 167, 20);
		couponSettingPanel.add(couponDiscounTxtField);
		
		JLabel lblCouponDiscount = new JLabel("Coupon Discount");
		lblCouponDiscount.setForeground(Color.WHITE);
		lblCouponDiscount.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCouponDiscount.setBounds(409, 14, 114, 17);
		couponSettingPanel.add(lblCouponDiscount);
		
		couponNoteTxtField = new JTextField();
		couponNoteTxtField.setColumns(10);
		couponNoteTxtField.setBounds(528, 41, 167, 20);
		couponSettingPanel.add(couponNoteTxtField);
		
		JLabel lblCouponNote = new JLabel("Coupon Note");
		lblCouponNote.setForeground(Color.WHITE);
		lblCouponNote.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCouponNote.setBounds(409, 45, 94, 17);
		couponSettingPanel.add(lblCouponNote);
	}

}
