package casestudy15102019;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.sql.Statement;

public class Login {

	public void checkValid() throws ClassNotFoundException, SQLException {

		JFrame l = new JFrame("Login Form...");

		JButton b = new JButton("Login");
		b.setBounds(180, 300, 90, 30);

		l.add(b);
		JLabel us, pass, result;
		us = new JLabel("User Name :");
		us.setBounds(50, 180, 100, 30);
		pass = new JLabel("Password :");
		l.add(us);
		l.add(pass);
		us.setForeground(Color.white);
		pass.setForeground(Color.white);
		pass.setBounds(50, 220, 100, 30);

		JTextField tus, tpass;
		tus = new JTextField();
		tus.setBounds(180, 180, 200, 30);
		l.add(tus);
		tpass = new JPasswordField();
		tpass.setBounds(180, 220, 200, 30);
		l.add(tpass);
		result = new JLabel();
		result.setBounds(180, 240, 200, 30);
		l.setSize(500, 500);
		l.setLayout(null);

		ImageIcon bg = new ImageIcon("C:\\Users\\User\\Downloads\\fb.jpg");
		JLabel bgl = new JLabel("", bg, JLabel.CENTER);
		bgl.setBounds(0, 0, 500, 500);
		l.add(bgl);
		l.setVisible(true);

		l.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ConnectionManager cn = new ConnectionManager();
				Statement st = null;
				try {
					st = cn.Connections().createStatement();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//Check the login details correct or Not
				String un = tus.getText();
				String pw = tpass.getText();
				String s = "select type,id from logindetails where uname='" + un + "' and pass='" + pw + "'";
				//System.out.println(s);
			
				ResultSet usfetch = null;
				try {
					usfetch = st.executeQuery(s);
					while (usfetch.next()) {
						int ty = usfetch.getInt("type");    //Get User Type
						int id = usfetch.getInt("id");     //Get User Id
						
						if (ty == 1) {    //Check Type Admin 
							l.dispose();
							Product p = new Product();
							p.addProduct();
						} else if (ty == 0) {   //Check Type User
							l.dispose();
							Inventory i = new Inventory();
							try {
								i.purchase(id);
							} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								JOptionPane.showMessageDialog(l, "User Name Or Password is incorrect");
							}
						}

					}
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(l, "User Name Or Password is incorrect");
				}

			}
		});

	}

}
