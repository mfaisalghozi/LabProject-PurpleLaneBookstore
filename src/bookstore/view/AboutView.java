package bookstore.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Label;
import java.awt.Color;

public class AboutView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AboutView frame = new AboutView();
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
	public AboutView() {
		setTitle("Tentang Aplikasi");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel = new Panel();
		panel.setBackground(new Color(230, 230, 250));
		panel.setBounds(0, 0, 434, 261);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel thanksLbl = new JLabel("Thank You For Using This Application !");
		thanksLbl.setFont(new Font("Tahoma", Font.BOLD, 20));
		thanksLbl.setBounds(10, 29, 414, 59);
		panel.add(thanksLbl);
		
		Label versionLbl = new Label("Bookstore PurpleLane V.1");
		versionLbl.setBounds(142, 82, 168, 22);
		panel.add(versionLbl);
		
		Label developerLbl = new Label("Developed By MFaisalGhozi");
		developerLbl.setBounds(142, 197, 168, 22);
		panel.add(developerLbl);
	}
}
