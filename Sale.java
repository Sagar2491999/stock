import java.awt.*;
import java.util.Date;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.*;
/*class Frame2 extends Frame implements ActionListener
{
JLabel jl=new JLabel("Bill Details!");
JLabel bl1=new JLabel("Bill No."); 
JLabel bt1=new JLabel("");
JLabel bl2=new JLabel("Date");
JLabel bt2=new JLabel("");
JLabel bl3=new JLabel("Customer Name");
JLabel bt3=new JLabel("");
JLabel bl4=new JLabel("Mobile");
JLabel bt4=new JLabel("");
JLabel jtl=new JLabel("Item Details....");
JLabel bl5=new JLabel("Total Ammount");
JLabel bt5=new JLabel();
JButton b1=new JButton("Submit");
JButton b2=new JButton("Close");
Font fo=new Font("",1,33);
Font fn=new Font("",2,25);
Font ft=new Font("",1,22);
JTable t=new JTable();
DefaultTableModel model=new DefaultTableModel();
String head[]={"S_no","ItemName","Description","Sale Price","Quantity","Amt"};
String iname;
Frame2()
{
setLayout(null);
setSize(1000,1020);
setLocationRelativeTo(null);
setResizable(false);
setTitle("Stockz");
jl.setForeground(Color.GREEN);
jl.setBounds(400,50,3000,50);add(jl);
jl.setFont(fo);add(jl);
//bt1.setText();
bl1.setBounds(50,150,200,50);add(bl1);
bl1.setFont(fn);add(bl1);
bt1.setBounds(300,150,200,50);add(bt1);
bt1.setFont(fn);add(bt1);
bl2.setBounds(550,150,200,50);add(bl2);
bl2.setFont(fn);add(bl2);
bt2.setBounds(800,150,200,50);add(bt2);
bt2.setFont(fn);add(bt2);
bl3.setBounds(50,250,200,50);add(bl3);
bl3.setFont(fn);add(bl3);
bt3.setBounds(300,250,200,50);add(bt3);
bt3.setFont(fn);add(bt3);
bl4.setBounds(550,250,200,50);add(bl4);
bl4.setFont(fn);add(bl4);
bt4.setBounds(800,250,200,50);add(bt4);
bt4.setFont(fn);add(bt4);
jtl.setForeground(Color.GREEN);
jtl.setBounds(400,350,300,50);add(jtl);
jtl.setFont(fo);add(jtl);
model.setColumnIdentifiers(head);
t.setModel(model);
JTableHeader th=t.getTableHeader();
th.setFont(ft);
JScrollPane scr=new JScrollPane(t);
scr.setBounds(50,450,900,350);
add(scr);
bl5.setBounds(50,840,200,50);add(bl5);
bl5.setFont(fn);add(bl5);
bt5.setBounds(300,840,200,50);add(bt5);
bt5.setFont(fn);add(bt5);
b1.setBounds(315,930,150,50);add(b1);
b1.setFont(fn);add(b1);
b2.setBounds(500,930,150,50);add(b2);
b2.setFont(fn);add(b2);
b2.addActionListener(this);
}
public void actionPerformed(ActionEvent e)
{
if(e.getSource()==b2)
{
dispose();
}
}
}*/
class Saleframe extends Frame implements ActionListener
{
JLabel jl=new JLabel("Sale Details !");
JLabel l1=new JLabel("Date");
JLabel l2=new JLabel("Customer Name");
JLabel l3=new JLabel("Mobile");
JLabel l4=new JLabel("Item Code");
JLabel l5=new JLabel("Item Name");
JLabel l6=new JLabel("Description");
JLabel l7=new JLabel("Available Quantity");
JLabel l8=new JLabel("Selling Price");
JLabel l9=new JLabel("Quantity");
JLabel l10=new JLabel("Selling_No.");
JTextField t1=new JTextField();
JTextField t2=new JTextField();
JTextField t3=new JTextField();
JTextField t4=new JTextField();
JTextField t5=new JTextField();
JTextField t6=new JTextField();
JTextField t7=new JTextField();
JTextField t8=new JTextField();
JTextField t9=new JTextField();
JTextField ts=new JTextField();
//JTextField t10=new JTextField();
JButton b1=new JButton("Search");
JButton b2=new JButton("Add To Cart");
JButton b3=new JButton("Remove From Cart");
JButton b4=new JButton("Bill Generation");
JButton b5=new JButton("Reset");
//JButton b5=new JButton("");
Font fo=new Font("",1,35);
Font fn=new Font("",2,30);
Font fb=new Font("",2,17);
Font ft=new Font("",1,20);
Date dd=new Date();
DefaultTableModel model=new DefaultTableModel();
JTable t=new JTable();
String head[]={"S_no","Item Name","Description","Saling Price","Quantity","Amount"};
Connection con;
PreparedStatement st;
ResultSet rs;
String icode,iname,idesc,dt,da,mob,cname;
int serial,sellnum,quty,pquty,srl=1;
float sp,amt;
Saleframe()
{
setLayout(null);
setSize(1450,1000);
setLocationRelativeTo(null);
setResizable(false);
setTitle("Stockz");
addWindowListener(new WindowAdapter ()
{
	public void windowClosing(WindowEvent ec)
		{
			dispose();
		}
});
jl.setForeground(Color.GREEN);
jl.setBounds(300,50,300,50);add(jl);
jl.setFont(fo);add(jl);
l1.setBounds(60,150,200,40);add(l1);
l1.setFont(fn);add(l1);
l10.setBounds(60,230,250,40);add(l10);
l10.setFont(fn);add(l10);
l2.setBounds(60,310,250,40);add(l2);
l2.setFont(fn);add(l2);

l3.setBounds(60,390,200,40);add(l3);
l3.setFont(fn);add(l3);
l4.setBounds(60,470,200,40);add(l4);
l4.setFont(fn);add(l4);
l5.setBounds(60,550,200,40);add(l5);
l5.setFont(fn);add(l5);
l6.setBounds(60,630,200,40);add(l6);
l6.setFont(fn);add(l6);
l7.setBounds(60,710,250,40);add(l7);
l7.setFont(fn);add(l7);
l8.setBounds(60,790,200,40);add(l8);
l8.setFont(fn);add(l8);
l9.setBounds(60,870,200,40);add(l9);
l9.setFont(fn);add(l9);
t1.setBounds(350,150,275,40);add(t1);
t1.setFont(fn);add(t1);
dt=String.valueOf(dd);
dt=dt.substring(8,10)+"/"+dt.substring(4,7)+"/"+dt.substring(24);
t1.setText(dt);
t1.setEditable(false);
ts.setBounds(350,230,275,40);add(ts);
ts.setFont(fn);add(ts);
ts.setEditable(false);
t2.setBounds(350,310,275,40);add(t2);
t2.setFont(fn);add(t2);
t3.setBounds(350,390,275,40);add(t3);
t3.setFont(fn);add(t3);
t4.setBounds(350,470,275,40);add(t4);
t4.setFont(fn);add(t4);
t5.setBounds(350,550,275,40);add(t5);
t5.setFont(fn);add(t5);
t6.setBounds(350,630,275,40);add(t6);
t6.setFont(fn);add(t6);
t7.setBounds(350,710,275,40);add(t7);
t7.setFont(fn);add(t7);
t8.setBounds(350,790,275,40);add(t8);
t8.setFont(fn);add(t8);
t9.setBounds(350,870,275,40);add(t9);
t9.setFont(fn);add(t9);
b1.setBounds(50,940,120,40);add(b1);
b1.setFont(fb);add(b1);
b2.setBounds(180,940,130,40);add(b2);
b2.setFont(fb);add(b2);
b3.setBounds(320,940,160,40);add(b3);
b3.setFont(fb);add(b3);
b4.setBounds(490,940,150,40);add(b4);
b4.setFont(fb);add(b4);
b5.setBounds(650,940,130,40);add(b5);
b5.setFont(fb);add(b5);
model.setColumnIdentifiers(head);
t.setModel(model);
JTableHeader th=t.getTableHeader();
th.setFont(ft);
JScrollPane scr=new JScrollPane(t);
scr.setBounds(700,150,700,700);
add(scr);
try
{
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost/bca","root","");
st=con.prepareStatement("select max(sellingno) from sale");
rs=st.executeQuery();
rs.next();
sellnum=rs.getInt(1);
if(sellnum==0)
sellnum=1;
else
sellnum++;
ts.setText(String.valueOf(sellnum));
}
catch(Exception ec)
{
System.out.println(ec);
}
b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
b4.addActionListener(this);
b5.addActionListener(this);
}
public void actionPerformed(ActionEvent e)
{

if(e.getSource()==b2)
{

quty=Integer.parseInt(t7.getText());
pquty=Integer.parseInt(t9.getText());
if(quty<pquty)
{
JOptionPane.showMessageDialog(null,"Available Quantity is less,So please enter the Quantity less than Available quantity ");
t9.setText("se");
t9.setText("");
t9.requestFocus();
}
else if(quty>=pquty)
{
iname=t5.getText();
idesc=t6.getText();
pquty=Integer.parseInt(t9.getText());
sp=Float.parseFloat(t8.getText());
amt=sp*pquty;
model.addRow(new Object[]{srl,iname,idesc,sp,pquty,amt});
/*t2.setText("se");
t2.setText("");
t3.setText("aw");
t3.setText("");
t4.setText("aq");
t4.setText("");
t5.setText("at");
t5.setText("");
t6.setText("ay");
t6.setText("");
t7.setText("au");
t7.setText("");
t8.setText("ai");
t8.setText("");
t9.setText("ao");
t9.setText("");*/
srl++;
da=t1.getText();//Date
cname=t2.getText();
mob=t3.getText();
icode=t4.getText();
iname=t5.getText();
idesc=t6.getText();
quty=Integer.parseInt(t9.getText());
sp=Float.parseFloat(t8.getText());
sellnum=Integer.parseInt(ts.getText());
try
{
st=con.prepareStatement("insert into sale values(?,?,?,?,?,?,?,?,?)");
st.setString(1,da);
st.setString(2,cname);
st.setString(3,mob);
st.setString(4,icode);
st.setString(5,iname);
st.setString(6,idesc);
st.setInt(7,quty);
st.setFloat(8,sp);
st.setInt(9,sellnum);
st.executeUpdate();
JOptionPane.showMessageDialog(null,"Soldout!");
t2.setText("se");
t2.setText("");
t3.setText("aw");
t3.setText("");
t4.setText("aq");
t4.setText("");
t5.setText("at");
t5.setText("");
t6.setText("ay");
t6.setText("");
t7.setText("au");
t7.setText("");
t8.setText("ai");
t8.setText("");
t9.setText("ao");
t9.setText("");
ts.setText("");
t2.requestFocus();
st=con.prepareStatement("select max(sellingno) from sale");
rs=st.executeQuery();
rs.next();
sellnum=rs.getInt(1);
if(sellnum==0)
sellnum=1;
else
sellnum++;
ts.setText(String.valueOf(sellnum));
}
catch(Exception es)
{
System.out.print("Selling Error"+es);
}

}
}
else if(e.getSource()==b1)
{

icode=t4.getText();
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
sp=rs.getInt("saleprice");
t5.setText(iname);
t6.setText(idesc);
t7.setText(String.valueOf(quty));
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
else if(e.getSource()==b5)
{
t2.setText("se");
t2.setText("");
t3.setText("aw");
t3.setText("");
t4.setText("aq");
t4.setText("");
t5.setText("at");
t5.setText("");
t6.setText("ay");
t6.setText("");
t7.setText("au");
t7.setText("");
t8.setText("ai");
t8.setText("");
t9.setText("ao");
t9.setText("");
ts.setText("");
}
else if(e.getSource()==b4)
{
//Frame2 f=new Frame2();
//f.setVisible(true);

for(int i=0;i<model.getRowCount();i++)
{
serial=Integer.parseInt(model.getValueAt(i,0).toString());
iname=model.getValueAt(i,1).toString();
idesc=model.getValueAt(i,2).toString();
sp=Float.parseFloat(model.getValueAt(i,3).toString());
quty=Integer.parseInt(model.getValueAt(i,4).toString());
amt=Float.parseFloat(model.getValueAt(i,5).toString());
try
{
st=con.prepareStatement("insert into sellcart values(?,?,?,?,?,?)");
st.setInt(1,serial);
st.setString(2,iname);
st.setString(3,idesc);
st.setFloat(4,sp);
st.setInt(5,quty);
st.setFloat(6,amt);
st.executeUpdate();
}
catch(Exception eb)
{
System.out.print("BillCart ERROR"+eb);
}
}
model.setRowCount(0);

BillGeneration f=new BillGeneration();
f.setVisible(true);
}
else if(e.getSource()==b3)
{
sellnum=sellnum-1;
try
{
st=con.prepareStatement("delete from sale where sellingno=?");
st.setInt(1,sellnum);
st.executeUpdate();
JOptionPane.showMessageDialog(null,"Remove From Sell Database!");
}
catch(Exception ed)
{
System.out.print("Delete of sellItem from database ERROR"+ed);
}

model.removeRow(t.getSelectedRow());
sellnum=Integer.parseInt(ts.getText());
//model.setRowCount(0);
}
}
}
class Sale
{
public static void main(String args[])
{
Saleframe f=new Saleframe();
f.setVisible(true);
}
}