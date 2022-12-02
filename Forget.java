import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

class Frame2 extends Frame implements WindowListener,ActionListener
{
Label l1=new Label("Forget Password");
Label l2=new Label("Security Question:-");
Label l3=new Label("Answer:-");
Label l4=new Label("User Name:-");
TextField t2=new TextField();
TextField t3=new TextField();
Choice ch=new Choice();
Button b1=new Button("Submit");
Button b2=new Button("Cancel");
Font ft=new Font("Arial",Font.BOLD,22);
Font ft1=new Font("Arial",Font.BOLD,17);
Connection con;
PreparedStatement st;
ResultSet rs;
String sq,ans,un,pwd,user;
  
Frame2()
{
setSize(450,400);
setLocationRelativeTo(null);
setResizable(false);
setLayout(null);
addWindowListener(this);
l1.setForeground(Color.GREEN);
l1.setBounds(120,30,180,30);add(l1);
l1.setFont(ft);


l2.setBounds(30,90,150,30);add(l2);
l2.setFont(ft1);
 

ch.setBounds(200,90,220,40);add(ch);
ch.setFont(ft1);
ch.add("What is your birth place");
ch.add("What is your pet name");
ch.add("What is your first school name");
ch.add("What is your nationality");

l3.setBounds(30,150,120,30);add(l3);
l3.setFont(ft1);

t2.setBounds(200,150,150,30);add(t2);
t2.setFont(ft1);

l4.setBounds(30,210,120,30);add(l4);
l4.setFont(ft1);

t3.setBounds(200,210,150,30);add(t3);
t3.setFont(ft1);
 
b1.setBounds(80,290,100,30);add(b1);
b1.addActionListener(this);
b1.setFont(ft1);

b2.setBounds(240,290,100,30 );add(b2);
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
if(ae.getSource()==b2)
{
System.exit(0);
}

else if(ae.getSource()==b1)
{
sq=ch.getSelectedItem();
ans=t2.getText();
user=t3.getText();

try
{
st=con.prepareStatement("select * from logon where sques=? and ans=? and uname=? ");
st.setString(1,sq);
st.setString(2,ans);
st.setString(3,user);

rs=st.executeQuery();
if(rs.next())
{
un=rs.getString(1);
pwd=rs.getString(2);
JOptionPane.showMessageDialog(null,"User Name:" + un + "\n Password:" + pwd);
dispose();
}
else
{
JOptionPane.showMessageDialog(null,"Wrong Security Question / Answer");
t2.setText("");
t3.setText("");
ch.select(0);
}  
}
catch(Exception e)
{
System.out.print(e);
}
}
}
}

class Forget
{
public static void main(String[] args)
{
Frame2 f2=new Frame2();
f2.setVisible(true);
}
}