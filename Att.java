import java.awt.*;
import java.util.Date;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;
class NewAttendence extends Frame implements ActionListener
{
JLabel jl=new JLabel("Mark Daily Attendence");
JLabel l1=new JLabel("Date");
JTextField t1=new JTextField();
Date dd=new Date();
JButton b=new JButton("Mark");
JLabel jl1=new JLabel("Employee Table");
JButton b1=new JButton("Submit");
JButton b2=new JButton("Reset");
DefaultTableModel model=new DefaultTableModel();
JTable t=new JTable();
String head[]={"S.no","Employee_I'd","Employee_Name","Status"};
Connection con;
PreparedStatement st;
ResultSet rs;
String dt,ed,en,da,sta;
int sn;
Font fo=new Font("",1,30);
Font fn=new Font("",2,25);
NewAttendence()
{
setLayout(null);
setSize(650,900);
setLocationRelativeTo(null);
setResizable(false);
setTitle("STOCKZ");
addWindowListener(new WindowAdapter()
{
	public void windowClosing(WindowEvent e)
		{
			dispose();
		}
}
);
jl.setForeground(Color.GREEN);
jl.setBounds(170,100,400,50);add(jl);
jl.setFont(fo);add(jl);
l1.setBounds(120,200,120,40);add(l1);
l1.setFont(fn);add(l1);
t1.setBounds(300,200,200,40);add(t1);
t1.setFont(fn);add(t1);
dt=String.valueOf(dd);
dt=dt.substring(8,10)+"/"+dt.substring(4,7)+"/"+dt.substring(24);
t1.setText(dt);
t1.setEditable(false);
b.setBounds(240,280,120,40);add(b);
b.setFont(fn);add(b);
jl1.setForeground(Color.BLUE);
jl1.setBounds(200,350,400,50);add(jl1);
jl1.setFont(fo);add(jl1);
model.setColumnIdentifiers(head);
t.setModel(model);

JScrollPane scr=new JScrollPane(t);
scr.setBounds(50,400,550,300);
add(scr);
b1.setBounds(130,780,120,40);add(b1);
b1.setFont(fn);add(b1);
b2.setBounds(400,780,120,40);add(b2);
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


b2.addActionListener(this);
b1.addActionListener(this);
b.addActionListener(this);
}
public void actionPerformed(ActionEvent e)
{
if(e.getSource()==b2)
{
model.setRowCount(0);
}
else if(e.getSource()==b)
{
try
{
st=con.prepareStatement("Select * from emp");
rs=st.executeQuery();
while(rs.next())
{
sn=rs.getInt(1);
ed=rs.getString(2);
en=rs.getString(3);
model.addRow(new Object[]{sn,ed,en});

}
}
catch(Exception et)
{
System.out.print(et);
}
}


else if(e.getSource()==b1)
{
da=t1.getText();
for(int i=0;i<model.getRowCount()-1;i++)
{
sn=Integer.parseInt(model.getValueAt(i,0).toString());
ed=model.getValueAt(i,1).toString();
en=model.getValueAt(i,2).toString();
sta=model.getValueAt(i,3).toString();

//JOptionPane.showMessageDialog(null,"Welcome");
JOptionPane.showMessageDialog(null,ed+"\n"+en+"\n"+sta+"\n"+da);
try{
st=con.prepareStatement("insert into Attendencedata values(?,?,?,?)");
st.setString(1,da);
st.setString(2,ed);
st.setString(3,en);
st.setString(4,sta);
st.executeUpdate();

}
catch(Exception es)
{
System.out.println(es);
}
}
JOptionPane.showMessageDialog(null,"Attendence Fill Successfully!");
model.setRowCount(0);
}

}
}

class Att
{
public static void main(String args[])
{
NewAttendence f=new NewAttendence();
f.setVisible(true);
}
}