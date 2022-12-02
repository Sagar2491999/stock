import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
class CustomerModify extends Frame implements ActionListener,KeyListener
{
JLabel jl=new JLabel("Modify Customer Details");
JLabel l1=new JLabel("Customer I'd:-");
JLabel l2=new JLabel("Customer Name:-");
JLabel l3=new JLabel("Shop Name:-");
JLabel l4=new JLabel("Address:-");
JLabel l5=new JLabel("ph.Number:-");
JButton b1=new JButton("Search");
JTextField t1=new JTextField();
JTextField t2=new JTextField();
JTextField t3=new JTextField();
JTextArea ta=new JTextArea("Type your address",2,3);
JTextField t4=new JTextField();

JButton b2=new JButton("Submit");
JButton b3=new JButton("Delete");
JButton b4=new JButton("Reset");
Font fo=new Font("",1,33);
Font fn=new Font("",2,25);
Connection con;
PreparedStatement st;
ResultSet rs;
int id;
String ph,name,add,sn;
CustomerModify()
{
setLayout(null);
setSize(620,700);
setLocationRelativeTo(null);
setResizable(false);
setBackground(Color.GRAY);
//Color c=new Color(204,204,204);
//setBackground(c);
addWindowListener(new WindowAdapter()
{
	public void windowClosing(WindowEvent e)
		{
			dispose();
		}
}
);
jl.setForeground(Color.GREEN);
jl.setBounds(100,50,410,50);add(jl);
jl.setFont(fo);add(jl);add(l1);
l1.setBounds(50,150,200,40);
l1.setFont(fn);add(l1);
l2.setBounds(50,230,200,40);add(l2);
l2.setFont(fn);add(l2);
l3.setBounds(50,310,200,40);add(l3);
l3.setFont(fn);add(l3);
l4.setBounds(50,390,200,40);add(l4);
l4.setFont(fn);add(l4);
l5.setBounds(50,470,200,40);add(l5);
l5.setFont(fn);add(l5);
t1.setBounds(320,150,235,40);add(t1);
t1.setFont(fn);add(t1);
t2.setBounds(320,230,235,40);add(t2);
t1.addKeyListener(this);
t2.setFont(fn);add(t2);
t3.setBounds(320,310,235,40);add(t3);
t3.setFont(fn);add(t3);
ta.setBounds(320,390,235,60);add(ta);
ta.setFont(fn);add(ta);
t4.setBounds(320,470,235,40);add(t4);
t4.setFont(fn);add(t4);
b1.setBounds(50,570,115,40);add(b1);
b1.setFont(fn);add(b1);
b1.addActionListener(this);
b2.setBounds(180,570,115,40);add(b2);
b2.setFont(fn);add(b2);
b2.addActionListener(this);
b3.setBounds(310,570,110,40);add(b3);
b3.setFont(fn);add(b3);
b3.addActionListener(this);
b4.setBounds(440,570,110,40);add(b4);
b4.setFont(fn);add(b4);
b4.addActionListener(this);

try
{
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost/bca","root","");
}
catch(Exception ex)
{
System.out.println(ex);
}
}
public void keyPressed(KeyEvent ke)
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
}
public void actionPerformed(ActionEvent e)
{
if(e.getSource()==b3)
{
id=Integer.parseInt(t1.getText());
try
{
st=con.prepareStatement("delete from reg where Customer_id=? ");
st.setInt(1,id);
st.executeUpdate();
JOptionPane.showMessageDialog(null,"Customer Details Delete Successfully !");
t1.setText("se");
t1.setText("");
t2.setText("cd");
t2.setText("");
t3.setText("sd");
t3.setText("");
ta.setText("st");
ta.setText("");
t4.setText("hh");
t4.setText("");
t1.requestFocus();
}
catch(Exception ed)
{
System.out.println(ed);
}
}
else if(e.getSource()==b4)
{
t1.setText("se");
t1.setText("");
t2.setText("cd");
t2.setText("");
t3.setText("sd");
t3.setText("");
ta.setText("st");
ta.setText("");
t4.setText("hh");
t4.setText("");
t1.requestFocus();
}
else if(e.getSource()==b1)
{
 id=Integer.parseInt(t1.getText());
try
{
st=con.prepareStatement("select * from reg where Customer_id=?");
st.setInt(1,id);
rs=st.executeQuery();
if(rs.next())
{
name=rs.getString("Customer_name");
sn=rs.getString("Shop_name");
add=rs.getString("Address");
ph=rs.getString("Phone_no");
t2.setText(name);
t3.setText(sn);
ta.setText(add);
t4.setText(ph);
}
else
{
JOptionPane.showMessageDialog(null,"Ivalid Customer I'd !");
}
}
catch(Exception et)
{
System.out.println(et);
}
}


else if(e.getSource()==b2)
{
id=Integer.parseInt(t1.getText());
name=t2.getText();
sn=t3.getText();
add=ta.getText();
ph=t4.getText();
//int x=String.valueOf(id).length();
if(name.length()==0 || ph.length()==0 || add.length()==0 || sn.length()==0 || String.valueOf(id).length()==0)
{
JOptionPane.showMessageDialog(null,"Please Fill All Entries");
t1.requestFocus();
}
else
{
try
{
st=con.prepareStatement("update reg set Customer_name=?,Shop_name=?,Address=?,Phone_no=? where Customer_id=?");
st.setString(1,name);
st.setString(2,sn);
st.setString(3,add);
st.setString(4,ph);
st.setInt(5,id);
st.executeUpdate();
JOptionPane.showMessageDialog(null,"Modify Successfully");
t1.setText("sd");
t1.setText("");
t2.setText("es");
t2.setText("");
t3.setText("tf");
t3.setText("");
ta.setText("ed");
ta.setText("");
t4.setText("dc");
t4.setText("");
t1.requestFocus();
}
catch(Exception ec)
{
System.out.println(ec);
}
}
}
}
}
class mcd
{
public static void main(String args[])
{
CustomerModify f=new CustomerModify();
f.setVisible(true);
}
}