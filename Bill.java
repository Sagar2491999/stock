import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.*;
class BillGeneration extends Frame implements ActionListener
{
JLabel jl=new JLabel("Billing Details!");
JLabel bl1=new JLabel("Bill No."); 
JTextField bt1=new JTextField();
JLabel bl2=new JLabel("Date");
JTextField bt2=new JTextField();
JLabel bl3=new JLabel("Customer Name");
JTextField bt3=new JTextField();
JLabel bl4=new JLabel("Mobile");
JTextField bt4=new JTextField("");
JLabel jtl=new JLabel("Item Details....");
JLabel bl5=new JLabel("Total Ammount");
JLabel bt5=new JLabel();
JButton b=new JButton("Close");
JButton bs=new JButton("Submit");//button for submit bill details into bill table of database
Font fo=new Font("",1,33);
Font fn=new Font("",2,25);
Font ft=new Font("",1,22);
JTable t=new JTable();
DefaultTableModel model=new DefaultTableModel();
String head[]={"S_no","ItemName","Description","Sale Price","Quantity","Amt"};
Connection con;
PreparedStatement st;
ResultSet rs;
String iname,icode,mob,idesc,dt,cname;
int quty,serial,bnumber,qutyitem;
float sp,amount,gamt,tamt;
BillGeneration()
{
setLayout(null);
setSize(1000,1020);
setLocationRelativeTo(null);
setResizable(false);
jl.setForeground(Color.GREEN);
addWindowListener(new WindowAdapter ()
{
	public void windowClosing(WindowEvent ec)
		{
			dispose();
		}
});
jl.setBounds(400,50,3000,50);add(jl);
jl.setFont(fo);add(jl);
bl1.setBounds(50,150,200,50);add(bl1);
bl1.setFont(fn);add(bl1);

bt1.setBounds(300,150,200,50);add(bt1);
bt1.setFont(fn);add(bt1);
bt1.setEditable(false);
bl2.setBounds(550,150,200,50);add(bl2);
bl2.setFont(fn);add(bl2);
bt2.setBounds(720,150,210,50);add(bt2);
bt2.setFont(fn);add(bt2);
bl3.setBounds(50,250,200,50);add(bl3);
bl3.setFont(fn);add(bl3);
bt3.setBounds(300,250,200,50);add(bt3);
bt3.setFont(fn);add(bt3);
bl4.setBounds(550,250,200,50);add(bl4);
bl4.setFont(fn);add(bl4);
bt4.setBounds(720,250,210,50);add(bt4);
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
bs.setBounds(350,930,150,50);add(bs);
bs.setFont(fn);add(bs);
b.setBounds(530,930,150,50);add(b);
b.setFont(fn);add(b);


try
{
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost/bca","root","");
st=con.prepareStatement("Select max(billnumber) from billdetail");
rs=st.executeQuery();
rs.next();
bnumber=rs.getInt(1);
if(bnumber==0)
bnumber=1;
else
bnumber++;
bt1.setText(String.valueOf(bnumber));
}
catch(Exception ec)
{
System.out.println(ec);
}
try
{
st=con.prepareStatement("select * from sellcart");
rs=st.executeQuery();
while(rs.next())
{
serial=rs.getInt(1);
iname=rs.getString(2);
idesc=rs.getString(3);
sp=rs.getFloat(4);
quty=rs.getInt(5);
amount=rs.getFloat(6);
model.addRow(new Object[]{serial,iname,idesc,sp,quty,amount});

}
}
catch(Exception eda)//exception of fatch data from sellcart
{
System.out.print("sellcart table ERROR"+eda);
}
for(int i=0;i<model.getRowCount();i++)
{
gamt=Float.parseFloat(model.getValueAt(i,5).toString());
tamt=tamt+gamt;
}
bt5.setText(String.valueOf(tamt));
b.addActionListener(this);
bs.addActionListener(this);
}
public void actionPerformed(ActionEvent e)
{
if(e.getSource()==bs)
{
bnumber=Integer.parseInt(bt1.getText());
cname=bt3.getText();
mob=bt4.getText();
dt=bt2.getText();
tamt=Float.parseFloat(bt5.getText());
try
{
st=con.prepareStatement("insert into billdetail values(?,?,?,?,?)");
st.setInt(1,bnumber);
st.setString(2,cname);
st.setString(3,mob);
st.setString(4,dt);
st.setFloat(5,tamt);
st.executeUpdate();
JOptionPane.showMessageDialog(null,"Bill made Successfull!");
model.setRowCount(0);
bt1.setText("az");
bt1.setText("");
bt2.setText("ae");
bt2.setText("");
bt3.setText("df");
bt3.setText("");
bt4.setText("yg");
bt4.setText("");
bt5.setText("kj");
bt5.setText("");
}
catch(Exception eabc)
{
System.out.print("Billdetail ERROR "+eabc);
}
try
{
st=con.prepareStatement("truncate table sellcart");
st.executeUpdate();
}
catch(Exception et)//truncate to billcart table
{
System.out.print("Truncate ERROR "+et);
}




for(int i=0;i<model.getRowCount();i++)
{
iname=model.getValueAt(i,1).toString();
quty=Integer.parseInt(model.getValueAt(i,4).toString());//5
JOptionPane.showMessageDialog(null,"Iteminfo delete Succussfully");
try 
{
st=con.prepareStatement("Select * from iteminfo where itemname=?");
st.setString(1,iname);
rs=st.executeQuery();
if(rs.next())
{
qutyitem=rs.getInt(2);//100
}
JOptionPane.showMessageDialog(null,"Iteminfo delete Succussfully");
qutyitem=qutyitem-quty;


st=con.prepareStatement("update iteminfo set quantity=? where itemname=?");
st.setInt(1,qutyitem);
st.setString(2,iname);
st.executeUpdate();
}
catch(Exception ei)//Exception of subtract the item quantity from the iteminfo table
{
System.out.print("Iteminfo ERROR"+ei);
}
}



}
else if(e.getSource()==b)
{
dispose();
}
}
}
class Bill
{
public static void main(String args[])
{
BillGeneration f=new BillGeneration();
f.setVisible(true);
}
}