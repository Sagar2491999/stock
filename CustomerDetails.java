import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.*;
import java.sql.*;


class CustomerDetails1 
{
Frame f;
Label l1;
JTable jt;
DefaultTableModel model;
Connection con;
PreparedStatement st;
ResultSet rs;
int id,phoneno;
String nm,addr,shopname;

CustomerDetails1()
{
f=new Frame("Customer Details");
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

l1=new Label("Customer Details");
l1.setFont(f1);
l1.setBounds(250,50,300,30);
f.add(l1);

String heads[]={"Customer ID","Name","Shop Name","Address","Phone No."};

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
st=con.prepareStatement("select * from custinfo");
rs=st.executeQuery();
while(rs.next())
{
id=rs.getInt(1);
nm=rs.getString(2);
shopname=rs.getString(3);
addr=rs.getString(4);
phoneno=rs.getInt(5);
model.addRow(new Object[]{id,nm,shopname,addr,phoneno});
}
}
catch(Exception e)
{
System.out.print(e);
}
f.setVisible(true);
}

}

class CustomerDetails
{
public static void main(String[] s)
{
CustomerDetails1 cd=new CustomerDetails1();
}
}