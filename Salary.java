import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
class SalarySlip extends Frame implements KeyListener,ActionListener
{
JLabel jl=new JLabel("Salary Slip Generation ");
JLabel l1=new JLabel("Month......");
JLabel l2=new JLabel("Year....");
JLabel l3=new JLabel("No. Of Working Days");
Choice ch=new Choice();
JTextField t2=new JTextField();
JTextField t3=new JTextField();
JButton b1=new JButton("Genrate");
JButton b2=new JButton("Submit");
JButton b3=new JButton("Reset");
DefaultTableModel model=new DefaultTableModel();
JTable t=new JTable();
String head[]={"S_no","EmpI'd","EmpName","Designation","No._Of_Days_Work","Net_Salary"};
Font fo=new Font("",1,30);
Font fn=new Font("",2,25);
char q;
Connection con;
PreparedStatement st;
ResultSet rs;
String mn,ed,en,yr;
int ns,sn,count=0;
SalarySlip()
{
setLayout(null);
setSize(850,900);
setLocationRelativeTo(null);
setResizable(false);
addWindowListener(new WindowAdapter()
{
	public void windowClosing(WindowEvent ew)
		{
			dispose();
		}
}
);
jl.setForeground(Color.green);
jl.setBounds(150,50,300,50);add(jl);
jl.setFont(fo);add(jl);
l1.setBounds(50,150,100,40);add(l1);
l1.setFont(fn);add(l1);
l2.setBounds(500,150,100,40);add(l2);
l2.setFont(fn);add(l2);
l3.setBounds(50,230,250,40);add(l3);
l3.setFont(fn);add(l3);
ch.setBounds(300,150,170,40);add(ch);
ch.add("Jan");
ch.add("Feb");
ch.add("Mar");
ch.add("Apr");
ch.add("May");
ch.add("Jun");
ch.add("Jul");
ch.add("Aug");
ch.add("Sep");
ch.add("Oct");
ch.add("Nov");
ch.add("Dec");

ch.setFont(fn);add(ch);
t2.addKeyListener(this);
t2.setBounds(630,150,170,40);add(t2);
t2.setFont(fn);add(t2);
t2.addKeyListener(this);
t3.setBounds(300,230,170,40);add(t3);
t3.setFont(fn);add(t3);
t3.addKeyListener(this);
b1.setBounds(350,320,160,40);add(b1);
b1.setFont(fn);add(b1);
b1.addActionListener(this);
b2.setBounds(200,780,160,40);add(b2);
b2.setFont(fn);add(b2);
b2.addActionListener(this);
b3.setBounds(500,780,160,40);add(b3);
b3.setFont(fn);add(b3);
b3.addActionListener(this);
model.setColumnIdentifiers(head);
t.setModel(model);
JScrollPane scr=new JScrollPane(t);
scr.setBounds(50,430,750,300);add(scr);
try
{
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost/bca","root","");
}
catch(Exception ec)
{
System.out.println(ec);
}
}
public void keyPressed(KeyEvent ke)
{
char c=ke.getKeyChar();
 if((c>='0' && c<='9') || (c==' ') || (c=='\b'))
{
t2.setEditable(true);
}
else 
{
t2.setEditable(false);
}

/*else if(ke.getSource()==t3)
{
else if((c>='0' && c<='9') || (c==' ') || (c=='\b'))
{
t3.setEditable(true);
}
else 
{
t3.setEditable(false);
}
}*/
//}
}
public void keyReleased(KeyEvent ke)
{
}
public void keyTyped(KeyEvent ke)
{
}
public void actionPerformed(ActionEvent e)
{
if(e.getSource()==b2)
{
for(int i=0;i<model.getRowCount();i++)
{
ed=model.getValueAt(i,2).toString();
en=model.getValueAt(i,3).toString();
ns=Integer.parseInt(model.getValueAt(i,6).toString());
mn=ch.getSelectedItem();
yr=t2.getText();
try
{
st=con.prepareStatement("insert into Salaryslip value(?,?,?,?,?)");
st.setString(1,ed);
st.setString(2,en);
st.setString(3,mn);
st.setString(4,yr);
st.setInt(5,ns);
st.executeUpdate();
}
catch(Exception es)
{
System.out.println(es);
}
}
JOptionPane.showMessageDialog(null,"SalaryData Fill Successfully!");
}
else if(e.getSource()==b3)
{
model.setRowCount(0);

t2.setText("sd");
t2.setText("");
t3.setText("ht");
t3.setText("");
}
else if(e.getSource()==b1)
mn=ch.getSelectedItem();
yr=t2.getText();
{
try
{
st=con.prepareStatement("select Empid,Empname,count (*) from Attendencedata where Status=? and substr(date,4,3)=? and substr(date,8,4)=? group by empid");
st.setString(1,"P");
st.setString(2,mn);
st.setString(3,yr);
rs=st.executeQuery();
JOptionPane.showMessageDialog(null,mn+"\n"+yr+"\n");
while(rs.next())
{
//sn=i;
ed=rs.getString(2);
en=rs.getString(3);
count=Integer.parseInt(rs.getString(5));
//i++;
}
}
catch(Exception eg)
{
System.out.println(eg);
}

}

}

}
class Salary
{
public static void main(String args[])
{
SalarySlip f=new SalarySlip();
f.setVisible(true);
}
}