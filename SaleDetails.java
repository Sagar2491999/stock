import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.*;
import java.sql.*;


class SaleDetails1 
{
Frame f;
Label l1;
JTable jt;
DefaultTableModel model;
Connection con;
PreparedStatement st;
ResultSet rs;
int quantity,snumber;
float sp;
String itemcode,itemname,description,date,customername,mobile;

SaleDetails1()
{
f=new Frame("Sale Details");
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

l1=new Label("Sale Details");
l1.setFont(f1);
l1.setBounds(250,50,310,40);
f.add(l1);

String heads[]={"Date","Customer Name","Mobile","Item Code","Item Name","Description","Quantity","saleprice","sellingno"};

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
st=con.prepareStatement("select * from sale");
rs=st.executeQuery();
while(rs.next())
{
date=rs.getString(1);
customername=rs.getString(2);
mobile=rs.getString(3);	
itemcode=rs.getString(4);
itemname=rs.getString(5);
description=rs.getString(6);
quantity=rs.getInt(7);
sp=rs.getFloat(8);
snumber=rs.getInt(9);
model.addRow(new Object[]{date,customername,mobile,itemcode,itemname,description,quantity,sp,snumber});
}
}
catch(Exception e)
{
System.out.print(e);
}
f.setVisible(true);
}


}

class SaleDetails
{
public static void main(String[] s)
{
SaleDetails1 cd=new SaleDetails1();
}
}