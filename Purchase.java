import java.awt.*;
import java.util.Date;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
class PurchaseItem extends Frame implements ActionListener
{
JLabel jl=new JLabel("Purchase Items Details! ");
JLabel l1=new JLabel("Item Code");
JLabel l2=new JLabel("Item Name");
JLabel l3=new JLabel("Description");
JLabel l4=new JLabel("Quantity");
JLabel l5=new JLabel("Reorder Level");
JLabel l6=new JLabel("Cost Price");
JLabel l7=new JLabel("Profit");
JLabel l8=new JLabel("Sales Price");
JLabel l9=new JLabel("Date Of Purchase");
JTextField t1=new JTextField();
JTextField t2=new JTextField();
JTextField t3=new JTextField();
JTextField t4=new JTextField();
JTextField t5=new JTextField();
JTextField t6=new JTextField();
JTextField t7=new JTextField();
JTextField t8=new JTextField();
JTextField t9=new JTextField();
JButton b1=new JButton("Search");
JButton b2=new JButton("Submit");
JButton b3=new JButton("Reset");
Date dd=new Date();
Font fo=new Font("",1,33);
Font fn=new Font("",2,28);
Connection con;
PreparedStatement st;
ResultSet rs;
String icode,iname,idesc,dt,dop;
int quty,rol;
float cp,sp,pft;
PurchaseItem()
{
setLayout(null);
setSize(710,1010);
setLocationRelativeTo(null);
setResizable(false);
addWindowListener(new WindowAdapter ()
{
	public void windowClosing(WindowEvent ec)
		{
			dispose();
		}
});
jl.setForeground(Color.green);
jl.setBounds(150,50,400,50);add(jl);
jl.setFont(fo);add(jl);
l1.setBounds(50,150,150,40);add(l1);
l1.setFont(fn);add(l1);
l2.setBounds(50,240,150,40);add(l2);
l2.setFont(fn);add(l2);
l3.setBounds(50,330,150,40);add(l3);
l3.setFont(fn);add(l3);
l4.setBounds(50,420,150,40);add(l4);
l4.setFont(fn);add(l4);
l5.setBounds(50,510,250,40);add(l5);
l5.setFont(fn);add(l5);
l6.setBounds(50,600,150,40);add(l6);
l6.setFont(fn);add(l6);
l7.setBounds(50,690,150,40);add(l7);
l7.setFont(fn);add(l7);
l8.setBounds(50,780,150,40);add(l8);
l8.setFont(fn);add(l8);
l9.setBounds(50,870,250,40);add(l9);
l9.setFont(fn);add(l9);
t1.setBounds(370,150,250,40);add(t1);
t1.setFont(fn);add(t1);
t2.setBounds(370,240,250,40);add(t2);
t2.setFont(fn);add(t2);
t3.setBounds(370,330,250,40);add(t3);
t3.setFont(fn);add(t3);
t4.setBounds(370,420,250,40);add(t4);
t4.setFont(fn);add(t4);
t5.setBounds(370,510,250,40);add(t5);
t5.setFont(fn);add(t5);
t6.setBounds(370,600,250,40);add(t6);
t6.setFont(fn);add(t6);
t7.setBounds(370,690,250,40);add(t7);
t7.setFont(fn);add(t7);
t8.setBounds(370,780,250,40);add(t8);
t8.setFont(fn);add(t8);
t9.setBounds(370,870,250,40);add(t9);
t9.setFont(fn);add(t9);
dt=String.valueOf(dd);
dt=dt.substring(8,10)+"/"+dt.substring(4,7)+"/"+dt.substring(24);
t9.setText(dt);
t9.setEditable(false);
b1.setBounds(50,940,150,40);add(b1);
b1.setFont(fn);add(b1);
b2.setBounds(255,940,150,40);add(b2);
b2.setFont(fn);add(b2);
b3.setBounds(460,940,150,40);add(b3);
b3.setFont(fn);add(b3);
//b4.setBounds(500,930,110,40);add(b4);
//b4.setFont(fb);add(b4);
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
}
public void actionPerformed(ActionEvent e)
{
if(e.getSource()==b3)
{
t1.setText("qw");
t1.setText("");
t2.setText("ew");
t2.setText("");
t3.setText("sd");
t3.setText("");
t4.setText("jh");
t4.setText("");
t5.setText("in");
t5.setText("");
t6.setText("oj");
t6.setText("");
t7.setText("pk");
t7.setText("");
t8.setText("ul");
t8.setText("");
}
else if(e.getSource()==b2)
{
icode=t1.getText();
quty=Integer.parseInt(t4.getText());
cp=Float.parseFloat(t6.getText());
pft=Float.parseFloat(t7.getText());
sp=Float.parseFloat(t8.getText());
dop=t9.getText();
try
{
st=con.prepareStatement("insert into purchase values(?,?,?,?,?,?)");
st.setString(1,icode);
st.setInt(2,quty);
st.setFloat(3,cp);
st.setFloat(4,pft);
st.setFloat(5,sp);
st.setString(6,dop);
st.executeUpdate();
JOptionPane.showMessageDialog(null,"Purchase Details Add Succussfully....");
st=con.prepareStatement("update iteminfo set quantity=quantity+? where itemcode=?");
st.setInt(1,quty);
st.setString(2,icode);
st.executeUpdate();
t1.setText("qw");
t1.setText("");
t2.setText("ew");
t2.setText("");
t3.setText("sd");
t3.setText("");
t4.setText("jh");
t4.setText("");
t5.setText("in");
t5.setText("");
t6.setText("oj");
t6.setText("");
t7.setText("pk");
t7.setText("");
t8.setText("ul");
t8.setText("");

}
catch(Exception es)
{
System.out.println(es);
}
}
else if(e.getSource()==b1)
{
icode=t1.getText();
try
{
st=con.prepareStatement("Select * from iteminfo where itemcode=?");
st.setString(1,icode);
rs=st.executeQuery();
if(rs.next())
{
iname=rs.getString("itemname");
idesc=rs.getString("itemdescription");
quty=rs.getInt("quantity");
rol=rs.getInt("reorderlevel");
cp=rs.getInt("costprice");
pft=rs.getInt("profit");
sp=rs.getInt("saleprice");
t2.setText(iname);
t3.setText(idesc);
t4.setText(String.valueOf(quty));
t5.setText(String.valueOf(rol));
t6.setText(String.valueOf(cp));
t7.setText(String.valueOf(pft));
t8.setText(String.valueOf(sp));
}
else
{
JOptionPane.showMessageDialog(null,"Ivalid ItemCode!");
}
}
catch(Exception re)
{
System.out.println(re);
}

}
}
}
class Purchase
{
public static void main(String args[])
{
PurchaseItem f=new PurchaseItem();
f.setVisible(true);

}

}