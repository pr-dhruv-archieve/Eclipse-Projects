package mp.feereport.frames;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class FeeReport extends JFrame {
	
	private static FeeReport frame;
	private JPanel contentPanel;
	
	/*
	 * Creating Frame
	 */
	public FeeReport() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		contentPanel = new JPanel();
		contentPanel.setBackground(Color.DARK_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		
		JLabel labelFeeeport = new JLabel("Fee Report");
		labelFeeeport.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btnAdminLogin = new JButton("Admin Login");
		btnAdminLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminLogin.main(new String[]{});
				frame.dispose();
			}
		});
		
		JButton btnAccountantLogin = new JButton("Accountant Login");
		btnAccountantLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AccountantLogin.main(new String[]{});
				frame.dispose();
			}
		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPanel);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(143)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(btnAccountantLogin,  Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
												.addComponent(btnAdminLogin, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
												.addComponent(labelFeeeport)))
								.addContainerGap(210, Short.MAX_VALUE))
				);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(labelFeeeport)
						.addGap(42)
						.addComponent(btnAdminLogin, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addGap(30)
						.addComponent(btnAccountantLogin, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(91, Short.MAX_VALUE))
			);
		contentPanel.setLayout(gl_contentPane);
		
	}
	
	public static FeeReport createInstance() {
		if (frame == null)
			return new FeeReport();
		else
			return frame;
	}
	
	
}
