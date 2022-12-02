import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
class EmployeeModify extends Frame implements ActionListener//,KeyListener
{
JLabel jl=new JLabel("Modify Employee Details !");

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
JButton b1=new JButton("Search");
JButton b2=new JButton("Submit");
JButton b3=new JButton("Delete");
JButton b4=new JButton("Reset");
Font fo=new Font("",1,30);
Font fn=new Font("",2,23);
Connection con;
PreparedStatement st;
ResultSet rs;
String eid,enm,deg,ph,add,eml,doj;
int sal;
EmployeeModify()
{
setLayout(null);
setSize(650,900);
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
jl.setBounds(110,50,380,50);add(jl);
jl.setFont(fo);add(jl);
l1.setBounds(50,150,150,40);add(l1);
l1.setFont(fn);add(l1);
l2.setBounds(50,230,190,40);add(l2);
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
t1.setBounds(290,150,260,40);add(t1);
t1.setFont(fn);add(t1);
t2.setBounds(290,230,260,40);add(t2);
t2.setFont(fn);add(t2);
t3.setBounds(290,310,260,40);add(t3);
t3.setFont(fn);add(t3);
t4.setBounds(290,390,260,40);add(t4);
t4.setFont(fn);add(t4);
t5.setBounds(290,470,260,40);add(t5);
t5.setFont(fn);add(t5);
t6.setBounds(290,550,260,40);add(t6);
t6.setFont(fn);add(t6);
t7.setBounds(290,630,260,40);add(t7);
t7.setFont(fn);add(t7);
t8.setBounds(290,710,260,40);add(t8);
t8.setFont(fn);add(t8);
b1.setBounds(40,800,120,40);add(b1);
b1.setFont(fn);add(b1);
b2.setBounds(170,800,120,40);add(b2);
b2.setFont(fn);add(b2);
b3.setBounds(300,800,120,40);add(b3);
b3.setFont(fn);add(b3);
b4.setBounds(435,800,130,40);add(b4);
b4.setFont(fn);add(b4);
try
{
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost/bca","root","");
}
catch(Exception ex)
{
System.out.println(ex);
}
b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
b4.addActionListener(this);
}

/*public void keyPressed(KeyEvent ke)
{
char c=ke.getKeyChar();
if((c>='0' && c<='9') || (c==' ') || (c=='\b'))
{
t1.setEditable(true);
}
else
{
t1.setEditable(false);
}
}
public void keyReleased(KeyEvent ke)
{
}
public void keyTyped(KeyEvent ke)
{
}*/

public void actionPerformed(ActionEvent e)
{
if(e.getSource()==b3)
{
eid=t1.getText();
try
{
st=con.prepareStatement("delete from Empinfo where EmpId=?");
st.setString(1,eid);
st.executeUpdate();
JOptionPane.showMessageDialog(null,"Employee Info Delete Successfully!");
t1.setText("ew");
t1.setText("");
t2.setText("gf");
t2.setText("");
t3.setText("ed");
t3.setText("");
t4.setText("ws");
t4.setText("");
t5.setText("qa");
t5.setText("");
t6.setText("az");
t6.setText("");
t7.setText("sx");
t7.setText("");
t8.setText("fv");
t8.setText("");
t1.requestFocus();
}
catch(Exception ed)
{
System.out.print("Delete Error"+ed);
}
}
else if(e.getSource()==b2)
{
try
{
eid=t1.getText();
enm=t2.getText();
deg=t3.getText();
sal=Integer.parseInt(t4.getText());
ph=t5.getText();
add=t6.getText();
eml=t7.getText();
doj=t8.getText();
st=con.prepareStatement("update Empinfo set EmpName=?,Designation=?,Salary=?,PhoneNo=?,Address=?,EMail=?,DateOfJoning=?  where EmpId=?");
st.setString(1,enm);
st.setString(2,deg);
st.setInt(3,sal);
st.setString(4,ph);
st.setString(5,add);
st.setString(6,eml);
st.setString(7,doj);
st.setString(8,eid);
st.executeUpdate();
JOptionPane.showMessageDialog(null,"Employee Details Modify Successfully!");
t1.setText("ew");
t1.setText("");
t2.setText("gf");
t2.setText("");
t3.setText("ed");
t3.setText("");
t4.setText("ws");
t4.setText("");
t5.setText("qa");
t5.setText("");
t6.setText("az");
t6.setText("");
t7.setText("sx");
t7.setText("");
t8.setText("fv");
t8.setText("");
t1.requestFocus();
}
catch(Exception eu)
{
System.out.println("Update Error"+eu);
}
}
if(e.getSource()==b4)
{
t1.setText("ew");
t1.setText("");
t2.setText("gf");
t2.setText("");
t3.setText("ed");
t3.setText("");
t4.setText("ws");
t4.setText("");
t5.setText("qa");
t5.setText("");
t6.setText("az");
t6.setText("");
t7.setText("sx");
t7.setText("");
t8.setText("fv");
t8.setText("");
}
else if(e.getSource()==b1)
{
 eid=t1.getText();
try
{
st=con.prepareStatement("select * from Empinfo where EmpId=?");
st.setString(1,eid);
rs=st.executeQuery();
if(rs.next())
{
enm=rs.getString("EmpName");
deg=rs.getString("Designation");
sal=rs.getInt("Salary");
ph=rs.getString("PhoneNo");
add=rs.getString("Address");
eml=rs.getString("Email");
doj=rs.getString("DateOfJoning");
t2.setText(enm);
t3.setText(deg);
t4.setText(String.valueOf(sal));
t5.setText(ph);
t6.setText(add);
t7.setText(eml);
t8.setText(doj);
}
else
{
JOptionPane.showMessageDialog(null,"Ivalid Employee I'd !");
}
}
catch(Exception et)
{
System.out.println("Error"+et);
}
}
}


}
class Emod
{
public static void main(String args[])
{
EmployeeModify f=new EmployeeModify();
f.setVisible(true);
}
}