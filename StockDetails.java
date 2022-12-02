import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.*;
import java.sql.*;


class StockDetails1 
{
Frame f;
Label l1;
JTable jt;
DefaultTableModel model;
Connection con;
PreparedStatement st;
ResultSet rs;
int quantity,reorderlevel;
String itemcode,itemname,itemdescription,date;
Float costprice,profit,saleprice;

StockDetails1()
{
f=new Frame("Stock Details");
f.setSize(700,700);
f.setLocationRelativeTo(null);
f.setResizable(false);
f.setLayout(null);
f.setForeground(Color.GREEN);
f.addWindowListener(new WindowAdapter()
{
	public void windowClosing(WindowEvent e)
		{
			f.dispose();
		}
}
);

Font f1=new Font("Arail",Font.BOLD,30);

l1=new Label("Stock Details");
l1.setFont(f1);
l1.setBounds(250,50,300,40);
f.add(l1);

String heads[]={"Item Code","Item Name","Item Description","Quantity","Reorder Level","Cost Price","Profit","Sale Price","Date"};

model=new DefaultTableModel();
model.setColumnIdentifiers(heads);

jt=new JTable();
jt.setModel(model);

JScrollPane sc=new JScrollPane(jt);
sc.setBounds(80,130,540,500);
f.add(sc);

try
{
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost/bca","root","");
st=con.prepareStatement("select * from iteminfo");
rs=st.executeQuery();
while(rs.next())
{
itemcode=rs.getString(1);
itemname=rs.getString(2);
itemdescription=rs.getString(3);
quantity=rs.getInt(4);
reorderlevel=rs.getInt(5);
costprice=rs.getFloat(6);
profit=rs.getFloat(7);
saleprice=rs.getFloat(8);
date=rs.getString(9);
model.addRow(new Object[]{itemcode,itemname,itemdescription,quantity,reorderlevel,costprice,profit,saleprice,date});
}
}
catch(Exception e)
{
System.out.print(e);
}
f.setVisible(true);
}


}

class StockDetails
{
public static void main(String[] s)
{
StockDetails1 cd=new StockDetails1();
}
}