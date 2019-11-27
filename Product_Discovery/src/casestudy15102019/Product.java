package casestudy15102019;

import java.awt.Color;
import java.awt.Container;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Product {

	public void addProduct() {

		JFrame f = new JFrame("Add Product...");
		JButton b = new JButton("Add");
		JButton in = new JButton("inventory");
		JButton lb = new JButton("Logout");
		b.setBounds(120, 300, 90, 30);
		in.setBounds(220, 300, 90, 30);
		lb.setBounds(340, 300, 90, 30);
		f.add(b);
		f.add(in);
		f.add(lb);
		JLabel l1, l2, l3, l4, l5, l6, l7;
		l1 = new JLabel("Product Name :");
		l1.setBounds(50, 100, 100, 30);
		l2 = new JLabel("Min.sell Qty :");
		l2.setBounds(50, 140, 100, 30);
		l3 = new JLabel("Price :");
		l3.setBounds(50, 180, 100, 30);
		l1.setForeground(Color.white);
		l2.setForeground(Color.white);
		l3.setForeground(Color.white);
		f.add(l1);
		f.add(l2);
		f.add(l3);
		JTextField t1, t2, t3, t4, t5, t6, t7;
		t1 = new JTextField();
		t1.setBounds(180, 100, 200, 30);
		f.add(t1);

		t2 = new JTextField();
		t2.setBounds(180, 140, 200, 30);
		f.add(t2);
		t3 = new JTextField();
		t3.setBounds(180, 180, 200, 30);
		f.add(t3);
		Container c = f.getContentPane();
		c.setBackground(Color.white);
		f.setSize(500, 500);
		f.setLayout(null);

		ImageIcon bg = new ImageIcon("C:\\Users\\User\\Downloads\\fb.jpg");
		JLabel bgl = new JLabel("", bg, JLabel.CENTER);
		bgl.setBounds(0, 0, 500, 500);
		f.add(bgl);
		f.setVisible(true);

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		t1.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent arg0) {
				String k = t1.getText();
				ConnectionManager cn = new ConnectionManager();
				Statement st = null;
				String s = "select * from product where pname = '" + k + "'";
				try {
					st = cn.Connections().createStatement();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ResultSet rs;
				try {
					rs = st.executeQuery(s);
					if (rs.next()){
					
					JOptionPane.showMessageDialog(f, "Already Product Added");
					t1.setText("");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
			
			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		lb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int k = JOptionPane.showConfirmDialog(f, "Do you want to leave");
				if (k == 0)
					f.dispose();

			}
		});
		b.addActionListener(new ActionListener() {
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

				String pn = t1.getText();
				String qty = t2.getText();
				String price = t3.getText();
				String s = "insert into product(pname,qty,price) values('" + pn + "','" + qty + "','" + price + "')";
				// System.out.println(s);
				try {
					st.executeUpdate(s);
					JOptionPane.showMessageDialog(f, "Product added Sucessfully");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(f,"Please check you Entered Values...");
				}

			}
		});

		in.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Inventory i = new Inventory();
				try {
					i.purchaseDetails();
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
