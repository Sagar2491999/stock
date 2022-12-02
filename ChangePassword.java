import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*; 
class Frame1 extends Frame implements ActionListener
{
Label jl=new Label("CHANGE PASSWORD"); 
Label l1=new Label("User_Name");
Label l2=new Label("Old_Password");
Label l3=new Label("New_Password");
Label l4=new Label("Confirm_Password");
TextField t1=new TextField();
TextField t2=new TextField();
TextField t3=new TextField();
TextField t4=new TextField();
JButton b1=new JButton("CHANGE");
JButton b2=new JButton("RESET");
Font fo=new Font("ArialBlack",Font.BOLD,25);
Font fn=new Font("Arial",Font.BOLD,15);
Connection con;
PreparedStatement st;
ResultSet rs;
String cpas,ps,pa,us,op;
Frame1()
{
setLayout(null);
setSize(500,600);
setLocationRelativeTo(null);
setTitle("Change Password");
addWindowListener(new WindowAdapter()
{
	public void windowClosing(WindowEvent e)
		{
			System.exit(0);
		}
});
jl.setForeground(Color.GREEN);
jl.setBounds(100,50,320,50);add(jl);
l1.setBounds(50,150,180,60);add(l1);
l2.setBounds(50,230,180,60);add(l2);
l3.setBounds(50,310,180,60);add(l3);
l4.setBounds(50,390,180,60);add(l4);
t1.setBounds(250,150,200,40);add(t1);
t2.setBounds(250,230,200,40);add(t2);
t3.setBounds(250,310,200,40);add(t3);
t3.setEchoChar('*');
t4.setBounds(250,390,200,40);add(t4);
t4.setEchoChar('*');
b1.setBounds(50,490,150,50);add(b1);
b2.setBounds(280,490,150,50);add(b2);
jl.setFont(fo);add(jl);
l1.setFont(fn);add(l1);
l2.setFont(fn);add(l2);
l3.setFont(fn);add(l3);
l4.setFont(fn);add(l4);
t1.setFont(fn);add(t1);
t2.setFont(fn);add(t2);
t3.setFont(fn);add(t3);
t4.setFont(fn);add(t4);
b1.setFont(fn);add(b1);
b2.setFont(fn);add(b2);
b2.addActionListener(this);
b1.addActionListener(this);
try
{
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost/stockzz","root","tangu");
}
catch(Exception ex)
{
System.out.println(ex);
}
}

public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b2)
{
t1.setText("sd");
t1.setText("");
t2.setText("df");
t2.setText("");
t3.setText("fs");
t3.setText("");
t4.setText("JH");
t4.setText("");
}
else if(ae.getSource()==b1)
{
us=t1.getText();
op=t2.getText();
ps=t3.getText();
cpas=t4.getText();
try
{
st=con.prepareStatement("select * from logon where uname=? and password=?");
st.setString(1,us);
st.setString(2,op);
rs=st.executeQuery();
if(rs.next())
{
	if(ps.equals(cpas))
	{
	st=con.prepareStatement("update logon set password=? where uname=?");
	st.setString(1,cpas);
	st.setString(2,us);
	st.executeUpdate();
	JOptionPane.showMessageDialog(null,"Password Change Successfully");
	t1.setText("sd");
	t1.setText("");
	t2.setText("asd");
	t2.setText("");
	t3.setText("fd");
	t3.setText("");
	t4.setText("fg");
	t4.setText("");
	}
	else
	{
	JOptionPane.showMessageDialog(null,"Password not match");
	t3.setText("fd");
	t3.setText("");
	t4.setText("ef");
	t4.setText("");
	}
}
else
{
JOptionPane.showMessageDialog(null,"Invalid Username/Password ");
}

}
catch(Exception e)
{
System.out.println(e);
}
}
}
}



class ChangePassword
{
public static void main(String args[])
{
Frame1 f=new Frame1();
f.setVisible(true);
}
}
