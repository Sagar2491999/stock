import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.*;
import java.sql.*;

class EmployeeDetails1 
{
Frame f;
Label l1;
JTable jt;
DefaultTableModel model;
Connection con;
PreparedStatement st;
ResultSet rs;
int salary;
String id,nm,addr,designation,email,dateofjoin,phoneno;
//Double salary;

EmployeeDetails1()
{
f=new Frame("Employee Details");
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

l1=new Label("Employee Details");
l1.setFont(f1);
l1.setBounds(200,50,310,40);
f.add(l1);

String heads[]={"Employee ID","Name","Designation","Salary","Phone No.","Address","Email","Dateofjoin"};

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
st=con.prepareStatement("select * from empinfo");
rs=st.executeQuery();
while(rs.next())
{
id=rs.getString(1);
nm=rs.getString(2);
designation=rs.getString(3);
salary=rs.getInt(4);
phoneno=rs.getString(5);
addr=rs.getString(6);
email=rs.getString(7);
dateofjoin=rs.getString(8);
model.addRow(new Object[]{id,nm,designation,salary,phoneno,addr,email,dateofjoin});
}
}
catch(Exception e)
{
System.out.print(e);
}
f.setVisible(true);
}

}

class EmployeeDetails
{
public static void main(String[] s)
{
EmployeeDetails1 cd=new EmployeeDetails1();
}
}