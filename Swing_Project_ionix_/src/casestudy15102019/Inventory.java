package casestudy15102019;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Inventory {

	public void purchase(int id) throws ClassNotFoundException, SQLException {

		JFrame f = new JFrame("Purchase Product");
		JButton b = new JButton("purchase");
		JButton bc = new JButton("Purchase view");
		JButton bd = new JButton("Sell view");
		JButton in = new JButton("Logout");
		b.setBounds(20, 400, 90, 30);
		bc.setBounds(120, 400, 140, 30);
		bd.setBounds(280, 400, 140, 30);
		in.setBounds(440, 400, 90, 30);
		f.add(b);
		f.add(in);
		f.add(bc);
		f.add(bd);
		JLabel l1, l2, l3, l4, l5, l6, l7;
		l1 = new JLabel("Product Name :");
		l1.setBounds(50, 100, 100, 30);
		l2 = new JLabel("Transaction:");
		l2.setBounds(50, 140, 100, 30);
		l3 = new JLabel("price:");
		l3.setBounds(50, 180, 100, 30);
		l4 = new JLabel("Quanty :");
		l4.setBounds(50, 220, 100, 30);
		l5 = new JLabel("Total :");
		l5.setBounds(50, 260, 100, 30);

		f.add(l1);
		f.add(l2);
		f.add(l3);
		f.add(l4);
		f.add(l5);
		l1.setForeground(Color.white);
		l2.setForeground(Color.white);
		l3.setForeground(Color.white);
		l4.setForeground(Color.white);
		l5.setForeground(Color.white);
		
		
		JComboBox t1, t2;

		t1 = new JComboBox();
		t1.setBounds(180, 100, 200, 30);
		f.add(t1);

		t2 = new JComboBox();
		t2.setBounds(180, 140, 200, 30);
		f.add(t2);
		JTextField t3, t4, t6;
		t6 = new JTextField();
		t6.setBounds(180, 180, 200, 30);
		f.add(t6);
		t3 = new JTextField();
		t3.setBounds(180, 220, 200, 30);
		f.add(t3);
		t4 = new JTextField();
		t4.setBounds(180, 260, 200, 30);
		f.add(t4);
		JTextField t7 = new JTextField();
		JTextField t8 = new JTextField();
		JTextField t5 = new JTextField();
		t1.addItem("Select Product");
		ConnectionManager cn = new ConnectionManager();
		Statement st = null;
		st = cn.Connections().createStatement();
		String s = "select * from product";
		ResultSet rs = st.executeQuery(s);
		while (rs.next()) {
			String pname = rs.getString("pname");
			
			t1.addItem(pname);

		}
		t2.addItem("Buy");
		t2.addItem("Sell");
		Container c = f.getContentPane();
		c.setBackground(Color.white);
		f.setSize(600, 600);
		f.setLayout(null);

		ImageIcon bg = new ImageIcon("C:\\Users\\User\\Downloads\\fb.jpg");
		JLabel bgl = new JLabel("", bg, JLabel.CENTER);
		bgl.setBounds(0, 0, 600, 600);
		f.add(bgl);
		f.setVisible(true);

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		in.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int k = JOptionPane.showConfirmDialog(f, "Do you want to leave");
				if (k == 0)
					f.dispose();

			}
		});
		t2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String kh = (String) t2.getSelectedItem();
				if (kh.equalsIgnoreCase("sell")) {
					t4.setVisible(false);
					l5.setVisible(false);
					b.setText("SELL");
				} else {
					t4.setVisible(true);
					l5.setVisible(true);
					b.setText("purchase");
				}

			}
		});

		t1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String k = (String) t1.getSelectedItem();

				String s = "select * from product where pname = '" + k + "'";
				System.out.println(s);
				try {
					ConnectionManager cn = new ConnectionManager();
					Statement st = null;
					st = cn.Connections().createStatement();
					ResultSet rs = st.executeQuery(s);
					while (rs.next()) {
						int pr = rs.getInt("price");
						t6.setText("" + pr);

					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});

		bc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				BuySell bs = new BuySell();
				try {
					bs.viewBuySell(id);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		bd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String lk = (String) t2.getSelectedItem();

				SellBuy sb = new SellBuy();
				try {

					sb.SellBuy(id);

				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		t3.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent arg0) {
				String k = (String) t1.getSelectedItem();

				String s = "select * from product where pname = '" + k + "'";
				System.out.println(s);
				try {
					ConnectionManager cn = new ConnectionManager();
					Statement st = null;
					st = cn.Connections().createStatement();
					ResultSet rs = st.executeQuery(s);
					while (rs.next()) {
						int pr = rs.getInt("price");
						int pid = rs.getInt("pid");
						int qty = rs.getInt("qty");

						t5.setText("" + pid);
						t7.setText("" + qty);
						int q = Integer.parseInt(t3.getText());

						int tot = pr * q;
						t4.setText("" + tot);

					}

				} catch (SQLException | ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				t8.setText("" + id);

				int pid = Integer.parseInt(t5.getText());
				int q = Integer.parseInt(t3.getText());
				int tot = Integer.parseInt(t4.getText());
				int qty = Integer.parseInt(t7.getText());
				int uid = Integer.parseInt(t8.getText());
				String trtype = (String) t2.getSelectedItem();
				ConnectionManager cn = new ConnectionManager();
				Statement kl = null;
				try {
					kl = cn.Connections().createStatement();
				} catch (ClassNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				Date tdate=new Date();
				if (trtype.equalsIgnoreCase("buy")) {

					int jh = qty - q;

					try {
						if (jh < 0) {
							JOptionPane.showMessageDialog(f, "Quantity not available");
						} else {
						
							String sql = "insert into inventory(pid,agntid,total,trtype,inqty,tdate) values('" + pid + "','"
									+ uid + "','" + tot + "','" + trtype + "','" + q + "','"+tdate+"')";
							System.out.println(sql);
							kl.executeUpdate(sql);
							JOptionPane.showMessageDialog(f, "Product added Sucessfully");

							kl.executeUpdate("update product set qty=qty-'" + q + "' where pid='" + pid + "'");
						}

					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

				else if (trtype.equalsIgnoreCase("Sell")) {
					String s2 = "insert into inventory(pid,agntid,total,trtype,inqty,tdate) values('" + pid + "','" + uid
							+ "','" + tot + "','" + trtype + "','" + q + "','"+tdate+"')";
					System.out.println(s);
					try {

						kl.executeUpdate(s2);
						String s3 = "update product set qty=qty +'" + q + "' where pid='" + pid + "'";
						System.out.println(s3);
						kl.executeUpdate(s3);
						JOptionPane.showMessageDialog(f, "Product Sell Sucessfully");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			}
		});
	}

	public void purchaseDetails() throws ClassNotFoundException, SQLException {

		ConnectionManager cn = new ConnectionManager();
		Statement st = null;
		st = cn.Connections().createStatement();

		JFrame f = new JFrame("Purchase Details...");

		String[] columnNames = { "Id", "Agent Name", "Product", "Transcation Type", "qty", "price", "Total" };
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columnNames);
		// DefaultTableModel model = new DefaultTableModel(tm.getData1(),
		// tm.getColumnNames());
		// table = new JTable(model);
		JTable table = new JTable();
		table.setModel(model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setFillsViewportHeight(true);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

		String s1 = "SELECT * FROM inventory as i,product as p,logindetails as l WHERE i.pid=p.pid and l.id=i.agntid";
		System.out.println(s1);
		ResultSet rs1 = null;
		try {
			rs1 = st.executeQuery(s1);
			int i = 0;
			while (rs1.next()) {
				int pid = rs1.getInt("invid");
				String uname = rs1.getString("uname");
				String name = rs1.getString("pname");
				String trtype = rs1.getString("trtype");
				int qty = rs1.getInt("inqty");
				int price = rs1.getInt("price");
				int total = rs1.getInt("total");

				model.addRow(new Object[] { pid, uname, name, trtype, qty, price, total });
				i++;

			}
			if (i < 1) {
				JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);
			}
			if (i == 1) {
				System.out.println(i + " Record Found");
			} else {
				System.out.println(i + " Records Found");
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		f.add(scroll);
		f.setVisible(true);
		f.setSize(400, 300);
	}
}
