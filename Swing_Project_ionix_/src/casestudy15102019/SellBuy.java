package casestudy15102019;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class SellBuy {

	public void SellBuy(int id) throws ClassNotFoundException, SQLException {
		ConnectionManager cn = new ConnectionManager();
		Statement st = null;
		st = cn.Connections().createStatement();

		JFrame f = new JFrame("Purchase Details...");

		String[] columnNames = { "Id", "Agent Name", "Product", "Transcation Type", "qty", "price" };
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

		System.out.println(id);
		String sell = "Sell";
		String s1 = "SELECT * FROM inventory as i,product as p,logindetails as l WHERE i.pid=p.pid and l.id=i.agntid and l.id=' "
				+ id + "' and trtype='" + sell + "' order by tdate desc";
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
