import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.*;

class modatt extends Frame implements ActionListener
{
JLabel jl=new JLabel("Modify Attendence");
JLabel jl1=new JLabel("Employee Table");
JLabel l1=new JLabel("Date");
JTextField t1=new JTextField();
JButton b1=new JButton("Mark");
JButton b2=new JButton("Submit");
JButton b3=new JButton("Reset");

Font fo=new Font("",1,30);
Font fn=new Font("",2,25);
DefaultTableModel model=new DefaultTableModel();
JTable t=new JTable();
String heads[]={"S.no","Employee Id","Employee Name","Status"};
Connection con;
PreparedStatement st;
ResultSet rs;
String dt,ed,en,da,sta;
int sn;
modatt()
{
setLayout(null);
setSize(650,900);
setLocationRelativeTo(null);
setResizable(false);
setTitle("STOCKZ");
jl.setForeground(Color.GREEN);
addWindowListener(new WindowAdapter()
{
	public void windowClosing(WindowEvent e)
		{
			dispose();
		}
});
jl.setBounds(170,100,400,50);add(jl);
jl.setFont(fo);add(jl);
l1.setBounds(120,200,120,40);add(l1);
l1.setFont(fn);add(l1);
t1.setBounds(300,200,200,40);add(t1);
t1.setFont(fn);add(t1);
b1.setBounds(240,280,120,40);add(b1);
b1.setFont(fn);add(b1);
b2.setBounds(130,780,120,40);add(b2);
b2.setFont(fn);add(b2);
b3.setBounds(400,780,120,40);add(b3);
b3.setFont(fn);add(b3);
jl1.setForeground(Color.BLUE);
jl1.setBounds(200,350,400,50);add(jl1);
jl1.setFont(fo);add(jl1);
model.setColumnIdentifiers(heads);
t.setModel(model);
JScrollPane scr=new JScrollPane(t);
scr.setBounds(50,400,550,300);
add(scr);
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
model.setRowCount(0);
}
else if(e.getSource()==b1)
{
dt=t1.getText();
try
{
st=con.prepareStatement("Select * from attendencedata where date=?");
st.setString(1,dt);
rs=st.executeQuery();
sn=1;
while(rs.next())
{
ed=rs.getString(2);
en=rs.getString(3);
sta=rs.getString(4);
model.addRow(new Object[]{sn,ed,en,sta});
sn++;
}
}
catch(Exception et)
{
System.out.print(et);
}
}
else if(e.getSource()==b2)
{
for(int i=0;i<model.getRowCount();i++)
{
sn=Integer.parseInt(model.getValueAt(i,0).toString());
ed=model.getValueAt(i,1).toString();
en=model.getValueAt(i,2).toString();
sta=model.getValueAt(i,3).toString();
try
{
st=con.prepareStatement("update attendencedata set empid=?,empname=?,status=? where date=?");
st.setString(1,ed);
st.setString(2,en);
st.setString(3,sta);
st.setString(4,dt);
st.executeUpdate();
}
catch(Exception el)
{
System.out.print(el);
}
}
JOptionPane.showMessageDialog(null,"Attendence Update Successfully!");
}
else if(e.getSource()==b3)
{

}

}
}
class modifyAtt
{
public static void main(String args[])
{
modatt a=new modatt();
a.setVisible(true);
}
}