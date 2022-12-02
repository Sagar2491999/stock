import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
class NewEmployee extends Frame implements ActionListener
{
JLabel jl=new JLabel("Employee Details");
JLabel l1=new JLabel("Emoloyee ID");
JLabel l2=new JLabel("Employee Name");
JLabel l3=new JLabel("Designation");
JLabel l4=new JLabel("Salary");
JLabel l5=new JLabel("Phone No.");
JLabel l6=new JLabel("Address");
JLabel l7=new JLabel("E.Mail");
JLabel l8=new JLabel("Date_of_Joing");
JTextField t1=new JTextField();
JTextField t2=new JTextField();
JTextField t3=new JTextField();
JTextField t4=new JTextField();
JTextField t5=new JTextField();
JTextField t6=new JTextField();
JTextField t7=new JTextField();
JTextField t8=new JTextField();
JButton b1=new JButton("Add TO Cart");
JButton b2=new JButton("Reset");
JButton b3=new JButton("Submit");
JButton b4=new JButton("Delete");

Font fo=new Font("",1,30);
Font fn=new Font("",2,23);
Font ft=new Font("",1,20);
DefaultTableModel model=new DefaultTableModel();
JTable t=new JTable();
String head[]={"EmpI'd","EmpName","Designation","Salary","PhoneNo","Address","E.Mail","D.O.J."};
Connection con;
PreparedStatement st;
ResultSet rs;
String eid,enm,add,eml,deg,doj,ph;
int sal;
NewEmployee()
{
setLayout(null);
setSize(1250,900);
setLocationRelativeTo(null);
setResizable(false);
addWindowListener(new WindowAdapter()
{
	public void windowClosing(WindowEvent e)
		{
			dispose();
		}
}
);
jl.setForeground(Color.GREEN);
jl.setBounds(110,50,300,50);add(jl);
jl.setFont(fo);add(jl);
l1.setBounds(50,150,150,40);add(l1);
l1.setFont(fn);add(l1);
l2.setBounds(50,230,150,40);add(l2);
l2.setFont(fn);add(l2);
l3.setBounds(50,310,150,40);add(l3);
l3.setFont(fn);add(l3);
l4.setBounds(50,390,150,40);add(l4);
l4.setFont(fn);add(l4);
l5.setBounds(50,470,150,40);add(l5);
l5.setFont(fn);add(l5);
l6.setBounds(50,550,150,40);add(l6);
l6.setFont(fn);add(l6);
l7.setBounds(50,630,150,40);add(l7);
l7.setFont(fn);add(l7);
l8.setBounds(50,710,150,40);add(l8);
l8.setFont(fn);add(l8);
t1.setBounds(250,150,180,40);add(t1);
t1.setFont(fn);add(t1);
t2.setBounds(250,230,180,40);add(t2);
t2.setFont(fn);add(t2);
t3.setBounds(250,310,180,40);add(t3);
t3.setFont(fn);add(t3);
t4.setBounds(250,390,180,40);add(t4);
t4.setFont(fn);add(t4);
t5.setBounds(250,470,180,40);add(t5);
t5.setFont(fn);add(t5);
t6.setBounds(250,550,180,40);add(t6);
t6.setFont(fn);add(t6);
t7.setBounds(250,630,180,40);add(t7);
t7.setFont(fn);add(t7);
t8.setBounds(250,710,180,40);add(t8);
t8.setFont(fn);add(t8);
b1.setBounds(50,800,170,40);add(b1);
b1.setFont(fn);add(b1);
b2.setBounds(260,800,170,40);add(b2);
b2.setFont(fn);add(b2);
model.setColumnIdentifiers(head);
t.setModel(model);
JTableHeader th=t.getTableHeader();
th.setFont(ft);
JScrollPane scr=new JScrollPane(t);
scr.setBounds(480,50,760,620);add(scr);
b3.setBounds(580,800,160,40);add(b3);
b3.setFont(fn);add(b3);
b4.setBounds(900,800,160,40);add(b4);
b4.setFont(fn);add(b4);
try
{
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost/bca","root","");
}
catch(Exception ec)
{
System.out.println(ec);
}
b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
b4.addActionListener(this);
}
public void actionPerformed(ActionEvent e)
{
if(e.getSource()==b1)
{
eid=t1.getText();
enm=t2.getText();
deg=t3.getText();
sal=Integer.parseInt(t4.getText());
ph=t5.getText();
add=t6.getText();
eml=t7.getText();
doj=t8.getText();
model.addRow(new Object[]{eid,enm,deg,sal,ph,add,eml,doj});
t1.setText("f");
t1.setText("");
t2.setText("e");
t2.setText("");
t3.setText("m");
t3.setText("");
t4.setText("j");
t4.setText("");
t5.setText("w");
t5.setText("");
t6.setText("s");
t6.setText("");
t7.setText("n");
t7.setText("");
t8.setText("k");
t8.setText("");
t1.requestFocus();
}
else if(e.getSource()==b2)
{
t1.setText("f");
t1.setText("");
t2.setText("e");
t2.setText("");
t3.setText("m");
t3.setText("");
t4.setText("j");
t4.setText("");
t5.setText("w");
t5.setText("");
t6.setText("s");
t6.setText("");
t7.setText("n");
t7.setText("");
t8.setText("k");
t8.setText("");
}
else if(e.getSource()==b3)
{
for(int i=0;i<model.getRowCount();i++)
{
eid=model.getValueAt(i,0).toString();
enm=model.getValueAt(i,1).toString();
deg=model.getValueAt(i,2).toString();
sal=Integer.parseInt(model.getValueAt(i,3).toString());
ph=model.getValueAt(i,4).toString();
add=model.getValueAt(i,5).toString();
eml=model.getValueAt(i,6).toString();
doj=model.getValueAt(i,7).toString();
try
{
st=con.prepareStatement("insert into Empinfo values(?,?,?,?,?,?,?,?)");
st.setString(1,eid);
st.setString(2,enm);
st.setString(3,deg);
st.setInt(4,sal);
st.setString(5,ph);
st.setString(6,add);
st.setString(7,eml);
st.setString(8,doj);
st.executeUpdate();
}
catch(Exception es)
{
System.out.println(es);
}
}
JOptionPane.showMessageDialog(null,"Employee Details Fill Successfully!");
model.setRowCount(0);
}
else if(e.getSource()==b4)
{
model.removeRow(t.getSelectedRow());
}
}
}
class Emp
{
public static void main(String args[])
{
NewEmployee f=new NewEmployee();
f.setVisible(true);
}
}