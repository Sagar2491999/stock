import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
class NewStock extends Frame implements ActionListener
{
JLabel jl=new JLabel("Add New Item! ");
JLabel l1=new JLabel("Item Code");
JLabel l2=new JLabel("Item Name");
JLabel l3=new JLabel("Description");
JTextField t1=new JTextField();
JTextField t2=new JTextField();
JTextField t3=new JTextField();
JButton b1=new JButton("Submit");
JButton b2=new JButton("Reset");
Font fo=new Font("",1,30);
Font fn=new Font("",2,25);
Connection con;
PreparedStatement st;
ResultSet rs;
String icode,iname,idesc;
NewStock()
{
setLayout(null);
setSize(510,530);
setLocationRelativeTo(null);
setResizable(false);
addWindowListener(new WindowAdapter ()
{
	public void windowClosing(WindowEvent e)
		{
			dispose();
		}
});
jl.setForeground(Color.green);
jl.setBounds(150,50,300,50);add(jl);
jl.setFont(fo);add(jl);
l1.setBounds(60,150,150,40);add(l1);
l1.setFont(fn);add(l1);
l2.setBounds(60,240,150,40);add(l2);
l2.setFont(fn);add(l2);
l3.setBounds(60,330,150,40);add(l3);
l3.setFont(fn);add(l3);
t1.setBounds(250,150,200,40);add(t1);
t1.setFont(fn);add(t1);
t2.setBounds(250,240,200,40);add(t2);
t2.setFont(fn);add(t2);
t3.setBounds(250,330,200,40);add(t3);
t3.setFont(fn);add(t3);
b1.setBounds(60,420,140,40);add(b1);
b1.setFont(fn);add(b1);
b2.setBounds(310,420,140,40);add(b2);
b2.setFont(fn);add(b2);
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
}
public void actionPerformed(ActionEvent e)
{
if(e.getSource()==b1)
{
icode=t1.getText();
iname=t2.getText();
idesc=t3.getText();
try
{
st=con.prepareStatement("Select * from iteminfo where itemcode=?");
st.setString(1,icode);
rs=st.executeQuery();
if(rs.next())
{
JOptionPane.showMessageDialog(null,"Already exists");
t1.requestFocus();
}
else
{
st=con.prepareStatement("insert into iteminfo values(?,?,?,'0','0','0','0','0','0')");
st.setString(1,icode);
st.setString(2,iname);
st.setString(3,idesc);
st.executeUpdate();
JOptionPane.showMessageDialog(null,"New Item Added Successfully!");
t1.setText("qw");
t1.setText("");
t2.setText("ew");
t2.setText("");
t3.setText("sd");
t3.setText("");
t1.requestFocus();
}
}
catch(Exception es)
{
System.out.println(es);
}

}
else if(e.getSource()==b2)
{
t1.setText("qw");
t1.setText("");
t2.setText("ew");
t2.setText("");
t3.setText("sd");
t3.setText("");
}

}
}
class NewItem
{
public static void main(String args[])
{
NewStock f=new NewStock();
f.setVisible(true);
}

}