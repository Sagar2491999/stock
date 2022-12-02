import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.*;
import java.sql.*;


class PurchaseDetails1 
{
Frame f;
Label l1;
JTable jt;
DefaultTableModel model;
Connection con;
PreparedStatement st;
ResultSet rs;
int quantity;
String itemcode,dateofpurchase;
Float costprice,profit,saleprice;

PurchaseDetails1()
{
f=new Frame("Purchase Details");
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

l1=new Label("Purchase Details");
l1.setFont(f1);
l1.setBounds(150,50,300,30);
f.add(l1);

String heads[]={"Item Code","Quantity","Cost Price","Profit","Sale Price","Date of Purchase"};

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
st=con.prepareStatement("select * from purchase");
rs=st.executeQuery();
while(rs.next())
{
itemcode=rs.getString(1);
quantity=rs.getInt(2);
costprice=rs.getFloat(3);
profit=rs.getFloat(4);
saleprice=rs.getFloat(5);
dateofpurchase=rs.getString(6);
model.addRow(new Object[]{itemcode,quantity,costprice,profit,saleprice,dateofpurchase});
}
}
catch(Exception e)
{
System.out.print(e);
}
f.setVisible(true);
}


}

class PurchaseDetails
{
public static void main(String[] s)
{
PurchaseDetails1 cd=new PurchaseDetails1();
}
}