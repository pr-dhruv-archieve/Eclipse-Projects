package mp.feereport.frames;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;

public class AdminLogin extends JFrame{
	
	private static AdminLogin frame;
	
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	
	/*
	 * Create the frame
	 */
	
	public AdminLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel labelAdminLogin = new JLabel("Admin Login");
		labelAdminLogin.setBackground(Color.DARK_GRAY);
		labelAdminLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel labelName = new JLabel("User Name : ");
		JLabel labelPassword = new JLabel("Password : ");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String uname = textField.getText();
				String password = new String(passwordField.getPassword());
				
				if (uname.equals("admin") && password.equals("admin123")) {
					AdminSection.main(new String[]{});
					frame.dispose();
				}
				else {
					JOptionPane.showMessageDialog(AdminLogin.this, "Sorry!!! Invalid user-id or password");
					textField.setText("");
					passwordField.setText("");
				}
			}
		});
		
		GroupLayout gl = new GroupLayout(contentPane);
		gl.setHorizontalGroup(
				gl.createParallelGroup(Alignment.LEADING)
					.addGroup(gl.createSequentialGroup()
						.addGroup(gl.createParallelGroup(Alignment.LEADING)
							.addGroup(gl.createSequentialGroup()
								.addGap(180)
								.addComponent(labelAdminLogin))
							.addGroup(gl.createSequentialGroup()
								.addGap(25)
								.addGroup(gl.createParallelGroup(Alignment.LEADING)
									.addComponent(labelName)
									.addComponent(labelPassword))
								.addGap(58)
								.addGroup(gl.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(passwordField)
									.addComponent(textField, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)))
							.addGroup(gl.createSequentialGroup()
								.addGap(177)
								.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(111, Short.MAX_VALUE))
			);
			gl.setVerticalGroup(
				gl.createParallelGroup(Alignment.LEADING)
					.addGroup(gl.createSequentialGroup()
						.addComponent(labelAdminLogin)
						.addGap(29)
						.addGroup(gl.createParallelGroup(Alignment.BASELINE)
							.addComponent(labelName)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(27)
						.addGroup(gl.createParallelGroup(Alignment.BASELINE)
							.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(labelPassword))
						.addGap(36)
						.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(51, Short.MAX_VALUE))
			);
			contentPane.setLayout(gl);
		
	}
	
	public static AdminLogin createInstance() {
		if (frame == null)
			return new AdminLogin();
		else
			return frame;
	}
	
}
