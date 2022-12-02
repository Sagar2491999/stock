import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

class Logframe extends Frame implements ActionListener,MouseListener
{
JLabel jl=new JLabel("Log   In");
JLabel l1=new JLabel("User Name-");
JLabel l2=new JLabel("Password-");
JLabel l3=new JLabel("Forget password.");
JLabel l4=new JLabel("Sign Up");
JTextField t1=new JTextField();
TextField t2=new TextField();
JButton b1=new JButton("Submit");
JButton b2=new JButton("Reset");
Font ft=new Font("Arial",Font.BOLD,30);
Font fn=new Font("Arial",2,20);

Connection con;
PreparedStatement st;
ResultSet rs;


Logframe()
{
setTitle("Login");
setSize(500,500);
setLocationRelativeTo(null);
setLayout(null);
setResizable(false);
jl.setBounds(180,50,200,50);add(jl);
jl.setFont(ft);add(jl);
addWindowListener(new WindowAdapter()
{
	public void windowClosing(WindowEvent e)
		{
			dispose();
		}
}
);
jl.setForeground(Color.GREEN);
l1.setBounds(80,150,150,30);add(l1);
l1.setFont(fn);

t1.setBounds(260,150,200,30);add(t1);
t1.setFont(fn);

l2.setBounds(80,230,150,30);add(l2);
l2.setFont(fn);

t2.setBounds(260,230,200,30);add(t2);
t2.setEchoChar('*');
t2.setFont(fn);

b1.setBounds(80,310,120,40);add(b1);
b1.addActionListener(this);
b1.setFont(fn);

b2.setBounds(260,310,120,40);add(b2);
b2.addActionListener(this);
b2.setFont(fn);

 l4.setBounds(80,400,100,30);add(l4);
l4.setFont(fn);add(l4); 
l4.addMouseListener(this);

l3.setBounds(260,400,220,30);add(l3);
l3.setFont(fn);add(l3);
l3.addMouseListener(this);

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



public void mouseClicked(MouseEvent we)
{
if(we.getSource()==l3)
{
Frame f2=new Frame2();
f2.setVisible(true);
}
//dispose();
else if(we.getSource()==l4)
{
Newu f=new Newu();
f.setVisible(true);
}
}

public void mouseEntered(MouseEvent we)
{
}

public void mouseExited(MouseEvent we)
{
}

public void mousePressed(MouseEvent we)
{
}

public void mouseReleased(MouseEvent we)
{
}

public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b1)
{
String un,pwd;
un=t1.getText();
pwd=t2.getText();

try
{
st=con.prepareStatement("select * from logon where uname=? and password=?");
st.setString(1,un);
st.setString(2,pwd);
rs=st.executeQuery();
if(rs.next())
{
Mainframe f=new Mainframe();
f.setVisible(true);
}
else
{
JOptionPane.showMessageDialog(null,"Invalid Username/Password");
t1.setText("");
t2.setText("uyf");
t2.setText("");
t1.requestFocus();
}
}
catch(Exception e)
{
System.out.print(e);
}
t1.setText("gf");
t1.setText("");
t2.setText("kn");
t2.setText("");
}
else if(ae.getSource()==b2)
{
t1.setText("");
t2.setText("uyf");
t2.setText("");

t1.requestFocus();
}
}
}



class Login
{
public static void main(String[] args)
{
Logframe f1=new Logframe();
f1.setVisible(true);
}
}