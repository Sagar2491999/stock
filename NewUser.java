import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

class Newu extends Frame implements ActionListener,WindowListener
{
Label l1=new Label("New User Details");
Label  l2=new Label("User Name -");
Label  l3=new Label("Password -");
Label  l4=new Label("Confirm Password -");
Label  l5=new Label("Secret Qusetion -");
Label  l6=new Label("Answer -");
TextField t1=new TextField("");
TextField t2=new TextField("");
TextField t3=new TextField("");
TextField t4=new TextField("");
Choice ch=new Choice();
Button b1=new Button("Create");
Button b2=new Button("Cancel");
Font ft=new Font("Arial",Font.BOLD,30);
Font ft1=new Font("",2,22);
Connection con;
PreparedStatement st;
ResultSet rs;
String un,pass,cpass,sq,answ,user;

Newu()
{
setSize(640,650);
setLocationRelativeTo(null);
setLayout(null);
setResizable(false);
addWindowListener(this);
l1.setForeground(Color.GREEN);
l1.setBounds(180,40,300,50);add(l1);
l1.setFont(ft);

l2.setBounds(50,110,150,30);add(l2);
l2.setFont(ft1);

l3.setBounds(50,180,150,30);add(l3);
l3.setFont(ft1);

l4.setBounds(50,240,190,30);add(l4);
l4.setFont(ft1);

l5.setBounds(50,300,170,30);add(l5);
l5.setFont(ft1);

l6.setBounds(50,360,150,30);add(l6);
l6.setFont(ft1);

t1.setBounds(300,110,270,30);add(t1);
t1.setFont(ft1);

t2.setBounds(300,180,270,30);add(t2);
t2.setEchoChar('*');
t2.setFont(ft1);

t3.setBounds(300,240,270,30);add(t3);
t3.setEchoChar('*');
t3.setFont(ft1);

t4.setBounds(300,360,270,30);add(t4);
t4.setFont(ft1);
t4.setEchoChar('*');

ch.setBounds(300,300,270,30);add(ch);
ch.add("What is your birth place");
ch.add("What is your pet name");
ch.add("What is your first school name");
ch.add("What is your nationality");
ch.setFont(ft1);
  
b1.setBounds(80,450,100,40);add(b1);
b1.addActionListener(this);
b1.setFont(ft1);

b2.setBounds(340,450,100,40);add(b2);
b2.setFont(ft1);
b2.addActionListener(this);

try
{
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost/bca","root","");
}
catch(Exception e)
{
System.out.print(e);
}
}

public void windowOpened(WindowEvent we)
{
}

public void windowActivated(WindowEvent we)
{
}

public void windowDeactivated(WindowEvent we)
{
}

public void windowIconified(WindowEvent we)
{
}

public void windowDeiconified(WindowEvent we)
{
}

public void windowClosing(WindowEvent we)
{
dispose();
}

public void windowClosed(WindowEvent we)
{
}

public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b1)
{
un=t1.getText();
pass=t2.getText();
cpass=t3.getText();
sq=ch.getSelectedItem();
answ=t4.getText();

try
{
st=con.prepareStatement("select * from logon where uname=?");
st.setString(1,un);
rs=st.executeQuery();

if(rs.next())
{
JOptionPane.showMessageDialog(null,"Already exist User Name");
t1.setText("");
t1.requestFocus();
}
else
{
try
{
st=con.prepareStatement("insert into logon values(?,?,?,?,?)");
st.setString(1,un);
st.setString(2,pass);
st.setString(3,cpass);
st.setString(4,sq);
st.setString(5,answ);

if(pass.equals(cpass))
{
st.executeUpdate();
JOptionPane.showMessageDialog(null,"Create Account Successfully");
t1.setText("");
t2.setText("ar");
t2.setText("");
t3.setText("");
t4.setText("");
ch.select(0);
t1.requestFocus();
}
else
{
JOptionPane.showMessageDialog(null,"password does not match");
t2.setText("ar");
t2.setText("");
t3.setText("aw");
t3.setText("");
t2.requestFocus();
}
}
catch(Exception e)
{
System.out.print(e);
} 
}
}
catch(Exception e)
{
System.out.print(e);
}
}

else if(ae.getSource()==b2)
{
System.exit(0);
}
}
}

class NewUser
{
public static void main(String[] args)
{
Newu f=new Newu();
f.setVisible(true);
}
}