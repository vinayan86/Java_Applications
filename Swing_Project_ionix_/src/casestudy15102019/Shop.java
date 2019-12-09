package casestudy15102019;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Shop {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		ConnectionManager cn = new ConnectionManager();
		cn.Connections();

		JFrame f = new JFrame("Login Form...");
		JButton a = new JButton("Admin/Agent");
	
		JButton c = new JButton("Exit");
		a.setBounds(70, 200, 150, 30);

		c.setBounds(280, 200, 90, 30);
	
		f.add(a);
		f.add(c);
		Container ctn = f.getContentPane();
		ctn.setBackground(Color.white);
		f.setSize(500, 500);
		f.setLayout(null);
		ImageIcon bg = new ImageIcon("C:\\Users\\User\\Downloads\\fb.jpg");
		JLabel bgl = new JLabel("", bg, JLabel.CENTER);
		bgl.setBounds(0, 0, 500, 500);
		f.add(bgl);
		f.setVisible(true);

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int k = JOptionPane.showConfirmDialog(f, "Do you want to leave");
				if (k == 0)
					f.dispose();
			}
		});
		a.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Login l = new Login();
				f.dispose();
				try {
					l.checkValid();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

	}

}
